
public class GameObject {

	int x;
	int y;
	int width;
	int height;
	int speed = 0;
	boolean isActive = true;
	int xSpeed;
	int ySpeed;
	
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	void update() {
		x+=xSpeed;
		y+=ySpeed;
	}
	
}
