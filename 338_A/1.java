import java.math.BigInteger;
import java.util.Scanner;


public class C {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long s=0,mod=1000000009;
		int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt(),c=n/k;
		if(m<=c*(k-1)+(n%k))System.out.println(m);
		else {
			int a=m-c*(k-1)-(n%k);
			long l=0,pase=0;
			//System.out.println(a);
			long pot=BigInteger.valueOf(2).modPow(BigInteger.valueOf(a), BigInteger.valueOf(mod)).longValue();
			pot=(2*(pot-1))%mod;
			/*System.out.println(pot);
			System.out.println(k);*/
			System.out.println(((pot*k)%mod+(m-a*k))%mod);
		}
	}
}
