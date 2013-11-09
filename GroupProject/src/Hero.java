import java.util.Random;


public class Hero {
	private String heroName;
	private int heroStrength, heroIntelligence, heroAgility;
	private int heroHealthPoints = 20;
	private boolean heroAlive = true;
	
	Random random = new Random();
	
	
	public Hero( String name ) {
		heroName = name;
	}
	public String getHeroName() {
		return heroName;
	}
	public void setStats(int strength, int intelligence, int agility) {
		heroStrength = (random.nextInt(5) + 1) * strength;
		heroIntelligence = (random.nextInt(5) + 1) * intelligence;
		heroAgility = (random.nextInt(5) + 1) * agility;
	}
	public void printStats() {
		System.out.println(heroHealthPoints);
		System.out.println(heroStrength);
		System.out.println(heroIntelligence);
		System.out.println(heroAgility);
	}
	public boolean getHeroAlive() {
		return heroAlive;
	}
	public void fight(Monster m) {
		System.out.println(heroName + " is fighting a " + m.getMonsterName());
		if (this.heroStrength > m.getMonsterStrength()) {
			System.out.println("stronger");
		}
		else {
			System.out.println("weaker");
		}
	}
}

class Warrior extends Hero {
	public Warrior(String name) {
		super(name);
		super.setStats(3,2,1);
	}
}

class Wizard extends Hero {
	public Wizard(String name) {
		super(name);
		super.setStats(1,2,3);
	}
}

class Rogue extends Hero {
	public Rogue(String name) {
		super(name);
		super.setStats(2,3,1);
	}
}




