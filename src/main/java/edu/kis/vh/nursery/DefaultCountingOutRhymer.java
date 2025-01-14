package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

	// TODO: refactor the class to use IntLinkedList instead of an array of ints
	private int[] numbers = new int[12];

	private int total = -1;

	public void countIn(int in) {
		if (!isFull())
			numbers[++total] = in;
	}

	public int getTotal() {
		return total;
	}

	public boolean callCheck() {
		return total == -1;
	}

	public boolean isFull() {
		return total == 11;
	}

	protected int peekaboo() {
		if (callCheck())
			return -1;
		return numbers[total];
	}
			
	public int countOut() {
		if (callCheck())
			return -1;
		return numbers[total--];
	}

}

// W środowisku Intelij kombinacja alt + <- / alt + -> powoduje przełączanie
// pomiędzy otwartymi plikami w środowisku.