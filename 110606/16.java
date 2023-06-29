import java.math.*;
import java.util.*;
public class Main {    
	static final 
		int MAX = 10010;    
	public static void main(String[] args) {        
		Scanner sc = new Scanner(System.in);        
		BigInteger[] a = new BigInteger[MAX];        
		a[0] = BigInteger.ZERO;        
		BigInteger k = BigInteger.ONE;;        
		count(a, k);        
		while (sc.hasNext()) {            
			System.out.println(a[sc.nextInt()]);        
		}    
	}    
	public static void count(BigInteger[] a, BigInteger k) {        
		int i = 1, cnt = 1;        
		while (i < MAX) {            
			for (int j = 0; j < cnt && i < MAX; ++j) {                
				a[i] = a[i - 1].add(k);                
				++i;            
			}            
			k = k.add(k);            
			++cnt;        
		}    
	}
}