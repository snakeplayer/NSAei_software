package NSAei_pkg;

import javax.swing.JFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import org.omg.CORBA.Environment;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmPingResult extends JFrame {
	
	JFrame FrmParent;
	String IpAddress;

	public frmPingResult(JFrame frmParent, String ipAddress) {
		
		frmPingResult.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPingResult.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmPingResult.this.setUndecorated(true);
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
				FrmParent.setVisible(true);
			}
		});
		
		JLabel lblOutput = new JLabel("");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOutput.setVerticalAlignment(SwingConstants.TOP);
		
		JButton button = new JButton("Retour");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmParent.setVisible(true);
				frmPingResult.this.setVisible(false);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOutput, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblOutput, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		// Hand written code
		new Thread() {
	        @Override
	        public void run() {
	        	FrmParent = frmParent;
	    		IpAddress = ipAddress;
	    		
	    		String s;
	            Process p;
	            try {
	                p = Runtime.getRuntime().exec("ping -c 4 " + IpAddress);
	                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));
	                lblOutput.setText("<html>");
	                while ((s = br.readLine()) != null)
	                    lblOutput.setText(lblOutput.getText() + s + "<br/>");
	                lblOutput.setText(lblOutput.getText() + "</html>");
	                p.waitFor();
	                lblOutput.setText(lblOutput.getText() + "exit: " + p.exitValue());
	                p.destroy();
	            } 
	            catch (Exception e1) {
	            	
	            }
	        }
	      }.start();
		
	}
}
