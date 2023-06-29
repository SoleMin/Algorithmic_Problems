import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String t = sc.nextLine();
		String p = sc.nextLine();
		
		int n = t.length();
		int m = p.length();
		int i = 0;
		int [] next = new int [m];
		int cnt = 0;
		ArrayList<Integer> index = new ArrayList<>();
		
		// next
		next[0] = 0;
		int k = 0;
		int q = 1;
		
		while ( q < m ) {
			//System.out.println(k + " " + p.charAt(k) + " " + p.charAt(q));
			while (k > 0 && p.charAt(k) != p.charAt(q)) {
				k = next[k-1];
			}
			if (p.charAt(k) == p.charAt(q)) next[q] = ++k;
			q++;
		}
		//----
		/*
		for (int l = 0; l < m; l++) {
			System.out.print(next[l] + " ");
		}*/
		q = 0;
		
		while ( i < n ) {
			//System.out.println(p.charAt(q) + " " + t.charAt(i) + " " + i + " " + q + " " + next[q] );
			while ( q > 0 && p.charAt(q) != t.charAt(i)) {
				q = next[q-1];
			}
			
			if (p.charAt(q) == t.charAt(i)) {
				if (q + 1 == m) {
					cnt++;
					index.add(i - m+2);
					q = next[q];
				} else q++;
			}
			i++;
			/*
			if (q == m) {
				//System.out.println("FIND!");
				cnt++;
				index.add(i-m+2);
				q = next[q-1];
			}
			i++; */
		}
		System.out.println(cnt);
		for (int y = 0; y < index.size(); y ++) {
			System.out.print(index.get(y) + " ");
		}
	}
}