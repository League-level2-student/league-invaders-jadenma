import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {

	JFrame frame;
	GamePanel panel;
	public static final int WIDTH = 500;
	public static final int LENGTH = 800;
	
	public LeagueInvaders() {
		frame = new JFrame();
		panel = new GamePanel();
	}
	
	void setup() {
		frame.add(panel);
		frame.setSize(WIDTH, LENGTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
	}
	
	public static void main(String[] args) {
		LeagueInvaders invader = new LeagueInvaders();
		invader.setup();
		
	}
	
}