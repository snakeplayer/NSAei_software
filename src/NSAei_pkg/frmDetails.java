/*
 * Authors : F. Troller, D. Schito, B. Chauche
 * Date : 2017-2018
 * Project : NSAei
 * Class : frmDetails.java
 * Description : Show interface details
 */

package NSAei_pkg;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Window.Type;

public class frmDetails extends JFrame {
	
	frmDetails(JFrame frmParent) {
		
		frmDetails.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDetails.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmDetails.this.setUndecorated(true);
		
		JPanel panel = new JPanel();
		
		JLabel lblNetmask = new JLabel("Netmask:");
		
		JLabel lblAdresse = new JLabel("Adresse:");
		
		JLabel lblAddresseMac = new JLabel("Addresse MAC:");
		
		JLabel lblNomDhote = new JLabel("nom d'hote");
		
		JLabel lblGateway = new JLabel("gateway");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(67)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblGateway)
						.addComponent(lblNomDhote)
						.addComponent(lblAddresseMac)
						.addComponent(lblNetmask)
						.addComponent(lblAdresse))
					.addContainerGap(165, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(102)
					.addComponent(lblAdresse)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNetmask)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAddresseMac)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNomDhote)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblGateway)
					.addContainerGap(85, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			// Back to main frmMain
			@Override
			public void mousePressed(MouseEvent e) {
				frmParent.setVisible(true);
				frmDetails.this.setVisible(false);
			}
		});
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addMouseListener(new MouseAdapter() {
			// Refresh interface info
			@Override
			public void mousePressed(MouseEvent arg0) {
				try
				{
					// Get ip address
					Runtime r = Runtime.getRuntime();
		            Process process = r.exec("bash ip.sh");
					BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
					String line = "";
		            while ((line = in.readLine()) != null) 
		            {
		                lblAdresse.setText(line.toString());
		            }
					
		            // Get MAC address
		            Process process2 = r.exec("python mac.py");
					BufferedReader in2 = new BufferedReader(new InputStreamReader(process2.getInputStream()));
					String line2 = "";
		            while ((line2 = in2.readLine()) != null) 
		            {
		                lblAddresseMac.setText(line2.toString());
		                
		            }
		            
		            // Get hostname
		            Process process3 = r.exec("python hostname.py");
					BufferedReader in3 = new BufferedReader(new InputStreamReader(process3.getInputStream()));
					String line3 = "";
		            while ((line3 = in3.readLine()) != null) 
		            {
		                lblNomDhote.setText(line3.toString());
		                
		            }
		            
		            // Get gateway
		            Process process4 = r.exec("python gateways.py");
					BufferedReader in4 = new BufferedReader(new InputStreamReader(process4.getInputStream()));
					String line4 = "";
		            while ((line4 = in4.readLine()) != null) 
		            {
		                lblGateway.setText(line4.toString());
		                
		            }
		            
		            // Get netmask
		            Process process5 = r.exec("python netmask.py");
					BufferedReader in5 = new BufferedReader(new InputStreamReader(process5.getInputStream()));
					String line5 = "";
		            while ((line5 = in5.readLine()) != null) 
		            {
		                lblNetmask.setText(line5.toString());
		                
		            }
					
				}
				catch(Exception e)
				{
					
					System.out.println("erreur");
				}
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(167)
					.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
		);
		this.getContentPane().setLayout(groupLayout);			
	}
}
