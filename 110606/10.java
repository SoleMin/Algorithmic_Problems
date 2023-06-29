import java.io.*;
import java.util.*;
import java.math.*;

class Main {
	static int n, hn, h4n;
	static BigInteger [] hanoi = new BigInteger[10000 + 1];
	static BigInteger [] hanoi4 = new BigInteger[10000 + 1];
	static BigInteger zero, one;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		zero = BigInteger.valueOf(0);
		one = BigInteger.valueOf(1);
		hanoi[1] = BigInteger.valueOf(1);
		hanoi4[0] = BigInteger.valueOf(0);
		hanoi4[1] = BigInteger.valueOf(1);
		hn = h4n = 2;
		
		while (sc.hasNextInt()) {
			n = sc.nextInt();
			solve(n);
			
			System.out.println(hanoi4[n]);
			
		}
	}
	public static void calchanoi(int n) {
		for(; hn <= n; hn++) {
			hanoi[hn] = hanoi[hn - 1].add(hanoi[hn-1]);
			hanoi[hn] = hanoi[hn].add(one);
		}
	}
	public static void solve (int n) {
		int k;
		BigInteger temp;
		for (; h4n <= n; h4n++) {
			hanoi4[h4n] = hanoi4[h4n-1].add(hanoi4[h4n-1]);
			hanoi4[h4n] = hanoi4[h4n].add(hanoi[1]);
			for (k = h4n-2; k > 0; k--) {
				calchanoi(h4n - k);
				temp = hanoi4[k].add(hanoi4[k]);
				temp = temp.add(hanoi[h4n-k]);
				if (hanoi4[h4n].compareTo(temp) == 1)
						hanoi4[h4n] = temp.add(zero);
				else 
					break;
			}
		}
	}
}