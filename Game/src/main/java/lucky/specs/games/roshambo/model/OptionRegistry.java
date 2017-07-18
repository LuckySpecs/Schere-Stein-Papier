package lucky.specs.games.roshambo.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class OptionRegistry {

    private static final String OPTION_SEPARATOR = " / ";
    private Map<String, Option> optionMap = new HashMap<>();

    public OptionRegistry() {
    }

    public Option getOption(String name) {
	return optionMap.get(name);
    }

    public Collection<Option> getOptions() {
	return optionMap.values();
    }

    public Option getOrCreateOption(String name) {
	Option option = getOption(name);

	if (option == null) {
	    option = new Option(name);
	    optionMap.put(name, option);
	}

	return option;
    }

    public void addFormula(String looser, String winner) {
	Option looserOption = getOrCreateOption(looser);
	Option winnerOption = getOrCreateOption(winner);
	looserOption.addSuccessor(winnerOption);
	winnerOption.addPredecessor(looserOption);
    }

    public String getOptionsString() {
	final StringBuilder builder = new StringBuilder();

	getOptions().forEach(option -> builder.append(option.getName()).append(OPTION_SEPARATOR));

	return builder.substring(0, builder.length() - OPTION_SEPARATOR.length());
    }

    public Option getRandomOption() {
	Random generator = new Random();
	int i = generator.nextInt(optionMap.size());
	List<Option> list = new LinkedList<>();
	list.addAll(getOptions());
	return list.get(i);
    }
}
