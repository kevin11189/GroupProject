import java.util.Random;


public class Hero {
	private int heroHealth;
    private int heroStrength;
    private int heroIntelligence;
    private int heroAgility;
    private int heroArmor;
    private int heroWeapon;
    private int heroGold;
	private String heroName;
	private boolean heroAlive, heroHit, heroAttacked;
	Random random = new Random();
	public Hero(String n) {
		heroName = n;
		heroHealth = 20;
		heroStrength = random.nextInt(19) + 1;
		heroIntelligence = random.nextInt(19) + 1;
		heroAgility = random.nextInt(19) + 1;
		heroArmor = 0;
		heroWeapon = 0;
		heroGold = 0;
		heroAlive = true;
	}
	public Hero() {
		heroName = "Loading...";
		heroHealth = 20;
		heroStrength = random.nextInt(19) + 1;
		heroIntelligence = random.nextInt(19) + 1;
		heroAgility = random.nextInt(19) + 1;
		heroArmor = 0;
		heroWeapon = 0;
		heroGold = 0;
		heroAlive = true;
	}

	//Name Methods
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	//Weapon Methods
	public void equipWeapon(int heroWeapon) {
		this.heroWeapon = heroWeapon;
		Main.getWindow().changeStats(Main.getParty());
	}
	public int getHeroWeapon() {
		return heroWeapon;
	}
	public String getHeroWeaponName() {
		if ( heroWeapon == 0 ) {
			return "stick";
		} else if ( heroWeapon == 1 ) {
			return "knife";
		} else if ( heroWeapon == 2 ) {
			return "sword";
		} else if ( heroWeapon == 3 ) {
			return "shotgun";
		} else {
			return "weapon error";
		}
	}

	public void equipArmor(int heroArmor) {
		this.heroArmor = heroArmor;
		Main.getWindow().changeStats(Main.getParty());
	}
	public int getHeroArmor() {
		return heroArmor;
	}
	public String getHeroArmorName() {
		if ( heroArmor == 0 ) {
			return "birthday suit";
		} else if ( heroArmor == 1 ) {
			return "jacket";
		} else if ( heroArmor == 2 ) {
			return "shield";
		} else if ( heroArmor == 3 ) {
			return "suit o' armor";
		} else {
			return "armor error";
		}
	}
	public static String getEquipmentType(Monster m) {
		if (m.getMonsterEquipment() == 1) {
			return "knife (+1 attack)";
		} else if (m.getMonsterEquipment() == 2) {
			return "jacket (+1 defense)";
		} else if (m.getMonsterEquipment() == 3) {
			return "sword (+2 attack)";
		} else if (m.getMonsterEquipment() == 4) {
			return "shield (+2 defense)";
		} else if (m.getMonsterEquipment() == 5) {
			return "shotgun (+3 attack)";
		} else if (m.getMonsterEquipment() == 6) {
			return "suit o' armor (+3 defense)";
		} else if (m.getMonsterEquipment() == 7) {
			return "small potion (+1 health)";
		} else if (m.getMonsterEquipment() == 8) {
			return "medium potion (+2 health)";
		} else if (m.getMonsterEquipment() == 9) {
			return "large potion (+3 health)";
		} else {
			return "nothing.";
		}
	}
	public static void pickupEquipment(Hero h, int i) {
		if ( i == 1 ) {
			h.equipWeapon(1);
		} else if ( i == 2 ) {
			h.equipArmor(1);
		} else if ( i == 3 ) {
			h.equipWeapon(2);
		} else if ( i == 4 ) {
			h.equipArmor(2);
		} else if ( i == 5 ) {
			h.equipWeapon(3);
		} else if ( i == 6 ) {
			h.equipArmor(3);
		} else if ( i == 7 ) {
			h.addHealth(1);
		} else if ( i == 8 ) {
			h.addHealth(2);
		} else if ( i == 9 ) {
			h.addHealth(3);
		}
		Main.getWindow().stopEquip();
		Main.getWindow().changeStats(Main.getParty());
	}

	//Agility Methods
	public int getHeroAgility() {
		return heroAgility;
	}
	public void setHeroAgility(int heroAgility) {
		this.heroAgility = heroAgility;
	}

	//Intelligence Methods
	public int getHeroIntelligence() {
		return heroIntelligence;
	}
	public void setHeroIntelligence(int heroIntelligence) {
		this.heroIntelligence = heroIntelligence;
	}

	//Strength Methods
	public int getHeroStrength() {
		return heroStrength;
	}
	public void setHeroStrength(int heroStrength) {
		this.heroStrength = heroStrength;
	}

	//Health Methods
	public void addHealth(int healthPoints) {
		this.heroHealth += healthPoints;
		if (this.heroHealth <= 0) {
			this.heroHealth = 0;
			this.heroAlive = false;
		} else if (this.heroHealth >= 20) {
			this.heroHealth = 20;
		}
		Main.getWindow().changeStats(Main.getParty());
	}
	public void setHeroHealth(int heroHealth) {
		this.heroHealth = heroHealth;
	}
	public int getHeroHealth() {
		return heroHealth;
	}

	//Gold Methods
	public int getHeroGold() {
		return heroGold;
	}
	public void addHeroGold(int gold) {
		this.heroGold += gold;
		Main.getWindow().changeStats(Main.getParty());
	}
	public void setHeroGold(int heroGold) {
		this.heroGold = heroGold;
	}

	//Alive Methods
	public boolean isHeroAlive() {
		return heroAlive;
	}
	public void setHeroAlive(boolean heroAlive) {
		this.heroAlive = heroAlive;
	}

	//Attacked Methods
	public void setHeroAttack(boolean heroAttacked) {
		this.heroAttacked = heroAttacked;
	}
	public boolean didHeroAttack() {
		return heroAttacked;
	}

	//Hit Methods
	public void setHeroHit(boolean heroHit) {
		this.heroHit = heroHit;
	}
	public boolean didHeroHit() {
		return  heroHit;
	}

	//Fight Methods
	public void heroFight(Monster m) {
		setHeroAttack(true);
		if (m.isMonsterAlive()) {
			if ( (random.nextInt(19) + 1) <= heroAgility) {
				m.addMonsterHealthPoints(- ((int)Math.ceil((double)heroStrength/3.0) + heroWeapon));
				setHeroHit(true);
			} else {
				setHeroHit(false);
			}
		}

	}
}
