/*
 * Authors : F. Troller, D. Schito, B. Chauche
 * Date : 2017-2018
 * Project : NSAei
 * Class : frmMain.java
 * Description : Main view. Allows to navigate through different views.
 */

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
		
		frmMain.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmMain.this.setUndecorated(true);
		
		JButton btnPing = new JButton("PING");
		btnPing.addMouseListener(new MouseAdapter() {
			// Show frmPing
			@Override
			public void mousePressed(MouseEvent e) {
				frmPing frm = new frmPing(frmMain.this);
				frm.setVisible(true);
				frm.setSize(new Dimension(480, 320));
				frmMain.this.setVisible(false);
			}
		});
		btnPing.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnTraceroute = new JButton("TRACEROUTE");
		btnTraceroute.addMouseListener(new MouseAdapter() {
			// Show frmTraceroute
			@Override
			public void mousePressed(MouseEvent e) {
				frmTraceroute frm = new frmTraceroute(frmMain.this);
				frm.setVisible(true);
				frm.setSize(new Dimension(480, 320));
				frmMain.this.setVisible(false);
			}
		});
		btnTraceroute.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnDetail = new JButton("DETAIL");
		btnDetail.addMouseListener(new MouseAdapter() {
			// Show frmDetail
			@Override
			public void mousePressed(MouseEvent e) {
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
		btnX.addMouseListener(new MouseAdapter() {
			// Shut down the device
			@Override
			public void mousePressed(MouseEvent e) {
				try
				{
					Runtime r = Runtime.getRuntime();
					Process process = r.exec("sudo shutdown -h now");
				}
				catch(Exception E)
				{
							
				}
			}
		});
		btnX.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblIPAddress = new JLabel("x.x.x.x");
		lblIPAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblGateway = new JLabel("x.x.x.x");
		lblGateway.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblSubnet = new JLabel("x.x.x.x");
		lblSubnet.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnRefresh = new JButton("Actualiser");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					lblIPAddress.setText(GetLocalAddressIPv4());
					lblGateway.setText(GetGateway());
					lblSubnet.setText(MaskSubNet());
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(44, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
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
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(93)
							.addComponent(btnX)))
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
						.addComponent(lblMasqueDeSousrseau, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSubnet, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnX)
						.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		lblIPAddress.setText(GetLocalAddressIPv4());
		lblGateway.setText(GetGateway());
		lblSubnet.setText(MaskSubNet());
	}
	
	// Return the subnet mask
	public String MaskSubNet()
	{
		try
		{
			Runtime r = Runtime.getRuntime();
			Process process4 = r.exec("python netmask.py");
			BufferedReader in4 = new BufferedReader(new InputStreamReader(process4.getInputStream()));
			String line4 = "";
			String tmp = "";
            while ((line4 = in4.readLine()) != null) 
            {
                tmp = line4.toString();   
            }
            return tmp;   
		}
		catch(Exception e )
		{
			return "";	
		}
	}
	
	// Return the gateway
	public String GetGateway()
	{
		try
		{
			Runtime r = Runtime.getRuntime();
			Process process4 = r.exec("python gateways.py");
			BufferedReader in4 = new BufferedReader(new InputStreamReader(process4.getInputStream()));
			String line4 = "";
			String tmp = "";
            while ((line4 = in4.readLine()) != null) 
            {
                tmp = line4.toString();
            }
            return tmp;
		}
		catch(Exception e )
		{
			return "";
		}
	}
	
	// Return the ipv4 address
	public String GetLocalAddressIPv4() throws UnknownHostException {
		try
		{
			Runtime r = Runtime.getRuntime();
	        Process process = r.exec("bash ip.sh");
			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = "";
			String tmp ="";
	        while ((line = in.readLine()) != null) 
	        {
	        	tmp += line.toString();
	        }
	        return tmp;
		}
		catch(Exception e )
		{
			return "";
		}
		
		
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
