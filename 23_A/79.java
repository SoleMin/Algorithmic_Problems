import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class CF23A implements Runnable{
        
    public static void main(String args[]){
       new CF23A().run();
    }
    
    @Override
    public void run(){
        try{
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            tok = null;
            solve();
            in.close();
            out.close();
            
        }
        catch(IOException e){
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    int nextInt()throws IOException{
        return Integer.parseInt(nextToken());
    } 
    
    double nextDouble()throws IOException{
        return Double.parseDouble(nextToken());
    }
    
    long nextLong() throws IOException{
        return Long.parseLong(nextToken());
    }
    
    String nextToken()throws IOException{
        while(tok == null || !tok.hasMoreTokens()){
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }
    
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok;
    //////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////
    private void solve()throws IOException{
        String s = nextToken();
        int l = s.length();
        int ans = 0;
        for(int i = 0; i < l - 1; i++){
            for(int j = i + 1; j < l; j++){
                String now = s.substring(i, j);
                if(s.substring(i + 1).indexOf(now) >= 0){
                ans = Math.max(ans, j - i);
                
            }
            }
        }
        
        out.println(ans);
    }
}
