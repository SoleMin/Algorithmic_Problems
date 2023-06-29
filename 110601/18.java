//7_1
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static BigInteger a;
	static BigInteger b;
	static BigInteger fibonachi[];
	// 481번쨰 인덱스가 101자리
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			String s1 = scan.next();
			String s[] = scan.nextLine().split(" ");
			String s2 = s[1];
			if (s1.equals("0") && s2.equals("0"))
				break;
			a = new BigInteger(s1);
			b = new BigInteger(s2);
			fibonachi = new BigInteger[482];
			fibonachi[0] = BigInteger.valueOf(0);
			fibonachi[1] = BigInteger.valueOf(1);
			int sum=0;
			if (a.equals(BigInteger.valueOf(0))) sum=2;
			//else if (a.equals(BigInteger.valueOf(1))) sum=1;
			System.out.println(fib(a, b)+sum);
		}
	}

	static int fib(BigInteger a, BigInteger b) {
		int sum = 0,tr=0, i=2;
		for (; i < 482; i++) {
			fibonachi[i] = fibonachi[i - 1].add(fibonachi[i - 2]);
			if (fibonachi[i].compareTo(a) >=0) {
				//System.out.println(fibonachi[i]);
				if(tr==0) {sum=i; tr=1;}
				if (fibonachi[i].compareTo(b) >0) {
					break;
				}
				else if(fibonachi[i].compareTo(b)==0) {
					i++; break;
				}
			}
		}
		return i-sum;
	}
}
//0 1 1 2 3 5 8 13 21 34 55 89 144