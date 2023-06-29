import java.util.Scanner;

public class R489C {
	static long MOD=(long)1e9+7;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		long n=scan.nextLong(), k=scan.nextLong();
		if(n==0) {
			System.out.println(0);
			return;
		}
		long x=2*n-1;
		long e=exp(2,k);
		System.out.println((x%MOD*e%MOD+1)%MOD);
	}
	public static long exp(long x, long e) {
		long res=1;     

		while (e>0)	{
			if(e%2==1) res=(res*x)%MOD;
			
			e/=2;
			x=(x*x)%MOD;
		}
		return res;
	}
}