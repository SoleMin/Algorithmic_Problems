import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<BigInteger> list = new ArrayList<>();
		list.add(BigInteger.ZERO);
		list.add(new BigInteger(2+""));
		list.add(new BigInteger(5+""));
		list.add(new BigInteger(13+""));
		
		for(int i = 4; i<=1000; i++)
			list.add(list.get(i-1).add(list.get(i-1).add(list.get(i-2).add(list.get(i-3)))));
		String line;
		while((line = br.readLine()) != null) {
			int n = Integer.parseInt(line);
			System.out.println(list.get(n));
		}
	}
}