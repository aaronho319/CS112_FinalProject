// Node class that will be used as the object for OOP based Stack calculator
public class Node {

	// defining the variables of the Node
	private String content;
	private Node next;

	// getters and setters for the variables

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Node getNext() {
		return this.next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}