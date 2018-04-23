import java.util.*;
import java.lang.*;
import java.util.Arrays;


public class StackulatorImperative implements Stackulator {


	// calls the implemented method from Stackulator
	@Override
	public void compute() {

		System.out.print("Please input calculator values for IMP: ");

		// initialization of variables
		Scanner sc = new Scanner(System.in);
		ArrayList<String> inputArray = new ArrayList<>();
		ArrayList<String> resultArray = new ArrayList<>();
		StackulatorImperative calc = new StackulatorImperative();
		
		// gets the next line input from scanner
		String str = sc.nextLine();

		// splits the input into an Array 
		String[] strSplit = str.split(" ");

		// adds the splitted string into the ArrayList
		for(int i = 0; i < strSplit.length; i++) {
			String addString = strSplit[i];
			calc.push(inputArray, addString);
		}

		// adds the items from the current ArrayList (inputArray) into the new ArrayList
		for(int i = 0; i < inputArray.size(); i++) {

			String currentString = inputArray.get(i);

			// if the first two elements have an operation involved, will return an error
			if(isOperator(currentString) && resultArray.size() < 2) {
				System.err.println("Error");
				break;

			}else if(isOperator(currentString) && resultArray.size() >= 2) {
				// gets the last two digits of the arraylist and calls the returnValue function
				int operator1 = Integer.parseInt(resultArray.get(resultArray.size() - 2));
				int operator2 = Integer.parseInt(resultArray.get(resultArray.size() - 1));
				int result = returnValue(operator1, operator2, currentString);

				// removes the last two elements in the arraylist and adds the result of returnValue
				// resultArray.remove(resultArray.get(resultArray.size() - 1));
				// resultArray.remove(resultArray.get(resultArray.size() - 1));
				calc.pop(resultArray);
				calc.pop(resultArray);

				calc.push(resultArray, result+"");
				// resultArray.add(result+"");

			} else if(!isOperator(currentString)) {
				// if the current string is not an operator, simply add it to the ArrayList
				resultArray.add(currentString);
			}

			//System.out.println(resultArray);
		}

		System.out.println(resultArray.get(0));
	}

/*
	public static void main(String[] args) {
		// initialization of calculator
		StackulatorImperative calc = new StackulatorImperative();

		// initialization of variables
		Scanner sc = new Scanner(System.in);
		ArrayList<String> inputArray = new ArrayList<>();
		ArrayList<String> resultArray = new ArrayList<>();
		
		// gets the next line input from scanner
		String str = sc.nextLine();

		// splits the input into an Array 
		String[] strSplit = str.split(" ");

		// adds the splitted string into the ArrayList
		for(int i = 0; i < strSplit.length; i++) {
			String addString = strSplit[i];
			calc.push(inputArray, addString);
		}

		// adds the items from the current ArrayList (inputArray) into the new ArrayList
		for(int i = 0; i < inputArray.size(); i++) {

			String currentString = inputArray.get(i);

			// if the first two elements have an operation involved, will return an error
			if(isOperator(currentString) && resultArray.size() < 2) {
				System.err.println("Error");
				break;

			}else if(isOperator(currentString) && resultArray.size() >= 2) {
				// gets the last two digits of the arraylist and calls the returnValue function
				int operator1 = Integer.parseInt(resultArray.get(resultArray.size() - 2));
				int operator2 = Integer.parseInt(resultArray.get(resultArray.size() - 1));
				int result = returnValue(operator1, operator2, currentString);

				// removes the last two elements in the arraylist and adds the result of returnValue
				// resultArray.remove(resultArray.get(resultArray.size() - 1));
				// resultArray.remove(resultArray.get(resultArray.size() - 1));
				calc.pop(resultArray);
				calc.pop(resultArray);

				calc.push(resultArray, result+"");
				// resultArray.add(result+"");

			} else if(!isOperator(currentString)) {
				// if the current string is not an operator, simply add it to the ArrayList
				resultArray.add(currentString);
			}

			System.out.println(resultArray);
		}
	}

*/

	// checks if the current String input is an operator or not
	public static boolean isOperator(String input) {
		String[] operators = {"*", "+", "-", "/"};

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

		if(operator.equals("+")) {
			result = operator1 + operator2;
			
		} else if(operator.equals("-")) {
			result = operator1 - operator2;
			
		} else if(operator.equals("*")) {
			result = operator1 * operator2;
			
		} else if(operator.equals("/")) {
			result = operator1 / operator2;
			
		}

		return result;
	}

	// adds the current string to the arraylist
	public static void push(ArrayList<String> inputArray, String string) {
		inputArray.add(string);
	}

	// removes the last element of the arraylist
	public static void pop(ArrayList<String> inputArray) {
		inputArray.remove(inputArray.get(inputArray.size() - 1));
	}

}