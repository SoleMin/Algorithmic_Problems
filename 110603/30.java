import java.io.*;
import java.util.*;
import java.math.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			String s = input.nextLine();
			
			if(s.equals(""))
				break;
			
			int n = Integer.parseInt(s);
			
			BigInteger arr[];
			
			if(n > 3) {
				arr = new BigInteger[n];
				arr[0] = BigInteger.valueOf(2);
				arr[1] = BigInteger.valueOf(5);
				arr[2] = BigInteger.valueOf(13);
				for(int i = 3; i < n; i++)
					arr[i] = arr[i - 1].multiply(BigInteger.valueOf(2)).add(arr[i - 2]).add(arr[i - 3]);
				
				System.out.println(arr[n - 1]);
			}
			else {
				arr = new BigInteger[3];
				arr[0] = BigInteger.valueOf(2);
				arr[1] = BigInteger.valueOf(5);
				arr[2] = BigInteger.valueOf(13);
				System.out.println(arr[n - 1]);
			}
		}
		
		input.close();
	}
}