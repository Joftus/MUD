package Testing.Visual;

import java.awt.EventQueue;
import javax.swing.JFrame;

import Dungeon.Utility.Constants;

@SuppressWarnings("serial")
public class Application extends JFrame {

	public Application() {
		
		initUI();
	}
	
	private void initUI() {
		add(new Board());
		setSize(Constants.VISUAL_X, Constants.VISUAL_Y);
		setTitle("MUD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			Application ex = new Application();
			ex.setVisible(true);
		});
	}
}
