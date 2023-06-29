import java.util.*;
import java.io.*;

/*
6
2 2
5 2
1 5
1 1
3
1 2
1 1
1 2
1 1
1 2
2 3
2 1
1
1

*/

public class e2 {

	static int n;
	static int m;
	static int[][] mat;

	public static void main(String[] args){
		JS scan = new JS();
		PrintWriter out = new PrintWriter(System.out);
		int t = scan.nextInt();
		long start = System.currentTimeMillis();
		for(int q = 1; q <= t; q++){
			n = scan.nextInt();
			m = scan.nextInt();
			// n = 12;
			// m = 20000;
			mat = new int[n][m];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					mat[i][j] = scan.nextInt();
					// mat[i][j] = 100000;
				}
			}
			int[] max = new int[m];
			PriorityQueue<Item> pq = new PriorityQueue<Item>();
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					max[i] = max(max[i], mat[j][i]);
				}
				pq.add(new Item(i, max[i]));
			}
			ArrayList<Item> guys = new ArrayList<Item>();
			while(!pq.isEmpty() && guys.size() < n){
				Item tt = pq.poll();
				guys.add(tt);
			}

			int[][] cost = new int[guys.size()][1 << n];
			// long time = System.currentTimeMillis();
			for(int i = 0; i < guys.size(); i++){
				int g = guys.get(i).a;
				for(int s = 0; s < n; s++){
					for(int j = 0; j < (1 << n); j++){
						int sum = 0;
						for(int k = 0; k < n; k++){
							if((j & (1 << k)) > 0){
								sum += mat[(k+s)%n][g];
							}
						}
						cost[i][j] = max(cost[i][j], sum);
					}
				}
			}

			// for(int i = 0; i < guys.size(); i++) System.out.println(Arrays.toString(cost[i]));

			// System.out.println(System.currentTimeMillis()-time);
			int full = (1 << n)-1;
			// time = System.currentTimeMillis();
			int[][] dp = new int[guys.size()+1][1 << n];
			int ans = 0;

			
	
			for(int c = 0; c < guys.size(); c++){
					for(int j = 0; j < (1 << n); j++){
						for(int i = j; i < (1 << n); i = (i+1)|j){
							dp[c+1][i] = 
								max(dp[c+1][i], cost[c][j]+dp[c][i^j]);
							
							ans = max(ans, dp[c+1][i]);
						}
					}
			}
			// for(int i = 0; i < dp.length; i++) System.out.println(Arrays.toString(dp[i]));
			// System.out.println(System.currentTimeMillis()-time);

			out.println(ans);
		}
		// System.out.println(System.currentTimeMillis()-start);
		out.flush();
	}

	static int max(int a, int b){
		return a > b? a : b;
	}

	static class Item implements Comparable<Item>{

		int a;
		int b;

		public Item(int a, int b){
			this.a = a;
			this.b = b;
		}

		public int compareTo(Item o){
			return o.b-this.b;
		}
	}

	static class JS{
		public int BS = 1<<16;
		public char NC = (char)0;
		byte[] buf = new byte[BS];
		int bId = 0, size = 0;
		char c = NC;
		double num = 1;
		BufferedInputStream in;
 
		public JS() {
			in = new BufferedInputStream(System.in, BS);
		}
 
		public JS(String s) throws FileNotFoundException {
			in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
		}
 
		public char nextChar(){
			while(bId==size) {
				try {
					size = in.read(buf);
				}catch(Exception e) {
					return NC;
				}				
				if(size==-1)return NC;
				bId=0;
			}
			return (char)buf[bId++];
		}
 
		public int nextInt() {
			return (int)nextLong();
		}
 
		public long nextLong() {
			num=1;
			boolean neg = false;
			if(c==NC)c=nextChar();
			for(;(c<'0' || c>'9'); c = nextChar()) {
				if(c=='-')neg=true;
			}
			long res = 0;
			for(; c>='0' && c <='9'; c=nextChar()) {
				res = (res<<3)+(res<<1)+c-'0';
				num*=10;
			}
			return neg?-res:res;
		}
 
		public double nextDouble() {
			double cur = nextLong();
			return c!='.' ? cur:cur+nextLong()/num;
		}
 
		public String next() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c>32) {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}
 
		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c!='\n') {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}
 
		public boolean hasNext() {
			if(c>32)return true;
			while(true) {
				c=nextChar();
				if(c==NC)return false;
				else if(c>32)return true;
			}
		}
	}
}