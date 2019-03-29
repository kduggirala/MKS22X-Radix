
public class Driver {
	public static void main(String[] args) {
		MyLinkedList<Integer> l = new MyLinkedList<Integer>();
		for (int i = 1; i < 10000; i += i) {
			l.add(i);
		}
		System.out.println(l);
		MyLinkedList<Integer> l2 = new MyLinkedList<Integer>();
		l2.add(15);
		l2.add(14);
		l2.add(4387);
		l.extend(l2);
		System.out.println(l);
		int size = l.size();
		for (int i = 0; i < size; i++) {
			System.out.print(l.pop() + " ");
		}
	}
}
