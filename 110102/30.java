import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		int cnt = 1;
		while ((input = br.readLine()) != null) {
			String[] num = input.split(" ");
			int m = Integer.parseInt(num[0]);
			int n = Integer.parseInt(num[1]);
			
			if (m == 0 && n == 0) {
				break;
			} else {
				char[][] chara = new char[m][n];
				for (int i = 0; i < m; i++) {
					chara[i] = br.readLine().toCharArray();
				}
				int[][] arr = new int[m][n];
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						if (chara[i][j] == '*') {
							add(arr, i, j);
						}
					}
				}
				System.out.println("Field #" + cnt++ + ":");
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						if (chara[i][j] == '*') {
							System.out.print(chara[i][j]);
						} else {
							System.out.print(arr[i][j]);
						}
					}
					System.out.println();
				}
				System.out.println();
			}
		}
	}
	
	static void add(int[][] arr, int m, int n) {
		for (int i = m - 1; i <= m + 1; i++) {
			for (int j = n - 1; j <= n + 1; j++) {
				try {
					arr[i][j]++;
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}
	}
}