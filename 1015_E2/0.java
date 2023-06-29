import java.util.*;

import java.io.*;import java.math.*;

//=============================================================================
//--------------------------Main-Class---------------------------------
//=============================================================================

public class A {
	
	
	public static void process()throws IOException{
		
		int height=sc.nextInt(), width=sc.nextInt();
		boolean[][] board=new boolean[width][height];
		for (int y=0; y<height; y++) {
			char[] line=sc.next().toCharArray();
			for (int x=0; x<width; x++)
				board[x][y]=line[x]=='*';
		}
		
		int[][] starLineLeft=new int[width][height], starLineRight=new int[width][height];
		int[][] starLineUp=new int[width][height], starLineDown=new int[width][height];
		for (int x=0; x<width; x++) {
			for (int y=0; y<height; y++) {
				if (x==0)
					starLineLeft[x][y]=board[x][y]?1:0;
				else
					starLineLeft[x][y]=board[x][y]?1+starLineLeft[x-1][y]:0;
				if (y==0)
					starLineUp[x][y]=board[x][y]?1:0;
				else
					starLineUp[x][y]=board[x][y]?1+starLineUp[x][y-1]:0;
			}
		}
		for (int x=width-1; x>=0; x--) {
			for (int y=height-1; y>=0; y--) {
				if (x==width-1)
					starLineRight[x][y]=board[x][y]?1:0;
				else
					starLineRight[x][y]=board[x][y]?1+starLineRight[x+1][y]:0;
				if (y==height-1)
					starLineDown[x][y]=board[x][y]?1:0;
				else
					starLineDown[x][y]=board[x][y]?1+starLineDown[x][y+1]:0;
			}
		}
		
		ArrayList<Pair2>[] eventsOnX=new ArrayList[width];
		for (int i=0; i<width; i++)
			eventsOnX[i]=new ArrayList<>();
		ArrayList<Pair2>[] eventsOnY=new ArrayList[height];
		for (int i=0; i<height; i++)
			eventsOnY[i]=new ArrayList<>();
		
		int starCount=0;
		for (int x=0; x<width; x++) {
			for (int y=0; y<height; y++) {
				int radius=Math.min(Math.min(starLineLeft[x][y], starLineRight[x][y]), Math.min(starLineUp[x][y], starLineDown[x][y]));
				if (radius>=2) {
					starCount++;
					int startX=x-radius+1;
					int endX=x+radius-1;
					int startY=y-radius+1;
					int endY=y+radius-1;
					eventsOnX[x].add(new Pair2(startY, 1));
					eventsOnX[x].add(new Pair2(endY+1, -1));
					eventsOnY[y].add(new Pair2(startX, 1));
					eventsOnY[y].add(new Pair2(endX+1, -1));
				}
			}
		}
		
		boolean[][] painted=new boolean[width][height];
		for (int x=0; x<width; x++) {
			Collections.sort(eventsOnX[x]);
			int index=0;
			int numIn=0;
			for (int y=0; y<height; y++) {
				while (index<eventsOnX[x].size()&&eventsOnX[x].get(index).x==y) {
					numIn+=eventsOnX[x].get(index).y;
					index++;
				}
				if (numIn>0) {
					painted[x][y]=true;
				}
			}
		}
//		for (int x=0; x<width; x++) {
//			for (int y=0; y<height; y++) {
//				System.out.print(painted[x][y]+" ");
//			}
//			System.out.println();
//		}
		for (int y=0; y<height; y++) {
			Collections.sort(eventsOnY[y]);
			int index=0;
			int numIn=0;
			for (int x=0; x<width; x++) {
				while (index<eventsOnY[y].size()&&eventsOnY[y].get(index).x==x) {
					numIn+=eventsOnY[y].get(index).y;
					index++;
				}
				if (numIn>0) {
					painted[x][y]=true;
				}
			}
		}
//		System.out.println("--------------");
//		for (int x=0; x<width; x++) {
//			for (int y=0; y<height; y++) {
//				System.out.print(painted[x][y]+" ");
//			}
//			System.out.println();
//		}
		
		for (int x=0; x<width; x++) {
			for (int y=0; y<height; y++) {
				if (board[x][y]^painted[x][y]) {
					System.out.println(-1);
					return;
				}
			}
		}
		println(starCount);
		for (int x=0; x<width; x++) {
			for (int y=0; y<height; y++) {
				int radius=Math.min(Math.min(starLineLeft[x][y], starLineRight[x][y]), Math.min(starLineUp[x][y], starLineDown[x][y]));
				if (radius>=2) {
					println((y+1)+" "+(x+1)+" "+(radius-1));
				}
			}
		}
		
    }






	
 
 
	
	//=============================================================================
	//--------------------------Dheeraj-Bhagchandani---------------------------------
	//=============================================================================
  
	 
    static FastScanner sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        boolean oj = true;
        if(oj){sc=new FastScanner();out=new PrintWriter(System.out);}
        else{sc=new FastScanner(100);out=new PrintWriter("output.txt");}
        int t=1;
//        t = sc.nextInt();
        while(t-->0) {process();}
        out.flush();out.close();  
    }
    
    static class Pair implements Comparable<Pair> {
		int x,y,z;
		Pair(int x, int y, int z) {
			this.x = x;
			this.z = z;
			this.y = y;
		}
		@Override
		public int compareTo(Pair o) {
			return Long.compare(x, o.x);
		}
	}
    static class Pair2 implements Comparable<Pair2> {
		int x,y;
		Pair2(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pair2 o) {
			return Long.compare(x, o.x);
		}
	}
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    
	static void println(Object o){out.println(o);}
	static void println(){out.println();}
	static void print(Object o){out.print(o);}
	static void pflush(Object o){out.println(o);out.flush();}
	static int ceil(int x, int y) {return (x % y == 0 ? x / y : (x / y + 1));}
	static long ceil(long x, long y) {return (x % y == 0 ? x / y : (x / y + 1));}
	static int max(int x, int y) {return Math.max(x, y);}
	static int min(int x, int y) {return Math.min(x, y);}
	static int abs(int x) {return Math.abs(x);}
	static long abs(long x) {return Math.abs(x);}
	static int log2(int N) {int result = (int) (Math.log(N) / Math.log(2));return result;}
	static long max(long x, long y) {return Math.max(x, y);}
	static long min(long x, long y) {return Math.min(x, y);}
	public static int gcd(int a, int b) {
	BigInteger b1 = BigInteger.valueOf(a);BigInteger b2 = BigInteger.valueOf(b);
	BigInteger gcd = b1.gcd(b2);return gcd.intValue();}
	public static long gcd(long a, long b) {
	BigInteger b1 = BigInteger.valueOf(a);BigInteger b2 = BigInteger.valueOf(b);
	BigInteger gcd = b1.gcd(b2);return gcd.longValue();}
   
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	static class FastScanner{BufferedReader br; StringTokenizer st;
	FastScanner()throws FileNotFoundException{
    	br=new BufferedReader(new InputStreamReader(System.in));}
	FastScanner(int a)throws FileNotFoundException{
   	br = new BufferedReader(new FileReader("input.txt"));}
    String next()throws IOException{
    while (st == null || !st.hasMoreElements()) {try{
    st = new StringTokenizer(br.readLine());}
    catch (IOException  e){ e.printStackTrace(); }}
    return st.nextToken(); } int nextInt() throws IOException{
    return Integer.parseInt(next());}
    long nextLong() throws IOException
    {return Long.parseLong(next());}
    double nextDouble()throws IOException { return Double.parseDouble(next()); }
    String nextLine() throws IOException{ String str = ""; try{
    str = br.readLine();} catch (IOException e){
    e.printStackTrace();} return str;}
    int[] readArray(int n)throws IOException{int[]A=new int[n];
    for(int i=0;i!=n;i++){A[i]=sc.nextInt();}return A;}
    long[] readArrayLong(int n)throws IOException{long[]A=new long[n];
    for(int i=0;i!=n;i++){A[i]=sc.nextLong();}return A;}}
	
	static void ruffleSort(int[] a) {Random get = new Random();
		for (int i = 0; i < a.length; i++) {int r = get.nextInt(a.length);
		int temp = a[i];a[i] = a[r];a[r] = temp;}Arrays.sort(a);}
	static void ruffleSort(long[] a) {Random get = new Random();
		for (int i = 0; i < a.length; i++) {int r = get.nextInt(a.length);
		long temp = a[i];a[i] = a[r];a[r] = temp;}Arrays.sort(a);}
}