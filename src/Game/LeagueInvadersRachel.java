package Game;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvadersRachel {
	public static void main(String[] args) {
		new LeagueInvadersRachel().setup();

	}

	JFrame frame = new JFrame();
	GamePanel panel;

	LeagueInvadersRachel() {
		frame = new JFrame();

	}

	void setup() {
		panel = new GamePanel();
		frame.add(panel);
		frame.addKeyListener(panel);
		final int x = 500;
		final int y = 800;
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(x, y);
		frame.getContentPane().setPreferredSize(new Dimension(x, y));
		frame.pack();
		panel.startGame();
	}
}
