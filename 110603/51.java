import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		BigInteger arr[] = new BigInteger[1001];
		
		arr[0] = new BigInteger("0");
		arr[1] = new BigInteger("2");
		arr[2] = new BigInteger("5");
		arr[3] = new BigInteger("13");
		
		for(int i =4; i<1001; i++) {
			arr[i] = (arr[i-1].multiply(new BigInteger("2"))).add(arr[i-2]).add(arr[i-3]);
		}
			
		while(input.hasNextLine()) {
			String s = input.nextLine();
			int num = Integer.parseInt(s);
			/**4이상부터 f(n-1)+ f(n-2) + f(n-3) 근데 어케 만듦?**/
			System.out.println(arr[num]);
		
		}
		
		
	}
}