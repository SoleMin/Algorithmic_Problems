import java.io.*;         
import java.util.*;         
import java.math.*;         

 
public class Main  implements Runnable {
//public static final String FileName = "test";
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
Scanner in;
static final int inf = 1000000000;
 
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
//  new Main().run();
}
 
public void run()  {      
    try {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));      
        //br = new BufferedReader(new FileReader(new File(FileName+".in")));
        //out = new PrintWriter(new BufferedWriter(new FileWriter(FileName+".out")));
        in = new Scanner(br);
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
    int n = nextInt();
    int K = nextInt();
    boolean[] f = new boolean[n+1];
    Arrays.fill(f, true);
    Vector<Integer> P = new Vector<Integer>();
    for (int i=2; i<=n; i++)
        if (f[i]) {
            for (int j=2*i; j<=n; j+=i) 
                f[j] = false;
            P.add(i);
        }
    for (int i=0; i<P.size()-1; i++) {
        int x = P.elementAt(i)+P.elementAt(i+1)+1;
        if (x<=n && f[x]) K--;
    }
    if (K<=0) out.println("YES"); else out.println("NO");
    //for (int x:P) out.print(x+" ");
    
}
  
}
















 
 
  