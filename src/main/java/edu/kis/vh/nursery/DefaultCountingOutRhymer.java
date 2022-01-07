package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {
	private final int ARRAY_SIZE = 12;
	private final int LAST_INDEX = 11;
	private final int EMPTY_ARRAY = -1;

	private int[] numbers = new int[ARRAY_SIZE];

	public int total = EMPTY_ARRAY;

	public void countIn(int in) {
		if (!isFull())
			numbers[++total] = in;
	}

	public boolean callCheck() {
		return total == EMPTY_ARRAY;
	}

	public boolean isFull() {
		return total == LAST_INDEX;
	}

	protected int peekaboo() {
		if (callCheck())
			return EMPTY_ARRAY;
		return numbers[total];
	}
			
	public int countOut() {
		if (callCheck())
			return EMPTY_ARRAY;
		return numbers[total--];
	}

}

// W środowisku Intelij kombinacja alt + <- / alt + -> powoduje przełączanie
// pomiędzy otwartymi plikami w środowisku.