import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int solCount;
	static int tempNode;
	static int[] result;
	static String[] cityName;
	static int[][] road;
	static boolean[] visited;
	static boolean[] cityBan;
	static boolean solved;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) throws NumberFormatException, IOException {

		int num = 1;
		while((n = Integer.parseInt(br.readLine())) != 0) {
			solCount = 0;
			solved = false;
			input();
			solve();
			list.sort(null);
			System.out.println("City map #"+ num++ +": "+solCount+" camera(s) found");
			for(int i = 0; i < solCount; i++)
				System.out.println(list.get(i));
			System.out.println();
			list.clear();
		}
	}

	static void solve() {
		int i;
		int[][] graph = new int[road.length][road[0].length];
		for(i = 1; i <= n; i++) {
			arrayCopy(graph);
			
			visited = new boolean[101];
			for(int j = 1; j <= n; j++) {
				graph[i][j] = 0;
				graph[j][i] = 0;
			}
			cityBan[i] = true;
			dfs(graph, i, 1);
			
			if(!verify()) {
				list.add(cityName[i]);
				solCount++;
			}
			cityBan[i] = false;
		}
	}

	static boolean verify() {
		for(int i = 1; i <= n; i++) {
			if(!visited[i] && !cityBan[i])
				return false;
		}
		return true;
	}

	static void arrayCopy(int[][] graph) {
		for(int j = 0; j < road.length; j++)
				System.arraycopy(road[j], 0, graph[j], 0, road[0].length);
	}

	static void dfs(int[][] graph, int nodeIndex, int nodeCount) {
		if(nodeIndex == n)
			nodeIndex = 0;

		int count = 0;
		int[] adj = new int[n+1];
		for(int i = 1; i <= n; i++)
			if(graph[nodeIndex+1][i] == 1) {
				adj[count+1] = i;
				count++;
			}
				
		visited[nodeIndex+1] = true;
		for(int i = 1; i <= count; i++) {
			
			if(!visited[adj[i]] && !cityBan[nodeIndex+1] && graph[nodeIndex+1][adj[i]] == 1)
				dfs(graph, adj[i]-1, nodeCount+=1);
		}
	}

	static void input() throws IOException {
		int i, j;
		result = new int[101];
		cityName = new String[101];
		road = new int[101][101];
		cityBan = new boolean[101];
		StringTokenizer st;

		for(i = 1; i <= 100; i++) {
			for(j = 1; j <= 100; j++) {
				road[i][j] = 0;
			}
		}

		for(i = 1; i <= n; i++) {
			cityName[i] = br.readLine();
		}
		int n1 = Integer.parseInt(br.readLine());
		for(i = 0; i < n1; i++) {
			String roadName = br.readLine();
			st = new StringTokenizer(roadName);
			cityCompare(st.nextToken(), st.nextToken());
		}
	}

	static void cityCompare(String s1, String s2) {
		int i; 
		int a = 0, b = 0;
		for(i = 1; i <= n; i++) {
			if(cityName[i].equals(s1))
				a = i;
			if(cityName[i].equals(s2))
				b = i;
		}
		road[a][b] = 1;
		road[b][a] = 1;
	}
}
