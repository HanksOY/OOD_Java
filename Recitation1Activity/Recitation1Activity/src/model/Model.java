package model;

public class Model {
	
	//you're building a calculator for this
	//recitation, so you need to be able to
	//store two numbers and the computation
	//that those numbers will perform (+, -, /, *)
	
	//write those attributes here.
	private int a;
    private int b;
    private String operator;

	
	//you also need a constructor for your model.
	//there is an example constructor in the controller
	//class. If your model does not need any parameters
	//when it is generated, then you do not need to write
	//a constructor and it will automatically generate
	//a default constructor.
    public Model() {}
    public Model(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public Model(int a, int b, String Operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }
	//finally, you need to write your setters, getters,
	//and operations--the methods that will perform the
	//desired computations.

    //Setters
    public void setA(int a) {this.a = a; }
    public void setB(int b) {this.b = b; }
    public void setOp(String operator) {this.operator = operator; }

    //Getters
    public int getA() { return this.a; }
    public int getB() { return this.b; }

    public String getOp() {
        return operator;
    }

    //Operations
    public int compute() {
        String op = this.operator;
        int computation = 0;
        switch(op) {
            case "+":
                computation = this.a + this.b;
                break;
            case "-":
                computation = this.a - this.b;
                break;
            case "*":
                computation = this.a * this.b;
                break;
            case "/":
                computation = this.a / this.b;
                break;
            default:
                computation = 0;
                break;
        }
        return computation;
    }
}
