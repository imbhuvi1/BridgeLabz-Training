package gcr_codebase.generics.UniversityCourseManagementSystem;

public abstract class CourseType {

    protected String evaluationMethod;

   public abstract String getEvaluationMethod();

   public void displayEvaluation() {
       System.out.println("Evaluation Method: " + getEvaluationMethod());
   }
}
