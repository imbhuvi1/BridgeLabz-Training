package scenario_based.HospitalManagementSystem;

import java.util.ArrayList;
import java.util.List;

// Patient entity
public class Patient extends Person {

    private List<String> medicalHistory = new ArrayList<>();

    public Patient(int id, String name) {
        super(id, name);
    }

    public void addMedicalRecord(String record) {
        medicalHistory.add(record);
    }

    public void viewMedicalHistory() {
        System.out.println("Medical History of " + name);
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }
}
