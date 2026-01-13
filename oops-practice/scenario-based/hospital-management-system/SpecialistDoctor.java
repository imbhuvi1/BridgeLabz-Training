package scenario_based.HospitalManagementSystem;

// Specialized doctor (polymorphism)
public class SpecialistDoctor extends Doctor {

    public SpecialistDoctor(int id, String name, String specialization) {
        super(id, name, specialization);
    }

    @Override
    public double calculateFee() {
        return 1000;
    }
}
