package lucky.specs.games.roshambo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lucky.specs.games.roshambo.model.Option;

public class Application {

    public static void main(String[] args) {
	OptionRegistry reg = new OptionRegistry();
	reg.addFormula("Stein", "Papier");
	reg.addFormula("Papier", "Schere");
	reg.addFormula("Schere", "Stein");

	try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
	    System.out.println("Please insert your selection:");
	    String playerOptionString = br.readLine();

	    Option playerOption = reg.getOption(playerOptionString);
	    if (playerOption == null) {
		System.err.println("Unknown option, accepted options : " + reg.getOptionsString());
	    }

	    Option appOption = reg.getRandomOption();

	    System.out.println("You: " + playerOptionString + " / Computer: " + appOption.getName());

	    if (appOption.getSuccessors().contains(playerOption)) {
		System.out.println("You won!");
	    } else if (appOption.getPredecessors().contains(playerOption)) {
		System.out.println("You lost!");
	    } else {
		System.out.println("Tie!");
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
