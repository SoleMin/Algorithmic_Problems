import java.io.*;
import java.util.*;

public class AA {
	static class O implements Comparable<O> {
		int problems;
		int penalty;

		public O(int p, int pp) {
			problems = p;
			penalty = pp;
		}

		public int compareTo(O arg0) {
			if (problems == arg0.problems) {
				return penalty - arg0.penalty;
			}
			return -(problems - arg0.problems);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String s = r.readLine();
		String[] sp = s.split("[ ]+");
		int n = new Integer(sp[0]), k = new Integer(sp[1]) - 1;
		O[] arr = new O[n];
		for (int i = 0; i < arr.length; i++) {
			s = r.readLine();
			sp = s.split("[ ]+");
			arr[i] = new O(new Integer(sp[0]), new Integer(sp[1]));
		}
		Arrays.sort(arr);

		int res = 1;

		int i = k + 1;
		while (i < arr.length && arr[i].problems == arr[k].problems
				&& arr[i].penalty == arr[k].penalty) {
			i++;
			res++;
		}

		i = k - 1;
		while (i >= 0 && arr[i].problems == arr[k].problems
				&& arr[i].penalty == arr[k].penalty) {
			i--;
			res++;
		}
		System.out.println(res);

	}
}
