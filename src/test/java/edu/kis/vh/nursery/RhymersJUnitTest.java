package edu.kis.vh.nursery;

import edu.kis.vh.nursery.list.IntLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class RhymersJUnitTest {

	@Test
	public void testCountIn() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		int testValue = 4;

		rhymer.countIn(testValue);
		Assert.assertEquals(testValue, rhymer.peekaboo());
	}

	@Test
	public void testCallCheck() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();

		Assert.assertTrue(rhymer.callCheck());

		rhymer.countIn(888);
		Assert.assertFalse(rhymer.callCheck());
	}

	@Test
	public void testIsFull() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		final int STACK_CAPACITY = 12;

		for (int i = 0; i < STACK_CAPACITY; i++) {
			Assert.assertFalse(rhymer.isFull());
			rhymer.countIn(888);
		}

		Assert.assertTrue(rhymer.isFull());
	}

	@Test
	public void testPeekaboo() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		final int EMPTY_STACK_VALUE = -1;
		int testValue = 4;

		Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.peekaboo());

		rhymer.countIn(testValue);
		Assert.assertEquals(testValue, rhymer.peekaboo());
	}

	@Test
	public void testCountOut() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		final int EMPTY_STACK_VALUE = -1;
		int testValue = 4;

		Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.countOut());

		rhymer.countIn(testValue);
		Assert.assertEquals(testValue, rhymer.countOut());

		Assert.assertEquals(EMPTY_STACK_VALUE, rhymer.countOut());
	}

	@Test
	public void testCountOutFIFO() {
		FIFORhymer fifoRhymer = new FIFORhymer();
		int[] testValues = {1, 2, 3};

		Assert.assertTrue(fifoRhymer.callCheck());

		for (int x : testValues) {
			fifoRhymer.countIn(x);
			Assert.assertFalse(fifoRhymer.callCheck());
		}

		for (int x : testValues) {
			Assert.assertFalse(fifoRhymer.callCheck());
			Assert.assertEquals(x, fifoRhymer.countOut());
		}

		Assert.assertTrue(fifoRhymer.callCheck());
	}

	@Test
	public void testCountInHanoi() {
		HanoiRhymer hanoiRhymer = new HanoiRhymer();
		int insertValue = 5;
		int[] callOutValues = {4, 5, 5};

		Assert.assertTrue(hanoiRhymer.callCheck());
		Assert.assertEquals(0, hanoiRhymer.reportRejected());

		hanoiRhymer.countIn(insertValue);
		Assert.assertFalse(hanoiRhymer.callCheck());
		Assert.assertEquals(0, hanoiRhymer.reportRejected());

		hanoiRhymer.countIn(insertValue);
		Assert.assertFalse(hanoiRhymer.callCheck());
		Assert.assertEquals(0, hanoiRhymer.reportRejected());

		hanoiRhymer.countIn(insertValue - 1);
		Assert.assertFalse(hanoiRhymer.callCheck());
		Assert.assertEquals(0, hanoiRhymer.reportRejected());

		hanoiRhymer.countIn(insertValue + 1);
		Assert.assertFalse(hanoiRhymer.callCheck());
		Assert.assertEquals(1, hanoiRhymer.reportRejected());

		for (int x : callOutValues) {
			Assert.assertEquals(x, hanoiRhymer.countOut());
		}
	}

	@Test
	public void testReportRejected() {
		HanoiRhymer hanoiRhymer = new HanoiRhymer();
		int insertValue = 5;

		Assert.assertEquals(0, hanoiRhymer.reportRejected());

		hanoiRhymer.countIn(insertValue);
		Assert.assertEquals(0, hanoiRhymer.reportRejected());

		hanoiRhymer.countIn(insertValue);
		Assert.assertEquals(0, hanoiRhymer.reportRejected());

		hanoiRhymer.countIn(insertValue - 1);
		Assert.assertEquals(0, hanoiRhymer.reportRejected());

		hanoiRhymer.countIn(insertValue + 1);
		Assert.assertEquals(1, hanoiRhymer.reportRejected());

		hanoiRhymer.countIn(insertValue + 1);
		Assert.assertEquals(2, hanoiRhymer.reportRejected());
	}

	@Test
	public void testIsEmpty() {
		IntLinkedList intLinkedList = new IntLinkedList();
		int value = 5;

		Assert.assertTrue(intLinkedList.isEmpty());

		intLinkedList.push(value);
		Assert.assertFalse(intLinkedList.isEmpty());

		intLinkedList.pop();
		Assert.assertTrue(intLinkedList.isEmpty());
	}

	@Test
	public void testPushAndPop() {
		IntLinkedList intLinkedList = new IntLinkedList();
		int[] pushValues = {1, 2, 3, 4, 5};
		int[] popValues = {5, 4, 3, 2, 1};

		for (int x : pushValues) {
			intLinkedList.push(x);
			Assert.assertEquals(x, intLinkedList.pop());
		}

		for (int x : pushValues) {
			intLinkedList.push(x);
		}

		for (int x : popValues) {
			Assert.assertEquals(x, intLinkedList.pop());
		}
	}

	@Test
	public void testTop() {
		IntLinkedList intLinkedList = new IntLinkedList();
		int emptyListValue = -1;
		int[] insertedValues = {1, 2, 3, 4, 5};

		Assert.assertEquals(emptyListValue, intLinkedList.top());

		for (int x : insertedValues) {
			intLinkedList.push(x);
			Assert.assertEquals(x, intLinkedList.top());
		}
	}

}
