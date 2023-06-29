import java.util.Scanner;

public class Main {
	public static int result;
	public static boolean[] visited;
	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			int n = input.nextInt();
			int k = input.nextInt();
			if (n == 0)
				break;
			visited = new boolean[n * 2 - 1];
			result = 0;
			backTrack(0, k);
			System.out.println(result);
		}
	}

	public static void backTrack(int index, int bishops) {
		if (index == visited.length) {
			if (bishops != 0)
				return;
			int count = 1;
			for (int i = 0, white = 0, black = 0; i < visited.length; ++i)
				if (visited[i])
					count *= (i / 2) + 1 - (i / 2 % 2 == 0 ? white++ : black++);
			result += count;
		} else {
			visited[index] = true;
			backTrack(index + 1, bishops - 1);
			visited[index] = false;
			backTrack(index + 1, bishops);
		}
	}
}
