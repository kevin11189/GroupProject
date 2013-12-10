
public class Main {
	public static TitleScreen titleScreen;
	private static Window window;
	private static Party party;
	private static Monster monster;
	public static void main(String[] args) {
		titleScreen = new TitleScreen();
	}
	public static void newGame() {
		party = new Party(3);
		monster = new Monster();
		window = new Window(party);
	}
	public static Window getWindow() {
		return window;
	}
	public static Party getParty() {
		return party;
	}
	public static Monster getMonster() {
		return monster;
	}
	public static void newMonster() {
		monster = new Monster();
	}
}
