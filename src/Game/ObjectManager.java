package Game;

import java.awt.Graphics;
import java.util.ArrayList;


public class ObjectManager {
	Rocketship ship;
	ArrayList <Projectille> projectile = new ArrayList<Projectille>();
	public ObjectManager(Rocketship object) {
	this.ship = object;

	}
void update() {
	ship.update();
	
}
void draw(Graphics g) {
	ship.draw(g);
	
}
}
