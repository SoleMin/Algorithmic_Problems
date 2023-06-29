import java.util.*;
import java.io.*;

public class luckydivision {
	public static int i(String s){
		return Integer.parseInt(s);
	}
	public static boolean solve(String k, int n){
		int temp = i(k);
		if(temp > n){
			return false;
		}
		if(n % temp == 0)
			return true;
		if(solve(k + "7", n))
			return true;

		return solve(k + "4", n);
	}
	public static void main(String args[]) throws Exception {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int n = i(r.readLine());
		boolean i = solve("7", n);
		boolean j = solve("4", n);
		if(i || j){
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}