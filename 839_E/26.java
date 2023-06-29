import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class E {
	
	static InputStream is;
	//String INPUT = "";

	public static void main(String[] args) throws IOException {
		is = System.in;
		int n = ni();
		int k = ni();
		
		int[][] aj = new int[n][n];
		
		for (int i = 0; i < aj.length; i++) {
			aj[i] = na(n);
		}
		
		int F = (n+1)/2;
		int B = n-F;
		
		int[] spanftf = new int[F];
		int[] spanftb = new int[F];
		for(int i =0; i < F; i++){
			for(int j =0; j < F; j++){
				if(i == j || aj[i][j] == 1){
					spanftf[i] |= 1<<j;
				}
			}
			for(int j =0; j< B; j++){
				if(aj[i][F+j] == 1){
					spanftb[i] |= 1<<j;
				}
			}
		}
		int[] maxes = new int[1<<B];
		for(int bm = 0; bm < (1<<F); bm++){
			int anded = (1<<F)-1;
			int spanToBack = (1<<B)-1;
			
			for(int i =0; i < F; i++){
				if((1<<i & bm) != 0){
					anded &= spanftf[i];
					spanToBack &= spanftb[i];
				}
			}
			
			if((anded & bm) == bm){
				maxes[spanToBack] = Math.max(maxes[spanToBack], Integer.bitCount(bm));
			}
		}
		int[] spanbtb = new int[B];
		for(int i =0; i < B; i++){
			for(int j =0; j< B; j++){
				if(aj[F+i][F+j] == 1 || i == j){
					spanbtb[i] |= 1<<j;
				}
			}
		}
		boolean[] isgood = new boolean[1<<B];
		for(int bm =0; bm < (1<<B); bm++){
			int anded = (1<<B)-1;
			
			for(int i =0; i < B; i++){
				if((1<<i & bm) != 0){
					anded &= spanbtb[i];
				}
			}
			
			if((anded & bm) == bm){
				isgood[bm] = true;
			}
			
		}
		bybc[] tosort = new bybc[1<<B];
		for (int i = 0; i < tosort.length; i++) {
			tosort[i]= new bybc(i);
		}
		Arrays.sort(tosort);
		
		int best = 1;
		for (int i = 0; i < tosort.length; i++) {
			int at  =tosort[i].mask;
			if(isgood[at]){
				best = Math.max(best, maxes[at]+Integer.bitCount(at));
			}
			
			for(int j =0; j < B; j++){
				if((1<<j & at) != 0){
					int to = at - (1<<j);
					maxes[to] = Math.max(maxes[to], maxes[at]);
				}
			}
			
		}
		
		//System.out.println("best: " + best);
		
		double ans= best*(best-1)/2.0 * (k*k/(double)(best*best));
		System.out.println(ans);
	}
	
	static class bybc implements Comparable<bybc>{
		int mask;

		public bybc(int mask) {
			super();
			this.mask = mask;
		}
		
		@Override
		public int compareTo(bybc o) {
			return Integer.bitCount(o.mask) - Integer.bitCount(mask);
		}
	}
	
	private static byte[] inbuf = new byte[1024];
	public static int lenbuf = 0, ptrbuf = 0;
	
	private static int readByte()
	{
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private static boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
	private static int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
	
	private static double nd() { return Double.parseDouble(ns()); }
	private static char nc() { return (char)skip(); }
	
	private static String ns()
	{
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private static char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private static char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	private static int[] na(int n)
	{
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}
	
	private static int ni()
	{
		int num = 0, b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private static long nl()
	{
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	//private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	//private void tr(Object... o) { if(!oj)System.out.println(Arrays.deepToString(o)); }
}