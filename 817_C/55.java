import java.util.Scanner;

public class C {
	
	public static void main(String[] args) {
		new C();
	}

	C() {
		
		Scanner in = new Scanner(System.in);
		
		long n = in.nextLong(), s = in.nextLong();
		long lo = 1, hi = 1000000000000000000L;
		
		while(lo<hi){
			//System.out.println(lo+" "+hi);
			//STUPID STUPID DUMB
			long mid = (lo+hi)/2;
			if(reallyBig(mid,s))
				hi = mid;
			else
				lo = mid+1;
		}
		
		//System.out.println(lo+" "+hi);
		if(!reallyBig(lo,s))
			System.out.println(0);
		else
			System.out.println(Math.max(n-lo+1,0));
			
		//System.out.println(reallyBig(100000000000000009L,100000000000000000L));

		in.close();

	}
	
	boolean reallyBig(long n, long s){
		int sum = 0;
		long temp = n;
		while(temp>0){
			sum += temp%10;
			temp/=10;
		}
		return n-sum>=s;
	}
	
}

/*

12 1

25 20

10 9

1000000000000000000 1000000000000000000

1000000000000000000 100000000000000000

 */









