import java.awt.Point;
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;



import static java.lang.Math.*;

public class Start {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void init() throws FileNotFoundException {
        if (ONLINE_JUDGE) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    public static void main(String[] args) {
        new Start().run();
        // Sworn to fight and die
    }

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int levtIndex, int rightIndex) {
        final int MAGIC_VALUE = 50;
        if (levtIndex < rightIndex) {
            if (rightIndex - levtIndex <= MAGIC_VALUE) {
                insertionSort(a, levtIndex, rightIndex);
            } else {
                int middleIndex = (levtIndex + rightIndex) / 2;
                mergeSort(a, levtIndex, middleIndex);
                mergeSort(a, middleIndex + 1, rightIndex);
                merge(a, levtIndex, middleIndex, rightIndex);
            }
        }
    }

    private static void merge(int[] a, int levtIndex, int middleIndex,
            int rightIndex) {
        int length1 = middleIndex - levtIndex + 1;
        int length2 = rightIndex - middleIndex;
        int[] levtArray = new int[length1];
        int[] rightArray = new int[length2];
        System.arraycopy(a, levtIndex, levtArray, 0, length1);
        System.arraycopy(a, middleIndex + 1, rightArray, 0, length2);
        for (int k = levtIndex, i = 0, j = 0; k <= rightIndex; k++) {
            if (i == length1) {
                a[k] = rightArray[j++];
            } else if (j == length2) {
                a[k] = levtArray[i++];
            } else {
                a[k] = levtArray[i] <= rightArray[j] ? levtArray[i++]
                        : rightArray[j++];
            }
        }
    }

    private static void insertionSort(int[] a, int levtIndex, int rightIndex) {
        for (int i = levtIndex + 1; i <= rightIndex; i++) {
            int current = a[i];
            int j = i - 1;
            while (j >= levtIndex && a[j] > current) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = current;
        }
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            init();
            solve();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    class LOL implements Comparable<LOL> {
        int x;
        int y;
        int num;

        public LOL(int x, int y,int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        @Override
        public int compareTo(LOL o) {
            return x - o.x; // ---->
            // return o.x - x; // <----
            // return o.y-y;
        }

    }
    
    
    
    public void solve() throws IOException {
    
        int n = readInt();
        int m = readInt();
        int k = readInt();
        
        int [] a = new int [n];
        for (int i = 0; i < n; i++){
            a[i] = readInt();
        }
        mergeSort(a);
        
        if (k>=m){
            out.print(0);
             return;
        }
        
        int ans = 0;
        k--;
        for (int i = n-1; i >=0; i--){
            ans += a[i];
            if (ans +  k >= m){
                out.print(n-i);
                return;
            }
            else {
                k--;
            }

        }
        out.print(-1);
        
        
    }
    
    
}

























