import java.io.*;
import java.util.*;

public class C {

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int a[] = in.readArray(8);
        int b[] = in.readArray(8);
        for(int i=0;i<8;i++){
        	a[i] += 100;
        	b[i] += 100;
        }
        int graph[][] = new int[210][210];
        int sx = a[0], sy = a[1], ex = a[2], ey = a[3];
        int l = Math.abs(sx-a[4]);
        //out.println(l);
        for(int i=0;i<=l;i++){
        	int x = sx, y = sy;
        	while(x!=ex||y!=ey){
        		graph[x][y]++;       
        		if(x<ex)x++;
        		else if(x>ex) x--;
        		if(y<ey) y++;
        		else if(y>ey) y--;
        	}
        	graph[x][y]++;
        	if(sx<a[6]){
        		sx++; ex++;
        	}	
        	else if(sx>a[6]){
        		sx--; ex--;
        	} 
        	if(sy<a[7]){
        		sy++; ey++;
        	}	
        	else if(sy>a[7]){
        		sy--; ey--;
        	}	
        }             
        int px = b[0], py = b[1], qx = b[4], qy = b[5];
      	double ca, cb;
        ca = (px+qx)/2.00; cb = (py+qy)/2.00;
        double r = Math.sqrt((px-qx)*(px-qx) + (py-qy)*(py-qy)); r/=2;
        for(int i=0;i<=200;i++){
        	for(int j=0;j<=200;j++){
        		if(Math.abs(i-ca)+Math.abs(j-cb)<=r) graph[i][j]++;
        	}
        }/*
        for(int i=98;i<=115;i++){
        	for(int j=98;j<=115;j++) out.print(graph[i][j]+" ");
        	out.println();
        }
        out.println(ca+" "+cb+" "+r);*/
       	boolean yes = false;
       	int cnt = 0;
       	for(int i=0;i<=200;i++){
       		for(int j=0;j<=200;j++) if(graph[i][j]==2){ yes = true; cnt++; }
       	}
       	out.println((yes)?"YES":"NO");
       	//out.println(cnt);
        out.flush();
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens())
				try { st = new StringTokenizer(br.readLine()); }
				catch(IOException e) {}
			return st.nextToken();
		}
		
		String nextLine(){
			try{ return br.readLine(); } 
			catch(IOException e) { } return "";
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		int[] readArray(int n) {
			int a[] = new int[n];
			for(int i=0;i<n;i++) a[i] = nextInt();
			return a;
		}
	}

	static final Random random = new Random();

	static void ruffleSort(int[] a){
		int n = a.length;
		for(int i=0;i<n;i++){
			int j = random.nextInt(n), temp = a[j];
			a[j] = a[i]; a[i] = temp;
		}
		Arrays.sort(a); 	
	}
}
