import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Codeforces {


    static long MOD = 1_000_000_007L;

    static void main2() throws Exception {
        int n = ni();
        int[] arr = nia(n);
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>(); 
        for(int r = 0; r < n; r++) {
            int sum = 0;
            for(int l = r; l >= 0; l--) {
                sum += arr[l];
                if(!map.containsKey(sum)) map.put(sum, new ArrayList<Pair<Integer, Integer>>());
                map.get(sum).add(new Pair<Integer, Integer>(l + 1, r + 1));
            }
        }
        int bestSum = Integer.MIN_VALUE;
        int bestSumCount = -1;
        for(Map.Entry<Integer, List<Pair<Integer, Integer>>> entry : map.entrySet()) {
            int count = 0;
            int r = -1;
            for(Pair<Integer, Integer> pair : entry.getValue()) {
                if(r < pair.first) {
                    count++;
                    r = pair.second;
                }
            }
            if(count > bestSumCount) {
                bestSumCount = count;
                bestSum = entry.getKey();
            }
        }
        //got best sum
        println(bestSumCount);
        int r = -1;
        for(Pair<Integer, Integer> pair : map.get(bestSum)) {
            if(r < pair.first) {
                println(pair.first + " " + pair.second);
                r = pair.second;
            }  
        }
    }

    // ____________________________________________________________________________
    //|                                                                            |
    //|  /$$$$$$  /$$$$$$         /$$$$$$   /$$                /$$$$$$   /$$$$$$   |
    //| |_  $$_/ /$$__  $$       /$$__  $$ | $$               /$$__  $$ /$$__  $$  |
    //|   | $$  | $$  \ $$      | $$  \__//$$$$$$   /$$   /$$| $$  \__/| $$  \__/  |
    //|   | $$  | $$  | $$      |  $$$$$$|_  $$_/  | $$  | $$| $$$$    | $$$$      |
    //|   | $$  | $$  | $$       \____  $$ | $$    | $$  | $$| $$_/    | $$_/      |
    //|   | $$  | $$  | $$       /$$  \ $$ | $$ /$$| $$  | $$| $$      | $$        |
    //|  /$$$$$$|  $$$$$$/      |  $$$$$$/ |  $$$$/|  $$$$$$/| $$      | $$        |
    //| |______/ \______/        \______/   \___/   \______/ |__/      |__/        |
    //|____________________________________________________________________________|



    private static byte[] scannerByteBuffer = new byte[1024]; // Buffer of Bytes
    private static int scannerIndex;
    private static InputStream scannerIn;
    private static int scannerTotal;
    private static BufferedWriter printerBW;
    private static boolean DEBUG = false;

    private static int next() throws IOException { // Scan method used to scan buf
        if (scannerTotal < 0)
            throw new InputMismatchException();
        if (scannerIndex >= scannerTotal) {
            scannerIndex = 0;
            scannerTotal = scannerIn.read(scannerByteBuffer);
            if (scannerTotal <= 0)
                return -1;
        }
        return scannerByteBuffer[scannerIndex++];
    }

    static int ni() throws IOException {
        int integer = 0;
        int n = next();
        while (isWhiteSpace(n)) // Removing startPointing whitespaces
            n = next();
        int neg = 1;
        if (n == '-') { // If Negative Sign encounters
            neg = -1;
            n = next();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += n - '0';
                n = next();
            } else
                throw new InputMismatchException();
        }
        return neg * integer;
    }

    static long nl() throws IOException {
        long integer = 0;
        int n = next();
        while (isWhiteSpace(n)) // Removing startPointing whitespaces
            n = next();
        int neg = 1;
        if (n == '-') { // If Negative Sign encounters
            neg = -1;
            n = next();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += n - '0';
                n = next();
            } else
                throw new InputMismatchException();
        }
        return neg * integer;
    }

    static String line() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = next();
        while (isWhiteSpace(n))
            n = next();
        while (!isNewLine(n)) {
            sb.append((char) n);
            n = next();
        }
        return sb.toString();
    }

    private static boolean isNewLine(int n) {
        return n == '\n' || n == '\r' || n == -1;
    }

    private static boolean isWhiteSpace(int n) {
        return n == ' ' || isNewLine(n) || n == '\t';
    }

    static int[] nia(int n) throws Exception {
        if (n < 0)
            throw new Exception("Array size should be non negative");
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = ni();
        return array;
    }

    static int[][] n2dia(int r, int c) throws Exception {
        if (r < 0 || c < 0)
            throw new Exception("Array size should be non negative");
        int[][] array = new int[r][c];
        for (int i = 0; i < r; i++)
            array[i] = nia(c);
        return array;
    }

    static long[] nla(int n) throws Exception {
        if (n < 0)
            throw new Exception("Array size should be non negative");
        long[] array = new long[n];
        for (int i = 0; i < n; i++)
            array[i] = nl();
        return array;
    }

    static float[] nfa(int n) throws Exception {
        if (n < 0)
            throw new Exception("Array size should be non negative");
        float[] array = new float[n];
        for (int i = 0; i < n; i++)
            array[i] = nl();
        return array;
    }

    static double[] nda(int n) throws Exception {
        if (n < 0)
            throw new Exception("Array size should be non negative");
        double[] array = new double[n];
        for (int i = 0; i < n; i++)
            array[i] = nl();
        return array;
    }

    static <T> void print(T ... str) {
        try {
            for(T ele : str) 
                printerBW.append(ele.toString());
            if (DEBUG)
                flush();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    static <T> void println(T ... str) {
        if(str.length == 0) {
            print('\n');
            return;
        }
        for(T ele : str)
            print(ele, '\n');
    }

    static void flush() throws IOException {
        printerBW.flush();
    }

    static void close() {
        try {
            printerBW.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        long startPointTime = System.currentTimeMillis();
        scannerIn = System.in;
        printerBW = new BufferedWriter(new OutputStreamWriter(System.out));
        if (args.length > 0 && args[0].equalsIgnoreCase("debug")
                || args.length > 1 && args[1].equalsIgnoreCase("debug"))
            DEBUG = true;

        main2();
        long endTime = System.currentTimeMillis();
        float totalProgramTime = endTime - startPointTime;
        if (args.length > 0 && args[0].equalsIgnoreCase("time") || args.length > 1 && args[1].equalsIgnoreCase("time"))
            print("Execution time is " + totalProgramTime + " (" + (totalProgramTime / 1000) + "s)");
        close();
    }

    static class Pair <L, R> {
        L first;
        R second;

        Pair(L first, R second) {
            this.first = first;
            this.second = second;
        }

        public boolean equals(Object p2) {
            if (p2 instanceof Pair) {
                return ((Pair) p2).first.equals(first) && ((Pair) p2).second.equals(second);
            }
            return false;
        }

        public String toString() {
            return "(first=" + first.toString() + ",second=" + second.toString() + ")";
        }
    }

    static class DisjointSet {
        int[] arr;
        int[] size;

        DisjointSet(int n) {
            arr = new int[n + 1];
            size = new int[n + 1];
            makeSet();
        }

        void makeSet() {
            for (int i = 1; i < arr.length; i++) {
                arr[i] = i;
                size[i] = 1;
            }
        }

        void union(int i, int j) {
            if (i == j)
                return;
            if (i > j) {
                i ^= j;
                j ^= i;
                i ^= j;
            }

            i = find(i);
            j = find(j);

            if (i == j)
                return;
            arr[j] = arr[i];
            size[i] += size[j];
            size[j] = size[i];
        }

        int find(int i) {
            if (arr[i] != i) {
                arr[i] = find(arr[i]);
                size[i] = size[arr[i]];
            }
            return arr[i];
        }

        int getSize(int i) {
            i = find(i);
            return size[i];
        }

        public String toString() {
            return Arrays.toString(arr);
        }
    }

    static boolean isSqrt(double a) {
        double sr = Math.sqrt(a);
        return ((sr - Math.floor(sr)) == 0);
    }

    static long abs(long a) {
        return Math.abs(a);
    }

    static int min(int ... arr) {
        int min = Integer.MAX_VALUE;
        for (int var : arr)
            min = Math.min(min, var);
        return min;
    }

    static long min(long ... arr) {
        long min = Long.MAX_VALUE;
        for (long var : arr)
            min = Math.min(min, var);
        return min;
    }

    static int max(int... arr) {
        int max = Integer.MIN_VALUE;
        for (int var : arr)
            max = Math.max(max, var);
        return max;
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}