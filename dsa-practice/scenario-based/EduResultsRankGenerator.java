package scenario_based;

import java.util.*;

class Student {
    String name;
    int marks;
    String district;
    int rank; // Final state rank

    Student(String name, int marks, String district) {
        this.name = name;
        this.marks = marks;
        this.district = district;
    }
}

public class EduResultsRankGenerator {

    // Merge two sorted lists in descending order while keeping stability
    public static List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> result = new ArrayList<>();
        int i = 0, j = 0;

        // Compare marks and merge in descending order
        while (i < left.size() && j < right.size()) {
            if (left.get(i).marks > right.get(j).marks) {
                result.add(left.get(i++));
            } else if (left.get(i).marks < right.get(j).marks) {
                result.add(right.get(j++));
            } else {
                result.add(left.get(i++)); // Keep left first for stability
            }
        }

        // Add remaining students from either list
        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));

        return result;
    }

    // Repeatedly merge district lists until one final list remains
    public static List<Student> mergeAllDistricts(List<List<Student>> districtLists) {
        if (districtLists.isEmpty()) return new ArrayList<>();

        // Merge lists pairwise like Merge Sort
        while (districtLists.size() > 1) {
            List<List<Student>> mergedLists = new ArrayList<>();

            for (int i = 0; i < districtLists.size(); i += 2) {
                if (i + 1 < districtLists.size()) {
                    mergedLists.add(merge(districtLists.get(i), districtLists.get(i + 1)));
                } else {
                    mergedLists.add(districtLists.get(i)); // Carry forward odd list
                }
            }

            districtLists = mergedLists;
        }

        return districtLists.get(0);
    }

    // Assign ranks while handling ties (same marks → same rank)
    public static void assignRanks(List<Student> students) {
        int rank = 1;
        int sameRankCount = 0;
        Integer prevMarks = null;

        for (Student s : students) {
            if (prevMarks != null && s.marks == prevMarks) {
                s.rank = rank; // Same rank for equal marks
                sameRankCount++;
            } else {
                rank = rank + sameRankCount; // Skip ranks after ties
                s.rank = rank;
                sameRankCount = 1;
                prevMarks = s.marks;
            }
        }
    }

    // Generate the final state rank list from all districts
    public static List<Student> generateStateRankList(List<List<Student>> districtLists) {
        List<Student> mergedList = mergeAllDistricts(districtLists);
        assignRanks(mergedList);
        return mergedList;
    }

    public static void main(String[] args) {

        // Each district already sorted by marks (descending)
        List<Student> districtA = Arrays.asList(
                new Student("Aarav", 95, "A"),
                new Student("Diya", 90, "A"),
                new Student("Kunal", 82, "A")
        );

        List<Student> districtB = Arrays.asList(
                new Student("Riya", 98, "B"),
                new Student("Arjun", 91, "B"),
                new Student("Meera", 82, "B")
        );

        List<Student> districtC = Arrays.asList(
                new Student("Kabir", 97, "C"),
                new Student("Ananya", 89, "C"),
                new Student("Ishaan", 80, "C")
        );

        // Combine all district lists
        List<List<Student>> districts = new ArrayList<>();
        districts.add(districtA);
        districts.add(districtB);
        districts.add(districtC);

        // Generate final ranked list
        List<Student> finalRankList = generateStateRankList(districts);

        // Display state rank list
        System.out.println("STATE RANK LIST:\n");
        for (Student s : finalRankList) {
            System.out.println("Rank " + s.rank + ": " + s.name +
                    " (" + s.district + ") - " + s.marks);
        }
    }
}
