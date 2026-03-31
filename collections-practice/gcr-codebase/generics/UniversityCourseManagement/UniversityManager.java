package gcr_codebase.generics.UniversityCourseManagementSystem;

import java.util.*;

class UniversityManager {

    public static void displayAllCourses(List<? extends CourseType> courseTypes) {
        for (CourseType type : courseTypes) {
            type.displayEvaluation();
        }
    }
}