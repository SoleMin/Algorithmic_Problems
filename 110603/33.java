import java.math.BigInteger;
import java.util.Scanner;

class Main {
	public static BigInteger[] bigNum = new BigInteger[3];
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int n, i;
		
		while(input.hasNextLine()) {
			String temp = input.nextLine();
			if(temp.equals(""))
				break;
			
			bigNum[0] = new BigInteger("2");
			bigNum[1] = new BigInteger("5");
			bigNum[2] = new BigInteger("13");
			
			n = Integer.parseInt(temp);
			
			for(i=0; i < n - 1; i++)
				plus(i % 3);
			System.out.println(bigNum[i % 3]);
		}
		input.close();
	}
	
	public static void plus(int target) {
		bigNum[target] = bigNum[target].add(bigNum[(target + 2) % 3]);
		bigNum[target] = bigNum[target].add(bigNum[(target + 1) % 3]).add(bigNum[(target + 2) % 3]);
	}
}