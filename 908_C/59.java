import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
public class naloga1{
	static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out=new PrintWriter(System.out);
	public static void main(String[] args) throws Exception{
		StringTokenizer st=new StringTokenizer(in.readLine());
		int n=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		int[] x=new int[n];
		st=new StringTokenizer(in.readLine());
		for(int i=0;i < n;i++){
			x[i]=Integer.parseInt(st.nextToken());
		}
		sim a=new sim(n,r);
		for(int i:x) {
			a.add(i);
		}
		for(double d:a.cy) {
			out.print(d+" ");
		}
		out.println();
		out.close();
	}
}
class sim{
	double[]cx;
	int[]ccx;
	double[]cy;
	int count;
	int n;
	int r;
	sim(int nn,int rr){
		r=rr;
		n=nn;
		cx=new double[n];
		ccx=new int[n];
		cy=new double[n];
		count=0;
	}
	void add(int x) {
		double lowest=r;
		for(int i=0;i<count;i++) {
			if(Math.abs(ccx[i]-x)<=2*r) {
				double dy=Math.sqrt(4*r*r-(ccx[i]-x)*(ccx[i]-x));
				lowest=Math.max(lowest,cy[i]+dy);
			}
		}
		ccx[count]=x;
		cy[count]=lowest;
		cx[count++]=x;
	}
}