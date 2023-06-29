import java.io.*;
import java.math.*;
import java.util.*;
class Main {
	static final int MAX = 1000;
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		BigInteger[] c = new BigInteger[MAX];
		c[0] = new BigInteger("0");
		c[1] = new BigInteger("2");
		c[2] = new BigInteger("5");
		c[3] = new BigInteger("13");
		for(int i = 4; i < MAX; i++){
			c[i]= c[i-1].add(c[i-1]);
			c[i]= c[i].add(c[i-2]);
			c[i]= c[i].add(c[i-3]);
		}
		while(input.hasNext()){
			int n = input.nextInt();
			System.out.println(c[n]);
		}
	}
}