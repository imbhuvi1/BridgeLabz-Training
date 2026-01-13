package scenario_based.OnlineVotingSystem;

// Implementation
public class ElectionServiceImpl implements ElectionService {

    @Override
    public void castVote(Voter voter, Candidate candidate) throws DuplicateVoteException {
        if (voter.hasVoted()) {
            throw new DuplicateVoteException("Duplicate voting not allowed");
        }
        candidate.addVote();
        voter.setVoted(true);
    }

    @Override
    public void declareResult(Candidate[] candidates) {
        System.out.println("\n--- Election Result ---");
        for (Candidate c : candidates) {
            System.out.println(c.getName() + " : " + c.getVotes() + " votes");
        }
    }
}
