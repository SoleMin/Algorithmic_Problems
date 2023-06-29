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
    
    class Lol implements Comparable<Lol>{
        int x;
        int y;
        
            public Lol (int x , int y){
                this.x = x;
                this.y = y;
            }

            @Override
            public int compareTo(Lol arg0) {
                if (arg0.x == x) {
                    return y-arg0.y;
                }
                return arg0.x-x;
            }
        
    }

    public void solve() throws IOException {
        
        int n = readInt();
        int k = readInt();
        k--;
        Lol [] a = new Lol [n];
                
        for (int i  = 0 ; i  <n; i++){
            int x = readInt();
            int y = readInt();
            a[i] = new Lol(x, y);
        }
        Arrays.sort(a);
        int ans = 1; 
        for (int i =k+1; i>-1; i++){
            if (i==n) break;
            if (a[i].x==a[k].x && a[i].y == a[k].y){
                ans++;
            }
            else break;
        }
        if (k!=0){
            for (int i =k-1; i>=0; i--){
                if (a[i].x==a[k].x && a[i].y == a[k].y){
                    ans++;
                }
                else break;
            }
        }
        out.print(ans);
        
        
        
    }
}

































