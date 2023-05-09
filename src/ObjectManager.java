import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	
	public ObjectManager(Rocketship rocket) {
		this.rocket=rocket;
	}
	
	
	void addProjectile(Projectile projectile) {
		for (Projectile i : projectiles) {
			update();
			if (i.y > LeagueInvaders.LENGTH && i.y < 0) {
				i.isActive = false;
			}
		}
	}
	
	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
		for (int i = 0; i < aliens.size(); i++) {
			update();
			if (aliens.get(i).y > LeagueInvaders.LENGTH && aliens.get(i).y < 0) {
				aliens.get(i).isActive = false;
			}
		}
	}
	
	void update() {
		
	}
	
	void draw(Graphics g) {
		rocket.draw(g);
		for (Projectile i : projectiles) {
			i.draw(g);
		}
		for (Alien i : aliens) {
			i.draw(g);
		}
	}
	void purgeObjects() {
		int alienlength = aliens.size()-1;
		while(alienlength >= 0) {
			if (!aliens.get(alienlength).isActive) {
				aliens.remove(alienlength);
			}
			alienlength--;
		}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
