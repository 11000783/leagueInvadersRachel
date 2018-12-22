package Game;

import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;

	public void GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void update() {
		x += 100;
		y += 30;
	}

	void draw(Graphics g) {
		g.fillRect(x, y, 100, 100);
	}
}
