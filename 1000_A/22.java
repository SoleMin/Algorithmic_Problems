import java.io.*;
import java.util.*;
public class A {
    public static void main(String[] args)throws Throwable {
        MyScanner sc=new MyScanner();
        PrintWriter pw=new PrintWriter(System.out);

        int n=sc.nextInt();

        String [] s={"M","L","S","XL","XS","XXL","XXS","XXXL","XXXS"};
        int [] cnt=new int [9];
        for(int i=0;i<n;i++){
            String t=sc.next();
            for(int j=0;j<9;j++)
                if(t.equals(s[j]))
                    cnt[j]++;
        }
        for(int i=0;i<n;i++){
            String t=sc.next();
            for(int j=0;j<9;j++)
                if(t.equals(s[j]))
                    cnt[j]--;
        }
        for(int i=0;i<9;i++)
            cnt[i]=Math.abs(cnt[i]);
        int ans=0;
        for(int i=0;i<9;i++)
            ans+=cnt[i];
        pw.println(ans/2);
        pw.flush();
        pw.close();
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {while (st == null || !st.hasMoreElements()) {
            try {st = new StringTokenizer(br.readLine());}
            catch (IOException e) {e.printStackTrace();}}
            return st.nextToken();}
        int nextInt() {return Integer.parseInt(next());}
        long nextLong() {return Long.parseLong(next());}
        double nextDouble() {return Double.parseDouble(next());}
        String nextLine(){String str = "";
            try {str = br.readLine();}
            catch (IOException e) {e.printStackTrace();}
            return str;}
    }
}