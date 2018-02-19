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

public class frmMain extends JFrame {
	
	public frmMain() throws IOException {
		
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
		
		lblIPAddress.setText(GetLocalAddressIPv4());
		/*
		List<String> lst = GetGatewayAddress();
		lblGateway.setText(lst.get(0));
		lblSubnet.setText(lst.get(3));*/
	}
	
	// Hand written code
	public String GetLocalAddressIPv4() throws UnknownHostException {
		InetAddress IP = InetAddress.getLocalHost();
		return IP.getHostAddress();
	}
	
	public List<String> GetGatewayAddress() throws IOException {
		String matchSubnetMask[] = { "0.0.0.0", "128.0.0.0", "192.0.0.0", "224.0.0.0", "240.0.0.0", "248.0.0.0",
				"252.0.0.0", "254.0.0.0", "255.0.0.0", "255.128.0.0", "255.192.0.0", "255.224.0.0", "255.240.0.0",
				"255.248.0.0", "255.252.0.0", "255.254.0.0", "255.255.0.0", "255.255.128.0", "255.255.192.0",
				"255.255.224.0", "255.255.240.0", "255.255.248.0", "255.255.252.0", "255.255.254.0", "255.255.255.0",
				"255.255.255.128", "255.255.255.192", "255.255.255.224", "255.255.255.240", "255.255.255.248",
				"255.255.255.252", "255.255.255.254" };
		String submask = "";
		Pattern pat;
		Matcher match;
		List<String> result = new ArrayList<String>();

		Process p = Runtime.getRuntime().exec("ip route");
		InputStream i = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(i);
		BufferedReader br = new BufferedReader(isr);

		pat = Pattern.compile(
				"\\b(?:(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9]))\\b");
		String line = br.readLine();

		while (line != null) {
			match = pat.matcher(line);
			while (match.find()) {
				result.add(match.group().toString());
					if (line.contains("/")) {
						submask = matchSubnetMask[Integer.parseInt(line.split("/")[1].split(" ")[0])];
						//result.add(submask);
						submask=null;

					}
			}
			line = br.readLine();
		}
		
		// index : 0 => Gateway
			// 1 => Network
			// 2 => Host 
			// 3 => Submask network
			for (String results : result) {
				System.out.println(results);

			}
			return result;
	}

}
