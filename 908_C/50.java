import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C {
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	public static PrintWriter pw = new PrintWriter(System.out);
	final static boolean debugmode = true;
	public static int k = 7; // for 10^9 + k mods.
	public static long STMOD = 1000000000 + k; // 10^9 + k
	public static void main(String[] args) {
		int disks = getInt();
		int radii = getInt();
		if(disks == 1){
			System.out.println(radii);
		}
		else{
			double[][] diskcenters = new double[disks][2];
			for(int i = 0;i<disks;i++){
				diskcenters[i][0] = getInt();
			}
			diskcenters[0][1] = radii;
			for(int i = 1;i<disks;i++){
				double cmax = 0;
				for(int prev = 0;prev < i;prev++){
					cmax = Math.max(cmax, calcintersection(diskcenters[prev][0],diskcenters[prev][1],radii,diskcenters[i][0],radii));
				}
				diskcenters[i][1] = cmax;
			}
			for(int i = 0;i<diskcenters.length;i++){
				System.out.print(Double.toString(diskcenters[i][1]) + " ");
			}
			System.out.print("\n");
		}
		
	}
	public static double calcintersection(double x1,double y1, double r1,double x2, double r2){
		// x1,y1 must be stationary.
		if(!intersects(x1-r1,x1+r1,x2-r1,x2+r2)){
			return r2;
		}
		else if(x1 == x2){
			return y1 + r1 + r2;
		}
		double lo = y1;
		double hi = y1 +  2 * r2;
		
		while(Math.abs(lo-hi) > 0.0000001){
			double mid = (lo+hi)/2.0;
			int u = colide(x1,y1,r1,x2,mid,r2);
			if(u == 1){
				lo = mid;
			}
			else if(u == 0)
			{
				hi = mid;
			}
			else{
				return mid;
			}
		}
		return (lo+hi)/2.0;
	}
	public static boolean intersects(double l1, double r1,double l2, double r2 ){
		if(l2  <= l1 && r2 >= l1){
			return true;
		}
		if(l2 <= r1 && r2 >= r1){
			return true;
		}
		if(l1 <= l2 && r2 <= r1){
			return true;
		}
		else if(l2 <= l1 && r1 <= r2){
			return true;
		}
		return false;
	}
	public static int colide(double x1,double y1,double r1,double x2,double y2,double r2){
		double dist = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y2-y1, 2));
		if (dist > r1 + r2){
			return 0;
		}
		else if(dist == r1+r2){
			return 2;
		}
		else{
			return 1;
		}
		
	}
	public static void debug(String toPrint){
		if(!debugmode) {return;}
		pw.println("[DEBUG]: "+toPrint);
	}
	public static void  submit(int[] k){
		pw.println(Arrays.toString(k));
		pw.close();
	}
	public static void submit(int p){
		pw.println(Integer.toString(p));
		pw.close();
	}
	public static void submit(String k){
		pw.println(k);
		pw.close();
	}
	public static void submit(double u){
		pw.println(Double.toString(u));
		pw.close();
	}
	public static void submit(long lng){
		pw.println(Long.toString(lng));
		pw.close();
		
	}
	public static int getInt(){
		if (st != null && st.hasMoreTokens()){
			return Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(sc.nextLine());
		return Integer.parseInt(st.nextToken());
	}
	public static long getLong(){
		if (st != null && st.hasMoreTokens()){
			return Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(sc.nextLine());
		return Long.parseLong(st.nextToken());
	}
	public static double getDouble(){
		if (st != null && st.hasMoreTokens()){
			return Double.parseDouble(st.nextToken());
		}
		st = new StringTokenizer(sc.nextLine());
		return Double.parseDouble(st.nextToken());
	}
	public static String getString(){
		if(st != null && st.hasMoreTokens()){
			return st.nextToken();
		}
		st = new StringTokenizer(sc.nextLine());
		return st.nextToken();
	}
	public static String getLine(){
		return sc.nextLine();
	}
	public static int[][] readMatrix(int lines,int cols){
		int[][] matrr = new int[lines][cols];
		for (int i = 0;i < lines;i++){
			for(int j = 0;j < cols;j++){
				matrr[i][j] = getInt();
			}
		}
		return matrr;
	}
	public static int[] readArray(int lines){
		int[] ar = new int[lines];		
		for (int i = 0;i<lines;i++) ar[i] =getInt();
		return ar;
	}
	
}
