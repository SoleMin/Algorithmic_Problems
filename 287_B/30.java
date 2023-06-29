import java.util.Scanner;


public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pipes pipes = new Pipes();
		pipes.solve();
		pipes.print();
	}

}

class Pipes {
	
	Pipes() {
		Scanner scr = new Scanner(System.in);
		n = scr.nextLong();
		k = scr.nextLong();
	}
	
	long bs(long nb, long nk) {
		
		long left = 2;
		long ls = (nk - left + 1) * (nk + left) / 2 - (nk - left);
		long right = nk;
		long rs = nk;
		
		if (nb > ls) {
			return -1;
		}
				
		long mid = left;
		
		while (rs < ls){
			mid = (left + right)/2;
			long ms = (nk - mid + 1) * (nk + mid) / 2 - (nk - mid);
			if (nb > ms) {
				right = mid;
				rs = ms;
			}
			else if (nb < ms){
				left = mid+1;
				ls = (nk - left + 1) * (nk + left) / 2 - (nk - left);
			}
			else {
				left = mid;
				break;
			} 
			
		}
		
		return left;
		
	}
	
	void solve() {
		long nn = n;
		long kk = k; 
		ans = 0;
		long ps = 1;
		long add;
		
		if (n == 1) {
			ans = 0;
			return;
		}
		
		nn = n - (ps - 1);
		while (nn > kk){
			add = bs(nn, kk);
			if (add == -1) {
				ans = -1;
				return;
			}
			else {
				ans = ans + (kk - add + 1);
			}
						
			long addn = (kk - add + 1) * (kk + add) / 2 - (kk - add); 
			ps = ps - 1 + addn;
			if (ps == n)
				return;
			nn = nn - (ps - 1);
			kk = add - 1;
		}
		
		if (nn > 0) {
			ans++;
		}
		
	}
	
	
	void print() {
		System.out.println(ans);
	}
	
	long ans;
	long n;
	long k;
}
