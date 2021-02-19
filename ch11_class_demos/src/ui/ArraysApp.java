package ui;

public class ArraysApp {

	public static void main(String[] args) {
		System.out.println("Welcome to Arrays");
		// p. 355
		double[] prices = new double[4];
		
		prices[0] = 5.99;
		prices[1] = 7.55;
		prices[2] = 11.11;
		prices[3] = 25.25;
		//prices[4] = 57.25;  <= not allowed
		
		System.out.println("item at idx 2: "+prices[2]);
		
		//p. 357
		int[] numbers = {5,24,7,9,45,11};
		System.out.println("array of numbers length = "+numbers.length);
		
		//p. 359
		System.out.println("All prices in our array:");
		for (int i=0; i < prices.length; i++) {
			System.out.println(i + ", "+prices[i]);
		}
		
		// p. 361
		int sum = 0;
		for (int i: numbers) {
			sum+=i;
		}
		System.out.println("sum = "+sum);
		System.out.println("# of elements = "+numbers.length);
		System.out.println("avg = "+(double)sum/(double)numbers.length);
		
		
		System.out.println("Bye");

	}

}
