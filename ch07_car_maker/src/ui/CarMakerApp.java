package ui;

import business.Car;

public class CarMakerApp {

	public static void main(String[] args) {
		// create a car
		// Car with public variables
		Car c1 = new Car();
		
		// set properties
		c1.setMake("Jeep");
		c1.setModel("Wrangler");
		
		// display properties
		System.out.println("Make = "+c1.getMake());
		System.out.println("Model = "+c1.getModel());
		

	}

}
