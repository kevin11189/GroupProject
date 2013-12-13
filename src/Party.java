import javax.swing.*;
import java.util.Random;

public class Party {

	private Hero[] party;
	private int x, y, numberOfPlayers, randomPlayer, roomsTraveled;
	private boolean running;
	private boolean successfulGoldPickup;
	private Random random = new Random();
	public Party(int players, boolean load) {
		party = new Hero[players];
		numberOfPlayers = players;
		x = 1;
		y = 1;
		roomsTraveled = 0;
		if (!load) {
			for(int i = 0; i < party.length; i++) {
				party[i] = new Hero(JOptionPane.showInputDialog("Enter a name for player " + (i + 1) + "."));
			}
		} else {
			for(int i = 0; i < party.length; i++) {
				party[i] = new Hero();
			}
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
			dropGold();
			Main.getWindow().startMove();
			Main.getWindow().startEquip();
			Main.getWindow().startOptions();
			Main.getWindow().stopCombatButtons();
		}
		if (!getHero(0).isHeroAlive() && !getHero(1).isHeroAlive() && !getHero(2).isHeroAlive()) {
			Main.getWindow().stopMove();
			Main.getWindow().stopCombatButtons();
			JOptionPane.showMessageDialog(null, "You have travelled " + roomsTraveled + " rooms. " + Main.getParty().getHero(0).getHeroName() + " has found " + Main.getParty().getHero(0).getHeroGold() + " gold. " + Main.getParty().getHero(1).getHeroName() + " has found " + Main.getParty().getHero(1).getHeroGold() + " gold. " + Main.getParty().getHero(2).getHeroName() + " has found " + Main.getParty().getHero(2).getHeroGold() + " gold.");
		}
		Main.getWindow().updateCombatLog();
		Main.getWindow().updateLoot();
	}

	public void partyRun() {
		running = true;
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
			roomsTraveled++;
			Main.newMonster();
			Main.getWindow().stopMove();
			Main.getWindow().startCombatButtons();
			Main.getWindow().stopEquip();
			Main.getWindow().stopOptions();
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
			roomsTraveled++;
			Main.newMonster();
			Main.getWindow().stopMove();
			Main.getWindow().startCombatButtons();
			Main.getWindow().stopEquip();
			Main.getWindow().stopOptions();
			Main.getWindow().changeStats(this);
		}
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void dropGold() {
		boolean findingGold = true;
		while(findingGold) {
			randomPlayer = random.nextInt(3);
			if (Main.getParty().getHero(randomPlayer).isHeroAlive()) {
				if (Main.getParty().getHero(randomPlayer).getHeroIntelligence() >= random.nextInt(20)) {
					successfulGoldPickup = true;
					Main.getParty().getHero(randomPlayer).addHeroGold(Main.getMonster().getMonsterGold());
				} else {
					successfulGoldPickup = false;
				}
				findingGold = false;
			}
		}
	}

	public int getRandomPlayer() {
		return randomPlayer;
	}

	public boolean isSuccessfulGoldPickup() {
		return successfulGoldPickup;
	}
	public void partyRest() {
		for (Hero aParty : party) {
			if (aParty.isHeroAlive()) {
				aParty.addHealth(1);
			}
		}
		if (random.nextInt(6) == 0) {
			Main.newMonster();
			Main.getWindow().stopMove();
			Main.getWindow().startCombatButtons();
			Main.getWindow().stopEquip();
			Main.getWindow().stopOptions();
			Main.getWindow().changeStats(this);
		}
	}

	public void setRoomsTraveled(int roomsTraveled) {
		this.roomsTraveled = roomsTraveled;
	}
	public int getRoomsTraveled() {
		return roomsTraveled;
	}
}
