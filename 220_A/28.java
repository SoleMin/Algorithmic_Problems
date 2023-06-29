import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class c {
    class IO {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st;
        Random rnd = new Random();;
        String nextToken() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = in.readLine();
                if (line == null)
                    return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }
        long nextLong() throws IOException {
            return Long.parseLong(nextToken());
        }
        double nextDouble() throws IOException {
            return Double.parseDouble(nextToken());
        }
    }
    
    void run() throws IOException{
        IO read=new IO();
        int n=read.nextInt();
        int a[]=new int[n],b[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=b[i]=read.nextInt();
        Arrays.sort(b);
        int cnt=0;
        for(int i=0;i<n;i++)
            if(a[i]!=b[i])
                cnt++;
        if(cnt==0||cnt==2)
            read.out.println("YES");
        else
            read.out.println("NO");
        read.out.close();
    }
    public static void main(String[] args) throws IOException {
        new c().run();
    }
}
