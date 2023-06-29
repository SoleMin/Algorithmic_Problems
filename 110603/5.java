import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
//셈
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	
		ArrayList<BigInteger> list = new ArrayList<>();
		
		while(input.hasNextLine()) {
			String n = input.nextLine();
			
			if(n.isEmpty()) break;
			
			int s = Integer.parseInt(n);
			list.add(count(s));
		}
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		input.close();
		

	}
	
	public static BigInteger count(int n) {
		BigInteger[] arr = new BigInteger[1001];
		
		arr[0] = BigInteger.ZERO;
		arr[1] = BigInteger.valueOf(2);
		arr[2] = BigInteger.valueOf(5);
		arr[3] = BigInteger.valueOf(13);

	
		
		for(int i = 4; i < arr.length; i++) {
			arr[i] = arr[i-1].multiply(arr[1]);
			arr[i] = arr[i].add(arr[i-2]);
			arr[i] = arr[i].add(arr[i-3]);
			//arr[i] = arr[i-1].add(arr[i-1]).add(arr[n-2]).add(arr[n-3]);
		}
		

		return arr[n];
	}

}
