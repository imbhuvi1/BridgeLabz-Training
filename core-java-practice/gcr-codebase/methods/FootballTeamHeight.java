
import java.util.*;

public class FootballTeamHeight {

    //Method to find sum of heights
    static int findSum(int[] heights) {
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }
        return sum;
    }

    //Method to find mean height
    static double findMean(int[] heights) {
        int sum = findSum(heights);
        return (double) sum / heights.length;
    }

    //Method to find shortest height
    static int findShortest(int[] heights) {
        int min = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < min) {
                min = heights[i];
            }
        }
        return min;
    }

    //Method to find tallest height
    static int findTallest(int[] heights) {
        int max = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > max) {
                max = heights[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] heights = new int[11];
        Random random = new Random();

        //Generate random heights between 150 and 250 cms
        System.out.println("Heights of Football Players (in cms):");
        for (int i = 0; i < heights.length; i++) {
            heights[i] = random.nextInt(101) + 150; // 150 to 250
            System.out.print(heights[i] + " ");
        }

        System.out.println("\n");

        int sum = findSum(heights);
        double mean = findMean(heights);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);

        // Display results
        System.out.println("Sum of heights       : " + sum + " cms");
        System.out.println("Mean height          : " + mean + " cms");
        System.out.println("Shortest player      : " + shortest + " cms");
        System.out.println("Tallest player       : " + tallest + " cms");
    }
}

