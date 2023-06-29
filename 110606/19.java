import java.io.*;
import java.math.BigInteger;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		memo_hanoi4[1] = new BigInteger("1");
		memo_hanoi[1] = new BigInteger("1");
		
		BigInteger result = new BigInteger("4");
		for(int i=2; i<10000; i++){
			memo_hanoi[i] = result.subtract(new BigInteger("1"));
			result = result.multiply(new BigInteger("2"));
		}
		
		StringBuilder sb = new StringBuilder();
		while(s!=null){
			sb.append(hanoi4(Integer.parseInt(s))).append('\n');
			s = br.readLine();
		}
		System.out.println(sb);
		
		
		
		
		
	}
	static BigInteger[] memo_hanoi4 = new BigInteger[10000];
	static BigInteger[] memo_hanoi = new BigInteger[10000];
	
	
	public static BigInteger hanoi4(int n){
		if(n==0) return new BigInteger("0");
		if(memo_hanoi4[n]!=null) return memo_hanoi4[n];
		BigInteger min = hanoi4(1).multiply(new BigInteger("2")).add(memo_hanoi[n-1]);
		for(int k=2; k<n; k++){
			BigInteger tmp = hanoi4(k).multiply(new BigInteger("2")).add(memo_hanoi[n-k]);
			if(min.compareTo(tmp)>0){
				min = tmp;
			}
		}
		memo_hanoi4[n] = min;
		return min;
		
		
	}
	
	
	
	
	
	
	
}