import java.io.*;

public class Main {
	public static int[][] remainto = { { 0, 1, 1, 0, 1, 2, 3, 2, 3, 3, 3 }, { 1, 2, 2, 0, 0, 1, 2, 3, 4, 4, 4 },
			{ 0, 2, 3, 1, 1, 0, 1, 4, 5, 3, 5 }, { 1, 1, 2, 2, 2, 0, 0, 3, 4, 2, 4 },
			{ 0, 0, 1, 2, 3, 1, 1, 2, 3, 1, 3 }, { 1, 0, 0, 1, 2, 2, 2, 1, 2, 2, 2 },
			{ 0, 1, 1, 2, 3, 3, 3, 0, 1, 2, 3 }, { 1, 2, 2, 3, 4, 4, 4, 0, 0, 1, 2 },
			{ 0, 2, 3, 4, 5, 3, 5, 1, 1, 0, 1 }, { 1, 1, 2, 3, 4, 2, 4, 2, 2, 0, 0 },
			{ 0, 0, 1, 2, 3, 1, 3, 2, 3, 1, 1 } };

	public static final int MAXDEPTH = 16;
	public static int[] finalPosition = { 0, 3, 4, 3, 0, 5, 6, 5, 0, 1, 2, 1, 0, 7, 8, 7, 0, 9, 10, 9, 0, 1, 2, 1 };
	public static int[] position = new int[24];
	public static int[] point = new int[2];
	public static int[] count = new int[2];
	public static int[] stack = new int[MAXDEPTH];
	public static int[] result = new int[MAXDEPTH];
	public static int rn;
	public static boolean possibility;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] numbers = br.readLine().split(" ");
			for (int i = 0; i < 24; i++)
				position[i] = Integer.parseInt(numbers[i]);
			count[0] = 0;
			count[1] = 0;
			point[0] = 0;
			point[1] = 12;
			rn = MAXDEPTH + 1;
			possibility = false;
			backTrack(0);
			if (possibility) {
				if (rn == 0)
					System.out.println("PUZZLE ALREADY SOLVED");
				else {
					for (int i = 0; i < rn; i++)
						System.out.print(result[i]);
					System.out.println();
				}
			} else
				System.out.println("NO SOLUTION WAS FOUND IN " + MAXDEPTH + " STEPS");
		}
	}

	public static int left(int base, int offset) {
		if (base < 12) {
			base += offset;
			if (base >= 12)
				base -= 12;
		} else {
			base += offset;
			if (base >= 24)
				base -= 12;
		}
		return base;
	}

	public static int right(int base, int offset) {
		if (base < 12) {
			base -= offset;
			if (base < 0)
				base += 12;
		} else {
			base -= offset;
			if (base < 12)
				base += 12;
		}
		return base;
	}

	public static void backTrack(int a) {
		if (a == rn)
			return;
		boolean isSame = true;
		for (int i = 0; i < 12 && isSame; i++)
			if (position[left(point[0], i)] != finalPosition[i])
				isSame = false;
		for (int i = 0; i < 12 && isSame; i++)
			if (position[left(point[1], i)] != finalPosition[i + 12])
				isSame = false;
		if (isSame) {
			for (int i = 0; i < a; i++) {
				result[i] = stack[i];
			}
			rn = a;
			possibility = true;
			return;
		}
		int minmove = 0;
		for (int i = 0; i < 21; i++) {
			int temp1 = position[left(point[i / 12], i % 12)];
			if (minmove < remainto[i / 2][temp1])
				minmove = remainto[i / 2][temp1];
		}
		if (a == MAXDEPTH || a + minmove > MAXDEPTH || a + minmove >= rn)
			return;
		int temp1, temp2;
		for (int i = 1; i <= 4; i++) {
			if (a >= rn - 1)
				break;
			stack[a] = i;
			switch (i) {
			case 1:
				if (count[0] > 0 || count[0] == -5)
					break;
				point[0] = right(point[0], 2);
				for (int j = 1; j <= 3; j++)
					position[right(point[1], j)] = position[right(point[0], j)];
				temp1 = count[0];
				temp2 = count[1];
				count[0]--;
				count[1] = 0;
				
				backTrack(a + 1);
				
				count[0] = temp1;
				count[1] = temp2;

				point[0] = left(point[0], 2);
				for (int j = 1; j <= 3; j++)
					position[right(point[1], j)] = position[right(point[0], j)];
				break;
			case 2:
				if (count[1] < 0 || count[1] == 5)
					break;
				point[1] = left(point[1], 2);
				for (int j = 1; j <= 3; j++)
					position[right(point[0], j)] = position[right(point[1], j)];
				temp1 = count[0];
				temp2 = count[1];
				count[0] = 0;
				count[1]++;
				backTrack(a + 1);
				count[0] = temp1;
				count[1] = temp2;
				point[1] = right(point[1], 2);
				for (int j = 1; j <= 3; j++)
					position[right(point[0], j)] = position[right(point[1], j)];
				break;
			case 3:
				if (count[0] < 0 || count[0] == 5)
					break;
				point[0] = left(point[0], 2);
				for (int j = 1; j <= 3; j++)
					position[right(point[1], j)] = position[right(point[0], j)];
				temp1 = count[0];
				temp2 = count[1];
				count[0]++;
				count[1] = 0;
				backTrack(a + 1);
				count[0] = temp1;
				count[1] = temp2;
				point[0] = right(point[0], 2);
				for (int j = 1; j <= 3; j++)
					position[right(point[1], j)] = position[right(point[0], j)];
				break;
			case 4:
				if (count[1] > 0 || count[1] == -5)
					break;
				point[1] = right(point[1], 2);
				for (int j = 1; j <= 3; j++)
					position[right(point[0], j)] = position[right(point[1], j)];
				temp1 = count[0];
				temp2 = count[1];
				count[0] = 0;
				count[1]--;
				backTrack(a + 1);
				count[0] = temp1;
				count[1] = temp2;
				point[1] = left(point[1], 2);
				for (int j = 1; j <= 3; j++)
					position[right(point[0], j)] = position[right(point[1], j)];
				break;
			}
		}
	}
}
