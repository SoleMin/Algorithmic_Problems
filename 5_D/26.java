import java.util.*;
import java.io.*;

public class Traffic extends Template{
	public double search1(int a, int w, int d){
		double s = 0;
		double l = 2*w+2*a*d;
		int repeat = 100;
		while( repeat-- > 0 ){
			double x = (s+l)/2;
			if( a*a*x*x + 2*a*w*x - w*w - 4*a*d > 0 ){
				l = x;
			} else {
				s = x;
			}
		}
		return l;
	}
	
	public double search2(int a, double lim, int k){
		double s = 0;
		double l = lim + 2*a*k;
		int repeat = 100;
		while( repeat-- > 0 ){
			double x = (s+l)/2;
			if( a*x*x + 2*lim*x - 2*k > 0 ){
				l = x;
			} else {
				s = x;
			}
		}
		return l;
	}
	
	public void solve() throws IOException {
		int a = nextInt();
		int v = nextInt();
		int l = nextInt();
		int d = nextInt();
		int w = nextInt();
		if( w > v ){
			w = v;
		}
		double time_max = Math.sqrt((double)2*d/a);
		double time_d = search1(a,w,d);
	//	writer.println(time_max*a < w); writer.println(v <= (w+a*time_d)/2); writer.println(w < v); 
		double t1 = (time_max*a < w) ? time_max : (v >= (w+a*time_d)/2) ? time_d : (w < v) ? (double)(2*v*v-2*v*w+2*a*d+w*w)/(2*a*v) : (double)v/a + (double)(d-(double)v*v/(2*a))/v;
		double lim = (time_max*a < w) ? time_max*a : w;
		double t3 = Math.min((double)(v-lim)/a, search2(a, lim, l-d));
//		double t = (Math.sqrt(limit*limit+2*a*(l-d))-limit)/a;
		double dist2 = (l-d) - t3*t3*a/2 - t3*lim;
		double t4 = dist2/v;
//		writer.println("t1 = " + t1);
//		writer.println("dist1 = " + dist1);
//		writer.println("t3 = " + t3);
//		writer.println("dist2 = " + dist2);
//		writer.println("t4 = " + t4);
		writer.println((t1+t3+t4));
	}
	
	public static void main(String[] args){
		new Traffic().run();
	}
}

abstract class Template implements Runnable{
	public abstract void solve() throws IOException;
	
	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;
	
	public void run(){
		try{
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
			writer = new PrintWriter(System.out);
			solve();
			reader.close();
			writer.close();
		} catch(Exception e){
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public int nextInt() throws IOException{
		return Integer.parseInt(nextToken());
	}
	
	public String nextToken() throws IOException{
		while( tokenizer == null || !tokenizer.hasMoreTokens() ){
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}
}