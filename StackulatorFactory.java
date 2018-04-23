// object for the factory design pattern

public class StackulatorFactory {

	// returns the calculator type via a string input
	public Stackulator getStackulator(String calculatorType) {
		if(calculatorType == null) {
			return null;
		// creates a StackulatorOOP
		} else if(calculatorType.equalsIgnoreCase("OOP")) { 		
			return new StackulatorOOP(); 
		// creates a StackulatorImperative
		} else if(calculatorType.equalsIgnoreCase("IMPERATIVE")) {
			return new StackulatorImperative();
		}
			return null;
	}
}