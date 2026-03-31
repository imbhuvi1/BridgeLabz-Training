package scenario_based.OnlineVotingSystem;

// Abstraction
public interface ElectionService {

    void castVote(Voter voter, Candidate candidate) throws DuplicateVoteException;
    void declareResult(Candidate[] candidates);
}
