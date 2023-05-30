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
	int score = 0;
	
	public ObjectManager(Rocketship rocket) {
		this.rocket=rocket;
	}
	
	
	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}
	
	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	
	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
		for (Projectile eachProjectile : projectiles) {
			eachProjectile.update();
		}
		checkCollision();
		purgeObjects();
		System.out.println(aliens.size());
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
		int projectilelength = projectiles.size()-1;
		while(projectilelength >= 0) {
			if (!projectiles.get(projectilelength).isActive) {
				projectiles.remove(projectilelength);
			}
			projectilelength--;
		}
	}

	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if (rocket.collisionBox.intersects(aliens.get(i).collisionBox)) {
				rocket.isActive = false;
				aliens.get(i).isActive = false;
			}
			for (int j = 0; j < projectiles.size(); j++) {
				if (projectiles.get(j).collisionBox.intersects(aliens.get(i).collisionBox)) {
					aliens.get(i).isActive = false;
					projectiles.get(j).isActive = false;
				}
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
