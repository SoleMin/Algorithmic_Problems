
import java.util.Scanner;

public class maxstack {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		long m=sc.nextLong();
		long c=0;
		if(m<=n) {
			c=(m-1)/2;
		}
		else
			c=n-m/2;
		System.out.println(c<0?0:c);
	}

}
