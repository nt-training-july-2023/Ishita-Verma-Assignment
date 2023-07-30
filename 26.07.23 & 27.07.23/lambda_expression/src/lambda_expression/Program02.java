package lambda_expression;

import java.util.Scanner;

public class Program02 {

	interface shape{
		public void area();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter");
		shape rectangle = () -> {
			int l=sc.nextInt();
			int b= sc.nextInt();
			System.out.println("area rectangle "+l*b);
		};
		
		shape cube = () -> {
			int a = sc.nextInt();
			System.out.println("area cube "+6*Math.pow(a, 2));
		};
		
		shape circle = () -> {
			int r = sc.nextInt();
			System.out.println("area circle "+ Math.PI*Math.pow(r, 2));
		};
		
		shape square = () -> {
			int a = sc.nextInt();
			System.out.println("area square "+ Math.pow(a, 2));
		};
		
		shape sphere = () -> {
			int r = sc.nextInt();
			System.out.println("area sphere "+ 4* Math.PI* Math.pow(r, 2));
		};
		
		shape cylinder = () -> {
			int h = sc.nextInt();
			int r = sc.nextInt();
			System.out.println("area cylinder " + Math.PI * Math.pow(r, 2) * h);
		};
		rectangle.area();
        cube.area();
        circle.area();
        square.area();
        sphere.area();
        cylinder.area();
	}

}
