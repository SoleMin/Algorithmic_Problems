import java.math.BigInteger;
import java.util.Scanner;

class Main {
	
	static BigInteger fib[] = new BigInteger[100000];
	static int idx = 0;
	
	public static void main(String[] args) throws Exception {
		//1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
		Scanner sc = new Scanner(System.in);
		
		String temp[]; //입력용
		BigInteger a, b, here;
		
		fib[1] = BigInteger.valueOf(1);
		fib[2] = BigInteger.valueOf(2);
		here = fib[2];
		idx = 2;
		
		while(sc.hasNextLine()) {
			temp = sc.nextLine().split(" ");
			if(temp[0].equals("0") && temp[1].equals("0")) { break; }
			a = new BigInteger(temp[0]);
			b = new BigInteger(temp[1]);
			
			if(b.compareTo(here) > 0) { here = setFib(here, b); }
			
			System.out.println(search(b,false) - search(a, true));
		}
		
		sc.close();
	}
	
	static BigInteger setFib(BigInteger here, BigInteger n) {
		idx++;
		while(true) {
			fib[idx] = fib[idx-1].add(fib[idx-2]);
			if(fib[idx].compareTo(n) > 0) { break; }
			idx++;
		}
		return fib[idx];
	}
	
	static int search(BigInteger x, boolean first) {
		int index = 1;
		while(true) {
			if(x.compareTo(fib[index])==0 && first)
				return --index;
			if(x.compareTo(fib[index]) < 0)
				break;
			index++;
		}
		return index-1;
	}
}