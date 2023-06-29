import java.util.*;
public class nolbach {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n =scan.nextInt();
		int k = scan.nextInt();
		boolean[] isPrime = new boolean[n + 1]; 
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for(int d = 2; d*d < isPrime.length; d++) {
			if(isPrime[d] == true) {
				for(int m = d*d; m < isPrime.length; m+=d) {
					isPrime[m] = false;
				}
			}
		}
		ArrayList<Integer> prime = new ArrayList<>();
		for(int i = 0; i < isPrime.length; i++) {
			if(isPrime[i] == true) {
				prime.add(i);
			}
		}
		int count = 0;
		for(int i = 2; i < prime.size(); i++) {
			if(prime.contains(prime.get(i - 2) + prime.get(i - 1) + 1)) {
				count++;
			}
		}
		if(count >= k) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

}
