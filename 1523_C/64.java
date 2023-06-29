import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class Main{
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
        long[] nextArray(long n) {
            long[] a = new long[(int) n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
    static class FastWriter extends PrintWriter {
        FastWriter(){
            super(System.out);
        }
        void println(int[] array) {
            for(int i=0; i<array.length; i++) {
                print(array[i]+" ");
            }
            println();
        }
        void println(long [] array) {
            for(int i=0; i<array.length; i++) {
                print(array[i]+" ");
            }
            println();
        }
    }
    static class Interval {
        long start,end;
        Interval(long start, long end)
        {
            this.start=start;
            this.end=end;
        }
    }
    static int MOD=998244353;
    public static void main(String[] args){
        FastScanner in = new FastScanner();
        FastWriter out = new FastWriter();
        Scanner sc=new Scanner(System.in);
        int t=in.nextInt();
        //int t=1;
        while (t-->0){
            int n=in.nextInt();
            int[] ar=in.nextArray(n);
            int[] level=new int[1005];
            int j=1;
            level[1]=1;
            out.println(1);
            for (int i = 1; i < n; i++) {
                if(ar[i]==1) {
                    j++;
                    level[j] = 1;
                }else {
                    while (j>=1){
                        if(level[j]+1!=ar[i]){
                            j--;
                        }else {
                            break;
                        }
                    }
                    level[j]++;
                }
                for (int k = 1; k <= j; k++) {
                    if(k==j){
                        out.print(level[k]);
                    }else {
                        out.print(level[k]+".");
                    }
                }
                out.println();
            }
        }
        out.close();
    }
    static int highestPowerOf2(int n) {
        if (n < 1){ return 0; }
        int res = 1;
        for (int i = 0; i < 8 * Integer.BYTES; i++) {
            int curr = 1 << i;
            if (curr > n){ break; }
            res = curr;
        }
        return res;
    }
    static int reduceFraction(int x, int y) {
        int d= gcd(x, y);
        return x/d+y/d;
    }
    static boolean subset(int[] ar,int n,int sum){
        if(sum==0){
            return true;
        }
        if(n<0||sum<0){
            return false;
        }
        return subset(ar,n-1,sum)||subset(ar,n-1,sum-ar[n]);
    }
    static boolean isPrime(int n){
        if(n<=1) return false;
        for(int i = 2;i<=Math.sqrt(n);i++){
            if (n % i == 0) return false;
        }
        return true;
    }
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    static boolean isPowerOfTwo(int n) {
        if(n==0||n==1){return false;}
        double v = Math.log(n) / Math.log(2);
        return ((int)(Math.ceil(v)) == (int)(Math.floor(v)));
    }
    static boolean isPerfectSquare(int x){
        if (x >= 0) {
            int sr = (int)Math.sqrt(x);
            return ((sr * sr) == x);
        }
        return false;
    }
    static int lower_bound(int[] arr, int x) {
        int low_limit = 0, high_limit = arr.length, mid = -1;
        while (low_limit < high_limit) {
            mid = (low_limit + high_limit) / 2;
            if (arr[mid] >= x){
                high_limit = mid;
            }else{
                low_limit = mid + 1;
            }
        }
        return low_limit;
    }
    static int upper_bound(int[] arr, int x) {
        int low_limit = 0, high_limit = arr.length, mid = -1;
        while (low_limit < high_limit) {
            mid = (low_limit + high_limit) / 2;
            if (arr[mid] > x){
                high_limit = mid;
            }else{
                low_limit = mid + 1;
            }
        }
        return low_limit;
    }
    static int binarySearch(int[] ar,int n,int num){
        int low=0,high=n-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(ar[mid]==num){
                return mid;
            }else if(ar[mid]>num){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return -1;
    }
}