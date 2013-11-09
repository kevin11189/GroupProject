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
		while (m.getMonsterAlive() && (player1.getHeroAlive() || player2.getHeroAlive() || player3.getHeroAlive()))  {
            if (player1.getHeroAlive()){
                player1.heroFight(m);
            }
            if (player2.getHeroAlive()) {
                player2.heroFight(m);
            }
            if (player3.getHeroAlive()) {
                player3.heroFight(m);
            }
            if (m.getMonsterAlive()) {
                if (player1.getHeroAlive()) {
                    m.monsterFight(player1);
                } else if (player2.getHeroAlive()) {
                    m.monsterFight(player2);
                } else if (player3.getHeroAlive()) {
                    m.monsterFight(player3);
                } else {
                    System.out.println("There is an error in the death of a character. All dead, but still going to fight sequence.");
                }
            }
        }
	}
}
