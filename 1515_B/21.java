
import java.io.*;
import java.util.*;


public class codeforces2 {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
//        Scanner scan = new Scanner(System.in);
//for (int i = 1; i <= 10; i++) {
//    System.out.println(i + " " + divisors(i).toString());
//}   
        int tc = sc.ni();
        for (int rep = 0; rep < tc; rep++) {
            long n = sc.nl();
            if (n % 2 == 1) {
                pw.println("NO");
            }
            else {
                n/= 2;
                if (perfectSquare(n)) {
                    pw.println("YES");
                }
                else if (n % 2 == 0 && perfectSquare(n/2)) {
                    pw.println("YES");
                }
                else {
                    pw.println("NO");
                }
            }
        }
        pw.close();
    }
    //precondition: n <= m
    public static boolean solve(int n,int m, int k) {
        return false;
    }
    public static boolean perfectSquare(long n) {
        long lo = 0;
        long hi = n;
        while (lo < hi) {
            long k = (lo + hi) / 2;
            if (k * k < n)
                lo = k + 1;
            else
                hi = k;
        }
        return (lo * lo == n);
    }
    static Set<Integer> divisors(int n) {
        Set<Integer> set = new HashSet();
        for (int i=1; i<=Math.sqrt(n); i++)
        {
            if (n%i==0)
            {
                // If divisors are equal, print only one
                if (n/i == i)
                    set.add(i);
      
                else {// Otherwise print both
                    set.add(i);
                    set.add(n / i);
                }
            }
        }
        return set;
    }
    static Map<Integer, Integer> primeFactorization(int x) {
        //first divide by 2
        Map<Integer, Integer> map = new HashMap();
        if (x == 0) return map;
        int count = 0;
        while (x % 2 == 0) {
            x /=2;
            count++;
        }
        //insert 2
        if (count > 0) map.put(2, count);
        for (int divisor = 3; divisor * divisor <= x; divisor += 2) {
            int cnt = 0;
            while (x % divisor == 0) {
                x /= divisor;
                cnt++;
            }
            if (cnt > 0) map.put(divisor, cnt);
        }
        if (x > 1) {
            map.put(x, 1);
        }
        return map;
    }
    static boolean isPrime(int n)
    {
 
        // Check if number is less than
        // equal to 1
        if (n <= 1)
            return false;
 
        // Check if number is 2
        else if (n == 2)
            return true;
 
        // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;
 
        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2) 
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b; 
        return gcd(b % a, a); 
    }
     
    // method to return LCM of two numbers
    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }
    public static void sort(int[] arr) {
        Random rgen = new Random();
        for (int i = 0; i < arr.length; i++) {
            int r = rgen.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }
        Arrays.sort(arr);
    }
 
    public static void sort(long[] arr) {
        Random rgen = new Random();
        for (int i = 0; i < arr.length; i++) {
            int r = rgen.nextInt(arr.length);
            long temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }
        Arrays.sort(arr);
    }
    /* */
    //printing methods
    /* */
    //WOW!
    /* */
    public static void printArr(PrintWriter pw, int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            sb.append(x + "");
        }
        sb.setLength(sb.length() - 1);
        pw.println(sb.toString());
    }
    public static void printArr2d(PrintWriter pw, int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : arr) {
            for (int x : row) {
                sb.append(x + " ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        pw.println(sb.toString());
    }
}
class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in), 32768);
        st = null;
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

    int ni() {
        return Integer.parseInt(next());
    }

    int[] intArray(int N) {
        int[] ret = new int[N];
        for (int i = 0; i < N; i++)
            ret[i] = ni();
        return ret;
    }

    long nl() {
        return Long.parseLong(next());
    }

    long[] longArray(int N) {
        long[] ret = new long[N];
        for (int i = 0; i < N; i++)
            ret[i] = nl();
        return ret;
    }

    double nd() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
class UnionFind {
    int size;
    private int[] id;
    public UnionFind(int size) {
        this.size = size;
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }
    public int find(int a) {
        if (id[a] != a) {
            id[a] = find(id[a]);
        }
        return id[a];
    }
    public void union(int a, int b) {
        int r1 = find(a);
        int r2 = find(b);
        if (r1 == r2) return;
        size--;
        id[r1] = r2;
    }
    @Override
    public String toString() {
        return Arrays.toString(id);
    }
}
