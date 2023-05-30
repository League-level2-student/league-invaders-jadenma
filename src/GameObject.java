import java.awt.Rectangle;

public class GameObject {

	int x;
	int y;
	int width;
	int height;
	int speed = 0;
	boolean isActive = true;
	int xSpeed;
	int ySpeed;
	Rectangle collisionBox;
	
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(x, y, width, height);
		
	}
	
	void update() {
		if (x<0) {
			x=0;
		}
		if (x+width > LeagueInvaders.WIDTH) {
			x=LeagueInvaders.WIDTH-width;
		}
		if (y<0) {
			y=0;
		}
		if (y+height > LeagueInvaders.LENGTH) {
			y=LeagueInvaders.LENGTH-height;
		}
		x+=xSpeed;
		y+=ySpeed;
		collisionBox.setBounds(x, y, width, height);
	}
	
}
