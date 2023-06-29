import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.math.*;

/*
 50
873 838 288 87 889 364 720 410 565 651 577 356 740 99 549 592 994 385 777 435 486 118 887 440 749 533 356 790 413 681 267 496 475 317 88 660 374 186 61 437 729 860 880 538 277 301 667 180 60 393

 6
 2 2 3 3 5 5
 
 4
 2 2 3 3

 */
public class C429 {
	
	static InputStream is;
	static int[] counts;
	static int[] sufsum;
	static long mod = (long)(1e9+7);
	static long[][] choose;
	static long[][] memo;
	public static void main(String[] args) throws IOException {
		
		
		is = System.in;
		int n = ni();
		int[] a = na(n);
		long[] fact = new long[n+2];
		fact[0] = 1;
		for (int i = 1; i < fact.length; i++) {
			fact[i] = (fact[i-1]*i)%mod;
		}
		
		HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			int cp = a[i];
			int sfree = 1;
			for(int p = 2; p*p <= a[i] && cp > 1; p++){
				int count = 0;
				while(cp % p == 0){
					cp /= p;
					count++;
				}
				if(count % 2 == 1) sfree *= p;
			}
			if(cp != 1) sfree *= cp;
			if(!hm.containsKey(sfree)) hm.put(sfree, new ArrayList<Integer>());
			hm.get(sfree).add(a[i]);
		}
		
		
		
		counts = new int[hm.size()];
		int dex = 0;
		
		//System.out.println(hm);
		long bigmult = 1;
		for(Integer key : hm.keySet()){
			ArrayList<Integer> list = hm.get(key);
			counts[dex++] = list.size();
			bigmult = bigmult*fact[list.size()] % mod;
//			HashMap<Integer,Integer> dups = new HashMap<>();
//			for(int x : list){
//				if(!dups.containsKey(x)){
//					dups.put(x, 0);
//				}
//				dups.put(x, dups.get(x)+1);
//			}
			
//			for (int k : dups.keySet()) {
//				int amount = dups.get(k);
//				long tomult = new BigInteger(fact[amount]+"").modInverse(new BigInteger(mod+"")).longValue();
//				bigmult*= tomult;
//				bigmult %= mod;
//			}
			
		}
		Arrays.sort(counts);
		sufsum = new int[counts.length];
		for(int i = counts.length-2; i >= 0; i--){
			sufsum[i] = sufsum[i+1]+counts[i+1];
		}
			
		choose = new long[2*n+3][2*n+3];
		for(int i = 0; i < choose.length; i++){
			choose[i][0] = 1;
			for(int j = 1; j <=i; j++){
				choose[i][j] = (choose[i-1][j]+choose[i-1][j-1])%mod;
			}
		}
		
		memo = new long[counts.length][700];
		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], -1);
		}
		//System.out.println("bigmult: " + bigmult);
		System.out.println((bigmult*dp(counts.length-2,counts[counts.length-1]-1))%mod);
	}
	
	static long dp(int dex, int need){
		if(dex == -1){
			if(need == 0) return 1;
			return 0;
		}
		//System.out.println("dex: " + dex + " need " + need);
		if(memo[dex][need] != -1) return memo[dex][need];
		int numspots = sufsum[dex]+1;
		long ret = 0;
		
		int c = counts[dex];
		for(int numdivs = 1; numdivs <= c; numdivs++) {
			long toadd = 0;

			for(int gotoneed =0; gotoneed <= need && gotoneed <= numdivs; gotoneed++) {
				long temp = choose[need][gotoneed];
				temp *= choose[numspots-need][numdivs-gotoneed];
				
				//System.out.println("dex: " + dex + " need: "+ need + " numdivs: " + numdivs + " c1: " + choose[need][gotoneed] + " c2 " +  choose[numspots-need][numdivs-gotoneed]);
				
				temp %= mod;
				temp *= dp(dex-1,need-gotoneed+c-numdivs);
				temp %= mod;
				
				toadd += temp;
				toadd %= mod;
			}
			toadd *= choose[c-1][numdivs-1];
			toadd %= mod;
			ret += toadd;
			ret %= mod;
		}
		
		//System.out.println("dex: " + dex + " need: "+ need + " ret: " + ret);
		
		return  memo[dex][need]=ret;
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
	
}