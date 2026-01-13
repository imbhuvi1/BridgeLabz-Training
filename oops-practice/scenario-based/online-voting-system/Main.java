package scenario_based.OnlineVotingSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Candidate c1 = new Candidate(1, "Candidate A");
        Candidate c2 = new Candidate(2, "Candidate B");
        Candidate[] candidates = {c1, c2};

        System.out.print("Enter Voter ID: ");
        int vid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Voter Name: ");
        String vname = sc.nextLine();

        Voter voter = new Voter(vid, vname);
        ElectionService service = new ElectionServiceImpl();

        System.out.println("Choose Candidate: 1 or 2");
        int choice = sc.nextInt();

        try {
            if (choice == 1)
                service.castVote(voter, c1);
            else
                service.castVote(voter, c2);

            System.out.println("Vote Cast Successfully");
        } catch (DuplicateVoteException e) {
            System.out.println(e.getMessage());
        }

        service.declareResult(candidates);
        sc.close();
    }
}
