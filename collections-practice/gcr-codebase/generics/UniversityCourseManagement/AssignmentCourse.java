package gcr_codebase.generics.UniversityCourseManagementSystem;

class AssignmentCourse extends CourseType {

    public AssignmentCourse() {
        this.evaluationMethod = "Assignments & Projects";
    }

    @Override
    public String getEvaluationMethod() {
        return evaluationMethod;
    }
}
