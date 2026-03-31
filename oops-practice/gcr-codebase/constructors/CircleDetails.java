class Circle2 {
    private double radius;
    Circle2() {
        this(1.0);
    }
    Circle2(double radius) {
        this.radius = radius;
    }
    void display() {
    	System.out.println("Radius is " + radius);
    }
}

public class CircleDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle2 c1 = new Circle2();
		Circle2 c2 = new Circle2(5.6);
		c1.display();
		c2.display();
	}

}