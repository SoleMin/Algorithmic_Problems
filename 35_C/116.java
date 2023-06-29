import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
 
public class C {
	Scanner in;
	PrintWriter out;
//	String INPUT = "3 3 1 1 1";
	String INPUT = "";
	
	void solve()
	{
		int n = ni();
		int m = ni();
		int k = ni();
	    int[][] f=new int[k][2];
        		
        		for(int i=0;i<k;i++) {
        			f[i][0]=ni()-1;
        			f[i][1]=ni()-1;
        		}
        		int mx=-1;
        		int resx=0;
        		int resy=0;        		
        		
        		for(int i=0;i<n;i++) {
        			for(int j=0;j<m;j++) {
        				int min=Integer.MAX_VALUE;
        				for(int l=0;l<k;l++) {
        					min=Math.min(min, Math.abs(f[l][0]-i)+Math.abs(f[l][1]-j));
        				}
        				if(min>mx) {
        					mx=min;
        					resx=i;
        					resy=j;
        				}
        			}
        			
        		}
        		out.println((resx+1)+" "+(resy+1));
        		
	}

	void run() throws Exception
	{
		in = INPUT.isEmpty() ? new Scanner(new File("input.txt")) : new Scanner(INPUT);
		out = INPUT.isEmpty() ? new PrintWriter("output.txt") : new PrintWriter(System.out);
 
		solve();
		out.flush();
	}
	
	
	public static void main(String[] args) throws Exception
	{
		new C().run();
	}
	
	int ni() { return Integer.parseInt(in.next()); }
	void tr(Object... o) { if(INPUT.length() != 0)System.out.println(o.length > 1 || o[0].getClass().isArray() ? Arrays.deepToString(o) : o[0]); }
	static String join(int[] a, int d){StringBuilder sb = new StringBuilder();for(int v : a){sb.append(v + d + " ");}return sb.toString();}
}