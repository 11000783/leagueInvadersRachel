package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer time;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font instFont;
	Rocketship ship = new Rocketship(250, 700, 50, 50);
	ObjectManager manager = new ObjectManager(ship);
    public static BufferedImage alienImg;
    public static BufferedImage rocketImg;
    public static BufferedImage bulletImg;
    public static BufferedImage spaceImg;

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		manager.purgeObjects();
		if (!ship.isAlive) {
			currentState = END_STATE;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 24, 200);
		g.setFont(instFont);
		g.drawString("Press ENTER to start", 95, 400);
		g.drawString("Press SPACE for instructions", 50, 600);

	}

	void drawGameState(Graphics g) {
		g.drawImage(spaceImg,0,0, LeagueInvadersRachel.width, LeagueInvadersRachel.height, null);
		manager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 125, 200);
		g.setFont(instFont);
		g.drawString("You killed " + manager.score + " enemies", 110, 400);
		g.drawString("Press ENTER to restart", 90, 600);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}

	}

	GamePanel() {
		time = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		instFont = new Font("Arial", Font.PLAIN, 30);
		 try {

             alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));

             rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));

             bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));

             spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

     } catch (IOException e) {

             // TODO Auto-generated catch block

             e.printStackTrace();

     }
	}

	void startGame() {
		time.start();
	}

	@Override

	public void paintComponent(Graphics g) {
	
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			ship.speedy = 10;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			ship.speedy = -10;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ship.speedx = 10;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ship.speedx = -10;
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {
				
				ship = new Rocketship(250, 700, 50, 50);
				manager = new ObjectManager(ship);
				System.out.println("end");
				
				currentState = MENU_STATE;
			}

		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.addProjectille(new Projectille(ship.x + 20, ship.y, 10, 10));

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 38) {
			ship.speedy = 0;
		}
		if (e.getKeyCode() == 40) {
			ship.speedy = 0;
		}
		if (e.getKeyCode() == 39) {
			ship.speedx = 0;
		}
		if (e.getKeyCode() == 37) {
			ship.speedx = 0;
		}

	}
}
