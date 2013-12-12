import java.util.Random;


public class Hero {
	private int heroHealth;
    private int heroStrength;
    private int heroIntelligence;
    private int heroAgility;
    private int heroArmor;
	private int heroArmorDurability;
    private int heroWeapon;
	private int heroWeaponDurability;
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
		heroWeaponDurability = 10;
		Main.getWindow().changeStats(Main.getParty());
	}
	public int getHeroWeapon() {
		return heroWeapon;
	}
	public String getHeroWeaponName() {
		if ( heroWeapon == 0 ) {
			return "Fist";
		} else if ( heroWeapon == 1 ) {
			return "Knife";
		} else if ( heroWeapon == 2 ) {
			return "Sword";
		} else if ( heroWeapon == 3 ) {
			return "Shotgun";
		} else {
			return "weapon error";
		}
	}

	public void equipArmor(int heroArmor) {
		this.heroArmor = heroArmor;
		heroArmorDurability = 10;
		Main.getWindow().changeStats(Main.getParty());
	}
	public int getHeroArmor() {
		return heroArmor;
	}
	public String getHeroArmorName() {
		if ( heroArmor == 0 ) {
			return "Clothes";
		} else if ( heroArmor == 1 ) {
			return "Jacket";
		} else if ( heroArmor == 2 ) {
			return "Shield";
		} else if ( heroArmor == 3 ) {
			return "Mail";
		} else {
			return "armor error";
		}
	}
	public static String getEquipmentType(Monster m) {
		if (m.getMonsterEquipment() == 1) {
			return "Knife (+1 attack)";
		} else if (m.getMonsterEquipment() == 2) {
			return "Jacket (+1 defense)";
		} else if (m.getMonsterEquipment() == 3) {
			return "Sword (+2 attack)";
		} else if (m.getMonsterEquipment() == 4) {
			return "Shield (+2 defense)";
		} else if (m.getMonsterEquipment() == 5) {
			return "Shotgun (+3 attack)";
		} else if (m.getMonsterEquipment() == 6) {
			return "Mail (+3 defense)";
		} else if (m.getMonsterEquipment() == 7) {
			return "Small Potion (+1 health)";
		} else if (m.getMonsterEquipment() == 8) {
			return "Medium Potion (+2 health)";
		} else if (m.getMonsterEquipment() == 9) {
			return "Large Potion (+3 health)";
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
				m.addMonsterHealthPoints(- getHeroDamage());
				if (heroWeaponDurability > 0) {
					addHeroWeaponDurability(-1);
				}
				setHeroHit(true);
			} else {
				setHeroHit(false);
			}
		}

	}

	public int getHeroArmorDurability() {
		return heroArmorDurability;
	}

	public void setHeroArmorDurability(int heroArmorDurability) {
		this.heroArmorDurability = heroArmorDurability;
	}

	public void addHeroArmorDurability(int i) {
		this.heroArmorDurability += i;
		if (heroArmorDurability <= 0) {
			heroArmor = 0;
		} else if ( heroArmorDurability >= 10) {
			heroArmor = 10;
		}
	}

	public int getHeroWeaponDurability() {
		return heroWeaponDurability;
	}

	public void setHeroWeaponDurability(int heroWeaponDurability) {
		this.heroWeaponDurability = heroWeaponDurability;
	}

	public void addHeroWeaponDurability(int i) {
		this.heroWeaponDurability += i;
		if (heroWeaponDurability <= 0) {
			heroWeapon = 0;
		} else if (heroWeaponDurability >= 10) {
			heroWeaponDurability = 10;
		}
	}

	public int getHeroDamage() {
		int heroDamage;
		heroDamage = heroWeapon;
		if (heroStrength % 3 > 0) {
			heroDamage++;
		}
		heroDamage += heroStrength/3;
		return heroDamage;
	}
}
