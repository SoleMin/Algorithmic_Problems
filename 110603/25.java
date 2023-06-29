import java.util.*;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		List<BigInteger> sl = new ArrayList<BigInteger>();
		BigInteger bN = new BigInteger("0");
		int n, i;
		
		sl.add(bN);
		sl.add(new BigInteger("2"));
		sl.add(new BigInteger("5"));
		sl.add(new BigInteger("13"));
		
		for(i = 4; i < 1001; i++){
			bN = sl.get(i-1).multiply(new BigInteger("2")).add(sl.get(i-2)).add(sl.get(i-3));
			sl.add(bN);
		}
		
		while(input.hasNext()){
			n = input.nextInt();
			System.out.println(sl.get(n));
		}
	}
}