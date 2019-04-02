
public class Radix {
	public static void main(String[] args) { 
		int[] data = new int[1000];
		for (int i = 0; i < 1000; i++) {
			data[i] = (int) (Math.random() * 1000 - 500);
		}
		radixsort(data);
		for (int i : data) {
			System.out.print(i + " ");
		}
	}
	@SuppressWarnings("unchecked")
	public static void radixsort(int[] data) {
		MyLinkedList<Integer>[] digits = new MyLinkedList[20];
		for (int i = 1; i < 20; i++) {
			digits[i] = new MyLinkedList<Integer>();
		}
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		int max = 0;
		for (int i = 0; i < data.length; i++) { 
			list.add(data[i]);
			if (Math.abs(data[i]) > max) max = Math.abs(data[i]);
		}
		int cur, digit;
		int length = (int) (Math.log10(max) + 1);
		for (int i = 1; i < length; i++) {
			while (list.size() > 0) {
				cur = list.pop();
				digit = (cur / (int)Math.pow(10, i)) % 10;
				digits[10 + digit].add(cur);
			}
			for (int j = 2; j < 20; j++) {
				digits[1].extend(digits[j]);
			}
			list = digits[1];
			digits[1].clear();
		}
		for (int i = 0; i < data.length; i++) {
			data[i] = list.pop();
		}
	}
}
