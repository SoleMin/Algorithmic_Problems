import java.util.*;

public class Beta17PA {

	boolean[] isPrime = new boolean[1001];
	int[] prime = new int[200];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Beta17PA().solve();
	}

	public void solve() {
		Scanner scan = new Scanner(System.in);
		int n, k;
		n = scan.nextInt();
		k = scan.nextInt();
		init();
		int m = 0;
		for(int i=2; i<=n; i++) {
			if(check(i)) m ++;
		}
		if(m>=k) System.out.println("YES");
		else System.out.println("NO");
	}

	private boolean check(int n) {
		if(n<6||!isPrime[n]) return false;
		int d = n-1;
		for(int i=0; i<199&&prime[i]+prime[i+1]<=d; i++) {
			if(prime[i]+prime[i+1]==d) return true;
		}
		return false;
	}

	private void init() {
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for(int i=2; i<1001; i++) {
			if(!isPrime[i]) continue;
			for(int j=i+i; j<1001; j+=i) {
				isPrime[j] = false;
			}
		}
		int count = 0;
		for(int i=2; i<1001; i++) {
			if(isPrime[i]) prime[count++] = i;
		}
	}
}
