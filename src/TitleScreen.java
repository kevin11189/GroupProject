import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreen extends JFrame {

	public JFrame frame = new JFrame("Welcome Screen");

	public TitleScreen() {
		JPanel titlePanel = new JPanel();
		Container pane = frame.getContentPane();
		pane.setLayout(new GridLayout(0,1));
		pane.setBackground(Color.BLACK);
		pane.setBounds(0, 0, 800, 600);
		pane.setPreferredSize(new Dimension(800, 600));
		titlePanel.setLayout(new GridLayout(0, 1));
		titlePanel.setBackground(Color.BLACK);
		JLabel titleText = new JLabel("Group Project");
		JLabel author1 = new JLabel("Kevin Rutten");
		JLabel author2 = new JLabel("William Reilly");
		JLabel author3 = new JLabel("Alban S");
		JLabel author4 = new JLabel("Spencer Cruz");
		titleText.setForeground(Color.WHITE);
		author1.setForeground(Color.WHITE);
		author2.setForeground(Color.WHITE);
		author3.setForeground(Color.WHITE);
		author4.setForeground(Color.WHITE);
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		author1.setHorizontalAlignment(SwingConstants.CENTER);
		author2.setHorizontalAlignment(SwingConstants.CENTER);
		author3.setHorizontalAlignment(SwingConstants.CENTER);
		author4.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(titleText);
		titlePanel.add(author1);
		titlePanel.add(author2);
		titlePanel.add(author3);
		titlePanel.add(author4);
		JButton buttonNew = new JButton("New Game");
		buttonNew.addActionListener(new newGameListener());
		JButton buttonLoad = new JButton("Load");
		pane.add(titlePanel);
		pane.add(buttonNew);
		pane.add(buttonLoad);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private class newGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Main.newGame();
			frame.setVisible(false);
		}
	}
}
