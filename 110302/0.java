import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0){
			br.readLine();
			String line = br.readLine();
			int m = Integer.parseInt(line.split(" ")[0]);
			int n = Integer.parseInt(line.split(" ")[1]);
			char[][] grid = new char[m][n];
			for (int i = 0; i < m; i++){
				line = br.readLine().toUpperCase();
				grid[i] = line.toCharArray();
			}
			int k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++){
				line = br.readLine().toUpperCase();
				searchWord(grid, line);
				}
			System.out.println();
		}
	}
	public static void searchWord(char[][] grid, String word) {
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1};
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1};
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++)
				for (int k = 0; k < dr.length; k++){
					int row = i;
					int col = j;
					boolean match = true;
					for (int l = 0; l < word.length(); l++) {
						if (row < 0 || col < 0 || row >= grid.length || col >= grid[i].length || word.charAt(l) != grid[row][col]) {
							match = false;
							break;
						}
						row += dr[k];
						col += dc[k];
					}
					if (match){
						System.out.println((i + 1) + " " + (j + 1));
						return;
					}
				}
	}
}