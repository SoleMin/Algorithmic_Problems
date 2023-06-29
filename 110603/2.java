import java.io.*;
import java.math.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		BigInteger[] counting = new BigInteger[1001];
		counting[1] = new BigInteger("2");
	  counting[2] = new BigInteger("5");
		counting[3]= new BigInteger("13");
		
		for( int i=4 ; i<counting.length;i++){
			counting[i]=counting[i-1].multiply(counting[1]).add(counting[i-2]).add(counting[i-3]);
		//	System.out.println(counting[i]);
		}
		
		while(scanner.hasNextInt()){
			int n = scanner.nextInt();
			scanner.nextLine();
			System.out.println(counting[n]);
		}
		
	}
}