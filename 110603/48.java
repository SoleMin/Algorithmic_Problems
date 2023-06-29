import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		while (scan.hasNextLine()){
			
			int std_num = scan.nextInt();
			ArrayList<BigInteger> seq = new ArrayList<>();
			
			BigInteger first = new BigInteger("2");
			BigInteger second = new BigInteger("5");
			BigInteger third = new BigInteger("13");
			BigInteger new_val;
			
			seq.add(first);
			seq.add(second);
			seq.add(third);
			
			while (seq.size() < std_num){
				new_val = first.add(second).add(third.multiply(BigInteger.valueOf(2)));
				first = second;
				second = third;
				third = new_val;
				seq.add(new_val);
			}
			System.out.println(seq.get(std_num - 1));
			scan.nextLine();
		}
	}
}