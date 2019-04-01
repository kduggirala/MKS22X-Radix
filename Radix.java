
public class Radix {
	public static void main(String[] args) { 
	
	}
	@SuppressWarnings("unchecked")
	public static void radixsort(int[] data) {
		MyLinkedList<Integer>[] digits = (MyLinkedList<Integer>[]) new Object[20];
		for (int i = 0; i < 20; i++) {
			digits[i] = new MyLinkedList<Integer>();
		}
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		int max = 0;
		for (int i = 0; i < data.length; i++) { 
			list.add(data[i]);
			if (Math.abs(data[i]) > max) max = Math.abs(data[i]);
		}
		int cur, digit;
		for (int i = 1; i < (int)(Math.log10(max) + 1); i++) {
			while (list.size() > 0) {
				cur = list.pop();
				digit = (cur / (int)Math.pow(10, i)) % 10;
				if (digit < 0) 
					digits[9 + cur].add(cur);
				else
					digits[10 + cur].add(cur);
			}
			for (int j = 1; j < 20; j++) {
				digits[0].extend(digits[j]);
			}
			list = digits[0];
			digits[0].clear();
		}
	}
}
