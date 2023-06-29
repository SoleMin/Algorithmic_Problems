import java.util.*;
import java.io.*;

class Turtle implements Comparable<Turtle> {
	int w;
	int s;

	public Turtle(int w, int s) {
		this.w = w;
		this.s = s;
	}

	public int compareTo(Turtle o) {
		if (this.s == o.s)
			return this.w - o.w;
		return this.s - o.s;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Turtle> list = new ArrayList<>();
		String line;
		while ((line = br.readLine()) != null && line.length() > 0)
			list.add(new Turtle(Integer.parseInt(line.split(" ")[0]), Integer.parseInt(line.split(" ")[1])));
		Collections.sort(list);
		int n = list.size();
		int max = 0;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, 100000000);
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			int weightI = list.get(i).w;
			int strengthI = list.get(i).s;
			for (int j = n - 1 ; j >= 0; j--) {
				if (dp[j] + weightI <= strengthI) {
					dp[j + 1] = Math.min(dp[j + 1], weightI + dp[j]);
				}
			}
		}
		for(int i = 0; i<dp.length; i++)
			if (dp[i] < 100000000)
				max = i;
		System.out.println(max);
	}
}