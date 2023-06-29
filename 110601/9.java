import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

class Main{
	
	public static int calcfibo(BigInteger n, BigInteger m) {

		int ans = 0;
		BigInteger num1 = BigInteger.valueOf(0);
		BigInteger num2 = BigInteger.valueOf(1);
		BigInteger sum = BigInteger.valueOf(1);
		while(true){
			
			sum = num1.add(num2);
			if(sum.compareTo(m) == 1) break;
			if(n.compareTo(sum) == -1 || n.compareTo(sum) == 0) ans++;
			num1 = num2;
			num2 = sum;
		}
		return ans;
	}
	
	public static void main(String[] args) throws Exception {
	BigInteger a;
	BigInteger b;
	BigInteger zero = BigInteger.valueOf(0);
    int n, m, ans;
    Scanner input = new Scanner(System.in);
    
    while(input.hasNextInt()) {
    	a = input.nextBigInteger();
    	b = input.nextBigInteger();
    	if((a.add(b)).compareTo(zero) == 0) break;
    	
    	ans = calcfibo(a, b);
   
    	System.out.println(ans);
    }
  }
}