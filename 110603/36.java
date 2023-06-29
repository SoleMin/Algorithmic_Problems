import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		BigInteger a[] = new BigInteger[1001];
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextLine()) {
			a[1] = new BigInteger("2");
			a[2] = new BigInteger("5");
			a[3] = new BigInteger("13");
			for (int i =4; i< 1001; i++)
				a[i] = new BigInteger("0");
			String s = sc.nextLine();
			if (s.length() == 0)
				break;
			int j = 4;
			int i = Integer.parseInt(s);
			while(j <= i) {
				a[j] = a[j].add(a[j-1]);
				a[j] = a[j].add(a[j-1]);
				a[j] = a[j].add(a[j-2]);
				a[j] = a[j].add(a[j-3]);
				j++;
			}
			
			System.out.println(a[i]);
		}
	}
}