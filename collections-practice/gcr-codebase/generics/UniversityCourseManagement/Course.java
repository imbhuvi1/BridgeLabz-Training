package gcr_codebase.generics.UniversityCourseManagementSystem;

public class Course<T extends CourseType> {
    private String courseName;
    private String department;
    private T courseType;

    public Course(String courseName, String department,T courseType){
        this.courseName = courseName;
       this.department = department;
       this.courseType = courseType;
    }

     public T getCourseType() {
       return courseType;
   }

   public void displayCourse() {
       System.out.println(
           "Course: " + courseName +
           " | Department: " + department
       );
       courseType.displayEvaluation();
   }
}