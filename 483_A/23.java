import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class C {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer=  new StringTokenizer(br.readLine());
		BigInteger left = new BigInteger(tokenizer.nextToken());
		BigInteger right= new BigInteger(tokenizer.nextToken());
		BigInteger val= (right.subtract(left)).add(new BigInteger(""+1));
		if(val.intValue()<3){
			System.out.println(-1);
			return;
			
		}


		BigInteger a, b, c;
		BigInteger i=left;
		while(i.intValue()<=right.intValue()){
			BigInteger temp1=i;  //a
			BigInteger temp2= i.add(new BigInteger(""+1));//b
			BigInteger j=temp2.add(new BigInteger(""+1));
			while(j.intValue()<=right.intValue()){
				BigInteger b1= temp2;
				BigInteger b2 =j;
				BigInteger b3 = temp1;
				BigInteger gcd= b1.gcd(b2);
				if(gcd.intValue()==1){
					BigInteger gcd2 =b2.gcd(b3);
					if(gcd2.intValue() !=1){
						a=b3;
						b= b1;
						c= b2;
						System.out.print(a+" "+b+" "+c+" ");
						System.out.println();
						return ;
					}

				}

				j=j.add(new BigInteger(""+1));
			}
			i=i.add(new BigInteger(""+1));

		}
		System.out.println(-1);
	}

}
