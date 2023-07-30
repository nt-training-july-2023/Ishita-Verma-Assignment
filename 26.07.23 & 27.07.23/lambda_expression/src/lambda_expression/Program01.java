package lambda_expression;
import java.util.*;
import java.util.function.Function;

public class Program01 {

	interface replace{
		public void change();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		replace ans = () -> {
			System.out.println(str.replaceAll("[aeiouAEIOU]", "#"));
		};
		ans.change();
	}

}
