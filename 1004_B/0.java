import java.io.*;
import java.util.*;

public class B_Sonya_and_Exhibition{
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception{
        int[] nm = in.readA();
        int n = nm[0], m = nm[1];
        int[][] people = new int[m][2];
        for(int i = 0; i < m; i++){
            // if(i < m-1)   
                people[i] = in.readA();
            // else 
            //     people[i] = new int[]{1, n};
            people[i][0]--;
            people[i][1]--;
        }
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return -((a[1]-a[0]) - (b[1]-b[0]));
            }
        });
        char[] row = new char[n];
        for(int i = 0; i < n; i++){
            row[i] = (char)(i%2 + '0');
        }
        System.out.println(new String(row));
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