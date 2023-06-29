import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		while (scan.hasNextLine()){
			int n = scan.nextInt();
			
			if (n == 0)
				break;
			
			ArrayList<BigInteger> seq = new ArrayList<>();
			
			BigInteger first = new BigInteger("1");
			BigInteger second = new BigInteger("0");
			
			seq.add(first);
			int idx = 1;
			
			while (idx != n){
				
				second = BigInteger.valueOf(1).add(seq.get(idx - seq.get(seq.get(idx - 1).intValue() - 1).intValue()));
				seq.add(second);
				idx += 1;
				
			}
			System.out.println(second);
		}
	}
}