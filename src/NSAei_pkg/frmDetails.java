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
		
		JLabel lblNetmask = new JLabel("netmask");
		lblNetmask.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblAdresse = new JLabel("adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblAddresseMac = new JLabel("adresse MAC");
		lblAddresseMac.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNomDhote = new JLabel("nom d'hote");
		lblNomDhote.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblGateway = new JLabel("gateway");
		lblGateway.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblAdresse_1 = new JLabel("Adresse :");
		lblAdresse_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNetmask_1 = new JLabel("Netmask :");
		lblNetmask_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblAddresseMac_1 = new JLabel("Addresse MAC :");
		lblAddresseMac_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNomDhote_1 = new JLabel("Nom d'hote :");
		lblNomDhote_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblGateway_1 = new JLabel("Gateway :");
		lblGateway_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblNetmask_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblAdresse_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(2))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAddresseMac_1)
								.addComponent(lblNomDhote_1)
								.addComponent(lblGateway_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGateway)
						.addComponent(lblNomDhote)
						.addComponent(lblAddresseMac)
						.addComponent(lblAdresse)
						.addComponent(lblNetmask))
					.addContainerGap(622, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGap(102)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblAdresse_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNetmask_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblAddresseMac_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNomDhote_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblGateway_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblAdresse)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblNetmask)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblAddresseMac)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblNomDhote))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblGateway)))
					.addContainerGap(87, Short.MAX_VALUE))
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
		
		JButton btnRefresh = new JButton("Actualiser");
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
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
							.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		this.getContentPane().setLayout(groupLayout);			
	}
}
