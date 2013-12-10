import java.awt.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class InputOutput extends Component {

	public static void save() throws IOException {
		String filename;
		boolean overwrite;
		System.out.print("Save Method Running.");
		filename = JOptionPane.showInputDialog("Please input filename:");
		File file = new File(filename);
		if (file.exists()) {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(null, "Save file exists. Would you like to overwrite it?", "Confirm",dialogButton);
			if(dialogResult==0) {
				System.out.println("Yes option");
				overwrite = true;
			} else {
				System.out.println("No Option");
				overwrite = false;
			}
		} else {
			overwrite = true;
		}
		if (overwrite) {
			PrintWriter outputFile = new PrintWriter(file);
			outputFile.println(Main.getParty().getHero(0).getHeroHealth());
			outputFile.println(Main.getParty().getHero(0).getHeroStrength());
			outputFile.println(Main.getParty().getHero(0).getHeroIntelligence());
			outputFile.println(Main.getParty().getHero(0).getHeroAgility());
			outputFile.println(Main.getParty().getHero(0).getHeroArmor());
			outputFile.println(Main.getParty().getHero(0).getHeroWeapon());
			outputFile.println(Main.getParty().getHero(0).getHeroGold());
			outputFile.println(Main.getParty().getHero(0).getHeroName());
			outputFile.println(Main.getParty().getHero(0).isHeroAlive());

			outputFile.println(Main.getParty().getHero(1).getHeroHealth());
			outputFile.println(Main.getParty().getHero(1).getHeroStrength());
			outputFile.println(Main.getParty().getHero(1).getHeroIntelligence());
			outputFile.println(Main.getParty().getHero(1).getHeroAgility());
			outputFile.println(Main.getParty().getHero(1).getHeroArmor());
			outputFile.println(Main.getParty().getHero(1).getHeroWeapon());
			outputFile.println(Main.getParty().getHero(1).getHeroGold());
			outputFile.println(Main.getParty().getHero(1).getHeroName());
			outputFile.println(Main.getParty().getHero(1).isHeroAlive());

			outputFile.println(Main.getParty().getHero(2).getHeroHealth());
			outputFile.println(Main.getParty().getHero(2).getHeroStrength());
			outputFile.println(Main.getParty().getHero(2).getHeroIntelligence());
			outputFile.println(Main.getParty().getHero(2).getHeroAgility());
			outputFile.println(Main.getParty().getHero(2).getHeroArmor());
			outputFile.println(Main.getParty().getHero(2).getHeroWeapon());
			outputFile.println(Main.getParty().getHero(2).getHeroGold());
			outputFile.println(Main.getParty().getHero(2).getHeroName());
			outputFile.println(Main.getParty().getHero(2).isHeroAlive());

			outputFile.println(Main.getParty().getX());
			outputFile.println(Main.getParty().getY());

			outputFile.close();
			System.out.println("Data written to the file.");
		}


	}
	public static void load() throws IOException {
		System.out.print("Load Method Running.");
		String filename = JOptionPane.showInputDialog("Please input filename:");
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		//Party need to be established with a new constructor... Or else it will annoy the user for new names. Will need to make it a complete load
		//	also, there is going to have to be an update script for the window. If not, there will be broken data. Check delay time to make sure
		//	there isn't an odd pause in the feedback.. Probably will be weird on mac, but on Windows it should just work.
		//	Think about that for the presentation.
		Main.getParty().getHero(0).setHeroHealth(inputFile.nextInt());
		inputFile.close();
	}
}
