import java.util.Random;


public class Hero {
	private int heroHealth, heroStrength, heroIntelligence, heroAgility, heroArmor, heroWeapon, heroGold, heroDamage;
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

	//Name Methods
	public String getHeroName() {
		return heroName;
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

	//Agility Methods
	public int getHeroAgility() {
		return heroAgility;
	}

	//Intelligence Methods
	public int getHeroIntelligence() {
		return heroIntelligence;
	}

	//Strength Methods
	public int getHeroStrength() {
		return heroStrength;
	}

	//Health Methods
	public void addHealth(int healthPoints) {
		this.heroHealth += healthPoints;
		if (this.heroHealth <= 0) {
			this.heroHealth = 0;
			this.heroAlive = false;
		}
		Main.getWindow().changeStats(Main.getParty());
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

	//Alive Methods
	public boolean isHeroAlive() {
		return heroAlive;
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
				heroDamage = ((int)Math.ceil((double)heroStrength/3.0) + heroWeapon); //round weapon damage correctly
				setHeroHit(true);
			} else {
				setHeroHit(false);
			}
		}

	}
}
