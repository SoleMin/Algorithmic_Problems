import java.io.*;         
import java.util.*;         
import java.math.*;         
 
public class Main  implements Runnable {
//public static final String FileName = "test";
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;
static final int inf = 1000000000+10;
 
int nextInt() throws IOException{      
    ST.nextToken();      
    return (int)ST.nval;      
}
long nextLong() throws IOException{      
    ST.nextToken();      
    return (long)ST.nval;      
}      
String next() throws IOException{      
    ST.nextToken();      
    return ST.sval;      
}      
double nextD() throws IOException{      
    ST.nextToken();      
    return ST.nval;      
}      
public static void main(String[] args) throws IOException {       
   new Thread(new Main()).start();
//	new Main().run();
}
 
public void run()  {      
    try {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));    	
    	//br = new BufferedReader(new FileReader(new File(FileName+".in")));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(FileName+".out")));
    	//in = new Scanner(br);
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();
        //in.close();
        br.close();   
    }         
    catch (IOException e) {       
    	e.printStackTrace();
    	throw new IllegalStateException(e);  
    }      
}


public void solve() throws IOException {
	int[] x = new int[32];
	int[] y = new int[32];
	x[0] = nextInt();
	y[0] = nextInt();	
	int n = nextInt();
	for (int i=1; i<=n; i++) {
		x[i] = nextInt();
		y[i] = nextInt();
	}
	n++;
	int[][] a = new int[n][n];
	int[][] b = new int[n-1][n-1];
	for (int i=0; i<n; i++)
		for (int j=0; j<n; j++)
			a[i][j] = (x[i]-x[j])*(x[i]-x[j])+ (y[i]-y[j])*(y[i]-y[j]);
	for (int i=1; i<n; i++)
		for (int j=1; j<n; j++)
			if (i!=j) b[i-1][j-1] = a[0][i]+a[i][j]+a[j][0]; else b[i-1][j-1] = 2*a[0][i];
	n--;
	
	int sz = 1<<n;
	int[] d = new int[sz];
	int[] p = new int[sz];
	d[1] = 0;
	for (int msk=1; msk<sz; msk++) {
		int j = 0;
		while ((msk&(1<<j))==0) j++;
		int t = inf;		
		for (int i=0; i<n; i++)
			if ((msk&(1<<i))>0)
			if (t>d[msk^((1<<i)|(1<<j))]+b[i][j]) {
				t = d[msk^((1<<i)|(1<<j))]+b[i][j];
				p[msk] = i*n+j;
			}	
		d[msk] = t;
		
	}
	out.println(d[sz-1]);
	out.print("0 ");
	int t = sz-1;
	while (t>0) {
		int hz = p[t];
		int i = hz/n;
		int j = hz%n;
		if (i!=j) out.print((i+1)+" "+(j+1)+" 0 ");else out.print((i+1)+" 0 ");
		t ^= (1<<i)|(1<<j);
	}
	
}
  
}
 
 
  