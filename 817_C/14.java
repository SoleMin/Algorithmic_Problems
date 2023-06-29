import java.util.Scanner;

public class CodeforcesC {

	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		long n = ob.nextLong();
		long s = ob.nextLong();
		long l = 1;
		long r = n;
		while(l<=r){
			long mid = (l + r)/2;
			if(reallybignumber(mid,s)){
				r = mid-1;
			}else{
				l = mid +1;
			}
		}
		/******long l1 = l;
		***while(l1<=n) {
			System.out.print(l1 + " ");
			l1++;
		}*/////////
		System.out.println(n-l+1);

	}

	private static boolean reallybignumber(long n,long s) {
		long m = n;
		long sum=0;
		int d=1;
		while(m>0){
			long rem = m % 10;
			sum =   rem * d + sum;
			m = m / 10;
		}
		if(n-sum >= s) return true;
		else return false;
	}

}