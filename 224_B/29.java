


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Parser p = new Parser(System.in);
		PrintWriter pw= new PrintWriter(System.out);

		int n = p.nextInt();
		int k = p.nextInt();

		int[] a = p.nextIntArray(n);
		int [] pos = new int[100001];
		Arrays.fill(pos,-1);
		int cnt = 0;
		for(int i=0; i<n; ++i){
			int e = a[i];
			if( pos[e] == -1 ){
				++cnt;
			}
			pos[e] = i;
			if( cnt == k){
				break;
			}
		}
		if( cnt < k){
			pw.println("-1 -1");
			pw.close();
			return;
		}
		int min = 1000000;
		int max = -1;
		for(int i=0; i<100001; ++i){
			if(pos[i] != -1 && pos[i] < min ){
				min = pos[i];
			}
			if( pos[i] > max){
				max = pos[i];
			}
		}
		++min;
		++max;

		pw.println(min+" "+max);
		pw.close();
	}
	
	





	static class Parser{
		
		StringTokenizer st;
		BufferedReader br;

		public Parser(InputStream is){
			this.br = new BufferedReader( new InputStreamReader(is));
			
		}
		
		public int nextInt(){
			return Integer.parseInt(nextToken());
		}
		
		public double nextDouble(){
			return Double.parseDouble(nextToken());
		}
		
		public String nextString(){
			return nextToken();
		}
		
		public int[] nextIntArray(int s){
			int[] a = new int[s];
			for(int i=0; i<s; ++i){
				a[i] = nextInt();
			}
			return a;
		}
		
		public int[][] nextIntTable(int r, int c){
			int[][] a = new int[r][c];
			for(int i=0; i<r; ++i){
				a[i] = nextIntArray(c);
			}
			return a;
		}
	
		private String nextToken() {
			if( st == null || ! st.hasMoreTokens() ){
				try{
					st = new StringTokenizer( br.readLine());
				}catch( Exception e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
	}
}



