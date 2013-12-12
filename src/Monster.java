import java.util.Random;
public class Monster {
	private Random random = new Random();
	private int monsterStrength, monsterIntelligence, monsterAgility, monsterHealthPoints, monsterMaxHealthPoints, monsterGold, monsterEquipment;
	private String monsterName;
	private Hero monsterTarget;
	private boolean monsterAttacked, monsterHit;
	private boolean monsterAlive = true;
	public Monster() {
		switch (random.nextInt(5) + 1) {
			case 1: {
				slime();
				break;
			}
			case 2: {
				orc();
				break;
			}
			case 3: {
				skeleton();
				break;
			}
			case 4: {
				zombie();
				break;
			}
			case 5: {
				demon();
				break;
			}
			default: {
			}
		}
		monsterAlive = true;
	}

	private void slime() {
//		monsterName = "slime";
//		monsterHealthPoints = random.nextInt(2) + 1;
//		monsterMaxHealthPoints = monsterHealthPoints;
//		monsterStrength = random.nextInt(2) + 1;
//		monsterIntelligence = random.nextInt(1) + 1;
//		monsterAgility = random.nextInt(1) + 1;
//		monsterGold = random.nextInt(20) + 10;
//		monsterEquipment = random.nextInt(10);
		monsterName = "Slime";
		monsterHealthPoints = random.nextInt(22) + 1;
		monsterMaxHealthPoints = monsterHealthPoints;
		monsterStrength = random.nextInt(22) + 1;
		monsterIntelligence = random.nextInt(21) + 1;
		monsterAgility = random.nextInt(21) + 1;
		monsterGold = random.nextInt(20) + 10;
		monsterEquipment = random.nextInt(10);
	}

	private void orc()  {
		monsterName = "Orc";
		monsterHealthPoints = random.nextInt(2) + 2;
		monsterMaxHealthPoints = monsterHealthPoints;
		monsterStrength = random.nextInt(3) + 2;
		monsterIntelligence = random.nextInt(3) + 2;
		monsterAgility = random.nextInt(3) + 2;
		monsterGold = random.nextInt(20) + 10;
		monsterEquipment = random.nextInt(10);
	}

	private void skeleton() {
		monsterName = "Skeleton";
		monsterHealthPoints = random.nextInt(3) + 3;
		monsterMaxHealthPoints = monsterHealthPoints;
		monsterStrength = random.nextInt(4) + 3;
		monsterIntelligence = random.nextInt(4) + 3;
		monsterAgility = random.nextInt(4) + 3;
		monsterGold = random.nextInt(20) + 10;
		monsterEquipment = random.nextInt(10);
	}

	private void zombie() {
		monsterName = "Zombie";
		monsterHealthPoints = random.nextInt(5) + 3;
		monsterMaxHealthPoints = monsterHealthPoints;
		monsterStrength = random.nextInt(3) + 5;
		monsterIntelligence = random.nextInt(3) + 1;
		monsterAgility = random.nextInt(3) + 2;
		monsterGold = random.nextInt(20) + 10;
		monsterEquipment = random.nextInt(10);
	}

	private void demon() {
		monsterName = "Demon";
		monsterHealthPoints = random.nextInt(6) + 4;
		monsterMaxHealthPoints = monsterHealthPoints;
		monsterStrength = random.nextInt(5) + 7;
		monsterIntelligence = random.nextInt(4) + 4;
		monsterAgility = random.nextInt(4) + 1;
		monsterGold = random.nextInt(20) + 10;
		monsterEquipment = random.nextInt(10);
	}

	public String getMonsterName() {
		return monsterName;
	}

	public boolean isMonsterAlive() {
		return monsterAlive;
	}

	public int getMonsterStrength() {
		return monsterStrength;
	}

	public int getMonsterIntelligence() {
		return monsterIntelligence;
	}

	public int getMonsterAgility() {
		return monsterAgility;
	}

	public int getMonsterHealthPoints() {
		return monsterHealthPoints;
	}

	public void addMonsterHealthPoints( int damage) {
		monsterHealthPoints += damage;
		if (monsterHealthPoints <= 0) {
			monsterHealthPoints = 0;
			monsterAlive = false;
		}
		Main.getWindow().changeStats(Main.getParty());
	}

	public int getMonsterMaxHealthPoints() {
		return monsterMaxHealthPoints;
	}
	public void monsterFight(Party p) {
		boolean attacking = true;
		int targetPlayer;
		while (attacking) {
			targetPlayer = random.nextInt(3);
			monsterAttacked = true;
			if (p.getHero(targetPlayer).isHeroAlive()) {
				if ( (random.nextInt(19) + 1) <= monsterAgility) {
					monsterHit = true;
					this.setMonsterTarget(Main.getParty().getHero(targetPlayer));
					p.getHero(targetPlayer).addHealth(-getMonsterDamage(p.getHero(targetPlayer)));
					p.getHero(targetPlayer).addHeroArmorDurability(-1);
				} else {
					monsterHit = false;
				}
				attacking = false;
			} else {
				attacking = true;
			}
		}
	}

	public Hero getMonsterTarget() {
		return monsterTarget;
	}

	public void setMonsterTarget(Hero monsterTarget) {
		this.monsterTarget = monsterTarget;
	}

	public boolean isMonsterHit() {
		return monsterHit;
	}

	public boolean isMonsterAttacked() {
		return monsterAttacked;
	}

	public void setMonsterAttacked(boolean monsterAttacked) {
		this.monsterAttacked = monsterAttacked;
	}

	public int getMonsterGold() {
		return monsterGold;
	}

	public int getMonsterEquipment() {
		return monsterEquipment;
	}

	public int getMonsterDamage(Hero h) {
		int monsterDamage;
		monsterDamage = monsterStrength/3;
		if (monsterStrength%3 > 0) {
			monsterDamage++;
		}
		monsterDamage -= h.getHeroArmor();
		if (monsterDamage <= 0) {
			monsterDamage = 0;
		}
		return monsterDamage;
	}
}