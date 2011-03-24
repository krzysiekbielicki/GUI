package pl.edu.pjwstk.s8267.GUI.Lab4;

import java.util.Iterator;

public class MySimpleIterator implements Iterable<Integer>, Iterator<Integer> {

	public static final int PRIME_NUMBERS = 1;
	public static final int ODD_NUMBERS = 2;
	public static final int EVEN_NUMBERS = 3;
	private int to;
	private int type;
	private int last;
	private int from;

	public MySimpleIterator(int from, int to, int type) {
		this.to = to;
		this.type = type;
		this.from = from;
		last = from-1;
	}

	@Override
	public Iterator<Integer> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		switch(type) {
		case PRIME_NUMBERS:
			next:for(int x = last+1; x < to; x++) {
				for(int y = 2; y < x; y++) {
					if(x%y == 0) continue next;
				}
				last = x;
				return true;
			}
			return false;
		case ODD_NUMBERS:
			if(last % 2 == 1) {
				if(last + 2 <= to) {
					last += 2;
					return true;
				}
			} else if(last + 1 <= to) {
				last += 1;
				return true;
			}
			return false;
		case EVEN_NUMBERS:
			if(last % 2 == 0) {
				if(last + 2 <= to) {
					last += 2;
					return true;
				}
			} else if(last + 1 <= to) {
				last += 1;
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public Integer next() {
		return last;
	}

	@Override
	public void remove() {

	}

	private void setLimits(int from, int to) {
		this.from = from;
		this.last = from-1;
		this.to = to;
	}

	private void setType(int type) {
		this.last = from-1;
		this.type = type;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MySimpleIterator msi = new MySimpleIterator(10, 100,
				MySimpleIterator.PRIME_NUMBERS);

		for (int el : msi)
			System.out.print(el + " ");
		System.out.println();

		msi.setType(MySimpleIterator.ODD_NUMBERS);
		msi.setLimits(15, 30);
		for (int el : msi)
			System.out.print(el + " ");
		System.out.println();

		msi.setType(MySimpleIterator.EVEN_NUMBERS);
		for (int el : msi)
			System.out.print(el + " ");
		System.out.println();
	}
}
