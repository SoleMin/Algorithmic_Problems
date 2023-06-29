import java.math.BigInteger;
import java.util.Scanner;
public class Main {    
	static BigInteger[] Counting = new BigInteger[1002];    
	public static void main(String[] args) {        
		Scanner sc = new Scanner(System.in);        
		Counting[1] = new BigInteger("2");        
		Counting[2] = new BigInteger("5");        
		Counting[3] = new BigInteger("13");        
		while (sc.hasNext()) {            
			int n = sc.nextInt();            
			if (n > 3) {                
				for (int i = 4; i <= n; i++) {                    
					if (Counting[i] != null)                        
						continue;                    
					Counting[i] = Counting[i - 1].shiftLeft(1).add(Counting[i - 2]).add(Counting[i - 3]);                
				}            
			}            
			System.out.println(Counting[n]);        
		}    
	}
}