import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
public class CircleComparison{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please give me a radius for the first circle");
		double firstRadius = in.nextDouble();
		Circle a = new Circle(firstRadius);
		//a.setRadius(in.nextDouble());
		System.out.println("Great! Please give me another radius so we can have two circles!");
		double secondRadius = in.nextDouble();
		Circle b = new Circle(secondRadius);
	//	b.setRadius(in.nextDouble());
		if(a.equals(b)){
			 System.out.println("They're the same circle!");
			 System.out.println(a.toString());
		 }
		 else{
			 System.out.println("The two circles aren't equal!");
			 System.out.println("Circle 1: ");
			 System.out.println(a.toString());
			 System.out.println("Circle 2: ");
			 System.out.println(b.toString());
		 }
		 in.close();
	}
}
 class Circle {
		private double radius;
		public Circle(double r_value) {
			radius = r_value;
		}
		public Circle() {
			radius = 1.0;//this(1.0)
		}
		public double getRadius(){
			return radius;
		}
		public void setRadius(double radius_val){
			radius = radius_val;
		}
		public String toString(){
			DecimalFormat round = new DecimalFormat("#.##");
			String ans = "Circumference: ";
			ans += round.format(this.circumference()) + "\n";
			ans += "Radius: ";
			ans += round.format(this.area());
			return ans;

		}
		public double circumference(){
			return 2*Math.PI*radius;
		}
		public double area(){
			return radius*radius*Math.PI;
		}
		public boolean equals(Circle other){
			if(this.radius == other.radius) return true;
			return false;
		}
	}
