import java.io.*;
import java.util.*;
import java.math.*;

class Main {
	public static void main(String[] args) throws Exception {
		ArrayList<BigInteger> fibo = new ArrayList<BigInteger>();
		
		Scanner scanner = new Scanner(System.in);
		BigInteger f1 = new BigInteger("1");
		BigInteger f2 = new BigInteger("2");
		
		BigInteger stand = new BigInteger("10");
		BigInteger last = stand.pow(100);
		BigInteger zero = new BigInteger("0");
		
		fibo.add(f1);
		fibo.add(f2);
		
		while(true){
			int n = fibo.size();
			BigInteger tmp = fibo.get(n-1).add(fibo.get(n-2));
			if(tmp.compareTo(last)>0)
				break;
			fibo.add(tmp);
		}
		
		
		while(scanner.hasNextBigInteger()){
			BigInteger start = scanner.nextBigInteger();
			BigInteger end = scanner.nextBigInteger();	
		
			if(start.compareTo(zero)==0 & end.compareTo(zero)==0)
				break;
			
			int count=0;
			for(BigInteger com : fibo){
				if(com.compareTo(end)>0)
					break;
				if(com.compareTo(start)>=0 ){
					count+=1;
				}				
			}
			

			System.out.println(count);
		}
		
	}
	
}