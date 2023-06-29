import java.util.*;
import java.io.*;

class Elephant implements Comparable<Elephant> {
	int w;
	int iq;
	int number;

	public Elephant(int w, int iq, int number) {
		this.w = w;
		this.iq = iq;
		this.number = number;
	}

	public int compareTo(Elephant o) {
		if (this.w == o.w) {
			if (this.iq == o.iq)
				return o.number - this.number;
			return o.iq - this.iq;
		}
		return this.w - o.w;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Elephant> list = new ArrayList<>();
		Deque<Integer> result = new ArrayDeque<>();
		String line;
		int number = 0;
		while ((line = br.readLine()) != null && line.length() > 0) {
			list.add(
					new Elephant(Integer.parseInt(line.split(" ")[0]), Integer.parseInt(line.split(" ")[1]), ++number));
		}
		Collections.sort(list);
		int[] dp = new int[list.size()];
		Arrays.fill(dp, 1);
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Math.max(1, dp[i]);
			for (int j = 0; j < i; j++) {
				if (list.get(i).iq < list.get(j).iq && list.get(i).w > list.get(j).w) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
		for (int i = 0; i < dp.length; i++)
			if (max < dp[i])
				max = dp[i];
		sb.append(max + "\n");
		int IQ = 0;
		for (int i = dp.length - 1; i >= 0 && max > 0; i--) {
			if (dp[i] == max && (IQ < list.get(i).iq)) {
				for (int j = i; j >= 0; j--)
					if (dp[j] == max && list.get(j).number < list.get(i).number && IQ < list.get(j).iq)
						i = j;
				max--;
				IQ = list.get(i).iq;
				result.push(list.get(i).number);
			}
		}
		while (!result.isEmpty())
			sb.append(result.pop() + "\n");
		System.out.print(sb);
	}
}