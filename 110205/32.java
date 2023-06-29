import java.io.*;
import java.util.Arrays;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		br.readLine();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] cds = new int[52];
			for (int j = 0; j < 52; j++) {
				cds[j] = j + 1;
			}
			int[][] sfl = new int[n][52];
			for (int j = 0; j < n; j++) {
				sfl[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();	
			}
			String m;
			while ((m = br.readLine()) != null && !m.equals("")) {
				int ind = Integer.parseInt(m) - 1;
				int[] tmp = new int[52];
				for (int j = 0; j < sfl[0].length; j++) {
					tmp[j] = cds[sfl[ind][j]-1];
				}
				cds = tmp;
			}
			String[] shapes = new String[]{"Clubs", "Diamonds","Hearts", "Spades"};
			String[] nums = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
			for (int j: cds) {
				System.out.println(nums[(j-1) % 13] + " of " + shapes[(j-1) / 13] + " ");
			}
			System.out.println();
		}
	}
}