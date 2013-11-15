import java.util.Random;
import java.util.Scanner;


public class Hero {
	private String heroName;
	private int heroStrength, heroIntelligence, heroAgility;
	private int heroWeapon = 0;
	private int heroArmor = 0;
	private int heroHealthPoints = 20;
	private boolean heroAlive = true;
	Scanner keyboard = new Scanner( System.in );
	
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
		System.out.println("What would you like " + heroName + " to have as a weapon?");
		setHeroWeapon(keyboard.nextInt());
		System.out.println("What would you like " + heroName + " to have for armor?");
		setHeroArmor(keyboard.nextInt());
		printStats();
	}
	public void setHeroWeapon( int weapon ) {
		heroWeapon = weapon;
	}
	public void setHeroArmor( int armor ) {
		heroArmor = armor;
	}
	public int getHeroArmor () {
		return heroArmor;
	}
	public void printStats() {
		System.out.println(heroName);
		System.out.println(heroHealthPoints);
		System.out.println(heroStrength);
		System.out.println(heroIntelligence);
		System.out.println(heroAgility);
	}
	public boolean getHeroAlive() {
		return heroAlive;
	}
	public void heroFight(Monster m) {
		if (m.getMonsterAlive()) {
			if ( (random.nextInt(19) + 1) <= heroAgility) {
				System.out.println(heroName + " attacks " + m.getMonsterName() + " with " + heroStrength + " strength divided by three rounded up.");
				m.changeMonsterHealthPoints(- ((int)Math.round((double)heroStrength/3.0) + heroWeapon));
    	        System.out.println(m.getMonsterHealthPonts());
			} else {
				System.out.println(heroName + " missed");
			}
        }

	}
    public void changeHeroHealthPoints(int i) {
        heroHealthPoints+=i;
        if (heroHealthPoints <= 0) {
            System.out.println(heroName + " is dead.");
            heroKill();
        }

    }

    public void heroKill() {
        heroAlive = false;
    }

    public int getHeroHealthPoints() {
        return heroHealthPoints;
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




