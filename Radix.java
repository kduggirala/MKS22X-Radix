import java.util.Arrays;
public class Radix {
	public static void main(String[]args){
		  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
		  int[]MAX_LIST = {1000000000,500,10};
		  for(int MAX : MAX_LIST){
		    for(int size = 31250; size < 2000001; size*=2){
		      long qtime=0;
		      long btime=0;
		      //average of 5 sorts.
		      for(int trial = 0 ; trial <=5; trial++){
		        int []data1 = new int[size];
		        int []data2 = new int[size];
		        for(int i = 0; i < data1.length; i++){
		          data1[i] = (int)(Math.random()*MAX);
		          data2[i] = data1[i];
		        }
		        long t1,t2;
		        t1 = System.currentTimeMillis();
		        radixsort(data2);
		        t2 = System.currentTimeMillis();
		        qtime += t2 - t1;
		        t1 = System.currentTimeMillis();
		        Arrays.sort(data1);
		        t2 = System.currentTimeMillis();
		        btime+= t2 - t1;
		        if(!Arrays.equals(data1,data2)){
		          System.out.println("FAIL TO SORT!");
		          System.exit(0);
		        }
		      }
		      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
		    }
		    System.out.println();
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
		for (int i = 1; i <= length; i++) {
			while (list.size() > 0) {
				cur = list.pop();
				digit = (cur / (int)Math.pow(10, i - 1)) % 10;
				digits[10 + digit].add(cur);
			}
			for (int j = 2; j < 20; j++) {
				digits[1].extend(digits[j]);
			}
			list.extend(digits[1]);
			digits[1].clear();
		}
		for (int i = 0; i < data.length; i++) {
			data[i] = list.pop();
		}
	}
}
