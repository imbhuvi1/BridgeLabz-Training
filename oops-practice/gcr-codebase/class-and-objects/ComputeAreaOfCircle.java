class Circle {
	private double radius;

	Circle() {
		// TODO Auto-generated constructor stub
		this.radius = 0;
	}

	Circle(double raidus) {
		this.radius = raidus;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void calculateArea() {
		double area = Math.PI * Math.pow(radius, 2);
		System.out.println("Area of circle is " + area);
	}

	public void calculateCircumference() {
		double circumference = 2 * Math.PI * radius;
		System.out.println("Circumference of circle is " + circumference);
	}

	public double getRadius() {
		return radius;
	}
}

public class ComputeAreaOfCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle = new Circle();
		circle.setRadius(5);
		circle.calculateArea();
		circle.calculateCircumference();
	}

}