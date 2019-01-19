package Game;

import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvadersRachel {
	public static void main(String[] args) {
		new LeagueInvadersRachel().setup();

	}

	static final int width = 500;
	static final int height = 800;
	JFrame frame = new JFrame();
	GamePanel panel;

	LeagueInvadersRachel() {
		frame = new JFrame();

	}

	void setup() {
		panel = new GamePanel();
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setSize(width, height);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.pack();
		panel.startGame();
	}
}
