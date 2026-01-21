package gcr_codebase.generics.AI_DrivenResumeScreeningSystem;

public class SoftwareEngineer extends JobRole {
    private String primaryLanguage;

    public SoftwareEngineer(String title, String department, String primaryLanguage) {
        super(title, department);
        this.primaryLanguage = primaryLanguage;
    }

    @Override
    public void displayRoleDetails() {
        System.out.println("Job Role: " + getTitle() + ", Department: " + getDepartment() + ", Primary Language: " + primaryLanguage);
    }
}