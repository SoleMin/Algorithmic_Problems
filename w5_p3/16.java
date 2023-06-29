import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		String t = input.nextLine();
		String p = input.nextLine();
		
		KMP(t, p);
		
		input.close();
	}
	
	public static void KMP(String t, String p) {
		int n = t.length();
		int m = p.length();
		int next[] = new int[p.length()];
		int count = 0;
		String where = "";
		int k = 0;
		int q = 1;
		
		while(q < m) {
			while(k > 0 && p.charAt(k) != p.charAt(q))
				k = next[k - 1];
			if(p.charAt(k) == p.charAt(q))
				k++;
			next[q] = k;
			q++;
		}
		int i = 0;
		k = 0;
		
		while(i < n) {
			while(k > 0 && p.charAt(k) != t.charAt(i))
				k = next[k - 1];
			if(p.charAt(k) == t.charAt(i))
				k++;
			if(k == m) {
				where += i - m + 2 + " ";
				k = next[k - 1];
				count++;
			}
			i++;
		}
		
		System.out.println(count);
		System.out.println(where);
		
	}
}