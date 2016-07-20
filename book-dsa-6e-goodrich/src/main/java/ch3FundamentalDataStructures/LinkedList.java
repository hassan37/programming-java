package ch3FundamentalDataStructures;

public interface LinkedList<E> {

	public int size();

	public boolean isEmpty();
	
	public void addFirst(E e);
	public void addLast(E e);
	public void add(E e);
	public void addAfter(final E e, int index);
	
	public E remove(int index);
	public E removeFirst();
	public E removeLast();
	
	public E getFirst();
	public E getLast();
	public E getAt(int index);

	public void swap(int i1, int i2);
}
