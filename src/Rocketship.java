import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=10;
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		 g.setColor(Color.BLUE);
	     g.fillRect(x, y, width, height);
	}
	
	public void up() {
	     ySpeed=-speed;
	}
	public void down() {
	     ySpeed=speed;
	}
	public void left() {
	     xSpeed=-speed;
	}
	public void right() {
	     xSpeed=speed;
	}
}
