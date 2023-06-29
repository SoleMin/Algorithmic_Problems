import java.io.*;
import java.util.*;
import java.math.*;

public class Main  {
    
    Scanner in;
    PrintWriter out;
    
    static class House implements Comparable <House>{
        int len;
        int pos;
        
        House(Scanner in){
            pos = in.nextInt() * 2;
            len = in.nextInt() * 2;         
        }
        
        public int compareTo(House arg0) {
            return this.pos-arg0.pos;
        }
        
    }
            
    void solve(){
        int n = in.nextInt();
        int size = in.nextInt();
        House []h = new House[n];
        for (int i = 0; i < h.length; i++){
            h[i] = new House(in);
        }
        Arrays.sort(h);
        int ans = 2;
        for (int i = 0; i < h.length - 1; i++){
            int next = i + 1;
            int sz = h[next].pos - h[i].pos - (h[next].len + h[i].len) / 2;
            if (sz == size * 2) {
                ans ++;
            } else if (sz > size * 2) {
                ans += 2;
            }
        }
        out.println(ans);
    }
    
    public void run(){
        in = new Scanner(System.in);
        out = new PrintWriter(System.out);
        
        try {
            solve();
        } finally {
            out.close();
        }
    }
    
    void asserT(boolean e){
        if (!e){
            throw new Error();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}