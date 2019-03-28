
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
			E data = head.data;
			head = head.next;
			return data;
		}
		return null;
	}
}
