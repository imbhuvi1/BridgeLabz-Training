package gcr_codebase.generics.UniversityCourseManagementSystem;

class ExamCourse extends CourseType {

    public ExamCourse() {
        this.evaluationMethod = "Written Exams";
    }

    @Override
    public String getEvaluationMethod() {
        return evaluationMethod;
    }
}
