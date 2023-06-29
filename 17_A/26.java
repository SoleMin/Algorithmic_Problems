import java.io.*;
import java.util.*;

public class Main {
	static Scanner in;
	static PrintWriter out;
//	static final String PROBLEM = "";

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int k = in.nextInt();

		boolean[] p = new boolean[n + 5];
		int[] pp = new int[n + 5];
		int ind = 0;
		Arrays.fill(p, true);
		p[0] = false;
		p[1] = false;
		for (int i = 2; i < n + 5; i++)
			if (p[i]) {
				pp[ind++] = i;
				for (int j = 2*i; j < n + 5; j += i) p[j] = false;
			}
//	    for (int i = 0; i < 30; i++) if (p[i]) out.println(i);
		
		boolean[] b = new boolean[n + 1];
		for (int i = 0; i < ind - 1; i++)
			if (pp[i] + pp[i + 1] + 1 <= n && p[pp[i] + pp[i + 1] + 1]) b[pp[i] + pp[i + 1] + 1] = true;
		
		int kol = 0;
		for (int i = 2; i <= n; i++)	
			if (b[i]) kol++;

		if (kol >= k) out.println("YES");
		else out.println("NO");

		out.close();
	}
}