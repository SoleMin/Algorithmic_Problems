import java.util.*;

class Main {

	static boolean isMatch(char[][] grid, String word, int row, int col) {
		int rows = grid.length, cols = grid[0].length;
		
		int[] rowDir = { -1, 0, 1, -1, 1, -1, 0, 1 };
		int[] colDir = { -1, -1, -1, 0, 0, 1, 1, 1 };
		
		for (int i=0; i < 8; i++) {
			int x = row, y = col;
			String chunk = "";
			for (int j=0; j < word.length() && 0 <= x && x < rows && 0 <= y && y < cols; j++) {
				chunk += grid[x][y];
				x += rowDir[i];
				y += colDir[i];
			}
			if (word.equals(chunk)) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);

		int tc = Integer.parseInt(input.nextLine());
		input.nextLine();

		for (int i=0; i < tc; i++) {
			if (0 < i) System.out.println();
			
			int rows = input.nextInt();
			int cols = input.nextInt();
			input.nextLine();
		
			char[][] grid = new char[rows][cols];
			
			for (int j=0; j < rows; j++) {
				String line = input.nextLine().toLowerCase();
				for (int k=0; k < cols; k++) {
					grid[j][k] = line.charAt(k);
				}
			}
			
			int search = Integer.parseInt(input.nextLine());
			for (int j=0; j < search; j++) {
				String word = input.nextLine().toLowerCase();
				
				boolean matched = false;
				int row = 0, col = 0;
				
				for (row = 0; row < rows; row++) {
					for (col = 0; col < cols; col++) {
						if (grid[row][col] == word.charAt(0)) {
							if (isMatch(grid, word, row, col)) {
								matched = true;
								break;
							}
						}
					}
					if (matched) break;
				}
				System.out.println(String.format("%d %d", row+1, col+1));
			}
		}
		input.close();
	}
}