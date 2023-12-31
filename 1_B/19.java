import java.io.*;         
import java.util.*;         
import java.math.*;         
import java.awt.geom.*;         
import java.util.regex.*;
public class Main implements Runnable  {
StreamTokenizer ST;      
PrintWriter out;      
BufferedReader br;   
int inf = 1000000000;


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
}

public void run()  {      
    try {          
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        ST = new StreamTokenizer(br);      
        solve();      
        out.close();
        br.close();            
    }         
    catch (IOException e) {        
        throw new IllegalStateException(e);       
    }      
}


String code(int x) {
    x--;
    StringBuilder sb = new StringBuilder();
    while (x>0) {
        int c = x%26;
        if (x<10) sb.append((char)(c+'0')); else sb.append((char)('A'+c-10));
        x /= 26;
    }
    if (sb.length()==0) sb.append("0");
    return sb.toString();
}
StringBuilder sb = new StringBuilder();
public void solve() throws IOException {
    int tt = Integer.parseInt(br.readLine());
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (int i=1; i<=10; i++) map.put(code(i), i);

    while (tt-->0) {
        String s = br.readLine();
        if (s.matches("^[A-Z]+[0-9]+$")) {
            int t = 0;
            while (Character.isLetter(s.charAt(t))) t++;
            int r = Integer.parseInt(s.substring(t));
            s = s.substring(0, t);
            int res = 0;
            for (int c:s.toCharArray()) {
                res *= 26;
                res += c-'A'+1;
            }
            out.println("R"+r+"C"+res);
        } else {
            int t = s.indexOf('C');
            int c = Integer.parseInt(s.substring(1, t));
            int r = Integer.parseInt(s.substring(t+1));
            //out.println(r+" "+c);
            sb.setLength(0);
            while (r>0) {
                r--;
                int ch = r%26;
                sb.append((char)('A'+ch));
                r /= 26;
            }
            sb = sb.reverse();
            out.println(sb+""+c);
        }
        
    }
    
    
}
}






 



