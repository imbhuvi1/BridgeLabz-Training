package scenario_based.OnlineVotingSystem;

// Voter entity
public class Voter {

    private int voterId;
    private String name;
    private boolean hasVoted;

    public Voter(int voterId, String name) {
        this.voterId = voterId;
        this.name = name;
        this.hasVoted = false;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void setVoted(boolean voted) {
        this.hasVoted = voted;
    }

    public String getName() {
        return name;
    }
}
