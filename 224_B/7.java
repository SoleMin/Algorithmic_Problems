import java.io.*;
import java.util.*;
public class B {
	static int i(String s) { return Integer.parseInt(s); }
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = in.readLine().split(" ");
		int n = i(arr[0]);
		int k = i(arr[1]);
		int[] A = new int[n];
		arr = in.readLine().split(" ");
		for(int i=0; i<n; i++)
			A[i] = i(arr[i]);
		
		int st = 0;
		int cnt = 0;
		int[] cnts = new int[100*100*10+1];
		for(int i=0; i<n; i++) {
			cnts[A[i]]++;
			if(cnts[A[i]] == 1) cnt++;
			else while(cnts[A[st]] > 1) {
				cnts[A[st]]--;
				st++;
			}
			if(cnt == k) {
				System.out.println((st+1)+" "+(i+1));
				return;
			}
		}
		System.out.println(-1+" "+-1);
	}
}
