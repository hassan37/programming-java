package list;

public class ArrayList<E> implements List<E> {

	private static final int DEFAULT_CAPACITY = 16;

	private E[] elementsArray;

	public ArrayList() { capacity = DEFAULT_CAPACITY; }
	public ArrayList(int cap) { capacity = cap > 0 ? cap : DEFAULT_CAPACITY; }

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void add(E e) {
	}

	@Override
	public void addAt(E e, int i) {
		// TODO Auto-generated method stub

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

}
