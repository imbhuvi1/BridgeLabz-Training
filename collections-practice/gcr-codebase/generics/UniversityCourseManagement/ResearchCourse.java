package gcr_codebase.generics.UniversityCourseManagementSystem;

class ResearchCourse extends CourseType {

    public ResearchCourse() {
        this.evaluationMethod = "Research & Thesis";
    }

    @Override
    public String getEvaluationMethod() {
        return evaluationMethod;
    }
}