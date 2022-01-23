package edu.kis.vh.nursery.list;

/**
 * Class representing a double linked list of integer values.
 */
public class IntLinkedList {

	/**
	 * Class representing a single node of the list.
	 */
	private class Node {

		private int value;
		private Node prev;
		private Node next;

		/**
		 * Creates a new node.
		 * @param i the value contained in the node
		 */
		public Node(int i) {
			value = i;
		}

		/**
		 * Gets value of the node.
		 * @return a value contained in the node
		 */
		public int getValue() {
			return value;
		}

		/**
		 * Gets the previous node.
		 * @return the previous node
		 */
		public Node getPrev() {
			return prev;
		}

		/**
		 * Sets the previous node to the given node.
		 * @param prev the node that will be set as the previous node
		 */
		public void setPrev(Node prev) {
			this.prev = prev;
		}

		/**
		 * Gets the next node.
		 * @return the next node
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * Sets the next node to the given node.
		 * @param next the node that will be set as the next node
		 */
		public void setNext(Node next) {
			this.next = next;
		}
	}

	private Node last;
	private int i;

	/**
	 * Adds a next element to the list.
	 * @param i the value to be added
	 */
	public void push(int i) {
		if (last == null)
			last = new Node(i);
		else {
			last.setNext(new Node(i));
			last.getNext().setPrev(last);
			last = last.getNext();
		}
	}

	/**
	 * Checks if the list is empty.
	 * @return if the list is empty or not
	 */
	public boolean isEmpty() {
		return last == null;
	}

	/**
	 * Checks if the list is full.
	 * @return if the list is full or not
	 */
	public boolean isFull() {
		return false;
	}

	/**
	 * Checks the value at the end of the list, but doesn't remove it.
	 * @return the value at the end of the list
	 */
	public int top() {
		if (isEmpty())
			return -1;
		return last.getValue();
	}

	/**
	 * Removes a value from the end of the list.
	 * @return the removed value
	 */
	public int pop() {
		if (isEmpty())
			return -1;
		int ret = last.getValue();
		last = last.getPrev();
		return ret;
	}

}
