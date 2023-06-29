import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()){
			System.out.println(countNum(scan.nextInt()));
		}
	}
	static BigInteger countNum(int num){
		BigInteger[] hanoi = new BigInteger[100001];
		BigInteger multi = new BigInteger("1");
		hanoi[0] = BigInteger.ZERO;
		int i = 1; 
		int cnt = 1;
		while(i <= 10000){
			for(int j = cnt; j >0 && i <= 10000; j--){
				hanoi[i] = hanoi[i-1].add(multi);
				i++;
			}
			cnt++;
			multi = multi.multiply(BigInteger.TWO);
		}
		return hanoi[num];
	}
}