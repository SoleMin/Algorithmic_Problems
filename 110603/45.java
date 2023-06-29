import java.io.*;
import java.math.BigInteger;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger[] memo = new BigInteger[1001];
		memo[1] = new BigInteger("2");
		memo[2] = new BigInteger("5");
		memo[3] = new BigInteger("13");
		for(int i=4; i<1001; i++){
			memo[i] = memo[i-1].multiply(new BigInteger("2")).add(memo[i-2]).add(memo[i-3]);
		}
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		
		while(s!=null){
			int n = Integer.parseInt(s);
			sb.append(memo[n]).append('\n');
			
			s = br.readLine();
		}
		
		System.out.println(sb);
		
		
		
		
	}
}