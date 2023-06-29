import java.math.BigInteger;
import java.util.Scanner;
public class Main {    
	public static void main(String[] args) {        
		Scanner sc = new Scanner(System.in);        
		BigInteger[] fibo = new BigInteger[555];        
		fibo[0] = new BigInteger("1");        
		fibo[1] = new BigInteger("2");        
		for (int i = 2; i < fibo.length; i++) {            
			fibo[i] = fibo[i - 1].add(fibo[i - 2]);        
		}        
		for(;;) {            
			BigInteger prev, next;            
			int res = 0;            
			prev = sc.nextBigInteger();            
			next = sc.nextBigInteger();            
			if (prev.compareTo(BigInteger.ZERO) == 0 && next.compareTo(BigInteger.ZERO) == 0) {                
				break;            
			}            
			for (int i = 0; i < fibo.length; i++) {                
				if (fibo[i].compareTo(prev) != -1 && fibo[i].compareTo(next) != 1) {                    
					res++;                
				}            
			}            
			System.out.println(res);        
		}    
	}
}