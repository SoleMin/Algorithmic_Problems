import java.util.*;
import java.io.*;
import java.math.*;

/**
 *
 * @author rohan
 */
public class Main {

        static int mod = (int) (1e9+7);
        static int MAX = (int)2e5+5;
        static void solve() 
        {
                int n = i();
                String[] s = new String[n];
                for(int i = 0 ; i<n ; i++)
                {
                    s[i] = s();
                }
                int[][] dp = new int[n][n];
                dp[0][0] = 1;
                for(int i = 1; i<n; i++)
                {
                    if(s[i-1].equals("f"))
                    {
                        for (int j = i-1 ; j>=0 ; j--)
                        {
                            dp[i][j+1] = dp[i-1][j];
                        }
                    }
                    else
                    {
                        int suff = 0;
                        for(int j = i-1; j>=0 ; j--)
                        {
                            suff += dp[i-1][j];
                            if(suff>=mod) suff-= mod;
                            dp[i][j] = suff;
                        }
                    }
                }

                int sum = 0;
                for (int i=0 ; i<n; i++)
                {
                    sum = sum+dp[n-1][i];
                    if(sum>=mod)
                        sum-=mod;
                }
                out.println(sum);
                out.close();
        }
  

    ///////////////////////////////////////////////////////////////////
        static InputReader sc = new InputReader(System.in);
        static PrintWriter out = new PrintWriter(System.out); 
        public static void main(String[] args)
        {
                new Thread(null,new Runnable() {
                @Override
                public void run() {
                    try{
                        solve();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
                },"1",1<<26).start();
        }

        static class Pair implements Comparable<Pair>{
                int x,y,i;
                Pair (int x,int y,int i)
                {
                        this.x = x;
                        this.y = y;
                        this.i = i;
                }
                    
                Pair (int x,int y)
                {
                        this.x = x;
                        this.y = y;
                }
        
                public int compareTo(Pair o)
                {
                        return -(this.y-o.y);
                }               
                public boolean equals(Object o)
                {
                        if (o instanceof Pair) {
                            Pair p = (Pair)o;
                            return p.x == x && p.y==y;
                        }
                        return false;
                }

                @Override
                public String toString()
                {
                        return x + " "+ y + " "+i;
                }
        
                public int hashCode()
                {
                        return new Long(x).hashCode() * 31 + new Long(y).hashCode();
                }
        } 


        static class Merge 
        {

                public static void sort(int inputArr[]) 
                {
                        int length = inputArr.length;
                        doMergeSort(inputArr,0, length - 1);
                }

                private static void doMergeSort(int[] arr,int lowerIndex, int higherIndex) {        
                        if (lowerIndex < higherIndex) {
                            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
                            doMergeSort(arr,lowerIndex, middle);
                            doMergeSort(arr,middle + 1, higherIndex);
                            mergeParts(arr,lowerIndex, middle, higherIndex);
                        }
                }

                private static void mergeParts(int[]array,int lowerIndex, int middle, int higherIndex)
                {
                        int[] temp=new int[higherIndex-lowerIndex+1];
                        for (int i = lowerIndex; i <= higherIndex; i++) {
                                temp[i-lowerIndex] = array[i];
                        }
                        int i = lowerIndex;
                        int j = middle + 1;
                        int k = lowerIndex;
                        while (i <= middle && j <= higherIndex) {
                                if (temp[i-lowerIndex] < temp[j-lowerIndex])
                                {
                                        array[k] = temp[i-lowerIndex];
                                        i++;
                                } 
                                else
                                {
                                        array[k] = temp[j-lowerIndex];
                                        j++;
                                }
                                k++;
                        }
                        while (i <= middle) {
                                array[k] = temp[i-lowerIndex];
                                k++;
                                i++;
                        }
                        while(j<=higherIndex){
                                array[k]=temp[j-lowerIndex];
                                k++;
                                j++;
                        }
                }
        }

        static long add(long a,long b){
                long x=(a+b);
                while(x>=mod) x-=mod;
                return x;
        }

        static long sub(long a,long b){
                long x=(a-b);
                while(x<0) x+=mod;
                return x;
        }

        static long mul(long a,long b){
                a%=mod;
                b%=mod;
                long x=(a*b);
                return x%mod;
        }


        static boolean isPal(String s){
                for(int i=0, j=s.length()-1;i<=j;i++,j--){
                        if(s.charAt(i)!=s.charAt(j)) return false;
                }
                return true;
        }
        static String rev(String s){
                StringBuilder sb=new StringBuilder(s);
                sb.reverse();
                return sb.toString();
        }

        static long gcd(long x,long y){
                if(y==0)
                        return x;
                else
                        return gcd(y,x%y);
        }

        static int gcd(int x,int y){
                if(y==0)
                        return x;
                else 
                        return gcd(y,x%y);
        }

        static long gcdExtended(long a,long b,long[] x){
                if(a==0){
                        x[0]=0;
                        x[1]=1;
                        return b;
                }
                long[] y=new long[2];
                long gcd=gcdExtended(b%a, a, y);
                x[0]=y[1]-(b/a)*y[0];
                x[1]=y[0];
                return gcd;
        }


        static long mulmod(long  a,long b,long m) {
                if (m <= 1000000009) return a * b % m;

                long res = 0;
                while (a > 0)
                {
                        if ((a&1)!=0)
                        {
                                res += b;
                                if (res >= m) res -= m;
                        }
                        a >>= 1;
                        b <<= 1;
                        if (b >= m) b -= m;
                }
                return res;
        }

        static int abs(int a,int b){
                return (int)Math.abs(a-b);
        }

        public static long abs(long a,long b){
                return (long)Math.abs(a-b);
        }

        static long pow(long n,long p){
                long  result = 1;
                if(p==0)
                        return 1;

                while(p!=0)
                {
                        if(p%2==1)
                                result *= n;        
                        p >>=1;
                        n*=n;       
                }
                return result;
        }

        static void debug(Object... o) {
                System.out.println(Arrays.deepToString(o));
        }

        static class InputReader 
        {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
                this.stream = stream;
        }

        public int snext() {
                if (snumChars == -1)
                        throw new InputMismatchException();
                if (curChar >= snumChars) {
                        curChar = 0;
                        try {
                                snumChars = stream.read(buf);
                        } catch (IOException e) {
                                throw new InputMismatchException();
                        }
                        if (snumChars <= 0)
                                return -1;
                }
                return buf[curChar++];
        }

        public int nextInt() {
                int c = snext();
                while (isSpaceChar(c)) {
                        c = snext();
                }
                int sgn = 1;
                if (c == '-') {
                        sgn = -1;
                        c = snext();
                }
                int res = 0;
                do {
                        if (c < '0' || c > '9')
                                throw new InputMismatchException();
                        res *= 10;
                        res += c - '0';
                        c = snext();
                } while (!isSpaceChar(c));
                return res * sgn;
        }

        public long nextLong() {
                int c = snext();
                while (isSpaceChar(c)) {
                        c = snext();
                }
                int sgn = 1;
                if (c == '-') {
                        sgn = -1;
                        c = snext();
                }
                long res = 0;
                do {
                        if (c < '0' || c > '9')
                                throw new InputMismatchException();
                        res *= 10;
                        res += c - '0';
                        c = snext();
                } while (!isSpaceChar(c));
                return res * sgn;
        }

        public int[] nextIntArray(int n) {
                int a[] = new int[n];
                for (int i = 0; i < n; i++) {
                        a[i] = nextInt();
                }
                return a;
        }

        public long[] nextLongArray(int n) {
                long a[] = new long[n];
                for (int i = 0; i < n; i++) {
                        a[i] = nextLong();
                }
                return a;
        }

        
        public String nextLine() {
                int c = snext();
                while (isSpaceChar(c))
                        c = snext();
                StringBuilder res = new StringBuilder();
                do {
                        res.appendCodePoint(c);
                        c = snext();
                } while (!isEndOfLine(c));
                return res.toString();
        }

        public boolean isSpaceChar(int c) {
                if (filter != null)
                        return filter.isSpaceChar(c);
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
                return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
                public boolean isSpaceChar(int ch);
        }

    }
    static int i()
    {
        return sc.nextInt();
    }
    static long l(){
        return sc.nextLong();
    }
    static int[] iarr(int n)
    {
        return sc.nextIntArray(n);
    }
    static long[] larr(int n)
    {
        return sc.nextLongArray(n);
    }
    static String s(){
        return sc.nextLine();
    }
} 