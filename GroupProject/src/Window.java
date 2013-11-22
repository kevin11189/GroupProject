import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Window extends JFrame {
	public JFrame frame = new JFrame("RPG Project");
	private JPanel panel1, panel2, panel3, panel4, panel5, combatTextPanel, combatButtonPanel, directionPanel;
	private static JPanel[][] miniMap;
	private JLabel player0Name, player0Health, player0Strength, player0Intelligence, player0Agility, player0Armor, player0Weapon, player0Gold;
	private JLabel player1Name, player1Health, player1Strength, player1Intelligence, player1Agility, player1Armor, player1Weapon, player1Gold;
	private JLabel player2Name, player2Health, player2Strength, player2Intelligence, player2Agility, player2Armor, player2Weapon, player2Gold;
	private JLabel monsterName, monsterHealth, monsterStrength, monsterIntelligence, monsterAgility;
	private JLabel player0Damage, player1Damage, player2Damage, monsterDamage;
	private JButton buttonUp, buttonDown, buttonRight, buttonLeft, buttonFight, buttonRun;
	public Window(Party p) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPane(frame.getContentPane(), p);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		stopCombatButtons();
	}
	public void addComponentsToPane(Container pane, Party p) {
		JPanel panelIn;
		JButton button;
		JLabel label;
		int x = p.getX();
		int y = p.getY();
		pane.setLayout(null);
		pane.setBackground(Color.RED);
		pane.setBounds(0,0,800,600);
		pane.setPreferredSize(new Dimension(800,600));
		//panel1
		panel1 = new JPanel(new GridLayout(0,2));
		panel1.setBackground(Color.BLACK);
		panel1.setBounds(15, 15, 250, 280);
		//name
		label = new JLabel("Name: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1.add(label);
		player0Name = new JLabel(p.getHero(0).getHeroName());
		player0Name.setForeground(Color.WHITE);
		player0Name.setHorizontalAlignment(SwingConstants.LEFT);
		panel1.add(player0Name);
		//health
		label = new JLabel("Health: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1.add(label);
		player0Health = new JLabel(Integer.toString(p.getHero(0).getHeroHealth()) + " / 20");
		player0Health.setForeground(Color.WHITE);
		player0Health.setHorizontalAlignment(SwingConstants.LEFT);
		panel1.add(player0Health);
		//strength
		label = new JLabel("Strength: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1.add(label);
		player0Strength = new JLabel(Integer.toString(p.getHero(0).getHeroStrength()));
		player0Strength.setForeground(Color.WHITE);
		player0Strength.setHorizontalAlignment(SwingConstants.LEFT);
		panel1.add(player0Strength);
		//intelligence
		label = new JLabel("Intelligence: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1.add(label);
		player0Intelligence = new JLabel(Integer.toString(p.getHero(0).getHeroIntelligence()));
		player0Intelligence.setForeground(Color.WHITE);
		player0Intelligence.setHorizontalAlignment(SwingConstants.LEFT);
		panel1.add(player0Intelligence);
		//Agility
		label = new JLabel("Agility: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1.add(label);
		player0Agility = new JLabel(Integer.toString(p.getHero(0).getHeroAgility()));
		player0Agility.setForeground(Color.WHITE);
		player0Agility.setHorizontalAlignment(SwingConstants.LEFT);
		panel1.add(player0Agility);
		//Armor
		label = new JLabel("Armor: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1.add(label);
		player0Armor = new JLabel(p.getHero(0).getHeroArmorName() + " (+" + Integer.toString(p.getHero(0).getHeroArmor()) + ")");
		player0Armor.setForeground(Color.WHITE);
		player0Armor.setHorizontalAlignment(SwingConstants.LEFT);
		panel1.add(player0Armor);
		//Weapon
		label = new JLabel("Weapon: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1.add(label);
		player0Weapon = new JLabel(p.getHero(0).getHeroWeaponName() + " (+" + Integer.toString(p.getHero(0).getHeroWeapon()) + ")");
		player0Weapon.setForeground(Color.WHITE);
		player0Weapon.setHorizontalAlignment(SwingConstants.LEFT);
		panel1.add(player0Weapon);
		//gold
		label = new JLabel("Gold: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1.add(label);
		player0Gold = new JLabel(Integer.toString(p.getHero(0).getHeroGold()));
		player0Gold.setForeground(Color.WHITE);
		player0Gold.setHorizontalAlignment(SwingConstants.LEFT);
		panel1.add(player0Gold);
		//addToPanel
		pane.add(panel1);
		//panel2
		panel2 = new JPanel(new GridLayout(0,2));
		panel2.setBackground(Color.BLACK);
		panel2.setBounds(275, 15, 250, 280);
		//name
		label = new JLabel("Name: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(label);
		player1Name = new JLabel(p.getHero(1).getHeroName());
		player1Name.setForeground(Color.WHITE);
		player1Name.setHorizontalAlignment(SwingConstants.LEFT);
		panel2.add(player1Name);
		//health
		label = new JLabel("Health: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(label);
		player1Health = new JLabel(Integer.toString(p.getHero(1).getHeroHealth()) + " / 20");
		player1Health.setForeground(Color.WHITE);
		player1Health.setHorizontalAlignment(SwingConstants.LEFT);
		panel2.add(player1Health);
		//strength
		label = new JLabel("Strength: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(label);
		player1Strength = new JLabel(Integer.toString(p.getHero(1).getHeroStrength()));
		player1Strength.setForeground(Color.WHITE);
		player1Strength.setHorizontalAlignment(SwingConstants.LEFT);
		panel2.add(player1Strength);
		//intelligence
		label = new JLabel("Intelligence: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(label);
		player1Intelligence = new JLabel(Integer.toString(p.getHero(1).getHeroIntelligence()));
		player1Intelligence.setForeground(Color.WHITE);
		player1Intelligence.setHorizontalAlignment(SwingConstants.LEFT);
		panel2.add(player1Intelligence);
		//Agility
		label = new JLabel("Agility: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(label);
		player1Agility = new JLabel(Integer.toString(p.getHero(1).getHeroAgility()));
		player1Agility.setForeground(Color.WHITE);
		player1Agility.setHorizontalAlignment(SwingConstants.LEFT);
		panel2.add(player1Agility);
		//Armor
		label = new JLabel("Armor: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(label);
		player1Armor = new JLabel(p.getHero(1).getHeroArmorName() + " (+" + Integer.toString(p.getHero(1).getHeroArmor()) + ")");
		player1Armor.setForeground(Color.WHITE);
		player1Armor.setHorizontalAlignment(SwingConstants.LEFT);
		panel2.add(player1Armor);
		//Weapon
		label = new JLabel("Weapon: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(label);
		player1Weapon = new JLabel(p.getHero(1).getHeroWeaponName() + " (+" + Integer.toString(p.getHero(1).getHeroWeapon()) + ")");
		player1Weapon.setForeground(Color.WHITE);
		player1Weapon.setHorizontalAlignment(SwingConstants.LEFT);
		panel2.add(player1Weapon);
		//gold
		label = new JLabel("Gold: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel2.add(label);
		player1Gold = new JLabel(Integer.toString(p.getHero(1).getHeroGold()));
		player1Gold.setForeground(Color.WHITE);
		player1Gold.setHorizontalAlignment(SwingConstants.LEFT);
		panel2.add(player1Gold);
		//addToPanel
		pane.add(panel2);
		//panel3
		panel3 = new JPanel(new GridLayout(0,2));
		panel3.setBackground(Color.BLACK);
		panel3.setBounds(535, 15, 250, 280);
		//name
		label = new JLabel("Name: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel3.add(label);
		player2Name = new JLabel(p.getHero(2).getHeroName());
		player2Name.setForeground(Color.WHITE);
		player2Name.setHorizontalAlignment(SwingConstants.LEFT);
		panel3.add(player2Name);
		//health
		label = new JLabel("Health: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel3.add(label);
		player2Health = new JLabel(Integer.toString(p.getHero(2).getHeroHealth()) + " / 20");
		player2Health.setForeground(Color.WHITE);
		player2Health.setHorizontalAlignment(SwingConstants.LEFT);
		panel3.add(player2Health);
		//strength
		label = new JLabel("Strength: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel3.add(label);
		player2Strength = new JLabel(Integer.toString(p.getHero(2).getHeroStrength()));
		player2Strength.setForeground(Color.WHITE);
		player2Strength.setHorizontalAlignment(SwingConstants.LEFT);
		panel3.add(player2Strength);
		//intelligence
		label = new JLabel("Intelligence: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel3.add(label);
		player2Intelligence = new JLabel(Integer.toString(p.getHero(2).getHeroIntelligence()));
		player2Intelligence.setForeground(Color.WHITE);
		player2Intelligence.setHorizontalAlignment(SwingConstants.LEFT);
		panel3.add(player2Intelligence);
		//Agility
		label = new JLabel("Agility: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel3.add(label);
		player2Agility = new JLabel(Integer.toString(p.getHero(2).getHeroAgility()));
		player2Agility.setForeground(Color.WHITE);
		player2Agility.setHorizontalAlignment(SwingConstants.LEFT);
		panel3.add(player2Agility);
		//Armor
		label = new JLabel("Armor: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel3.add(label);
		player2Armor = new JLabel(p.getHero(2).getHeroArmorName() + " (+" + Integer.toString(p.getHero(2).getHeroArmor()) + ")");
		player2Armor.setForeground(Color.WHITE);
		player2Armor.setHorizontalAlignment(SwingConstants.LEFT);
		panel3.add(player2Armor);
		//Weapon
		label = new JLabel("Weapon: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel3.add(label);
		player2Weapon = new JLabel(p.getHero(2).getHeroWeaponName() + " (+" + Integer.toString(p.getHero(2).getHeroWeapon()) + ")");
		player2Weapon.setForeground(Color.WHITE);
		player2Weapon.setHorizontalAlignment(SwingConstants.LEFT);
		panel3.add(player2Weapon);
		//gold
		label = new JLabel("Gold: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel3.add(label);
		player2Gold = new JLabel(Integer.toString(p.getHero(2).getHeroGold()));
		player2Gold.setForeground(Color.WHITE);
		player2Gold.setHorizontalAlignment(SwingConstants.LEFT);
		panel3.add(player2Gold);
		//addToPanel
		pane.add(panel3);
		//panel4
		panel4 = new JPanel(null);
		panel4.setBackground(Color.BLACK);
		panel4.setBounds(15, 305, 510, 280);
		combatTextPanel = new JPanel(new GridLayout(0,1));
		combatTextPanel.setBounds(10, 10, 300, 80);
		combatTextPanel.setBackground(Color.BLACK);
		player0Damage = new JLabel("");
		player1Damage = new JLabel("");
		player2Damage = new JLabel("");
		monsterDamage = new JLabel("");
		player0Damage.setForeground(Color.GREEN);
		player1Damage.setForeground(Color.GREEN);
		player2Damage.setForeground(Color.GREEN);
		monsterDamage.setForeground(Color.RED);
		combatTextPanel.add(player0Damage);
		combatTextPanel.add(player1Damage);
		combatTextPanel.add(player2Damage);
		combatTextPanel.add(monsterDamage);
		panel4.add(combatTextPanel);
		combatButtonPanel = new JPanel(new GridLayout(1,0));
		combatButtonPanel.setBounds(10, 100, 370, 20);
		combatButtonPanel.setBackground(Color.BLACK);
		buttonFight = new JButton("Fight");
		buttonFight.addActionListener(new combatListenerFight());
		combatButtonPanel.add(buttonFight);
		buttonRun = new JButton("Run");
		buttonRun.addActionListener(new combatListenerRun());
		combatButtonPanel.add(buttonRun);
		panel4.add(combatButtonPanel);
		miniMap = new JPanel[5][3];
		for (int row = 0; row < miniMap.length; row++) {
			for (int col = 0; col < miniMap[row].length; col++) {
				miniMap[row][col] = new JPanel();
				if ( x == col && y == row) {
					miniMap[row][col].setBackground(Color.RED);
				} else {
					miniMap[row][col].setBackground(Color.WHITE);
				}
				miniMap[row][col].setBounds(390 + (col * 40), 10 + (row * 30), 30, 20);
				panel4.add(miniMap[row][col]);
			}
		}
		directionPanel = new JPanel(new GridLayout(2,2));
		buttonUp = new JButton("Up");
		buttonUp.addActionListener(new directionListenerUp());
		directionPanel.add(buttonUp);
		buttonDown = new JButton("Down");
		buttonDown.addActionListener(new directionListenerDown());
		directionPanel.add(buttonDown);
		buttonLeft = new JButton("Left");
		buttonLeft.addActionListener(new directionListenerLeft());
		directionPanel.add(buttonLeft);
		buttonRight = new JButton("Right");
		buttonRight.addActionListener(new directionListenerRight());
		directionPanel.add(buttonRight);
		directionPanel.setBounds(390, 160, 110, 110);
		directionPanel.setBackground(Color.BLACK);
		panel4.add(directionPanel);
		pane.add(panel4);

		//panel5
		panel5 = new JPanel(new GridLayout(0,2));
		panel5.setBackground(Color.BLACK);
		panel5.setBounds(535, 305, 250, 280);
		//name
		label = new JLabel("Name: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel5.add(label);
		monsterName = new JLabel(Main.getMonster().getMonsterName());
		monsterName.setForeground(Color.WHITE);
		monsterName.setHorizontalAlignment(SwingConstants.LEFT);
		panel5.add(monsterName);
		//health
		label = new JLabel("Health: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel5.add(label);
		monsterHealth = new JLabel(Integer.toString(Main.getMonster().getMonsterHealthPoints()) + " / " + Integer.toString(Main.getMonster().getMonsterMaxHealthPoints()));
		monsterHealth.setForeground(Color.WHITE);
		monsterHealth.setHorizontalAlignment(SwingConstants.LEFT);
		panel5.add(monsterHealth);
		//strength
		label = new JLabel("Strength: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel5.add(label);
		monsterStrength = new JLabel(Integer.toString(Main.getMonster().getMonsterStrength()));
		monsterStrength.setForeground(Color.WHITE);
		monsterStrength.setHorizontalAlignment(SwingConstants.LEFT);
		panel5.add(monsterStrength);
		//intelligence
		label = new JLabel("Intelligence: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel5.add(label);
		monsterIntelligence = new JLabel(Integer.toString(Main.getMonster().getMonsterIntelligence()));
		monsterIntelligence.setForeground(Color.WHITE);
		monsterIntelligence.setHorizontalAlignment(SwingConstants.LEFT);
		panel5.add(monsterIntelligence);
		//Agility
		label = new JLabel("Agility: ");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel5.add(label);
		monsterAgility = new JLabel(Integer.toString(Main.getMonster().getMonsterAgility()));
		monsterAgility.setForeground(Color.WHITE);
		monsterAgility.setHorizontalAlignment(SwingConstants.LEFT);
		panel5.add(monsterAgility);
		//addToPanel
		pane.add(panel5);
	}
	public void changeStats(Party p) {
		//player0
		player0Name.setText(p.getHero(0).getHeroName());
		player0Health.setText(Integer.toString(p.getHero(0).getHeroHealth()) + " / 20");
		player0Strength.setText(Integer.toString(p.getHero(0).getHeroStrength()));
		player0Intelligence.setText(Integer.toString(p.getHero(0).getHeroIntelligence()));
		player0Agility.setText(Integer.toString(p.getHero(0).getHeroAgility()));
		player0Armor.setText(p.getHero(0).getHeroArmorName() + " (+" + Integer.toString(p.getHero(0).getHeroArmor()) + ")");
		player0Weapon.setText(p.getHero(0).getHeroWeaponName() + " (+" + Integer.toString(p.getHero(0).getHeroWeapon()) + ")");
		player0Gold.setText(Integer.toString(p.getHero(0).getHeroGold()));
		//player1
		player1Name.setText(p.getHero(1).getHeroName());
		player1Health.setText(Integer.toString(p.getHero(1).getHeroHealth()) + " / 20");
		player1Strength.setText(Integer.toString(p.getHero(1).getHeroStrength()));
		player1Intelligence.setText(Integer.toString(p.getHero(1).getHeroIntelligence()));
		player1Agility.setText(Integer.toString(p.getHero(1).getHeroAgility()));
		player1Armor.setText(p.getHero(1).getHeroArmorName() + " (+" + Integer.toString(p.getHero(1).getHeroArmor()) + ")");
		player1Weapon.setText(p.getHero(1).getHeroWeaponName() + " (+" + Integer.toString(p.getHero(1).getHeroWeapon()) + ")");
		player1Gold.setText(Integer.toString(p.getHero(1).getHeroGold()));
		//player2
		player2Name.setText(p.getHero(2).getHeroName());
		player2Health.setText(Integer.toString(p.getHero(2).getHeroHealth()) + " / 20");
		player2Strength.setText(Integer.toString(p.getHero(2).getHeroStrength()));
		player2Intelligence.setText(Integer.toString(p.getHero(2).getHeroIntelligence()));
		player2Agility.setText(Integer.toString(p.getHero(2).getHeroAgility()));
		player2Armor.setText(p.getHero(2).getHeroArmorName() + " (+" + Integer.toString(p.getHero(2).getHeroArmor()) + ")");
		player2Weapon.setText(p.getHero(2).getHeroWeaponName() + " (+" + Integer.toString(p.getHero(2).getHeroWeapon()) + ")");
		player2Gold.setText(Integer.toString(p.getHero(2).getHeroGold()));
		//monster
		monsterName.setText(Main.getMonster().getMonsterName());
		monsterHealth.setText(Integer.toString(Main.getMonster().getMonsterHealthPoints()) + " / " + Integer.toString(Main.getMonster().getMonsterMaxHealthPoints()));
		monsterStrength.setText(Integer.toString(Main.getMonster().getMonsterStrength()));
		monsterIntelligence.setText(Integer.toString(Main.getMonster().getMonsterIntelligence()));
		monsterAgility.setText(Integer.toString(Main.getMonster().getMonsterAgility()));

	}
	public void updateMiniMap() {
		int x = Main.getParty().getX();
		int y = Main.getParty().getY();
		for (int row = 0; row < miniMap.length; row++) {
			for (int col = 0; col < miniMap[row].length; col++) {
				if ( x == col && y == row) {
					miniMap[row][col].setBackground(Color.RED);
				} else {
					miniMap[row][col].setBackground(Color.WHITE);
				}
			}
		}
	}
	public void updateCombatLog() {
		//combat
		if (Main.getParty().getHero(0).didHeroAttack()) {
			if (Main.getParty().getHero(0).didHeroHit()) {
				player0Damage.setText(Main.getParty().getHero(0).getHeroName() + " attacks " + Main.getMonster().getMonsterName() + " for " + ((int)Math.round((double)Main.getParty().getHero(0).getHeroStrength()/3.0) + Main.getParty().getHero(0).getHeroWeapon()));//attacked hit
			} else {
				player0Damage.setText(Main.getParty().getHero(0).getHeroName() + " missed.");//attacked missed
			}
		} else {
			player0Damage.setText(Main.getParty().getHero(0).getHeroName() + " didn't get a chance to attack.");
		}
		if (Main.getParty().getHero(1).didHeroAttack()) {
			if (Main.getParty().getHero(1).didHeroHit()) {
				player1Damage.setText(Main.getParty().getHero(1).getHeroName() + " attacks " + Main.getMonster().getMonsterName() + " for " + ((int)Math.round((double)Main.getParty().getHero(1).getHeroStrength()/3.0) + Main.getParty().getHero(1).getHeroWeapon()));//attacked hit
			} else {
				player1Damage.setText(Main.getParty().getHero(1).getHeroName() + " missed.");//attacked missed
			}
		} else {
			player1Damage.setText(Main.getParty().getHero(1).getHeroName() + " didn't get a chance to attack.");
		}
		if (Main.getParty().getHero(2).didHeroAttack()) {
			if (Main.getParty().getHero(2).didHeroHit()) {
				player2Damage.setText(Main.getParty().getHero(2).getHeroName() + " attacks " + Main.getMonster().getMonsterName() + " for " + ((int)Math.round((double)Main.getParty().getHero(2).getHeroStrength()/3.0) + Main.getParty().getHero(2).getHeroWeapon()));//attacked hit
			} else {
				player2Damage.setText(Main.getParty().getHero(2).getHeroName() + " missed.");//attacked missed
			}
		} else {
			player2Damage.setText(Main.getParty().getHero(2).getHeroName() + " didn't get a chance to attack.");
		}
		//monster
		if (Main.getMonster().isMonsterAttacked()) {
			if (Main.getMonster().isMonsterHit()) {
				monsterDamage.setText(Main.getMonster().getMonsterName() + " attacks " + Main.getMonster().getMonsterTarget() + " for " + (int)Math.round((double)Main.getMonster().getMonsterStrength()/3.0));//attacked hit
			} else {
				monsterDamage.setText(Main.getMonster().getMonsterName() + " missed.");//attacked missed
			}
		} else {
			monsterDamage.setText(Main.getMonster().getMonsterName() + " didn't get a chance to attack.");
		}
	}
	public void clearCombatLog() {
		player0Damage.setText("");
		player1Damage.setText("");
		player2Damage.setText("");
		monsterDamage.setText("");
	}
	public void stopMove() {
		buttonUp.setEnabled(false);
		buttonDown.setEnabled(false);
		buttonLeft.setEnabled(false);
		buttonRight.setEnabled(false);
	}
	public void startMove() {
		buttonUp.setEnabled(true);
		buttonDown.setEnabled(true);
		buttonLeft.setEnabled(true);
		buttonRight.setEnabled(true);
	}
	public void stopCombatButtons() {
		buttonFight.setEnabled(false);
		buttonRun.setEnabled(false);
	}
	public void startCombatButtons() {
		buttonFight.setEnabled(true);
		buttonRun.setEnabled(true);
	}
	private class directionListenerUp implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Main.getParty().addY(-1);
			updateMiniMap();
			clearCombatLog();
		}
	}
	private class directionListenerDown implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Main.getParty().addY(1);
			updateMiniMap();
			clearCombatLog();
		}
	}
	private class directionListenerLeft implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Main.getParty().addX(-1);
			updateMiniMap();
			clearCombatLog();
		}
	}
	private class directionListenerRight implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Main.getParty().addX(1);
			updateMiniMap();
			clearCombatLog();
		}
	}
	private class combatListenerFight implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Main.getParty().partyFight(Main.getMonster());
		}
	}
	private class combatListenerRun implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Run");
		}
	}
}