import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static BigInteger tow=new BigInteger("2"),mod=new BigInteger("1000000007");
	static BigInteger pow(BigInteger a,BigInteger b) {
		if(b.equals(BigInteger.ZERO))return BigInteger.ONE;
		BigInteger x=pow(a,b.divide(tow));
		if(b.mod(tow).equals(BigInteger.ZERO)) 
			return x.mod(mod).multiply(x.mod(mod)).mod(mod);
		else 
			return x.mod(mod).multiply(x.mod(mod)).mod(mod).multiply(a).mod(mod);
	}
	public static void main(String[] args) throws IOException {
		BigInteger x=in.RB(),k=in.RB();
		if(k.equals(BigInteger.ZERO))System.out.println(x.multiply(tow).mod(mod));
		else if(x.equals(BigInteger.ZERO))System.out.println(0);
		else {
			BigInteger x1=tow.multiply(x).subtract(BigInteger.ONE);
			x1=x1.mod(mod);
			BigInteger x2=pow(tow,k);
			x2=x2.mod(mod);
			System.out.println(x1.multiply(x2).add(BigInteger.ONE).mod(mod));
			
		}
	}
}


class in{
	static StringTokenizer st=new StringTokenizer("");
	static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	static String next() throws IOException {
		while(!st.hasMoreTokens())st=new StringTokenizer(bf.readLine());
		return st.nextToken();
	}
	static int RI() throws IOException {
		return Integer.parseInt(next());
	}
	static BigInteger RB() throws IOException {
		return new BigInteger(next());
	}
}