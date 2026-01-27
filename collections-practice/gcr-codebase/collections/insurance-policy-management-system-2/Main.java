package gcr_codebase.collections.insurance_policy_management_system2;

import java.time.LocalDate;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Management manager = new Management();

		Policy p1 = new Policy(101, "Govind", LocalDate.now().plusDays(10).toString(), "Health", 5000);

		Policy p2 = new Policy(102, "Akash", LocalDate.now().plusDays(40).toString(), "Life", 12000);

		Policy p3 = new Policy(103, "Aman", LocalDate.now().minusDays(30).toString(), "Health", 5000);

		Policy p4 = new Policy(104, "Govind", LocalDate.now().plusDays(40).toString(), "Life", 12000);

		manager.addPolicy(p1);
		manager.addPolicy(p2);
		manager.addPolicy(p3);
		manager.addPolicy(p4);

		manager.displayAllPolicies();

		manager.expiringSoon();

		manager.getPolicy(101);

		manager.findPolicyHolderPolicies("Govind");

		manager.removeExpired();

		manager.displayAllPolicies();
	}

}