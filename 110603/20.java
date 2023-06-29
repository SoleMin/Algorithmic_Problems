import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input =new Scanner(System.in);
		
		BigInteger[] result=new BigInteger[1001];
		result[1]=BigInteger.TWO;
		result[2]=result[1].multiply(BigInteger.TWO).add(BigInteger.ONE);
		result[3]=result[2].multiply(BigInteger.TWO).add(result[1]).add(BigInteger.ONE);
		for(int i=4; i<=1000; i++){
			result[i]=result[i-3].add(result[i-2]).add(result[i-1].multiply(BigInteger.TWO));
		}
		
		while(input.hasNext()) {
			int n=input.nextInt();
			
			System.out.println(result[n]);
		}
		input.close();
	}
}