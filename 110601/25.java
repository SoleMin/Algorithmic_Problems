import java.util.*;
import java.math.BigInteger;

class Main {
	public static void main(String[] args)  {
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		
		while(flag){
			
			BigInteger first = input.nextBigInteger();
			BigInteger end = input.nextBigInteger();
			BigInteger zero = new BigInteger("0");
			
			if(first.compareTo(zero) == 0 && end.compareTo(zero) == 0)
				break;
			
			BigInteger n = new BigInteger("1");
			BigInteger n1 = new BigInteger("1");
			BigInteger n2 = new BigInteger("1");
			BigInteger n3 = new BigInteger("0");
			
			int cnt = 0;
			
			boolean flag2 = true;
			
			while(flag2){
				
				if(n3.compareTo(first) != -1 && n3.compareTo(end) != 1)
					cnt++;
				else if(n3.compareTo(end) == 1)
					break;
				
				n3 = n1.add(n2);
				n1 = n2;
				n2 = n3;
			}
			
			if(first.compareTo(n)==0)
				cnt++;
			
			System.out.println(cnt);
			
		}
	}
}

