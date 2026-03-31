package gcr_codebase.streamapi;

import java.util.*;
import java.util.stream.*;

class Doctor implements Comparable<Doctor> {
	protected String name;
	protected boolean availableOnWeekends;
	protected String speciality;

	public Doctor(String name, boolean availableOnWeekends, String speciality) {
		this.availableOnWeekends = availableOnWeekends;
		this.name = name;
		this.speciality = speciality;
	}

	@Override
	public int compareTo(Doctor d) {
		return this.speciality.compareTo(d.speciality);
	}
}

public class DoctorAvailability {
	public static void main(String[] args) {
		List<Doctor> doctors = List.of(new Doctor("Dr. Manish", false, "Cardiologist"),
				new Doctor("Dr. Arpit", true, "Neurologist"), new Doctor("Dr. Bhuvnesh", false, "Gynacologist"),
				new Doctor("Dr. Ayush", false, "Dermatologist"), new Doctor("Dr. Prayank", true, "Orthopedic"),
				new Doctor("Dr. Puspendra", true, "Pediatrician  "), new Doctor("Dr. Shravan", true, "Orthopedic"),
				new Doctor("Dr. Lovekush", false, "Gynacologist"));

		System.out.println("Doctors available on weekends and sorted by specialty: \n");
		doctors.stream().filter(d -> d.availableOnWeekends).sorted()
				.forEach(d -> System.out.println(d.name + " (" + d.speciality.trim() + ")"));
	}
}
