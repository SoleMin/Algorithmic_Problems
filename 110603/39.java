import java.io.*;
import java.util.*;
import java.math.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		BigInteger a[] = new BigInteger[1000];
		a[0] = new BigInteger("1");
		a[1] = new BigInteger("2");
		a[2] = new BigInteger("5");
		a[3] = new BigInteger("13");
		
		for(int i = 4; i< a.length; i++){
			a[i] = a[i-1].add(a[i-1]).add(a[i-2]).add(a[i-3]);
		}		
		
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(a[n]);
			
		}
		
		
		
	}
}