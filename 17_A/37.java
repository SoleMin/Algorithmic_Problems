import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt()-1;
		PrimeGen p = new PrimeGen(n);
		List<Integer> prims = new ArrayList<Integer>();
		for(int i = 2; i <= n; i++){
			if(p.isPrime(i)>0){
				prims.add(i);
			}
		}
		int sum = 0;
		for(int i = 0; i < prims.size() - 1; i++){
			int c = prims.get(i) + prims.get(i+1) + 1;
			if(c <= n && p.isPrime(c)>0){
				sum ++;
			}
		}
		System.out.println(sum>=k?"YES":"NO");
	}

	static int sum(List<Integer> is) {
		int c = 0;
		for (int i : is)
			c += i;
		return c;
	}
	
	static class PrimeGen {
		public PrimeGen(int m) {
			m = (int) Math.sqrt(m);
			double max = 0;
			int r = 1;
			for (int i = 0; i < 4;) {
				max += r * m / Math.pow(Math.log1p(m), ++i);
				r *= i;
			}
			p = new int[(int) max];
			for (int i = 0, e = 2; i < p.length; i++) {
				for (; isPrime(e) < 1; e++)
					;
				p[i] = e++;
			}
			this.m = p[p.length - 1];
			this.m = this.m * this.m;
		}

		int isPrime(int n) {
			for (int e : p)
				if (e < 1)
					break;
				else if (n != e && n % e < 1)
					return 0;
			return 1;
		}

		int max() {
			return m;
		}

		int[] p;
		int m;
	}
}
