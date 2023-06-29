import java.io.*;
import java.util.*;
import java.math.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger exp = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		BigInteger[] num = new BigInteger[10001];
		
		num[0] = BigInteger.ZERO;
		int count = 1;
		int e = 0;
		for(int i=1; i<=10000;){
			for(int j=count; i<=10000 && j>0; i++, j--){
				num[i]=num[i-1].add(exp);
			}
			count++;
			e++;
			exp=two.pow(e);
		}
		String input = br.readLine();
		while(input!=null){
			System.out.println(num[Integer.parseInt(input)].toString());
			input = br.readLine();
		}
	}
}