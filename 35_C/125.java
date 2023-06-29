import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws IOException {
		File f = new File("input.txt");
		Scanner sc = new Scanner(f);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output.txt")));
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[][] grid = new boolean[n][m];
		for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) 
			grid[i][j] = false;
		Queue<Pair> q = new LinkedList<>();
		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			x--;
			y--;
			grid[x][y] = true;
			q.add(new Pair(x, y));
		}
		Pair last = new Pair(-1, -1);
		while (!q.isEmpty()) {
			Pair current = q.poll();
			last = current;
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					if (i != 0 && j != 0) continue;
					if (inside(current.x + i, current.y + j, n, m) &&
							!grid[current.x + i][current.y + j]) {
						grid[current.x + i][current.y + j] = true;
						q.add(new Pair(current.x + i, current.y + j));
						//bw.append((current.x + i) + " " + (current.y + j) + "\n");
					}
				}
			}
		}
		
		bw.append((last.x + 1) + " " + (last.y + 1) + "\n");
		bw.flush();
		bw.close();
		
		sc.close();
	}
	static class Pair {
		int x;
		int y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static boolean inside(int a, int b, int n, int m) {
		return (a >= 0 && a < n && b >= 0 && b < m);
	}
}
