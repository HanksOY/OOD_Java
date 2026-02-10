package control;

//This package allows us to read an input from the
//command line. You will have to generate an object of it
//to take that input.
import java.util.Scanner;

//Because our controller is managing our two other
//classes, then it ought to have access to their
//package contents.
import model.*;
import view.*;



public class Controller {
	
	//Declare the class attributes.
	//Scanner is the object that we will store
	//user input to and pass appropriate commands
	//to other objects depending on that input.
	Scanner userInput;
	String next;
	
	Model model;
	View view;

	int nextInt;
	String nextString;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
		this.userInput = new Scanner(System.in);
	}
	public Controller() {
		this.model = new Model();
		this.view = new View();
		this.userInput = new Scanner(System.in);
	}

	//For notes on using Scanner for inputs, see:
	//https://www.w3schools.com/java/java_user_input.asp
	public void run() {
		
		//The view class is called to display the first message.
		view.init();
		view.promptInput();

		nextInt = userInput.nextInt();
		model.setA(nextInt);

		nextInt = userInput.nextInt();
		model.setB(nextInt);

		nextString = userInput.next();
		model.setOp(nextString);

		view.output(model.getOp(), model.getA(), model.getB(), model.compute());
	}
	
}
