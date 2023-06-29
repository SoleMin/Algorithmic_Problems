import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	static List<List<Integer>> getLayers(int[] numbers, int a, int b) {
		boolean[] used = new boolean[numbers.length];
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			hs.add(numbers[i]);
		}
		HashMap<Integer, Integer> numberToIndex = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			numberToIndex.put(numbers[i], i);
		}

		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		for (int i = 0; i < numbers.length; i++) {
			if (!used[i]) {

				List<Integer> ansRow = new ArrayList<Integer>();
				LinkedList<Integer> current = new LinkedList<Integer>();
				current.add(numbers[i]);
				while (!current.isEmpty()) {
					int c = current.removeFirst();
					used[numberToIndex.get(c)] = true;

					boolean found = false;

					if (hs.contains(a - c)) {
						found = true;
						if (a - c != c)
							current.add(a - c);
					}

					if (hs.contains(b - c)) {
						found = true;
						if (b - c != c)
							current.add(b - c);
					}

					if (found || ansRow.size() > 0)
						ansRow.add(c);

					hs.remove(c);
				}

				ans.add(ansRow);
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();

		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}

		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			hs.add(numbers[i]);
		}

		int[] belongs = new int[n];
		for (int i = 0; i < belongs.length; i++) {
			belongs[i] = -1;
		}

		HashMap<Integer, Integer> numberToIndex = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			numberToIndex.put(numbers[i], i);
		}

		boolean possible = true;

		List<List<Integer>> layers = getLayers(numbers, a, b);
		for (List<Integer> layer : layers) {

			if (layer.size() == 0) {
				System.out.println("NO");
				return;
			}

			int starting = -1;
			for (int j = 0; j < layer.size(); j++) {
				int cur = layer.get(j);

				int nei = 0;
				if (hs.contains(a - cur)) {
					nei++;
				}

				if (hs.contains(b - cur)) {
					nei++;
				}

				if (nei == 1 || (a == b && nei == 2)) {
					starting = j;
				}
			}

			if (starting == -1)
				throw new Error();

			int c = layer.get(starting);
			HashSet<Integer> layerset = new HashSet<Integer>(layer);
			while (true) {

				if (layerset.contains(c) && layerset.contains(a - c)) {
					belongs[numberToIndex.get(c)] = 0;
					belongs[numberToIndex.get(a - c)] = 0;
					layerset.remove(c);
					layerset.remove(a - c);
					c = b - (a - c);
				} else if (layerset.contains(c) && layerset.contains(b - c)) {
					belongs[numberToIndex.get(c)] = 1;
					belongs[numberToIndex.get(b - c)] = 1;
					layerset.remove(c);
					layerset.remove(b - c);
					c = a - (b - c);
				} else {
					break;
				}

			}
		}

		printResult(belongs);

	}

	static void printResult(int[] belongs) {

		boolean ok = true;
		for (int i = 0; i < belongs.length; i++) {
			if (belongs[i] < 0)
				ok = false;
		}

		if (ok) {
			System.out.println("YES");
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < belongs.length; i++) {
				sb.append(belongs[i]);
				if (i != belongs.length - 1)
					sb.append(" ");
			}

			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	}

}