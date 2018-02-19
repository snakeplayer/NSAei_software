package NSAei_pkg;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javafx.scene.layout.Border;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmTracerouteResult extends JFrame {
	
	JFrame FrmParent;
	String IpAddress;
	
	public frmTracerouteResult(JFrame frmParent, String ipAddress) {
		
		frmTracerouteResult.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTracerouteResult.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmTracerouteResult.this.setUndecorated(true);
		
		
		JButton btnBack = new JButton("Retour");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmParent.setVisible(true);
				frmTracerouteResult.this.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblOutput = new JLabel("<html>");
		lblOutput.setVerticalAlignment(SwingConstants.TOP);
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JTextArea taOutput = new JTextArea();
		taOutput.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				addWindowListener(new WindowAdapter() {
					@Override
					public void windowOpened(WindowEvent arg0) {
						
					}
				});
			}
		});
		taOutput.setLineWrap(true);
		taOutput.setFont(new Font("Monospaced", Font.PLAIN, 12));
		taOutput.setEditable(false);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addComponent(taOutput, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblOutput, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(taOutput, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
						.addComponent(lblOutput, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				new Thread() {
			        @Override
			        public void run() {
			        	FrmParent = frmParent;
						IpAddress = ipAddress;
						
						String s;
				        Process p;
				        try {
				            p = Runtime.getRuntime().exec("traceroute " + IpAddress);
				            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));
				            taOutput.setText("Traceroute en cours...");
				            while ((s = br.readLine()) != null)
				            {
				            	taOutput.setText(taOutput.getText() + s + String.format("%n") /*+ "<br/>"*/);
				            }
				            
				            taOutput.setText(taOutput.getText() /*+ "</html>"*/);
				            p.waitFor();
				            taOutput.setText(taOutput.getText() + "exit: " + p.exitValue());
				            p.destroy();
				        } 
				        catch (Exception e1) {
				        	
				        }
			        }
			      }.start();
				
				
			}
		});
		
		// Hand written code
		/*
		JScrollPane scrollzonetexte = new JScrollPane(taOutput, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		frmTracerouteResult.this.getContentPane().add(scrollzonetexte, BorderLayout.CENTER);*/
		
		
        
        
	}
}
