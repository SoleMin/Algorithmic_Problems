/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wilso
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class codeforces {
    static final long MOD2 = 998_244_353;
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
       
        int tc = sc.ni();
//        int tc = 1;
        for (int rep = 0; rep < tc; rep++) {
            int N = sc.ni();
            int[] arr = sc.intArray(N);
            pw.println(solve(arr));
        }
        
        pw.close();
    }
 
    
    static String solve(int[] arr) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList();
        list.add(0);
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            for (int j = list.size() - 1; j >= 0; j--) {
                if (x - 1 == list.get(j)) {
                    list.set(j, x);
                    while (list.size() > j+1) {
                        list.remove(list.size() - 1);
                    }
                    list.add(0);
                    
                    //append
                    for (int idx = 0; idx < list.size() - 1; idx++) {
                        sb.append(list.get(idx) + ".");
                    }
                    sb.setLength(sb.length() - 1);
                    sb.append("\n");
                    break;
                }
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
   
    static int summation(int x) {
        return x * (x+1) / 2;
    }  
    static long pow(long num, long exp, long mod){
        long ans=1;
        for(int i=1;i<=exp;i++){
            ans=(ans*num)%mod;
        }
        return ans;
    }
    static boolean isPrime(int n)
    {
 
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
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
    static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
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
    static int charint(char c) {
        return Integer.parseInt(String.valueOf(c));
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

class MultiSet {
    TreeMap<Long, Integer> map = new TreeMap<>();
    private int size = 0;
    public MultiSet() {
    }
    public void add(Long val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        size++;
    }
    public void remove(Long val) {
        map.put(val, map.get(val) - 1);
        if (map.get(val) == 0) {
            map.remove(val);
        }
        size--;
    }
    public int size() {
        return size;
    }
    public Long higher(Long val) {
        return map.higherKey(val);
    }
    public Long lower(Long val) {
        return map.lowerKey(val);
    }
    public Long ceiling(Long val) {
        return map.ceilingKey(val);
    }
    public Long floor(Long val) {
        return map.floorKey(val);
    }
    public Long first() {
        return map.firstKey();
    }
    public Long last() {
        return map.lastKey();
    }
    public boolean isEmpty() {
        return map.isEmpty();
    }
}
