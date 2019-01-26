package Game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score;
	Rocketship ship;
	ArrayList<Projectille> projectiles = new ArrayList<Projectille>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	public ObjectManager(Rocketship object) {
		this.ship = object;
		this.score = 0;
	}

	void update() {
		ship.update();
		for (int i = 0; i < projectiles.size(); i++) {
			Projectille p = projectiles.get(i);
			p.update();
		}
		for (int e = 0; e < aliens.size(); e++) {
			Alien a = aliens.get(e);
			a.update();
		}
	}

	void draw(Graphics g) {
		ship.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			Projectille p = projectiles.get(i);
			p.draw(g);
		}
		for (int e = 0; e < aliens.size(); e++) {
			Alien a = aliens.get(e);
			a.draw(g);
		}
	}

	void addAlien(Alien a) {
		aliens.add(a);
	}

	void addProjectille(Projectille p) {
		projectiles.add(p);
	}

	public void manageEnemies() {

		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvadersRachel.width), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (!aliens.get(i).isAlive) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (!projectiles.get(i).isAlive) {
				projectiles.remove(i);
			}
		}
	}

	void checkCollision() {
		for (Alien a : aliens) {
			if (ship.collisionBox.intersects(a.collisionBox)) {
				ship.isAlive = false;
			}

			for (Projectille p : projectiles) {
				if (p.collisionBox.intersects(a.collisionBox)) {
					a.isAlive = false;
					p.isAlive = false;
					score += 1;
				}
			}
		}
	}

	void getScore() {

	}
}
