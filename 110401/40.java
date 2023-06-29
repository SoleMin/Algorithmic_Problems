import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		int test = scanner.nextInt();
		
		for(int t=0;t<test;t++){
			int n= scanner.nextInt();
			int[] address = new int[n];
			for(int i=0;i<address.length;i++){
				address[i]=scanner.nextInt();
			}
			Arrays.sort(address);
			int mid = address[address.length/2];
			int result = 0;
			for(int i=0;i<address.length;i++){
				result+=Math.abs(address[i]-mid);
			}
			System.out.println(result);
		}
		
	}
}