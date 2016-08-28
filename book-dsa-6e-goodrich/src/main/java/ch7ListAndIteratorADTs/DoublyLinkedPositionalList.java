package ch7ListAndIteratorADTs;

import java.util.NoSuchElementException;

public class DoublyLinkedPositionalList<E> implements PositionalList<E> {

	private static class Node<E> implements Position<E> {
		E e;
		Node<E> prev;
		Node<E> next;

		Node() {}
		Node(E e, Node<E> prev, Node<E> next) {
			this.prev = prev;
			this.e = e;
			this.next = next;
		}

		@Override
		public E getElement() { return e; }

		@Override
		public String toString() { return e.toString(); }
	}

	private int size;
	private Node<E> head;
	private Node<E> tail;

	public DoublyLinkedPositionalList() {
		head = new Node<>();
		tail = new Node<>();
		head.next = tail;
		tail.prev = head;
	}

	private Node<E> validateAndReturnNode(Position<E> p) {
		if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid postion.");
		Node<E> n = (Node<E>) p;
		if (null == n.next) throw new IllegalArgumentException("This Position is no longer part of the list.");
		
		return n;
	}
	
	private Position<E> addBetween(E e, Node<E> prev, Node<E> next) {
		Node<E> n = new Node<>(e, prev, next);
		prev.next = n;
		next.prev = n;

		size++;
		return n;
	}

	@Override
	public int size() { return size; }

	@Override
	public boolean isEmpty() { return 0 == size; }

	@Override
	public Position<E> first() {
		if (tail == head.next) 
			throw new NoSuchElementException();

		return head.next;
	}

	@Override
	public Position<E> last() {
		if (tail.prev == head) 
			throw new NoSuchElementException();

		return tail.prev;
	}

//------------------------------ ADD NODES ------------------------------//

	@Override
	public Position<E> add(E e) { return addLast(e); }

	@Override
	public Position<E> addFirst(E e) { return addBetween(e, head, head.next); }

	@Override
	public Position<E> addLast(E e) { return addBetween(e, tail.prev, tail); }

	@Override
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> nodeAtGivenPos = validateAndReturnNode(p);
		return addBetween(e, nodeAtGivenPos.prev, nodeAtGivenPos);
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> nodeAtGivenPos = validateAndReturnNode(p);
		return addBetween(e, nodeAtGivenPos, nodeAtGivenPos.next);
	}

	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> nodeAtGivenPos = validateAndReturnNode(p);
		return nodeAtGivenPos.prev;
	}

	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> nodeAtGivenPos = validateAndReturnNode(p);
		return nodeAtGivenPos.next;
	}

	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> nodeAtGivenPos = validateAndReturnNode(p);
		E oe = nodeAtGivenPos.e;
		nodeAtGivenPos.e = e;

		return oe;
	}

	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> nodeAtGivenPos = validateAndReturnNode(p);
		nodeAtGivenPos.prev.next = nodeAtGivenPos.next;
		nodeAtGivenPos.next.prev = nodeAtGivenPos.prev;
		nodeAtGivenPos.next = nodeAtGivenPos.prev = null;
		E e = nodeAtGivenPos.e;
		nodeAtGivenPos.e = null;
		size--;
		

		return e;
	}

	private void print() {
		Node<E> cur = head.next;
		StringBuilder sb = new StringBuilder("[Size: ")
				.append(size)
				.append("] - [Head: ").append(head.next)
				.append("] - [tail: ").append(tail.prev)
				.append("] - [")
				;
		while(null != cur.next) {
			sb.append(cur.e).append(", ");
			cur = cur.next;
		}
		System.out.println(sb.append("]").toString());
	}

	public static void main(String[] args) {
		DoublyLinkedPositionalList<Integer> sl = new DoublyLinkedPositionalList<>();
		sl.add(1); sl.print();
		sl.add(2); sl.print();
		sl.addFirst(3); sl.print();
		sl.remove(sl.first()); sl.print();
/*		sl.addAfter(4, 1); sl.print();
		sl.add(5); sl.print();
		System.out.println("\n---consecutive swap---\n");
		sl.swap(0, 1); sl.print();
		sl.swap(2, 3); sl.print();
		sl.swap(3, 4); sl.print();
		sl.swap(1, 2); sl.print();
		sl.swap(3, 4); sl.print();
		System.out.println("\n--swap---\n");
		sl.swap(0, 4); sl.print();
		sl.swap(0, 2); sl.print();
		sl.swap(2, 4); sl.print();
		sl.swap(1, 3); sl.print();
		sl.swap(0, 2); sl.print();
		sl.swap(1, 3); sl.print();*/
	}
}
