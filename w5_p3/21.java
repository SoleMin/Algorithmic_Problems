import java.util.*;
class Main {
	
	static int[] NEXT;
	static String T, P;
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		T = input.nextLine();
		P = input.nextLine();
		
		N = T.length();
		M = P.length();
		
		NEXT = new int[M+1];
		stringMatcher();
	}
	
	static void stringMatcher() {
		List<Integer> nums = new ArrayList<Integer>();
		int i = 1, q = 0, isM = 0;
		next();
		
		while(i <= N) {
			while(q > 0 && P.charAt(q) != T.charAt(i-1))
				q = NEXT[q];
			
			if(P.charAt(q) == T.charAt(i-1))
				q += 1;
			
			if(q == M){
				isM++;
				nums.add(i+1-M);
				q = NEXT[q];
			}
			i++;
		}
		
		System.out.println(isM);
		for(i = 0; i < nums.size()-1; i++)
			System.out.print(nums.get(i) + " ");
		System.out.print(nums.get(i));
	}
	
	static void next() {
		int k = 0, q = 2;
		NEXT[1] = 0;
		
		while(q <= M){
			while(k > 0 && P.charAt(k) != P.charAt(q-1))
				k = NEXT[k];
			if(P.charAt(k) == P.charAt(q-1))
				k += 1;
			NEXT[q] = k;
			q++;
		}
	}
}