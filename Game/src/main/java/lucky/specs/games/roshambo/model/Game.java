package lucky.specs.games.roshambo.model;

public class Game {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private OptionRegistry reg;
    private Option playerOption;

    public void init() {
	reg = new OptionRegistry();
	reg.addFormula("Stein", "Papier");
	reg.addFormula("Papier", "Schere");
	reg.addFormula("Schere", "Stein");
    }

    public String getResult() {
	StringBuilder result = new StringBuilder();
	Option appOption = reg.getRandomOption();
	result.append("You: " + playerOption.getName() + " / Computer: " + appOption.getName() + LINE_SEPARATOR);
	if (appOption.getSuccessors().contains(playerOption)) {
	    result.append("You won!");
	} else if (appOption.getPredecessors().contains(playerOption)) {
	    result.append("You lost!");
	} else {
	    result.append("Tie!");
	}
	return result.toString();
    }

    public void setInput(String playerOptionString) {
	playerOption = reg.getOption(playerOptionString);
	if (playerOption == null) {
	    System.err.println("Unknown option, accepted options : " + reg.getOptionsString());
	}
    }

}
