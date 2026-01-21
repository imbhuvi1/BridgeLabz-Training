package gcr_codebase.generics.UniversityCourseManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Course<ExamCourse> cs101 =
                new Course<>("CS101", "Computer Science", new ExamCourse());

        Course<AssignmentCourse> cs102 =
                new Course<>("CS102", "Computer Science", new AssignmentCourse());

        Course<ResearchCourse> phd101 =
                new Course<>("PhD Research", "Research Dept", new ResearchCourse());

        cs101.displayCourse();
        cs102.displayCourse();
        phd101.displayCourse();

        System.out.println("\n---- Evaluation Types Offered ----");

        List<CourseType> courseTypes = new ArrayList<>();
        courseTypes.add(new ExamCourse());
        courseTypes.add(new AssignmentCourse());
        courseTypes.add(new ResearchCourse());

        UniversityManager.displayAllCourses(courseTypes);
    }
}