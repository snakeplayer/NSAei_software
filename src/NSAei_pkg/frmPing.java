/*
 * Authors : F. Troller, D. Schito, B. Chauche
 * Date : 2017-2018
 * Project : NSAei
 * Class : frmPing.java
 * Description : View used to configure a ping
 */

package NSAei_pkg;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class frmPing extends JFrame {
	private JTextField tfIPAddress;
	JFrame FrmParent;
	
	frmPing(JFrame frmParent) {
		FrmParent = frmParent;
		
		frmPing.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPing.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmPing.this.setUndecorated(true);
		
		JLabel lblText = new JLabel("Adresse IP \u00E0 PING :");
		lblText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPingResult = new JLabel("");
		lblPingResult.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		tfIPAddress = new JTextField();
		tfIPAddress.setText("10.134.96.1");
		tfIPAddress.setHorizontalAlignment(SwingConstants.CENTER);
		tfIPAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfIPAddress.setColumns(10);
		
		JButton btn192168 = new JButton("192.168.");
		btn192168.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfIPAddress.setText(btn192168.getText());
			}
		});
		
		btn192168.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btn100 = new JButton("10.0.");
		btn100.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfIPAddress.setText(btn100.getText());
			}
		});
		btn100.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btn10128 = new JButton("10.128.");
		btn10128.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfIPAddress.setText(btn10128.getText());
			}
		});
		btn10128.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btn17216 = new JButton("172.16.");
		btn17216.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfIPAddress.setText(btn17216.getText());
			}
		});
		btn17216.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnPing = new JButton("PING");
		btnPing.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frmPingResult frm = new frmPingResult(frmPing.this, tfIPAddress.getText());
				frm.setVisible(true);
				frm.setSize(new Dimension(480, 320));
				frmPing.this.setVisible(false);
			}
		});
		btnPing.setForeground(Color.BLACK);
		btnPing.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btn1 = new JButton("1");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfIPAddress.setText(tfIPAddress.getText().concat(btn1.getText()));
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btn2 = new JButton("2");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfIPAddress.setText(tfIPAddress.getText().concat(btn2.getText()));
			}
		});
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btn3 = new JButton("3");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfIPAddress.setText(tfIPAddress.getText().concat(btn3.getText()));
			}
		});
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btn4 = new JButton("4");
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfIPAddress.setText(tfIPAddress.getText().concat(btn4.getText()));
			}
		});
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btn5 = new JButton("5");
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfIPAddress.setText(tfIPAddress.getText().concat(btn5.getText()));
			}
		});
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btn6 = new JButton("6");
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfIPAddress.setText(tfIPAddress.getText().concat(btn6.getText()));
			}
		});
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btn7 = new JButton("7");
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfIPAddress.setText(tfIPAddress.getText().concat(btn7.getText()));
			}
		});
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btn8 = new JButton("8");
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfIPAddress.setText(tfIPAddress.getText().concat(btn8.getText()));
			}
		});
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btn9 = new JButton("9");
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfIPAddress.setText(tfIPAddress.getText().concat(btn9.getText()));
			}
		});
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btnDel = new JButton("SUP");
		btnDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfIPAddress.setText((tfIPAddress.getText() == null || tfIPAddress.getText().length() == 0) ? null : (tfIPAddress.getText().substring(0, tfIPAddress.getText().length() - 1)));
			}
		});
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btn0 = new JButton("0");
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfIPAddress.setText(tfIPAddress.getText().concat(btn0.getText()));
			}
		});
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btnPoint = new JButton(".");
		btnPoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tfIPAddress.setText(tfIPAddress.getText().concat(btnPoint.getText()));
			}
		});
		btnPoint.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btnBack = new JButton("Retour");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frmParent.setVisible(true);
				frmPing.this.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblText, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(tfIPAddress, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btn192168)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btn100, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btn10128, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btn17216, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnPing, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblPingResult, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btn0, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPoint, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
					.addGap(23))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblText, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfIPAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn192168)
								.addComponent(btn100, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btn10128, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn17216, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnPing, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPingResult, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn0, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPoint, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addGap(36))))
		);
		getContentPane().setLayout(groupLayout);
	}
}
