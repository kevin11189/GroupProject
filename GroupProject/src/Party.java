import javax.swing.*;

public class Party {

	private Hero[] party;
	private int x, y;
	private boolean running;
	public Party(int players) {
		party = new Hero[players];
		x = 1;
		y = 1;
		for(int i = 0; i < party.length; i++)
		{
			party[i] = new Hero(JOptionPane.showInputDialog("Enter a name for player " + (i + 1) + "."));
		}

		for(int i = 0; i < party.length; i++)
		{
			System.out.println(party[i].getHeroName() + "\n" +
					party[i].getHeroStrength() + "\n" +
					party[i].getHeroIntelligence() + "\n" +
					party[i].getHeroAgility() + "\n" +
					party[i].getHeroHealth() + "\n" +
					party[i].getHeroArmor() + "\n" +
					party[i].getHeroWeapon() + "\n" +
					party[i].getHeroWeaponName() + "\n" +
					party[i].getHeroArmorName() + "\n" +
					party[i].getHeroGold()
			);
		}
	}

	public void partyFight( Monster m) {
		running = false;
		if (m.isMonsterAlive() && ( getHero(0).isHeroAlive() || getHero(1).isHeroAlive() || getHero(2).isHeroAlive() ) ) {
			if (getHero(0).isHeroAlive() && m.isMonsterAlive()) {
				getHero(0).heroFight(m);
			} else {
				getHero(0).setHeroAttack(false);
			}
			if (getHero(1).isHeroAlive() && m.isMonsterAlive()) {
				getHero(1).heroFight(m);
			} else {
				getHero(1).setHeroAttack(false);
			}
			if (getHero(2).isHeroAlive() && m.isMonsterAlive()) {
				getHero(2).heroFight(m);
			} else {
				getHero(2).setHeroAttack(false);
			}
			if (m.isMonsterAlive()) {
				m.setMonsterAttacked(true);
				if (getHero(0).isHeroAlive() || getHero(1).isHeroAlive() || getHero(2).isHeroAlive()) {

					m.monsterFight(Main.getParty());
				}
			} else {
				m.setMonsterAttacked(false);
			}
		}
		if (!m.isMonsterAlive()) {
			Main.getWindow().startMove();
			Main.getWindow().stopCombatButtons();
		}
		if (!(getHero(0).isHeroAlive() && getHero(1).isHeroAlive() && getHero(2).isHeroAlive())) {
			Main.getWindow().stopMove();
			Main.getWindow().stopCombatButtons();
			JOptionPane.showMessageDialog(null, "YOU LOSE BITCH");
		}
		Main.getWindow().updateCombatLog();
	}

	public void partyRun() {
		running = true;
		System.out.println("RUN!");
		Main.getMonster().monsterFight(Main.getParty());
		Main.getWindow().updateCombatLog();
		Main.getWindow().startMove();
		Main.getWindow().stopCombatButtons();
	}

	public boolean isRunning() {
		return running;
	}
	public Hero getHero(int i) {
		return party[i];
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void addX(int x) {
		this.x += x;
		if ( this.x < 0 ) {
			this.x = 0;
		} else if ( this.x > 2) {
			this.x = 2;
		} else {
			Main.newMonster();
			Main.getWindow().stopMove();
			Main.getWindow().startCombatButtons();
			Main.getWindow().changeStats(this);
		}
	}

	public void addY(int y) {
		this.y += y;
		if ( this.y < 0 ) {
			this.y = 0;
		} else if ( this.y > 4 ) {
			this.y = 4;
		} else {
			Main.newMonster();
			Main.getWindow().stopMove();
			Main.getWindow().startCombatButtons();
			Main.getWindow().changeStats(this);
		}
	}

}
