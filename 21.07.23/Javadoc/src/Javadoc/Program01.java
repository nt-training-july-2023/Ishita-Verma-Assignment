package Javadoc;

public class Program01 {

	/**
	 *@param length
	 *@param width
	 *@return area
	 */
	public static int area(int length,int width) {
	return length*width;
	}
	public static void main(String[] args) {

		int length=2, width=4;
		int ans=area(length,width);
		System.out.println(ans);
	}

}
