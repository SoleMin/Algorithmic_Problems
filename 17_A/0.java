import java.util.*;

public class NoldbachProblem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int desiredNum = scan.nextInt();
		boolean[] isPrime = new boolean[num+1];
		Arrays.fill(isPrime, true);
		for(int divisible = 2; divisible*divisible<=num;divisible++) {
			if(isPrime[divisible]==true) {
				for(int multiple=divisible*divisible;multiple<num;multiple+=divisible) {
					isPrime[multiple]=false;
				}
			}
		}
		ArrayList<Integer> prime = new ArrayList<>();
		for(int i = 2;i<isPrime.length;i++) {
			if(isPrime[i])prime.add(i);
		}
		//System.out.println(prime);
		int count=0;
		for(int i =1;i<prime.size()&&prime.get(i)<=num;i++) {
			//System.out.print(1+prime.get(i)+prime.get(i-1)+" ");
			if(prime.contains(1+prime.get(i)+prime.get(i-1)))count++;
		}

		System.out.println(count>=desiredNum?"YES":"NO");

	}

}
