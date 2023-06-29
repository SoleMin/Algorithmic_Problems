import java.io.*;
import java.util.*;

/**
 __                  __
 ( _)                ( _)
 / / \\              / /\_\_
 / /   \\            / / | \ \
 / /     \\          / /  |\ \ \
 /  /   ,  \ ,       / /   /|  \ \
 /  /    |\_ /|      / /   / \   \_\
 /  /  |\/ _ '_| \   / /   /   \    \\
 |  /   |/  0 \0\    / |    |    \    \\
 |    |\|      \_\_ /  /    |     \    \\
 |  | |/    \.\ o\o)  /      \     |    \\
 \    |     /\\`v-v  /        |    |     \\
 | \/    /_| \\_|  /         |    | \    \\
 | |    /__/_ `-` /   _____  |    |  \    \\
 \|    [__]  \_/  |_________  \   |   \    ()
 /    [___] (    \         \  |\ |   |   //
 |    [___]                  |\| \|   /  |/
 /|    [____]                  \  |/\ / / ||
 (  \   [____ /     ) _\      \  \    \| | ||
 \  \  [_____|    / /     __/    \   / / //
 |   \ [_____/   / /        \    |   \/ //
 |   /  '----|   /=\____   _/    |   / //
 __ /  /        |  /   ___/  _/\    \  | ||
 (/-(/-\)       /   \  (/\/\)/  |    /  | /
 (/\/\)           /   /   //
 _________/   /    /
 \____________/    (


 @author NTUDragons-Reborn
 */

public class C{
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
    // main solver
    static class Task{

        double eps= 0.00000001;
        static final int MAXN = 10000001;

        // stores smallest prime factor for every number
        static int spf[] = new int[MAXN];

        Map<Integer,Set<Integer>> dp= new HashMap<>();

        // Calculating SPF (Smallest Prime Factor) for every
        // number till MAXN.
        // Time Complexity : O(nloglogn)
        public void sieve()
        {
            spf[1] = 1;
            for (int i=2; i<MAXN; i++)

                // marking smallest prime factor for every
                // number to be itself.
                spf[i] = i;

            // separately marking spf for every even
            // number as 2
            for (int i=4; i<MAXN; i+=2)
                spf[i] = 2;

            for (int i=3; i*i<MAXN; i++)
            {
                // checking if i is prime
                if (spf[i] == i)
                {
                    // marking SPF for all numbers divisible by i
                    for (int j=i*i; j<MAXN; j+=i)

                        // marking spf[j] if it is not
                        // previously marked
                        if (spf[j]==j)
                            spf[j] = i;
                }
            }
        }

        // A O(log n) function returning primefactorization
        // by dividing by smallest prime factor at every step
        public Set<Integer> getFactorization(int x)
        {
            if(dp.containsKey(x)) return dp.get(x);
            Set<Integer> ret = new HashSet<>();
            while (x != 1)
            {
                if(spf[x]!=2) ret.add(spf[x]);
                x = x / spf[x];
            }
            dp.put(x,ret);
            return ret;
        }
        // function to find first index >= x
        public int lowerIndex(List<Integer> arr, int n, int x)
        {
            int l = 0, h = n - 1;
            while (l <= h)
            {
                int mid = (l + h) / 2;
                if (arr.get(mid) >= x)
                    h = mid - 1;
                else
                    l = mid + 1;
            }
            return l;
        }

        // function to find last index <= y
        public int upperIndex(List<Integer> arr, int n, int y)
        {
            int l = 0, h = n - 1;
            while (l <= h)
            {
                int mid = (l + h) / 2;
                if (arr.get(mid) <= y)
                    l = mid + 1;
                else
                    h = mid - 1;
            }
            return h;
        }

        // function to count elements within given range
        public int countInRange(List<Integer> arr, int n, int x, int y)
        {
            // initialize result
            int count = 0;
            count = upperIndex(arr, n, y) -
                    lowerIndex(arr, n, x) + 1;
            return count;
        }
        InputReader in;
        PrintWriter out;
        public void solve(InputReader in, PrintWriter out) {
            this.in=in;
            this.out=out;
            int t=in.nextInt();
            while(t-->0){
                int n= in.nextInt();
                int[] arr= new int[n];
                for(int i=0;i<n;i++) arr[i]= in.nextInt();
                int[] cur= new int[n];
                int idx=0;
                for(int num: arr){
                    if(idx<n && num==cur[idx]+1){
                        cur[idx]=num;
                        printRes(cur, idx);
                        idx++;
                    }
                    else{
                        for(int i=idx;i>=0;i--){
                            if(i<n && num!=cur[i]+1) cur[i]=0;
                            else{
                                cur[i]=num;
                                printRes(cur,i);
                                i++;
                                idx=i;
                                break;
                            }
                        }
                    }

                }
            }
        }

        public void printRes(int[] cur, int idx){
            for(int i=0;i<idx;i++) out.print(cur[i]+".");
            out.println(cur[idx]);
        }

        public boolean ok(char[] s){
            boolean allEqual = true;
            boolean Alternate = true;
            for (int i = 0; i < s.length - 1; i++){
                if (s[i]!=s[i+1]){
                    allEqual = false;
                }
                else{
                    Alternate = false;
                }
            }
            if (s[0] == '0' || s[s.length-1] == '0'){
                return false;
            }
            return allEqual || Alternate;
        }

        // private int cal()
        public static boolean nextPermutation(char[] array){
            boolean hasNext = false;
            int i;
            for(i = array.length-2; i >= 0; i--){
                if(array[i] < array[i+1]){
                    hasNext = true;
                    break;
                }
            }
             
            if(!hasNext){// If all elements are arranged from largest to smallest, it means the largest string
                return false;
            }
             
            // Find backward from the subscript of i + 1 (must be monotonically decreasing), find a smallest element in the set larger than array [i]
            int j;
            for(j = i+1; j < array.length; j++){
                if(array[j] <= array[i]){
                    break;
                }
            }
            j--;
             
            // Swap these two elements, and then reverse all the elements in i + 1 and later (i + 1, array.length)
            swap(array, i, j);
            reverse(array, i+1, array.length);
       
            return true;
        }
        public static void swap(char[] array, int i, int j) {
            char temp =array[i];
            array[i] = array[j];
            array[j] =temp;	
        }
        public static void reverse(char[] array, int start, int end){
            for(int i = start, j = end-1; i < j; i++, j--) {
                swap(array, i, j);
            }
        }

        public static class compareL implements Comparator<Tuple>{
            @Override
            public int compare(Tuple t1, Tuple t2) {
                return t2.l - t1.l;
            }
        }
        public static class compareR implements Comparator<Tuple>{
            @Override
            public int compare(Tuple t1, Tuple t2) {
                return t1.r - t2.r;
            }
        }
        public static class Tuple{
            public int l, r, w;
            public Tuple(int l, int r,int w){
                this.l = l; this.r= r;
                this.w =w;
            }
        }
        public static class Range implements Comparable<Range>{
            public int l, r;
            List<Integer> data;
            int weight;
            public Range(int l, int r, List<Integer> data){
                this.data = data;
                this.l = l; this.r =r;
                this.weight = (int)1e9;
            }

            @Override
            public int compareTo(Range o) {
                return this.l - o.l;
            }
        }
        public int _gcd(int a,  int  b)
        {

            if(b == 0) {
                return a;
            }
            else {
                return _gcd(b, a % b);
            }
        }

    }

    static class Tuple implements Comparable<Tuple>{
        int x, y, z;
        public Tuple(int x, int y, int z){
            this.x= x;
            this.y= y;
            this.z=z;
        }
        @Override
        public int compareTo(Tuple o){
            return this.x-o.x;
        }
    }

    static class Pair implements Comparable<Pair>{
        public int x;
        public int y;
        public Pair(int x, int y){
            this.x= x;
            this.y= y;
        }

        @Override
        public int compareTo(Pair o) {
            return this.x-o.x;
        }
    }
    // fast input reader class;
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
        public double nextDouble(){
            return Double.parseDouble(nextToken());
        }
        public long nextLong(){
            return Long.parseLong(nextToken());
        }
    }
}