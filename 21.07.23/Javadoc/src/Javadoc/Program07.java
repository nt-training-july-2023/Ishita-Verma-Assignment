package Javadoc;

import java.util.*;

public class Program07 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Scanner sc = new Scanner(System.in);
		try {
			int i = sc.nextInt();
			if (i < 0 || i >= arr.length) {
				throw new ArrayIndexOutOfBoundsException("Out of bound");
			}
			if (i == 0) {
				throw new NullPointerException("Null");
			}

			System.out.println("ans " + i);

		} catch (NullPointerException e) {
			System.out.println("Null");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Out of bound");
		}
	}

}
