package lucky.specs.games.roshambo.model;

import java.util.HashSet;
import java.util.Set;

public class Option {
    private final String name;
    private Set<Option> predecessors = new HashSet<>();
    private Set<Option> successors = new HashSet<>();

    public Option(String name) {
	this.name = name;
    }

    public Set<Option> getPredecessors() {
	return predecessors;
    }

    public void addPredecessor(Option predecessor) {
	predecessors.add(predecessor);
    }

    public Set<Option> getSuccessors() {
	return successors;
    }

    public void addSuccessor(Option successor) {
	successors.add(successor);
    }

    public String getName() {
	return name;
    }

    @Override
    public boolean equals(Object other) {
	boolean isEqual = false;
	if (other != null && (this.getClass() == other.getClass())) {
	    isEqual = getName().equals(((Option) other).getName());
	}
	return isEqual;
    }

    @Override
    public int hashCode() {
	return name.hashCode();
    }
}
