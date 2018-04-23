import java.util.*;

// Stackulator Factory Pattern to initialize the StackulatorFactory
public class StackulatorFactoryPattern {
	public static void main(String[] args) {

		// initializes the StackulatorFactory
		StackulatorFactory stackulatorFactory = new StackulatorFactory();
		Scanner sc = new Scanner(System.in);

		// input calculator type and number (e.g. OOP 5 or imperative 5)
		System.out.print("Please Input Calculator Type and Number of instance: ");

		// gets the next input line
		String str = sc.nextLine();
		// splits the input 
		String[] input = str.split(" ");

		// reads the first input and ends the loop when it reads an END
		while(!input[0].equalsIgnoreCase("END")) {

			// reads the second value of the string[] 
			int count = Integer.parseInt(input[1]);

			// loops up until the number ends
			for(int i = 0; i < count; i++) {
				System.out.format("Working on Calculator %d. ", i+1);

				// initializes the correct Stackulator from the factory using the input
				Stackulator stackCalc = stackulatorFactory.getStackulator(input[0]);

				// computes the values 
				stackCalc.compute();	
			}
			
			System.out.print("Please Input Calculator Type and Number of instance: ");
			str = sc.nextLine();
			input = str.split(" ");
		}
	}
}