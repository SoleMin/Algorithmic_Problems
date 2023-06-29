import java.io.*;
import java.util.*;

class Main {
	static Map<Character, Integer> suit_map;
	static Map<Character, Integer> rank_map;
	
	static {
		suit_map = new HashMap<>();
		rank_map = new HashMap<>();
		char[] suit = { 'C', 'D', 'H', 'S' };
		char[] rank = { 'T', 'J', 'Q', 'K', 'A' };
		for (int i = 0; i < 4; i++) {
			suit_map.put(suit[i], i);
		}
		for (int i = 2; i < 10; i++) {
			rank_map.put((char)(i + 48), i);
		}
		for (int i = 0; i < 5; i++) {
			rank_map.put(rank[i], i + 10);
		}
	}
	
	static class Pair implements Comparable<Pair> {
		int x, y;
		
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Pair p) {
			return x == p.x ? p.y - y : p.x - x;
		}
	}
	
	public static int eval(String card) {
		return 15 * suit_map.get(card.charAt(1)) + rank_map.get(card.charAt(0));
	}
	
	public static int eval(int[] card) {
		int[] suit_f = new int[4];
		int[] rank_f = new int[15];
		for (int i = 0; i < 5; i++) {
			suit_f[card[i] / 15]++;
			rank_f[card[i] % 15]++;
		}
		List<Pair> p_list = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			if (rank_f[i] > 0) {
				p_list.add(new Pair(rank_f[i], i));
			}
		}
		Collections.sort(p_list);
		boolean flush = false;
		for (int i = 0; i < 4; i++) {
			flush |= suit_f[i] == 5;
		}
		boolean straight;
		if (straight = p_list.size() == 5) {
			for (int i = 1; i < 5; i++) {
				straight &= p_list.get(i - 1).y - p_list.get(i).y == 1;
			}
		}
		Pair p_zero = p_list.get(0);
		Pair p_one = p_list.get(1);
		int ret = 0;
		for (Pair p : p_list) {
			ret = 15 * ret + p.y;
		}
		if (straight && flush) {
			return 800000000 + p_zero.y;
		} else if (p_zero.x == 4) {
			return 700000000 + p_zero.y;
		} else if (p_zero.x == 3 && p_one.x == 2) {
			return 600000000 + p_zero.y;
		} else if (flush) {
			return 500000000 + ret;
		} else if (straight) {
			return 400000000 + p_zero.y;
		} else if (p_zero.x == 3) {
			return 300000000 + p_zero.y;
		} else if (p_zero.x == 2 && p_one.x == 2) {
			return 200000000 + ret;
		} else if (p_zero.x == 2) {
			return 100000000 + ret;
		} else {
			return ret;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			StringTokenizer st = new StringTokenizer(line);
			int[] A = new int[5];
			int[] B = new int[5];
			for (int i = 0; i < 5; i++) {
				A[i] = eval(st.nextToken());
			}
			for (int i = 0; i < 5; i++) {
				B[i] = eval(st.nextToken());
			}
			Arrays.sort(A);
			Arrays.sort(B);
			int A_eval = eval(A);
			int B_eval = eval(B);
			out.append(A_eval > B_eval ? "Black wins.\n" : A_eval < B_eval ? "White wins.\n" : "Tie.\n");
		}
		
		System.out.print(out);
		br.close();
	}
}