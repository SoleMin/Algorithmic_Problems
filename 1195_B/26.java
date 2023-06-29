import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;
 
public class Main {
    
    public static void main(String[] args) throws Exception{
        FastReader sc=new FastReader(); 
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        Main mm=new Main();
        long n=sc.nextLong();
        long k=sc.nextLong();
        long l=0;
        long r=1000000000;
        long ans=-1;
        while(l<=r) {
            long mid=(l+r)/2;
            if(n-mid<=0) {
                r=mid-1;
            }
            else {
                long temp=(n-mid)*(n-mid+1)-(2*mid);
                if(temp==2*k) {
                    ans=mid;
                    break;
                }
                else if(temp<2*k) {
                    r=mid-1;
                }
                else if(temp>2*k) {
                    l=mid+1;
                }
            }
        }
        System.out.println(ans);
    }  
}


class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 
 
    public FastReader() 
    { 
        br = new BufferedReader(new
                 InputStreamReader(System.in)); 
    } 
 
    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 
 
    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 
 
    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 
 
    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 
 
    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
} 