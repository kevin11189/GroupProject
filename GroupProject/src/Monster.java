import java.util.Random;
public class Monster {
	private Random random = new Random();
	private int monsterStrength, monsterIntelligence, monsterAgility, monsterHealthPoints, monsterMaxHealthPoints;
	private String monsterName, monsterTarget;
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
				System.out.println("There is an error in the monster creation process.");
			}
		}
		monsterAlive = true;
	}

	private void slime() {
		monsterName = "slime";
		monsterHealthPoints = random.nextInt(2) + 1;
		monsterMaxHealthPoints = monsterHealthPoints;
		monsterStrength = random.nextInt(2) + 1;
		monsterIntelligence = random.nextInt(1) + 1;
		monsterAgility = random.nextInt(1) + 1;
	}

	private void orc()  {
		monsterName = "orc";
		monsterHealthPoints = random.nextInt(2) + 2;
		monsterMaxHealthPoints = monsterHealthPoints;
		monsterStrength = random.nextInt(3) + 2;
		monsterIntelligence = random.nextInt(3) + 2;
		monsterAgility = random.nextInt(3) + 2;
	}

	private void skeleton() {
		monsterName = "skeleton";
		monsterHealthPoints = random.nextInt(3) + 3;
		monsterMaxHealthPoints = monsterHealthPoints;
		monsterStrength = random.nextInt(4) + 3;
		monsterIntelligence = random.nextInt(4) + 3;
		monsterAgility = random.nextInt(4) + 3;
	}

	private void zombie() {
		monsterName = "zombie";
		monsterHealthPoints = random.nextInt(5) + 3;
		monsterMaxHealthPoints = monsterHealthPoints;
		monsterStrength = random.nextInt(3) + 5;
		monsterIntelligence = random.nextInt(3) + 1;
		monsterAgility = random.nextInt(3) + 2;
	}

	private void demon() {
		monsterName = "demon";
		monsterHealthPoints = random.nextInt(6) + 4;
		monsterMaxHealthPoints = monsterHealthPoints;
		monsterStrength = random.nextInt(5) + 7;
		monsterIntelligence = random.nextInt(4) + 4;
		monsterAgility = random.nextInt(4) + 1;
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
	public void monsterFight(Hero h) {
		if (h.isHeroAlive()) {
			if ( (random.nextInt(19) + 1) <= monsterAgility) {
				monsterHit = true;
				h.addHealth(- ((int)Math.ceil((double)monsterStrength/3.0) + h.getHeroArmor()));
				System.out.println(h.getHeroHealth());
			} else {
				monsterHit = false;
			}
		}
	}

	public String getMonsterTarget() {
		return monsterTarget;
	}

	public void setMonsterTarget(String monsterTarget) {
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
}