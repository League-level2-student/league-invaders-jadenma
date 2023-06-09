import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=10;
		// TODO Auto-generated constructor stub
		if (needImage) {
		    loadImage ("rocket.png");
		}
	}

	void draw(Graphics g) {
	     if (gotImage) {
	   		g.drawImage(image, x, y, width, height, null);
	    }
	     else {
	   		g.setColor(Color.BLUE);
	   		g.fillRect(x, y, width, height);
	   	}
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
		super.update();
		
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
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10);
}
}
