import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class FireAgain {

	public static void main(String[] args) throws IOException {
		BufferedReader readData = new BufferedReader(new FileReader("input.txt"));
		PrintWriter writer = new PrintWriter(new File("output.txt"));
		String line = readData.readLine();
		String[] temp = line.split(" ");
		int n = Integer.valueOf(temp[0]);
		int m = Integer.valueOf(temp[1]);
		int x = 0, y = 0;
		line = readData.readLine();
		int k = Integer.valueOf(line);
		boolean[][] visited = new boolean[n + 1][m + 1];
		Queue<Integer> qX = new LinkedList<Integer>();
		Queue<Integer> qY = new LinkedList<Integer>();
		line = readData.readLine();
		String[] temp2 = line.split(" ");
		for (int i = 0; i < temp2.length - 1; i+=2) {
			x = Integer.valueOf(temp2[i]);
			y = Integer.valueOf(temp2[i + 1]);
			visited[x][y] = true;
			qX.add(x);
			qY.add(y);
		}

		while (!qX.isEmpty()) {
			x = qX.poll();
			y = qY.poll();
			if (x >= 2 && !visited[x - 1][y]) {
				visited[x - 1][y] = true;
				qX.add(x - 1);
				qY.add(y);
			}
			if (x + 1 <= n && !visited[x + 1][y]) {
				visited[x + 1][y] = true;
				qX.add(x + 1);
				qY.add(y);
			}
			if (y >= 2 && !visited[x][y - 1]) {
				visited[x][y - 1] = true;
				qX.add(x);
				qY.add(y - 1);
			}
			if (y + 1 <= m && !visited[x][y + 1]) {
				visited[x][y + 1] = true;
				qX.add(x);
				qY.add(y + 1);
			}
		}
		writer.write(x + " ");
		writer.write(y + " ");
		writer.close();
	}

}
