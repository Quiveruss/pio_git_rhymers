package edu.kis.vh.nursery;

public class FIFORhymer extends DefaultCountingOutRhymer {

	// TODO: when DefaultCountingOutRhymer will be improved, delete this
	private DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

	// TODO: use IntLinkedList's interface to improve performance instead of using additional rhymer
	@Override
	public int countOut() {
		while (!callCheck())
			temp.countIn(super.countOut());
		
		int ret = temp.countOut();
		
		while (!temp.callCheck())
			countIn(temp.countOut());
		
		return ret;
	}
}
