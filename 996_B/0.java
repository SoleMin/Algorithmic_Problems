//============================================================================
/*				"There is nothing that can take the pain away.
      But eventually you will find a way to live with it.
				There will be nightmares.
	  And every day when you wake up, it will be the first thing you think about.
				Until one day, it will be the second thing."
*/
// Author      : Murad
// Online Judge: Codeforces.cpp & Atcoder.cpp
// Description : Problem name
//============================================================================
/* Riven && Vladimir && Ekko */
import java.io.*;
import java.lang.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static boolean Prime(long x){
        if(x==2)return true;
        else if(x%2==0 ||x<2)return false;
        for(int i=3;i*i<=x;i+=2){
            if(x%i==0)return false;
        }
        return true;
    }
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solver = new Solution();
        solver.solv(1,in,out);
        out.close();
    }
    static class Solution{
        public void solv(int testnumber,InputReader in,PrintWriter out){
            int n=in.nextInt();
            int vladi[]=new int[n];
            for(int idx=0;idx<n;idx++)vladi[idx]=in.nextInt();
            int ans=0,move=0;
            int i=0;
            while(true){
                if(i>=n)i=0;
                if(vladi[i]-move<=0){
                    ans=i+1;
                    break;
                }
                i++;
                move++;
            }
            out.println(ans);
        }
    }
    static class Pair<C, I extends Number> implements Comparable<Pair<C, Number>> {
        long value;
        long idx;
        Pair(long v, long i)
        {
            value = v;
            idx = i;
        }

        @Override
        public int compareTo(Pair<C, Number> p) {
            return (int)(value - p.value);
        }
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong()
        {
            return Long.parseLong(next());
        }
        public double nextDouble()
        {
            return Double.parseDouble(next());
        }
        public String nextLine()
        {
            try
            {
                return reader.readLine();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
        public boolean hasNext()
        {
            String next=null;
            try
            {
                next=reader.readLine();
            }
            catch(Exception e)
            {
            }
            if(next==null)
            {
                return false;
            }
            tokenizer=new StringTokenizer(next);
            return true;
        }
    }
    static class NumberTheory{
        public static long gcd(long a,long b){
            long c;
            while (a != 0) {
                c = a;
                a = b % a;
                b = c;
            }
            return b;
        }
    }
    //Relatively Prime :- if diffrence between two number is equal to 1
}