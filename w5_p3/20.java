import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine().toUpperCase();
		String s1 = br.readLine().toUpperCase();
		
		KMP(s, s1);
	}
	static void KMP(String s, String s1){
		int n = s.length();
		int m = s1.length();
		int count = 0;
		int[] num = new int[n];
		for(int i = 0; i < n; i++)
			num[i] = 0;
		int[] next = computeNext(s1);
		int q = 0;
		for(int i = 0; i < n; i++){
			while(q > 0 && s1.charAt(q) != s.charAt(i))
				q = next[q - 1];
			if(s1.charAt(q) == s.charAt(i)){
				if(q == m - 1){
					q = next[q];
					num[count] = i - m + 2;
					count++;
				}
				else
					q = q + 1;
			}
		}
		System.out.println(count);
		for(int i = 0; i < count; i++)
			System.out.print(num[i] + " ");
	}
	static int[] computeNext(String s1){
		int m = s1.length();
		int[] next = new int[m];
		int k = 0;
		int q = 1;
		while(q < m){
			while(k > 0 && s1.charAt(k) != s1.charAt(k))
				k = next[k - 1];
			if(s1.charAt(q) == s1.charAt(k)){
				k = k + 1;
				next[q] = k;
			}
			q++;
		}
		return next;
	}
}