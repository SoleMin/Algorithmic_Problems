import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger[] input = new BigInteger[100000];
		ArrayList<BigInteger> al = new ArrayList<BigInteger>();
		al.add(new BigInteger("1"));
		al.add(new BigInteger("1"));
		while(true) {
			String[] arr = br.readLine().split(" ");
			input[0] = new BigInteger(arr[0]);
			input[1] = new BigInteger(arr[1]);
			if (arr[0].equals(arr[1]) && arr[1].equals("0")) {
				break;
			}
			int cnt = 0;
			int i = 1;
			
			
			BigInteger[] a = new BigInteger[2];
			while(true) {
				a[0] = al.get(i - 1);
				a[1] = al.get(i);
				if (al.size() - 1 < i + 1) {
					al.add(a[0].add(a[1]));
				}
				i++;
				
				if (a[1].compareTo(input[0]) >= 0 && a[1].compareTo(input[1]) <= 0) {
					cnt++;
				}
				if (a[1].compareTo(input[1]) > 0) {
					break;
				}
			}
			System.out.println(cnt);
		}
	}
}
