import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int input[] = new int[4];
	static int result[] = new int[4];
	static int non[][];
	static int nonsize;
	static int depth;
	static boolean find;
	static boolean check[];
	static int rotate[] = { 1, -1 };
	static int route[];

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int Testcase = scan.nextInt();
		scan.nextLine();
		int original = 0;
		while (Testcase-- > 0) {
			scan.nextLine();
			for (int i = 0; i < 4; i++)
				input[i] = scan.nextInt();
			original = input[0] * 1000 + input[1] * 100 + input[2] * 10 + input[3];
			for (int i = 0; i < 4; i++)
				result[i] = scan.nextInt();
			nonsize = scan.nextInt();
			non = new int[nonsize][4];
			for (int n = 0; n < nonsize; n++)
				for (int i = 0; i < 4; i++)
					non[n][i] = scan.nextInt();
			find = false;
			check = new boolean[10000];
			route = new int[10000];
			bfs();
			if (!find)
				System.out.println("-1");
			else {
				int sum = 0;
				int i = result[0] * 1000 + result[1] * 100 + result[2] * 10 + result[3];
				for (; route[i] != original; i = route[i])
					sum++;
				System.out.println(sum + 1);
			}

		}
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		check[input[0] * 1000 + input[1] * 100 + input[2] * 10 + input[3]] = true;
		q.offer(input[0] * 1000 + input[1] * 100 + input[2] * 10 + input[3]);
		while (q.size() != 0) {
			int node = q.poll();
			input[0] = node / 1000;
			input[1] = (node / 100) % 10;
			input[2] = (node / 10) % 10;
			input[3] = node % 10;
			if (node == result[0] * 1000 + result[1] * 100 + result[2] * 10 + result[3]) {
				find = true;
				break;
			}

			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 2; j++) {
					int tmp = input[i];
					input[i] = input[i] + rotate[j] == 10 ? 0 : input[i] + rotate[j] == -1 ? 9 : input[i] + rotate[j];
					boolean is_non = false;
					for (int k = 0; k < nonsize; k++)
						if (input[0] == non[k][0] && input[1] == non[k][1] && input[2] == non[k][2]
								&& input[3] == non[k][3]) {
							is_non = true;
							break;
						}
					if (!check[input[0] * 1000 + input[1] * 100 + input[2] * 10 + input[3]] && !is_non) {
						route[input[0] * 1000 + input[1] * 100 + input[2] * 10 + input[3]] = node;
						q.offer(input[0] * 1000 + input[1] * 100 + input[2] * 10 + input[3]);
						check[input[0] * 1000 + input[1] * 100 + input[2] * 10 + input[3]] = true;
					}
					input[i] = tmp;
				}
		}
	}
}