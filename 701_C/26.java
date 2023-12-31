import java.util.*;

public class Q3a {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		String s = in.nextLine();

		HashMap<Integer, Integer> seen = new HashMap<>();

		for (int i = 0; i < n; i++) {
			Character c = s.charAt(i);
			int ci = (int) c.charValue();
			// System.out.println(ci);
			seen.put(ci, seen.get(ci) == null ? 1 : seen.get(ci) + 1);
		}

		HashMap<Integer, Integer> sub = new HashMap<Integer, Integer>();
		int start = 0;
		int min = 10000000;
		for (int i = 0; i < n; i++) {
			Character c = s.charAt(i);
			int ci = (int) c.charValue();

			sub.put(ci, sub.get(ci) == null ? 1 : sub.get(ci) + 1);
			
			while(sub.size() == seen.size()) {
				min = Math.min(min, i - start + 1);
				c = s.charAt(start);
				start ++;
				ci = (int) c.charValue();
				if( sub.get(ci) == 1) 
					sub.remove(ci);
				else
					sub.put(ci, sub.get(ci) - 1);
			}
		}

		System.out.print(min);

		// System.out.println( seen_all_at - begin + 1);

		in.close();
	}
}