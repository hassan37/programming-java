package ch3FundamentalDataStructures;

public class CircularSinglyLinkedList<E> implements CircularLinkedList<E> {
	
	private static class Node<E> {
		E e;
		Node<E> next;

		public Node(E e) { this.e = e; }

		@Override
		public String toString() { return e.toString(); }
	}

	private Node<E> current;
	private int size;

	private void incrementSize() { size++; }
	private void decrementSize() { size--; }
	private String indexOutOfBoundMessage(int index) { return "Invalid Index " + index + " Size: " + size; }
	private boolean isValidIndex(int index) { return index >= 0 && index < size; }
	private boolean isConsecutiveNodesSwap(int i1, int i2) { return Math.abs(i1-i2) == 1; }

	private Node<E> nodeAt(int index) {
		Node<E> cur = current;
		int pos = 0;
		while(pos++ < index) {
			cur = cur.next;
		}

		return cur;
	}
	private Node<E> nodeAt(Node<E> fromNode, int fromIndex, int toIndex) {
		Node<E> cur = fromNode;
		int pos = fromIndex;
		while(pos++ < toIndex) {
			cur = cur.next;
		}

		return cur;
	}


	@Override
	public int size() { return size; }

	@Override
	public boolean isEmpty() { return 0 == size; }

	@Override
	public void addFirst(E e) { 
		
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAfter(E e, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void swap(int i1, int i2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		
	}

}
