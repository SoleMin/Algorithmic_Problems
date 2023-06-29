import java.awt.Point;
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

import static java.lang.Math.*;

public class Testt {

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
        new Testt().run();
    }

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int leftIndex, int rightIndex) {
        final int MAGIC_VALUE = 50;
        if (leftIndex < rightIndex) {
            if (rightIndex - leftIndex <= MAGIC_VALUE) {
                insertionSort(a, leftIndex, rightIndex);
            } else {
                int middleIndex = (leftIndex + rightIndex) / 2;
                mergeSort(a, leftIndex, middleIndex);
                mergeSort(a, middleIndex + 1, rightIndex);
                merge(a, leftIndex, middleIndex, rightIndex);
            }
        }
    }

    private static void merge(int[] a, int leftIndex, int middleIndex,
            int rightIndex) {
        int length1 = middleIndex - leftIndex + 1;
        int length2 = rightIndex - middleIndex;
        int[] leftArray = new int[length1];
        int[] rightArray = new int[length2];
        System.arraycopy(a, leftIndex, leftArray, 0, length1);
        System.arraycopy(a, middleIndex + 1, rightArray, 0, length2);
        for (int k = leftIndex, i = 0, j = 0; k <= rightIndex; k++) {
            if (i == length1) {
                a[k] = rightArray[j++];
            } else if (j == length2) {
                a[k] = leftArray[i++];
            } else {
                a[k] = leftArray[i] <= rightArray[j] ? leftArray[i++]
                        : rightArray[j++];
            }
        }
    }

    private static void insertionSort(int[] a, int leftIndex, int rightIndex) {
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            int current = a[i];
            int j = i - 1;
            while (j >= leftIndex && a[j] > current) {
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


    public void solve() throws IOException {
        
        int n  = readInt();
        int [] a = new int [n];
        for (int i = 0; i < n; i++){
            a[i] = readInt();
        }
        mergeSort(a);
        
        int sum = 0;
        for (int i = 0; i <n; i++){
            sum+=a[i];
        }
        int sum2 = 0;
        int ans = 0;
        for (int i = n-1; i >=0; i-- ){
            sum2+=a[i];
            sum-=a[i];
            ans++;
            if (sum2>sum){
                break;
            }
        }
        
        out.print(ans);
    }
/*  for (int i =0; i<n; i++){
        out.print(a[i]+" ");
    }*/
}

















