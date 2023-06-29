import java.io.*;
import java.util.*;

public class Solution{
    
    public static void main(String[] args) throws Exception{
        int N = in.readInt();
        int ans = 0;
        for(int i = 1; i <= N; i++){
            int layer = f(i,N);
            ans += layer;
            // System.out.println(i+"-> "+layer);
        }
        System.out.println(ans);
    }

    public static int f(int l, int N){
        int count = 0, max = N-l+1;
        // System.out.println("max="+max);
        for(int i = 0; i < l; i++){
            max -= (N-i)/(l);
            if(max >= 0)
                count++;
            if(max <= 0)
                break;
        }
        return count;
    }

    static Inputer in;
    static {
        in = new Inputer();
    }

    static class Inputer{
        BufferedReader br;
        Inputer(){
            try{
                br = new BufferedReader(new InputStreamReader(System.in));
            }
            catch(Exception e){}
        }
        public int readInt() throws Exception{
            return Integer.parseInt(readLine());
        }
        public long readLong() throws Exception{
            return Long.parseLong(readLine());
        }
        public int[] readA(String delim) throws Exception{
            String[] s = readLine().split(delim);
            int[] A = new int[s.length];
            for(int i = 0; i < s.length; i++)
                A[i] = Integer.parseInt(s[i]);
            return A;
        }
        public int[] readA() throws Exception{
            String[] s = readLine().split("\\s+");
            int[] A = new int[s.length];
            for(int i = 0; i < s.length; i++)
                A[i] = Integer.parseInt(s[i]);
            return A;
        }
        public long[] readLA() throws Exception{
            String[] s = readLine().split("\\s+");
            long[] A = new long[s.length];
            for(int i = 0; i < s.length; i++)
                A[i] = Long.parseLong(s[i]);
            return A;
        }
        public String readLine() throws Exception{
            return br.readLine();
        }
        public int[] copyA(int[] A){
            int[] B = new int[A.length];
            for(int i= 0 ; i < A.length; i++)
                B[i] = A[i];
            return B;
        }
    }
    static void shuffle(int[] A){
        int n = A.length;
        Random rand = new Random();
        for(int t = 0; t < A.length; t++){
            int i1 = rand.nextInt(n);
            int i2 = rand.nextInt(n);
            int tmp = A[i1];
            A[i1] = A[i2];
            A[i2] = tmp;
        }
    }
}