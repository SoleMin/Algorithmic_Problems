import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;


public class f {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Hashtable<Long, Boolean> d = new Hashtable<Long, Boolean>();
		int n = in.nextInt(), k = in.nextInt(), size = 0, a[] = new int[n];
		for (int i = 0; i < n; i++) a[i] = in.nextInt();
		Arrays.sort(a);
		for (int i = 0; i < n; i++) {
			long x = a[i];
			if (!d.containsKey(x)) {
				d.put(x * k, true);
				size++;
			}
		}
		System.out.println(size);
	}

}

  	 		   							  		 	  	 	