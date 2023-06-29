
import java.util.*;
import java.io.*;

public class two {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader in = new BufferedReader(new FileReader("two"));

		HashSet<Integer> good = new HashSet<>();
		int i=1;
		for (; i<= (int)(1e9);) {
			i <<= 1;
			good.add(i);
		}
		
		for (i=3; i*i*2 <= (int)(1e9); i++) {
			good.add(i*i*2);
		}
		
		int beg = 4;
		for (i=3; beg + i*4 <= (int)(1e9); i+=2) {
			good.add(beg + i*4);
			beg += i*4;
		}
		
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			if (good.contains(n)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			
		}

	}
}
