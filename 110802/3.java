import java.io.*;

public class Main {
	private static final int LIMIT = 50;
	private static int MAXDEPTH;
	private static int[][] move = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	private static char[] direction = { 'U', 'R', 'D', 'L' };
	private static boolean solved;
	private static int[][] puzzle = new int[4][4];
	private static int top;
	private static int[] stack = new int[LIMIT];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		String[] numbers;
		while (t-- > 0) {
			solved = false;
			top = 0;
			for (int i = 0; i < 4; i++) {
				numbers = br.readLine().split(" ");
				for (int j = 0; j < 4; j++)
					puzzle[i][j] = Integer.parseInt(numbers[j]);
			}
			solve();
			if (solved) {
				for (int i = 0; i < top; i++)
					System.out.print(direction[stack[i]]);
				System.out.println();
			} else
				System.out.println("This puzzle is not solvable.");
		}

	}

	private static int cost() {
		int cost1 = 0;
		int cost2 = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (puzzle[i][j] != 0)
					cost1 += Math.abs(i - ((puzzle[i][j] - 1) / 4));
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (puzzle[i][j] != 0)
					cost2 += Math.abs(j - ((puzzle[i][j] - 1) % 4));
			}
		}
		return cost1 + cost2;
	}

	public static void solve() {
		int value = 0;
		int row = 0, col = 0, l;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (puzzle[i][j] == 0) {
					value += i;
					row = i;
					col = j;
				}
				for (int k = i; k < 4; k++) {
					if (k == i)
						l = j + 1;
					else
						l = 0;
					for (; l < 4; l++) {
						if (puzzle[k][l] != 0 && puzzle[i][j] > puzzle[k][l])
							value++;
					}
				}
			}
		}
		if (value % 2 == 0)
			return;
		for (MAXDEPTH = cost(); !solved && MAXDEPTH <= LIMIT; MAXDEPTH += 2)
			backTrack(0, row, col);
	}

	public static void backTrack(int a, int currRow, int currCol) {
		int i, c;
		int nextRow = 0, nextCol = 0;
		c = cost();
		if (c == 0) {
			solved = true;
			return;
		}
		if (a + c > MAXDEPTH)
			return;

		for (i = 0; i < 4; i++) {
			nextRow = currRow + move[i][0];
			nextCol = currCol + move[i][1];
			if (top > 0 && (stack[top - 1] + 2) % 4 == i || nextRow < 0 || nextRow >= 4 || nextCol < 0 || nextCol >= 4)
				continue;
			swap(currRow, currCol, nextRow, nextCol);
			stack[top++] = i;
			backTrack(a + 1, nextRow, nextCol);
			if (solved)
				return;
			top--;
			swap(currRow, currCol, nextRow, nextCol);
		}

	}

	private static void swap(int i, int j, int i2, int j2) {
		int temp = puzzle[i][j];
		puzzle[i][j] = puzzle[i2][j2];
		puzzle[i2][j2] = temp;
	}
}