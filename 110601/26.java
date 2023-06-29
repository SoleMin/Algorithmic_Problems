import java.util.Scanner;
import java.math.BigInteger;
class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(true) {
			BigInteger a= sc.nextBigInteger();
			BigInteger b= sc.nextBigInteger();
			BigInteger zero= new BigInteger("0");
			
			if(a.compareTo(zero)==0 && b.compareTo(zero)==0) break;
			
			BigInteger n1= new BigInteger("0");
			BigInteger n2= new BigInteger("1");
			BigInteger n3= new BigInteger("0");
			int count=0;
			
			while(true) {
			n3= n1.add(n2);
			n1= n2;
			n2= n3;
			
			if(n3.compareTo(a)!=-1 && n3.compareTo(b)!=1) {
				count++;
			}
			else if(n3.compareTo(b)==1) 
				break;
			}
			System.out.println(count);
		}
	}
}