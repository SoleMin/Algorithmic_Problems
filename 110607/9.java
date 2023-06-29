import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;

class Main {
	
	static BigInteger max = new BigInteger("2000000001");
	static BigInteger[] seq = new BigInteger[max];
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			String s = input.nextLine();
			BigInteger n = new BigInteger(s);
			self(n);
			System.out.println("" + seq[n]);
		}
	}
	
	static void self(BigInteger n){
		seq[1] = 1;
		BigInteger i = new BigInteger("1");
		while(i.compareTo(n) == -1){
			seq[i+1] = 1 + seq[(i+1)-seq[seq[i]]];
			i.add("1");
		}
	}
}