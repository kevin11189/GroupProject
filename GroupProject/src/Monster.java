import java.util.Random;
public class Monster {
	private Random random = new Random();
	private int monsterTypeInt, monsterStrength, monsterIntelligence, monsterAgility, monsterHealthPoints;
	private String monsterName;
	private boolean monsterAlive = true;
	public Monster() {
		setMonsterType();
	}
	
	public Monster( int type ) {
		switch (type) {
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
				setMonsterType();
				break;
			}
		}
		
	}
	
	public Monster( String type ) {
		switch (type.toLowerCase()) {
			case "slime": {
				slime();
				break;
			}
			case "orc": {
				orc();
				break;
			}
			case "skeleton": {
				skeleton();
				break;
			}
			case "zombie": {
				zombie();
				break;
			}
			case "demon": {
				demon();
				break;
			}
			default: {
				setMonsterType();
				break;
			}
		}
		
	}
	
	private void setMonsterType() {
		monsterTypeInt = random.nextInt(5) + 1;
		switch (monsterTypeInt) {
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
	}
	
	public void printMonsterStats() {
		System.out.println(monsterHealthPoints);
		System.out.println(monsterStrength);
		System.out.println(monsterIntelligence);
		System.out.println(monsterAgility);
	}
	
	public int getMonsterStrength() {
		return monsterStrength;
	}
	public String getMonsterName() {
		return monsterName;
	}
	
	private void slime() {
			monsterTypeInt = 1;
			monsterName = "slime";
			monsterHealthPoints = random.nextInt(2) + 1;
			monsterStrength = random.nextInt(2) + 1;
			monsterIntelligence = random.nextInt(1) + 1;
			monsterAgility = random.nextInt(1) + 1;
	}
	
	private void orc()  {
			monsterTypeInt = 2;
			monsterName = "orc";
			monsterHealthPoints = random.nextInt(2) + 2;
			monsterStrength = random.nextInt(3) + 2;
			monsterIntelligence = random.nextInt(3) + 2;
			monsterAgility = random.nextInt(3) + 2;
	}
	
	private void skeleton() {
			monsterTypeInt = 3;
			monsterName = "skeleton";
			monsterHealthPoints = random.nextInt(3) + 3;
			monsterStrength = random.nextInt(4) + 3;
			monsterIntelligence = random.nextInt(4) + 3;
			monsterAgility = random.nextInt(4) + 3;
	}
	
	private void zombie() {
			monsterTypeInt = 4;
			monsterName = "zombie";
			monsterHealthPoints = random.nextInt(5) + 3;
			monsterStrength = random.nextInt(3) + 5;
			monsterIntelligence = random.nextInt(3) + 1;
			monsterAgility = random.nextInt(3) + 2;
	}
	
	private void demon() {
			monsterTypeInt = 5;
			monsterName = "demon";
			monsterHealthPoints = random.nextInt(6) + 4;
			monsterStrength = random.nextInt(5) + 7;
			monsterIntelligence = random.nextInt(4) + 4;
			monsterAgility = random.nextInt(4) + 1;
			
	}
}



