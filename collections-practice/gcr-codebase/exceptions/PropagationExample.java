package gcr_codebase.exceptions;

public class PropagationExample {

    static void method1() {
        int x = 10 / 0; // Causes exception
    }

    static void method2() {
        method1(); // Call method1
    }

    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}
