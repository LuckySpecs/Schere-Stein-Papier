package lucky.specs.games.roshambo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lucky.specs.games.roshambo.model.Game;

public class Application {

    public static void main(String[] args) {

	Game game = new Game();
	game.init();
	try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
	    System.out.println("Please insert your selection:");
	    String playerOptionString = br.readLine();
	    game.setInput(playerOptionString);
	    System.out.println(game.getResult());
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

}
