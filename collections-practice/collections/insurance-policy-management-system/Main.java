package gcr_codebase.collections.insurance_policy_management_system;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Management manager = new Management();

		Policy p1 = new Policy(101, "Alice", "2026-02-10", "Health", 5000);
		Policy p2 = new Policy(102, "Bob", "2025-11-15", "Auto", 3000);
		Policy p3 = new Policy(103, "Charlie", "2025-10-01", "Home", 7000);
		Policy p4 = new Policy(101, "Duplicate Alice", "2026-03-01", "Health", 6000);

		manager.addPolicy(p1);
		manager.addPolicy(p2);
		manager.addPolicy(p3);
		manager.addPolicy(p4);

		manager.displayAllPolicies();
		manager.expiringSoon();
		manager.displayByCoverageType("Health");

		List<Policy> inputList = Arrays.asList(p1, p3, p4);
		manager.displayDuplicates(inputList);

		manager.compare();
	}

}
