import java.io.*;
import java.math.BigInteger;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			String[] str = reader.readLine().split(" ");
			BigInteger b1 = new BigInteger(str[0]);
			BigInteger b2 = new BigInteger(str[1]);

			if(b2.subtract(b1).compareTo(new BigInteger("1"))<1){
				System.out.println(-1);
				return;
			}

			if(b2.subtract(b1).compareTo(new BigInteger("2"))==0){
				BigInteger b = b1.add(new BigInteger("1"));
				BigInteger c = b1.add(new BigInteger("2"));

				if(!b1.gcd(c).equals(new BigInteger("1"))){
					System.out.println(b1.toString()+" "+b.toString()+" "+c.toString());
				}else{
					System.out.println(-1);
				}
				return;
			}

			BigInteger b = b1.add(new BigInteger("1"));
			BigInteger c = b1.add(new BigInteger("2"));
			BigInteger d = b1.add(new BigInteger("3"));

			if(b1.remainder(new BigInteger("2")).equals(new BigInteger("1"))){
				System.out.println(b.toString()+" "+c.toString()+" "+d.toString());
			}else{
				System.out.println(b1.toString()+" "+b.toString()+" "+c.toString());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
	 		 			     	   	 			       		