import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		BigInteger[] arr = new BigInteger[1000];
		
		arr[0]=BigInteger.valueOf(2);
		arr[1]=BigInteger.valueOf(5);
		arr[2]=BigInteger.valueOf(13);
		
		for(int i=3;i<arr.length;i++){
			BigInteger a = arr[i-1].add(arr[i-1]).add(arr[i-2]).add(arr[i-3]);
			arr[i] = a;
		}
		
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			System.out.println(arr[n-1]);
		}
		
	
	}
}