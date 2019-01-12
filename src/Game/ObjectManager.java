package Game;

import java.awt.Graphics;
import java.util.ArrayList;


public class ObjectManager {
	Rocketship ship;
	ArrayList <Projectille> projectiles = new ArrayList<Projectille>();
	public ObjectManager(Rocketship object) {
	this.ship = object;

	}
void update() {
	ship.update();
	for (int i = 0; i < projectiles.size(); i++) {
		Projectille p = projectiles.get(i);
		p.update();
	}
}
void draw(Graphics g) {
	ship.draw(g);
	for (int i = 0; i < projectiles.size(); i++) {
		Projectille p = projectiles.get(i);
		p.draw(g);
	System.out.println("wow");
	}
}
void addProjectille(Projectille p) {
projectiles.add(p);
}
}
