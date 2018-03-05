package NSAei_pkg;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMain extends JFrame {
	
	public frmMain() throws IOException {
		
		frmMain.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmMain.this.setUndecorated(true);
		
		JButton btnPing = new JButton("PING");
		btnPing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmPing frm = new frmPing(frmMain.this);
				frm.setVisible(true);
				frm.setSize(new Dimension(480, 320));
				frmMain.this.setVisible(false);
			}
		});
		btnPing.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnTraceroute = new JButton("TRACEROUTE");
		btnTraceroute.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmTraceroute frm = new frmTraceroute(frmMain.this);
				frm.setVisible(true);
				frm.setSize(new Dimension(480, 320));
				frmMain.this.setVisible(false);
			}
		});
		btnTraceroute.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnDetail = new JButton("DETAIL");
		btnDetail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmDetails frm = new frmDetails(frmMain.this);
				frm.setVisible(true);
				frm.setSize(new Dimension(480, 320));
				frmMain.this.setVisible(false);
			}
		});
		btnDetail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblAdresseIp = new JLabel("Adresse IP :");
		lblAdresseIp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresseIp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblAdresseDuRouteur = new JLabel("Adresse du routeur :");
		lblAdresseDuRouteur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblMasqueDeSousrseau = new JLabel("Masque de sous-r\u00E9seau :");
		lblMasqueDeSousrseau.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Process bash = Runtime.getRuntime().exec("shutdown");
				
				
				
				
			}
		});
		btnX.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblIPAddress = new JLabel("x.x.x.x");
		lblIPAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblGateway = new JLabel("x.x.x.x");
		lblGateway.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblSubnet = new JLabel("x.x.x.x");
		lblSubnet.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAdresseDuRouteur)
								.addComponent(lblMasqueDeSousrseau)
								.addComponent(lblAdresseIp, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblIPAddress, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(lblGateway, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblSubnet, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnPing)
							.addGap(33)
							.addComponent(btnTraceroute)
							.addGap(34)
							.addComponent(btnDetail)))
					.addContainerGap(36, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(407, Short.MAX_VALUE)
					.addComponent(btnX)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnDetail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnTraceroute, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPing, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIPAddress, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAdresseIp))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAdresseDuRouteur, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGateway, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMasqueDeSousrseau, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(btnX))
						.addComponent(lblSubnet, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		GetIpAddress();
		
		lblIPAddress.setText(GetIpAddress());
		/*
		List<String> lst = GetGatewayAddress();
		lblGateway.setText(lst.get(0));
		lblSubnet.setText(lst.get(3));*/
	}
	
	// Hand written codes
	
	public String GetIpAddress() throws IOException {
		
		Process p = Runtime.getRuntime().exec("ip route | pyp \" pp[-1] | w[-1] \"");

		InputStream i = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(i);
		BufferedReader br = new BufferedReader(isr);

		String ip = br.readLine();
		
		return ip;
	}

}
