import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] agrs) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();
		KMP(S, P);
	}

	public static void KMP(String s, String p) {
		ArrayList<Integer> result = new ArrayList<>();
		int[] next = getNext(p);
		int j = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			while (j > 0 && s.charAt(i) != p.charAt(j))
				j = next[j - 1];
			if (s.charAt(i) == p.charAt(j)) {
				if (j == p.length() - 1) {
					result.add(i - p.length() + 1);
					count++;
					j = next[j];
				} else {
					j++;
				}
			}
		}
		System.out.println(count);
		for(int i =0; i<result.size(); i++) {
			System.out.print(result.get(i)+1);
			if(i!=result.size()-1)
				System.out.print(" ");
		}
	}

	public static int[] getNext(String P) {
		int j = 0;
		int[] next = new int[P.length()];
		for (int i = 1; i < next.length; i++) {
			while (j > 0 && P.charAt(i) != P.charAt(j))
				j = next[j - 1];
			if (P.charAt(i) == P.charAt(j))
				next[i] = ++j;
		}
		return next;
	}
}