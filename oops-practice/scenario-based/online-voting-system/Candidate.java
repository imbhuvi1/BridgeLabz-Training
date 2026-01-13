package scenario_based.OnlineVotingSystem;

// Candidate entity
public class Candidate {

    private int candidateId;
    private String name;
    private int votes;

    public Candidate(int candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
        this.votes = 0;
    }

    public void addVote() {
        votes++;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }
}
