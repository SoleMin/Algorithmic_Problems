import java.io.*;
import java.util.*;

public class c {
	public static void main(String[] args)
			throws IOException {
		BufferedReader r =	
				new BufferedReader(new InputStreamReader(System.in), 1);
		String s = r.readLine();
		int n = Integer.parseInt(s);
		String s2 = r.readLine();
		StringTokenizer st = new StringTokenizer(s2," ");
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(a);
		if (a[n - 1] == 1) a[n - 1] = 2;
		else {a[n - 1] = 1; Arrays.sort(a);}
		for (int i = 0; i < n; i++)
			System.out.println(a[i]);
	}
}
