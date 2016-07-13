package ch3FundamentalDataStructures;

public class SinglyLinkedList<E> {

	private static class Node<E> {
		E e;
		Node<E> next;

		public Node(E e) { this.e = e; }
		
		public boolean hasNext() { return null != next; }
	}

	private Node<E> head;
	private Node<E> tail;
	private int size;

	private void incrementSize() { size++; }
	private void decrementSize() { size--; }
	
	private boolean buildFirstNode(E e) {
		boolean built = false;
		if (isEmpty()) {
			Node<E> newNode = new Node<>(e);
			head = tail = newNode;
			built = true;
		}
		
		return built;
	}
	
	public int size() { return size; }
	public boolean isEmpty() { return null == head; }
	
	public void add(E e) {
		if (!buildFirstNode(e)) {
			Node<E> newNode = new Node<>(e);
			tail.next = newNode;
			tail = newNode;
		}
		incrementSize();
	}

	public void addFirst(E e) {
		if (!buildFirstNode(e)) {
			Node<E> newNode = new Node<>(e);
			newNode.next = head;
			head = newNode;
		}
		incrementSize();
	}

	public void addLast(E e) { add(e); }

	public void addAfter(final E e, final Node<E> node) {
		if (null == node) {
			throw new IllegalArgumentException("Given node can not be null");
		} else if (tail == node) {
			add(e);
		} else {
			Node<E> cur = head;
			while(cur.hasNext()) {
				if (cur == node) {
					Node<E> newNode = new Node<>(e);
					newNode.next = cur.next;
					cur.next = newNode;
					incrementSize();
					break;
				}
				cur = cur.next;
			}
		}
		throw new IllegalArgumentException("Given node can not be found.");
	}

	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> sl = new SinglyLinkedList<>();
	}

}

















