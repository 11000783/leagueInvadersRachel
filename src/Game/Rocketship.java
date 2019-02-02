package Game;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speedx;
	int speedy;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speedx = 0;
		speedy = 0;
	}

	void update() {
		super.update();
		y += speedy;
		x += speedx;
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}
}