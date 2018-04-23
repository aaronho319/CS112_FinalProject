import java.util.*;

public class StackulatorOOP implements Stackulator{

	// initialize global variables
	private static Node topNode; 
	private static int nodeCounter = 0;


	// calls the implemented method from Stackulator
	@Override
	public void compute() {

		StackulatorOOP calc = new StackulatorOOP();
		// creates a scanner instance for the command-line input
		Scanner sc = new Scanner(System.in);

		System.out.print("Please input calculator values for OOP: ");

		// reads the next line in the command-line
		String str = sc.nextLine();

		// splits the string between the spaces and stores it into an Array 
		String[] strSplit = str.split(" ");

		// goes through each element in the Array
		for(int i = 0; i < strSplit.length; i++) {

			// binds the ith element to the variable top
			String top = strSplit[i];
		
			// if the first two elements have an operation involved, will return an error
			if(isOperator(top) && nodeCounter < 2) {
				System.err.println("Error");
				break;

			// if the number of nodes is greater than or equal to 2 and the next element is an operator
			}else if(isOperator(top) && nodeCounter >= 2) {

				String poppedOperator = top;	

				// gets the last elements of the Linked-List and calls the returnValue function
				int operator2 = Integer.parseInt(calc.pop());
				int operator1 = Integer.parseInt(calc.pop());

				int result = returnValue(operator1, operator2, poppedOperator);
				
				// pushes the result back to the linked-list
				calc.push(result+"");

			// if the input is a number simply put it inside the linked-list
			} else if(!isOperator(top)) {
				calc.push(top);
			}
		}

		// prints out the last value of the linked-list as the final answer
		System.out.println(calc.pop());
		
	
	}
	
	// public static void main(String[] args) {

	// 	// create an instance of the calculator
	// 	StackulatorOOP calc = new StackulatorOOP();

	// }	

	// checks if the current String input is an operator or not

	
	public static boolean isOperator(String input) {
		String[] operators = {"*", "+", "-", "/"};

		// checks if input will be the same as the operators Array
		for(String s : operators) {
			if(input.equals(s)) {
				return true;	
			}
		}

		return false;
	}

	// simply does the operation based on the String operator given to the two integers
	public static int returnValue(int operator1, int operator2, String operator) {
		int result = 0;

		// if the operator is "+", add the operands
		if(operator.equals("+")) {
			result = operator1 + operator2;
			
		// if the operator is "-", subtracts the operands	
		} else if(operator.equals("-")) {
			result = operator1 - operator2;

		// if the operator is "*", multiplies the operands	
		} else if(operator.equals("*")) {
			result = operator1 * operator2;
		
		// if the operator is "/", divides the operands	
		} else if(operator.equals("/")) {
			result = operator1 / operator2;
			
		}

		return result;
	}

	// function that adds to the linked-list the current string as a Node
	public static void push(String input) {
		// creates a new Node named node
		Node node = new Node();

		// sets the content of the node to the String input
		node.setContent(input);

		// sets the next element of the node as the global topNode
		node.setNext(topNode);

		// sets the value of topNode to the current node
		topNode = node;

		// increment the nodeCounter 
		nodeCounter++;
	}

	// function that removes the last node in the linked-list and returns a String
	public static String pop() {

		// sets the string to the content of the topNode
		String out = topNode.getContent();

		// sets topNode to the next value of the topNode
		topNode = topNode.getNext();

		// decremenes the nodeCounter
		nodeCounter--;

		// returns the string
		return out;
	}

}