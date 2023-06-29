import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	private static final int SIM = 1;
	private static final int NAO = 2;
	
	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] a = new int[n][m];
		int[][] graphVerticial = null;
		int[][] graphDiagonal = null;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				a[i][j] = in.nextInt();
			}
		}
		
		graphVerticial = createGraphVertical(n, m, a);
		graphDiagonal = createGraphDiagonal(n, m, a);
		
//		print(graphVerticial);
//		System.out.println("##########################");
//		print(graphDiagonal);
		
		int result = 0;
		int k = 1;
		int piso = 0;
		int teto = 1000000000;
		
		while(true) {
			
			k = (int) Math.ceil((teto - piso) / 2.0) + piso;
			
			if(isOk(n, k, graphVerticial, graphDiagonal)) {
				result = Math.max(result, k);
				piso = k;
			}
			else{
				teto = k - 1;
			}

			//System.out.println(piso + ", " + teto);
			
			if(teto <= piso) break;
			
		}
		
		System.out.println(result);
		
	}
	
	public static int[][] createGraphVertical(int n, int m, int[][] a){
		
		int[][] graph = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j  < n; j++) {
				
				if(i == j) continue;
				if(i > j) {graph[i][j] = graph[j][i]; continue;}
				
				graph[i][j] = Integer.MAX_VALUE;
				
				for(int k = 0; k < m; k++) {
					graph[i][j] = Math.min(graph[i][j], Math.abs(a[i][k] - a[j][k]));
				}
			}
		}
		
		return graph;
	}
	
	public static int[][] createGraphDiagonal(int n, int m, int[][] a){
		
		int[][] graph = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j  < n; j++) {
				
				graph[i][j] = Integer.MAX_VALUE;
				
				for(int k = 0; k < m - 1; k++) {
					graph[i][j] = Math.min(graph[i][j], Math.abs(a[j][k] - a[i][k + 1]));
				}
			}
		}
		
		return graph;
	}
	
	public static int hasPath(int n, int k, int origem, int destino, int conjunto, int[][] graph, int[][][] pd) {
		
		//System.out.println(origem + ", " + destino);
		//print(conjunto);
		
		if(pd[origem][destino][conjunto] != 0) return pd[origem][destino][conjunto];
		
		if(conjunto == 0) {
			return origem == destino ? SIM : NAO;
		} 
		else if(origem == destino){
			return NAO;
		}
		
		for(int i = 0; i < n; i++) {
			
			if(i == origem) continue;
			
			int novoConjunto = conjunto - (1 << i);
			boolean pertenceConjunto = ((conjunto >> i) % 2) == 1;
			
			if(pertenceConjunto && graph[origem][i] >= k && hasPath(n, k, i, destino, novoConjunto, graph, pd) == SIM) {
				pd[origem][destino][conjunto] = SIM;
				return pd[origem][destino][conjunto];
			}
		}
		
		pd[origem][destino][conjunto] = NAO;
		
		return pd[origem][destino][conjunto];
		
	}
	
	public static boolean isOk(int n, int k, int[][] graphVertical, int[][] graphDiagonal) {
		
		int conjunto = (int) Math.pow(2, n) - 1;
		
		int[][][] pd = new int[n][n][(int)Math.pow(2, n)];
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				
				if(i == j && n > 1) continue;
				
				int novoConjunto = conjunto - (1 << i);
				
				if(graphDiagonal[i][j] >= k && hasPath(n, k, i, j, novoConjunto, graphVertical, pd) == SIM) {
					return true;
				}
				
			}
		}
		
		return false;
		
	}
	
	public static void print(int[][] graph) {
		
		for(int i = 0; i < graph.length; i++) {
			
			for(int j = 0; j < graph.length; j++) {
				
//				if(graph[i][j] >= 3 ) System.out.print("1 ");
//				else System.out.print("0 ");
				System.out.print(graph[i][j] + " ");
				
			}
			
			System.out.println();
			
		}
		
	}
	
	public static void print(int n) {
		
		List<Integer> bits = new Vector<>();
		
		while(n > 0) {
			
			bits.add(n % 2);
			n /= 2;
		}
		
		for(int i = bits.size() - 1; i >= 0; i--) {
			System.out.print(bits.get(i));
		}
		
		System.out.println();
		
	}
	
}
