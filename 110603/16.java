import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;
class Main {
	public static void main(String[] args) throws Exception {
		BigInteger[] arr = new BigInteger[1000];
		arr[0] = BigInteger.valueOf(1);
		arr[1] = BigInteger.valueOf(2);
		arr[2] = BigInteger.valueOf(5);
		arr[3] = BigInteger.valueOf(13);
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextInt()){
			int n = input.nextInt();
			if(n > 3){
				for(int i = 4; i < n + 1; i++){
					arr[i] = arr[i-1].multiply(arr[1]).add(arr[i-2]).add(arr[i-3]);
				}
			}
			
			System.out.println(arr[n]);
		}
	}
}