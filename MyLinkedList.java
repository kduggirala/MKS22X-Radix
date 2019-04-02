
public class MyLinkedList<E> {
	private class Node {
		E data;
		Node next;
		public Node(E data) {
			this.data = data;
			next = null;
		}
	}
	private Node head;
	private Node tail;
	private int size;
	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	public String toString() {
		StringBuffer string = new StringBuffer();
		Node cur = head;
		while (cur != null) {
			string.append(cur.data + " ");
			cur = cur.next;
		}
		return string.toString();
	}
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}
	public void add(E element) {
		if(head == null) {
			head = new Node(element);
			tail = head;
		}
		else {
			Node next = new Node(element);
			tail.next = next;
			tail = next;
		}
		size++;
	}
	public void extend(MyLinkedList<E> l) {
		if (l.head != null) {
			if (head == null) {
				head = l.head;
				tail = l.tail;
			}
			else {
				tail.next = l.head;
				tail = l.tail;
			}
			l.clear();
			size += l.size();
		}
	}
	public E getFirst() {
		return head == null ? null : head.data;
	}
	public E getLast() {
		return tail == null ? null : tail.data;
	}
	public E pop() {
		if (head != null) {
			size--;
			E data = head.data;
			head = head.next;
			return data;
		}
		return null;
	}
	public E remove(int index) {
		if (index < size) {
			if (index == 0) return pop();
			size--;
			Node cur = head.next;
			Node prev = head;
			Node next = cur.next;
			for (int i = 1; i < index; i++) {
				cur = next;
				prev = cur;
				next = cur.next;
			}
			E data = cur.data;
			prev.next = next;
			if (index == size - 1) tail = prev;
			return data;
		}
		else 
			throw new IllegalArgumentException();
	}
	public int size() {
		return size;
	}
}