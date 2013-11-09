
public class GroupProject {

	
	public static void main(String[] args) {
		
		
		Party party = new Party("Kevin", "Jessica", "Sadie");
		
		while ( party.player1.getHeroAlive() || party.player2.getHeroAlive() || party.player3.getHeroAlive()) {
			party.fight(new Monster());
		}
		
		
		

		


		
	}

}
