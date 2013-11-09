
public class Party {
	public Warrior player1;
	public Wizard player2;
	public Rogue player3;
	public Party(String warrior, String wizard, String rogue) {
		player1 = new Warrior(warrior);
		player2 = new Wizard(wizard);
		player3 = new Rogue(rogue);
	}
	
	public void fight(Monster m) {
		player1.fight(m);
		player2.fight(m);
		player3.fight(m);
	}
}
