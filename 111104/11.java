import java.util.*;
class Main {
	
	static class Pair implements Comparable<Pair> {
		int w, s;
		public Pair(int w, int s) {
			this.w = w;
			this.s = s;
		}
		public int compareTo(Pair o) {
			return (this.s != o.s) ? this.s - o.s : this.w - o.w;
		}
	}
	
	static String solution(List<Pair> list) {
		Collections.sort(list);
		
		int MAX_VALUE = (int)1e9;
		int size = list.size();
		int[][] matrix = new int[size][2];
		for (int i=0; i < size; i++) {
			Pair p = list.get(i);
			matrix[i][0] = p.w;
			matrix[i][1] = p.s;
		}
		
		int[] dp = new int[size+1];
		Arrays.fill(dp,MAX_VALUE);
		dp[0] = 0;
		for(int i=0; i < size; i++) {
			for (int j=size; j >= 0; j--) {
				if (dp[j]+matrix[i][0] <= matrix[i][1]) {
					dp[j+1] = Math.min(dp[j+1], matrix[i][0] + dp[j]);
				}
			}
		}
		
		int max = 0;
		for(int i=0; i < dp.length; i++) {
			if (dp[i] < MAX_VALUE) max = i;	
		}
		
		return String.valueOf(max);
	}
	
	static void print(String result) {
		System.out.println(result);	
	}
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);

		ArrayList<Pair> list = new ArrayList<>();
		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (line == null || line.length() == 0) break;
			String[] values = line.split(" ");
			Pair pair = new Pair(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
			list.add(pair);
		}
		print(solution(list));
		input.close();
	}
}