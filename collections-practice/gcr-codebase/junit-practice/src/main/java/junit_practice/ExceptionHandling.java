package junit_practice;

public class ExceptionHandling {
	public int divide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Cannot divide by 0");
		}
		return a / b;
	}
}