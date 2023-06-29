import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {    
    static void deal(int n,int[] arr) {
        int[] a = new int[n];
        a[0] = 1;
        int l = 1;
        out.println(toString(a,l));
        for(int i=1;i<n;i++) {
            if(arr[i] == 1) {
                a[l] = 1;
                l++;
            } else {
                int index = l-1;
                while(index>=0 && a[index] != arr[i]-1) {
                    index--;
                }
                a[index]++;
                l = index+1;
            }
            out.println(toString(a,l));
        }
    }
    
    static String toString(int[] arr,int l) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<l-1;i++) {
            sb.append(arr[i]);
            sb.append('.');
        }
        sb.append(arr[l-1]);
        return sb.toString();
    }
    
	public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        for(int i=0;i<t;i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int j=0;j<n;j++) arr[j] = sc.nextInt();
            deal(n,arr);
        }
        out.close();
    }
    
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;
    
    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
        
        public MyScanner() {
                br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
                while (st == null || !st.hasMoreElements()) {
                        try {
                                st = new StringTokenizer(br.readLine());
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
                return st.nextToken();
        }
        
        int nextInt() {
                return Integer.parseInt(next());
        }
        
        long nextLong() {
                return Long.parseLong(next());
        }
        
        double nextDouble() {
                return Double.parseDouble(next());
        }
        
        String nextLine(){
                String str = "";
    try {
            str = br.readLine();
    } catch (IOException e) {
            e.printStackTrace();
    }
    return str;
        }
        
    }
}