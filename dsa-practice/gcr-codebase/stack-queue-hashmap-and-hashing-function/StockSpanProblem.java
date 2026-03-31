/*
 * Stock Span Problem
 * Problem: For each day in a stock price array, calculate the span (number of consecutive days the price was less than or equal to the current day's price).
 * Hint: Use a stack to keep track of indices of prices in descending order.
*/

package gcr_codebase.stack_queue_hashmap_hashing_function;

import java.util.Scanner;
import java.util.Stack;

public class StockSpanProblem {

    public static void calculateSpan(int[] price, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[n];

        // First day span is always 1
        span[0] = 1;
        stack.push(0);

        for (int i = 1; i < n; i++) {

            // Pop elements while current price is higher
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            // If stack is empty, price is greater than all previous
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current index
            stack.push(i);
        }

        System.out.println("Stock Spans:");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] price = new int[n];
        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        calculateSpan(price, n);
        sc.close();
    }
}
