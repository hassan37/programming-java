package list.src;

public class ListWithArray<E> implements HList<E> {

	private static final int DEFAULT_CAPACITY = 16;
	private int cap;
	private int size;

	private E[] items;

	public ListWithArray() { cap = DEFAULT_CAPACITY; }
	public ListWithArray(int cap) { cap = cap > 0 ? cap : DEFAULT_CAPACITY; }

	private void grow() {
		
	}

	public void add(E e) {
		items[size++] = e;
	}

	public int size() { return 0; }

	public boolean isEmpty() { return size == 0; }

	@Override
	public void addAt(E e, int i) {
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void swap(int i1, int i2) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		int size = 32;
		for (int j = 0; j < size; j++) {
			System.out.println(j + " | " + (j >> 1));
		}
	}
}
