package datastructures.archive.ch3FundamentalDataStructures;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements LinkedList<E> {

	private static class Node<E> {
		E e;
		Node<E> next;

		public Node(E e) { this.e = e; }

		@Override
		public String toString() { return e.toString(); }
	}

	private Node<E> head;
	private Node<E> tail;
	private int size;

	private void incrementSize() { size++; }
	private void decrementSize() { size--; }
	private String indexOutOfBoundMessage(int index) { return "Invalid Index " + index + " Size: " + size; }
	private boolean isValidIndex(int index) { return index >= 0 && index < size; }
	private boolean isConsecutiveNodesSwap(int i1, int i2) { return Math.abs(i1-i2) == 1; }

	private Node<E> nodeAt(int index) {
		Node<E> cur = head;
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

	private void print() {
		Node<E> cur = head;
		StringBuilder sb = new StringBuilder("[Size: ")
				.append(size)
				.append("] - [Head: ").append(head)
				.append("] - [tail: ").append(tail)
				.append("] - [")
				;
		while(null != cur) {
			sb.append(cur.e).append(", ");
			cur = cur.next;
		}
		System.out.println(sb.append("]").toString());
	}

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

	private void makeNull(Node<E> n) {
		n.next = null;
		n.e = null;
	}

	private void linkFirst(E e) {
		if (!buildFirstNode(e)) {
			Node<E> newNode = new Node<>(e);
			newNode.next = head;
			head = newNode;
		}
		incrementSize();
	}
	private void linkLast(E e) {
		if (!buildFirstNode(e)) {
			Node<E> newNode = new Node<>(e);
			tail.next = newNode;
			tail = newNode;
		}
		incrementSize();
	}
	private void linkAfter(E e, int index) {
		Node<E> x = nodeAt(index);
		Node<E> newNode = new Node<>(e);
		newNode.next = x.next;
		x.next = newNode;
		incrementSize();
	}

	private E unlinkFirst() {
		Node<E> toBeUnlinked = head;
		head = toBeUnlinked.next;
		E e = toBeUnlinked.e;
		makeNull(toBeUnlinked);
		decrementSize();

		return e;
	}
	private E unlinkLast() {
		Node<E> toBeUnlinked = tail;
		E e = toBeUnlinked.e;
		makeNull(toBeUnlinked);
		decrementSize();

		tail = nodeAt(size-1);
		tail.next = null;

		return e;
	}
	private E unlink(int index) {
		Node<E> toBeUpdated = nodeAt(index-1);
		Node<E> toBeUnlinked = toBeUpdated.next;

		toBeUpdated.next = toBeUnlinked.next;

		E e = toBeUnlinked.e;
		makeNull(toBeUnlinked);
		decrementSize();

		return e;
	}

	private void updateHead(Node<E> n) { head  = n; }
	private void updateTail(Node<E> n) {
		tail  = n;
		tail.next = null;
 	}
	private void updateHeadTail(int left, Node<E> leftNode, int right, Node<E> rightNode) {
		boolean firstNodeIsHead = (0 == left);
		boolean secondNodeIsTail = (size-1 == right);
		if(firstNodeIsHead) { updateHead(rightNode); }
		if(secondNodeIsTail) { updateTail(leftNode); }
	}
	
	private void swapConsecutiveNodes(int i1, int i2) {
		int left = (i1 < i2 ? i1 : i2);
		int right = (i1 < i2 ? i2 : i1);
		
		Node<E> nodeBeforeLeft = (left > 0 ? nodeAt(left-1) : null);
		Node<E> leftNode = (null == nodeBeforeLeft ? nodeAt(left) : nodeBeforeLeft.next);

		Node<E> rightNode = leftNode.next;
		Node<E> nodeAfterRight = rightNode.next;
		
		if (null != nodeBeforeLeft)
			nodeBeforeLeft.next = rightNode;
		leftNode.next = nodeAfterRight;
		rightNode.next = leftNode;
		
		updateHeadTail(left, leftNode, right, rightNode);
	}
	private void swapNodes(int i1, int i2) {
		int left = (i1 < i2 ? i1 : i2);
		int right = (i1 < i2 ? i2 : i1);
		Node<E> nodeBeforeLeft = (left > 0 ? nodeAt(left-1) : null);
		Node<E> leftNode = (null == nodeBeforeLeft ? nodeAt(left) : nodeBeforeLeft.next);
		Node<E> nodeAfterLeft = leftNode.next;
		
		Node<E> nodeBeforeRight = nodeAt(nodeAfterLeft, left+1, right-1);
		Node<E> rightNode = nodeBeforeRight.next;
		Node<E> nodeAfterRight = rightNode.next;
		
		if (null != nodeBeforeLeft) 
			nodeBeforeLeft.next = rightNode;
		nodeBeforeRight.next = leftNode;
		leftNode.next = nodeAfterRight;
		rightNode.next = nodeAfterLeft;
		updateHeadTail(left, leftNode, right, rightNode);
	}
	
	public void addFirst(E e) { linkFirst(e); }
	public void addLast(E e) { linkLast(e); }
	public void add(E e) { linkLast(e); }
	public void addAfter(final E e, int index) {
		if (isValidIndex(index)) {
			if (index == size-1) {
				linkLast(e);
			} else { 
				linkAfter(e, index);
			}
		} else {
			throw new IndexOutOfBoundsException(indexOutOfBoundMessage(index));
		}
	}

	public E remove(int index) {
		E e = null;
		if (isValidIndex(index)) {
			if (0 == index) {
				e = unlinkFirst();
			} else if (size-1 == index) {
				e = unlinkLast();
			} else {
				e = unlink(index);
			}
		} else {
			throw new IndexOutOfBoundsException(indexOutOfBoundMessage(index));
		}

		return e;
	}
	public E removeFirst() {
		if (null == head) 
			throw new NoSuchElementException();
		return unlinkFirst();
	}
	public E removeLast() {
		if (null == tail) 
			throw new NoSuchElementException();
		return unlinkLast();
	}

	public E getFirst() {
		if (null == head) 
			throw new NoSuchElementException();

		return head.e;
	}
	public E getLast() {
		if (null == tail) 
			throw new NoSuchElementException();
		return tail.e;
	}
	public E getAt(int index) {
		E e = null;
		if (isValidIndex(index)) {
			e = nodeAt(index).e;
		} else {
			throw new IndexOutOfBoundsException(indexOutOfBoundMessage(index));
		}
		return e;
	}

	public void swap(int i1, int i2) {
		if (size > 1 && i1 != i2 && isValidIndex(i1) && isValidIndex(i2)) {
			if (isConsecutiveNodesSwap(i1, i2)) {
				swapConsecutiveNodes(i1,i2);
			} else {
				swapNodes(i1,i2);
			}
		} else {
			throw new IndexOutOfBoundsException(indexOutOfBoundMessage(i1) + indexOutOfBoundMessage(i2));
		}
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> sl = new SinglyLinkedList<>();
		sl.add(1); sl.print();
		sl.add(2); sl.print();
		sl.addFirst(3); sl.print();
		sl.addAfter(4, 1); sl.print();
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
		sl.swap(1, 3); sl.print();
	}

}
