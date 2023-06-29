import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P1141F {

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[][] b = new int[n][n];
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			a[i] = Integer.parseInt(st.nextToken());
			
			int r = i;
			b[r][r] = a[r];
			if (!map.containsKey(b[r][r]))
				map.put(b[r][r], new ArrayList<Integer>());
			for(int l = 0; l < r; ++l) {
				b[l][r] = b[l][r-1] + a[r];
				if (!map.containsKey(b[l][r]))
					map.put(b[l][r], new ArrayList<Integer>());
			}
		}

		
		for(int r = 0; r < n; ++r) {
			for(int l = 0; l <= r; ++l) {
				int sum = b[l][r];
				ArrayList<Integer> intervals = map.get(sum);
				int last_r = -1;
				if(!intervals.isEmpty())
					last_r = intervals.get(intervals.size()-1);
				
				if(l > last_r) {
					intervals.add(l);
					intervals.add(r);
				}
				
			}
		}
		
		//int best_sum = -1;
		ArrayList<Integer> best_intervals = new ArrayList<Integer>();
		
		for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			//int sum = entry.getKey();
			ArrayList<Integer> intervals = entry.getValue();
			
			if(intervals.size() > best_intervals.size()) {
				best_intervals = intervals;
			}
		}
		
		bw.write(best_intervals.size()/2 + "\n");
		for(int i = 0; i < best_intervals.size(); i += 2) {
			bw.write((best_intervals.get(i)+1) + " " + (best_intervals.get(i+1)+1) + "\n");
		}


		br.close();
		bw.close();
	}
}