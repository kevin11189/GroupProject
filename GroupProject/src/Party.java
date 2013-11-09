
public class Party {
	public Warrior player1;
	public Wizard player2;
	public Rogue player3;
	public Party(String warrior, String wizard, String rogue) {
		player1 = new Warrior(warrior);
		player2 = new Wizard(wizard);
		player3 = new Rogue(rogue);
	}
	
	public void partyFight(Monster m) {
		
		if (player1.getHeroAlive()){
			player1.heroFight(m);
		}
		if (player2.getHeroAlive()) {
			player2.heroFight(m);
		}
		if (player3.getHeroAlive()) {
			player3.heroFight(m);
		}

	}
}
