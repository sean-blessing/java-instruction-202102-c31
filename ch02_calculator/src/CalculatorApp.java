
public class CalculatorApp {

	public static void main(String[] args) {
		System.out.println("Hello");
		
		int n1 = 5;
		int n2 = 8;
		int n3 = 21;
		int n4 = 4;
		
		int sum1 = n2 + n3;	// should be 29
		int diff1 = n3 - n1;
		int prod1 = n3 * n2;
		int quot1 = n3 / n1;
		System.out.println("sum1 = " + sum1);
		System.out.println(diff1);
		System.out.println(prod1);
		System.out.println(quot1);
	
		int sum2 = n3 + n4;
		sum2 = n4 + n1;
		
		
		System.out.println("Bye");

	}

}
