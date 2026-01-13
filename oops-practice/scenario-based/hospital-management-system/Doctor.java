package scenario_based.HospitalManagementSystem;

// Doctor entity
public class Doctor extends Person {

    private String specialization;

    public Doctor(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    // polymorphic method
    public double calculateFee() {
        return 500;
    }
}
