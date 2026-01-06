package gcr_codebase.encapsulation_polymorphism_interface_abstraction;

//Interface for medical record operations
interface MedicalRecord {
  void addRecord(String record);
  void viewRecords();
}

//Abstract class representing a patient
abstract class Patient {
  private int patientId;
  private String name;
  private int age;

  //Sensitive data protected using encapsulation
  private String diagnosis;
  private String medicalHistory;

  public Patient(int patientId, String name, int age) {
      this.patientId = patientId;
      this.name = name;
      this.age = age;
  }

  //Abstract method for bill calculation
  public abstract double calculateBill();

  //Concrete method to display patient details
  public void getPatientDetails() {
      System.out.println("Patient ID: " + patientId);
      System.out.println("Name: " + name);
      System.out.println("Age: " + age);
  }

  //Setter methods for sensitive data
  protected void setDiagnosis(String diagnosis) {
      this.diagnosis = diagnosis;
  }

  protected void setMedicalHistory(String medicalHistory) {
      this.medicalHistory = medicalHistory;
  }

  //Getter methods for sensitive data
  protected String getDiagnosis() {
      return diagnosis;
  }

  protected String getMedicalHistory() {
      return medicalHistory;
  }
}

//Class representing in patient
class InPatient extends Patient implements MedicalRecord {

  private int daysAdmitted;
  private double dailyCharge;

  public InPatient(int patientId, String name, int age, int daysAdmitted, double dailyCharge) {
      super(patientId, name, age);
      this.daysAdmitted = daysAdmitted;
      this.dailyCharge = dailyCharge;
  }

  //Override method for bill calculation
  @Override
  public double calculateBill() {
      return daysAdmitted * dailyCharge;
  }

  //Add medical record
  @Override
  public void addRecord(String record) {
      setMedicalHistory(record);
  }

  //View medical record
  @Override
  public void viewRecords() {
      System.out.println("Medical History: " + getMedicalHistory());
  }
}

//Class representing out patient
class OutPatient extends Patient implements MedicalRecord {

  private double consultationFee;

  public OutPatient(int patientId, String name, int age, double consultationFee) {
      super(patientId, name, age);
      this.consultationFee = consultationFee;
  }

  //Override method for bill calculation
  @Override
  public double calculateBill() {
      return consultationFee;
  }

  //Add medical record
  @Override
  public void addRecord(String record) {
      setDiagnosis(record);
  }

  //View medical record
  @Override
  public void viewRecords() {
      System.out.println("Diagnosis: " + getDiagnosis());
  }
}

//Main class demonstrating polymorphism
public class HospitalPatientManagement {

  public static void processPatient(Patient patient) {

      patient.getPatientDetails();
      System.out.println("Total Bill: " + patient.calculateBill());

      if (patient instanceof MedicalRecord) {
          ((MedicalRecord) patient).viewRecords();
      }

      System.out.println();
  }

  public static void main(String[] args) {

      Patient p1 = new InPatient(101, "Rahul", 30, 5, 2000);
      ((MedicalRecord) p1).addRecord("Surgery recovery");

      Patient p2 = new OutPatient(102, "Neha", 25, 500);
      ((MedicalRecord) p2).addRecord("Viral fever");

      processPatient(p1);
      processPatient(p2);
  }
}

