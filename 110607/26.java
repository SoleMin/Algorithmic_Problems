import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BigInteger num;
		while(scan.hasNextInt()){
			num = scan.nextBigInteger();
			if(num.equals(BigInteger.ZERO)) break;
			System.out.println(countNum(num));
		}
	}
	static int countNum(BigInteger num){
		BigInteger[] G = new BigInteger[700000];
		int sum = 0;
		int i;
		G[0] = BigInteger.ONE;
		G[1] = BigInteger.valueOf(2);
		G[2] = BigInteger.valueOf(2);
		if(num.equals(BigInteger.ONE)){
			return 1;
		} else if(num.equals(BigInteger.valueOf(3))){
			return 2;
		} else {
			for(i = 2; i < 700000; i++){
				G[i] = G[i - intValue(G[intValue(G[i-1])])];
				G[i] = G[i].add(BigInteger.ONE);
				sum += intValue(G[i]);
				if(sum >= intValue(num)) break;
			}
			return i;
		}
	}
	private static int intValue(BigInteger bigInteger){
		int int_bigNum = bigInteger.intValue();
		return int_bigNum;
	}
}