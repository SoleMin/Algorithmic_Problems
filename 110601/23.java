import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		BigInteger[] arr = new BigInteger[1000];
		
		arr[0]=BigInteger.valueOf(1);
		arr[1]=BigInteger.valueOf(2);
		
		for(int i=2;i<arr.length;i++){
			BigInteger a = arr[i-1].add(arr[i-2]);
			arr[i]= a;
		}
		
		while(scanner.hasNextLine()){
			BigInteger a =scanner.nextBigInteger();
		  BigInteger b =scanner.nextBigInteger();
			
			int count = 0;
			
			if(a.compareTo(b) == 0 && a.compareTo(BigInteger.ZERO) ==0 ){
				break;
			}
			
			for(int i=0;i<arr.length;i++){
				if(a.compareTo(arr[i]) != 1 && b.compareTo(arr[i]) != -1){
					count++;
				}
			}
			
			System.out.println(count);
		}
		
	}
}