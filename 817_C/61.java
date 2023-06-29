import java.util.Scanner;

public class ReallyBigNumbers {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long s  = sc.nextLong();
		
		long m = s;
		
		while(m-digitAdd(m)<s && m<=n){
			m++;
		}
		System.out.println(Math.max(n-m+1, 0));
	}
	
	private static int digitAdd(long s){
		int sum = 0;
		
		for(long i = 0,j=1L;i<(int)Math.log10(s)+1; i++,j*=10){
			sum += (s/j)%10;
		}
		
		return sum;
	}

}
