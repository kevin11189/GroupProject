import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Panel extends JFrame {
    private JLabel messageLabel;

    private JLabel player1Label, player2Label, player3Label;

    private JButton redButton;
    private JButton blueButton;
    private JButton yellowButtom;
    private JPanel panel;
    private JPanel characterPanel;


    private final int WINDOW_HEIGHT = 600;
    private final int WINDOW_WIDTH = 800;

    //Constructor
    public Panel() {
        setTitle("Colors");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        messageLabel = new JLabel("Click a button to select a color.");
        player1Label = new JLabel("player1");
        player2Label = new JLabel("player2");
        player3Label = new JLabel("player3");
        redButton = new JButton("Red");
        blueButton = new JButton("Blue");
        yellowButtom = new JButton("Yellow");

        redButton.addActionListener(new RedButtonListener());
        blueButton.addActionListener(new BlueButtonListener());
        yellowButtom.addActionListener(new YellowButtonListener());

        panel = new JPanel();
        panel.add(messageLabel);
        panel.add(redButton);
        panel.add(blueButton);
        panel.add(yellowButtom);

        characterPanel = new JPanel(new GridLayout(3,1));
        characterPanel.add(player1Label);
        characterPanel.add(player2Label);
        characterPanel.add(player3Label);
        characterPanel.setBounds(100, 100, 100, 100);

        add(characterPanel);

        setVisible(true);
    }

    private class RedButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.RED);
            messageLabel.setForeground(Color.BLUE);
        }
    }

    public class BlueButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.BLUE);
            messageLabel.setForeground(Color.YELLOW);
        }
    }

    public class YellowButtonListener implements  ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.YELLOW);
            messageLabel.setForeground(Color.RED);
        }
    }



}
