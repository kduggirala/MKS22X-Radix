
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
}
