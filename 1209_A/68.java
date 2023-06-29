import java.io.*;
import java.util.*;
import java.math.*;

public class A {

	public void realMain() throws Exception {

		BufferedReader fin = new BufferedReader(new InputStreamReader(System.in), 1000000);

		String in = fin.readLine();

		String[] ar = in.split(" ");

		int n = Integer.parseInt(ar[0]);
		
		int[] a = new int[n];

		for(int i = 0; i < n; i++) {
			int ret = 0;
			boolean dig = false;
			for (int ch = 0; (ch = fin.read()) != -1; ) {
        			if (ch >= '0' && ch <= '9') {
            				dig = true;
           				ret = ret * 10 + ch - '0';
        			} else if (dig) break;
    			}

			a[i] = ret;
			
		}

		int ret = 0;

		Arrays.sort(a);

		boolean[] colored = new boolean[n];

		for(int i = 0; i < n; i++) {
			if(!colored[i]) {
				ret++;
				for(int j = i; j < n; j++) {
					if(a[j] % a[i] == 0) {
						colored[j] = true;
					}
				}
			}
		}

		System.out.println(ret);



	}


	public static void main(String[] args) throws Exception {
		A a = new A();
		a.realMain();
	}
}