package scenario_based.OnlineVotingSystem;

// Custom exception
public class DuplicateVoteException extends Exception {

    public DuplicateVoteException(String message) {
        super(message);
    }
}
