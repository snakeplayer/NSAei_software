/*
 * Authors : F. Troller, D. Schito, B. Chauche
 * Date : 2017-2018
 * Project : NSAei
 * Class : frmLaunch.java
 * Description : Launch frmMain
 */

package NSAei_pkg;

import java.awt.Dimension;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class frmLaunch {

	public static void main(String[] args) throws IOException {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		// Launch frmMain
		frmMain frm = new frmMain();
		frm.setSize(new Dimension(480, 320));
		frm.setVisible(true);
	}

}
