//package codeforces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SameSumBlocksHard {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in .nextInt();

		long[] a = new long[n + 1];
		long[] sum = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			a[i] = in.nextInt();
			sum[i] = sum[i - 1] + a[i];
		}

		Map<Long, List<int[]>> map = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				long x = sum[j] - sum[i - 1];
				List<int[]> list = map.get(x);
				if (list == null) {
					list = new ArrayList<>();
					map.put(x, list);
				}
				list.add(new int[] {i, j});
			}
		}

		List<int[]> ans = new ArrayList<>();
		for (Map.Entry<Long, List<int[]>> entry : map.entrySet()) {
			List<int[]> list = entry.getValue();
			List<int[]> tmp = new ArrayList<>();
			calc(list, tmp);
			if (tmp.size() > ans.size()) {
				ans.clear();
				ans.addAll(tmp);
			}
		}

		System.out.println(ans.size());
		for (int[] pair : ans) {
			System.out.println(pair[0] + " " + pair[1]);
		}

		in.close();
	}

	static void calc(List<int[]> list, List<int[]> tmp) {
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] < o2[1]) {
					return -1;
				} else if (o1[1] > o2[1]) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		int last = -1;
		for (int[] p : list) {
			if (last == -1) {
				last = p[1];
				tmp.add(p);
			} else if (p[0] > last) {
				last = p[1];
				tmp.add(p);
			}
		}
	}
}
