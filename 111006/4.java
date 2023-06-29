import java.util.*;
import java.io.*;

public class Main {

	private static boolean[][] road;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int d = 1;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			String[] name = new String[n];
			road = new boolean[n][n];
			visited = new boolean[n];
			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				name[i] = br.readLine();
				map.put(name[i], i);
			}
			int r = Integer.parseInt(br.readLine());
			for (int i = 0; i < r; i++) {
				String[] city = br.readLine().split(" ");
				int v1 = map.get(city[0]);
				int v2 = map.get(city[1]);
				road[v1][v2] = true;
				road[v2][v1] = true;

			}
			String[] camera = new String[n];
			int cameraCount = 0;
			for (int i = 0; i < visited.length; i++) {
				int currCycle = countCycle(i);
				if (currCycle > 1) {
					camera[cameraCount++] = name[i];
				}
			}
			Arrays.sort(camera, 0, cameraCount);
			if (d > 1)
				sb.append("\n");
			sb.append("City map #" + (d++) + ": " + cameraCount + " camera(s) found\n");
			for (int i = 0; i < cameraCount; i++) {
				sb.append(camera[i] + "\n");
			}
		}
		System.out.print(sb);
	}

	private static void visit(int v) {
		if (!visited[v]) {
			visited[v] = true;
			for (int i = 0; i < road.length; i++) {
				if (road[v][i]) {
					visit(i);
				}
			}
		}
	}

	private static int countCycle(int v) {
		Arrays.fill(visited, false);
		visited[v] = true;
		int count = 0;
		for (int i = 0; i < road.length; i++) {
			if (!visited[i]) {
				visit(i);
				count++;
			}
		}
		return count;
	}
}