import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		int i;
		int num;
		Scanner input = new Scanner(System.in);
		while(input.hasNextInt()){
			num = input.nextInt();
			BigInteger result[] = new BigInteger[1001];
 			result[1] = BigInteger.TWO; // result[1] = 2
			result[2] = result[1];
 			result[2] = result[2].add(BigInteger.TWO);
			result[2] = result[2].add(BigInteger.ONE); // result[2] = 5 
			result[3] = result[2];
 			result[3] = result[3].multiply(BigInteger.TWO);
			result[3] = result[3].add(BigInteger.TWO);
			result[3] = result[3].add(BigInteger.ONE); // result[3] = 13
			
			for(i=4;i<=num;i++){
				result[i] = result[i-1];
				result[i] = result[i].multiply(result[1]);
				result[i] = result[i].add(result[i-2]);
				result[i] = result[i].add(result[i-3]);
			}
			System.out.println (result[num]);
		}
	}
}