package scenario_based.LibraryManagementSystem;

// Staff fine logic
public class StaffFineCalculator implements FineCalculator {

    @Override
    public double calculateFine(long lateDays) {
        return lateDays > 10 ? (lateDays - 10) * 1 : 0;
    }
}
