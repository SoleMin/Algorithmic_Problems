import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main { 
    public static StreamTokenizer in;
    public static PrintStream out;
    public static BufferedReader br;

    public static String readString() throws IOException {
        in.nextToken();
        return  in.sval;
        }

    public static double readDouble() throws IOException {
        in.nextToken();
        return in.nval;
        }

    public static int readInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
    
    public static String readLine() throws IOException {
    return br.readLine();
    }
    
    public static int genans(String ss) {
    	
    	int n = ss.length();
    	char[] s = ss.toCharArray();
    	int res = 0;
    	while (true) {
    		int firstT = -1;
    		for (int i=0; i<n; i++)
    			if (s[i]=='T') { firstT = i; break; }
    		
    		int lastH = -1;
    		for (int i=n-1; i>=0; i--)
    			if (s[i]=='H') { lastH=i; break; }
    		
    		if (firstT<lastH) {
    			res++;
    			s[firstT] = 'H';
    			s[lastH] = 'T';
    		} else break;
    		
    	}	
    	return res;
    }
    
    public static void main(String[] args) throws IOException {

        in = new StreamTokenizer(new InputStreamReader (System.in) );
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintStream(System.out);

        readLine();
        String s = readLine();
        int n = s.length();
        String kk = s;
        int ans = n*100;
        for (int tr=0; tr<n+2; tr++) {
        	String kk2 = "";
        	for (int i=1; i<n; i++) kk2 = kk2 +kk.charAt(i);
        	kk2 = kk2 + kk.charAt(0);
        	kk = kk2;
        
        int cur = genans(kk);
        //out.println(kk+" "+cur);
        if (cur<ans) ans = cur;
        }
        
        out.println(ans);

    }
    

}

