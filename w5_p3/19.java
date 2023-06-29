import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Main {
	
	static List<Integer> next = new ArrayList<Integer>();
	static List<Integer> printLine = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		String T = sc.nextLine();
		String P = sc.nextLine();
		findNext(P);
		KMP(T, P);
		
		System.out.println(printLine.size());
		
		for (int j = 0; j < printLine.size(); j++) {
			System.out.printf("%d ", printLine.get(j));
		}
		
		System.out.println();
	}
	
	static void findNext(String P) {
		
		next.add(0, -1);
		int k = -1;
		int q = 1;
		while (q < P.length()) {
			while (k > -1 && P.charAt(k+1) != P.charAt(q)) {
				k = next.get(k);
			}
			if (P.charAt(k+1) == P.charAt(q)) k += 1;
			next.add(q, k);
			q++;
		}
	}
	
	static void KMP(String T, String P) {
		
		int q = -1, i = 0;
		while (i < T.length()) {
			while (q > -1 && P.charAt(q+1) != T.charAt(i)) {
				q = next.get(q);
			}
			if (P.charAt(q+1) == T.charAt(i)) {
				q += 1;
			}
			if (q == P.length() - 1) {
				printLine.add(i - P.length() + 2);
				q = next.get(q);
			}
			i++;
		}
	}
}