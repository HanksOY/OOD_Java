package view;

public class View {
	
	public void init() {
		System.out.println("Welcome to Recitaiton 1: Build a console calculator!");
	}
	
	//Right now, the view class has one method that prints a welcome message
	//when the program starts up.
	//Is there a better way to organize the data that the View class will need
	//to access (as in, all those print statements in the Controller class
	//so that we don't need to write a unique method for every 
	//possible scenario?
	//How do we design this to be more modular?
	public  void promptInput() {
		System.out.println("Enter two numbers and then the operation");
	}

	public void output(String operation, int numA, int numB, int computation) {
		String op = "";
		switch (operation) {
			case "+":
				op = "sum";
				break;
			case "-":
				op = "difference";
				break;
			case "*":
				op = "product";
				break;
			case "/":
				op = "quotient";
				break;
		}
		System.out.println("The " + op + " of " + numA + " and " + numB + " is " + computation + "!");
	}
}
