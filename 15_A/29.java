import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProblemA {
	
	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		String[] line = s.readLine().split(" ");
		int n = Integer.valueOf(line[0]);
		int ht = Integer.valueOf(line[1]);
		
		int[][] house = new int[n][2];
		Set<Integer> candidates = new HashSet<Integer>(); 
		for (int i = 0 ; i < n ; i++) {
			String[] data = s.readLine().split(" ");
			house[i][0] = Integer.valueOf(data[0]) * 2;
			house[i][1] = Integer.valueOf(data[1]);
			candidates.add(house[i][0] - house[i][1] - ht);
			candidates.add(house[i][0] + house[i][1] + ht);
		}
		
		int ans = 0;
		for (int p : candidates) {
			int f = p - ht;
			int t = p + ht;
			boolean isok = true;
			for (int i = 0 ; i < n ; i++) {
				if (house[i][0] + house[i][1] <= f) {
				} else if (house[i][0] - house[i][1] >= t) {
				} else {
					isok = false;
					break;
				}
			}
			if (isok) {
				ans++;
			}
		}
		
		
		out.println(ans);
		out.flush();
	}


	public static void debug(Object... os){
		System.err.println(Arrays.deepToString(os));
	}
}