
public class MyLinkedList<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;
	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	public void add(E element) {
		if(head == null) {
			head = new Node<E>(element);
		}
		else {
			Node<E> next = new Node<E>(element);
			if (tail == null) {
				tail = next;
				head.next = tail;
			}
			else {
				tail.next = next;
				tail = next;
			}
		}
		size++;
	}
	public void merge(MyLinkedList<E> l1, MyLinkedList<E> l2) {
		l1.tail.next = l2.head;
		l1.tail = l2.tail;
	}
	public E getFirst() {
		return head == null ? null : head.data;
	}
	public E getLast() {
		return tail == null ? (head == null ? null : head.data) : tail.data;
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
			Node<E> cur = head.next;
			Node<E> prev = head;
			Node<E> next = cur.next;
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
}
