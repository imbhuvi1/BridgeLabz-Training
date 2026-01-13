package scenario_based.LibraryManagementSystem;

// Student fine logic
public class StudentFineCalculator implements FineCalculator {

    @Override
    public double calculateFine(long lateDays) {
        return lateDays > 5 ? (lateDays - 5) * 2 : 0;
    }
}
