import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        FastScanner sc=new FastScanner();
        PrintWriter pw=new PrintWriter(System.out);
        double eps=1e-12;
        while(sc.hasNext()){
            int n=sc.nextInt();
            int r=sc.nextInt();
            double[]shu=new double[n];
            for(int i=0;i<n;i++)shu[i]=sc.nextDouble();
            double[]res=new double[n];
            for(int i=0;i<n;i++){
                for(int j=0;j<i;j++){
                    double temp=Math.abs(shu[i]-shu[j]);
                    if(temp<2*r||Math.abs(temp-2*r)<eps){
                        res[i]=Math.max(res[i],res[j]+Math.sqrt(4*r*r-temp*temp));
                    }
                }
                res[i]=Math.max(res[i],r);
            }
            for(int i=0;i<n;i++){
                pw.print(res[i]+" ");
            }
            pw.flush();
        }
    }
}
class FastScanner{
    BufferedReader br;
    StringTokenizer st;
    FastScanner(){
        br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer("");
    }

    String nextLine(){
        String s="";
        try {
            s=br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
    boolean hasNext(){
        String s="";
        while(!st.hasMoreTokens()){
            s=nextLine();
            if(s==null)return false;
            st=new StringTokenizer(s);
        }
        return true;
    }
    String next(){
        String s="";
        while(!st.hasMoreTokens()){
            s=nextLine();
            st=new StringTokenizer(s);
        }
        return st.nextToken();
    }
    int nextInt(){
        return Integer.valueOf(next());
    }
    long nextLong(){
        return Long.valueOf(next());
    }
    double nextDouble(){
        return Double.valueOf(next());
    }
}

