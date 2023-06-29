
import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;


import static java.lang.Math.*;

public class Main implements Runnable {
    
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void init() throws FileNotFoundException {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
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

    private static void merge(int[] a, int leftIndex, int middleIndex, int rightIndex) {
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
                            a[k] = leftArray[i] <= rightArray[j] ? leftArray[i++] : rightArray[j++];
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
    
    public static void main(String[] args) {
        new Main().run();
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

    int mini = Integer.MAX_VALUE;
    int maxi = Integer.MIN_VALUE;
    int ans = 0;
    int ans2 = 0;
    int sum = 0;

    void solve() throws IOException {
        int n = readInt();
        int m = readInt();
        int maxi=0;
        int  [][] a = new int [n][m];
        int k = readInt();
        ArrayDeque<Point> dq = new ArrayDeque<Point> ();
        Point p = new Point();
        for (int i = 0; i<n; i++)
            for (int j= 0; j<m; j++){
                a[i][j]=Integer.MAX_VALUE;
            }
        for (int i = 0; i<k; i++){
            int x = readInt()-1;
            int y = readInt()-1;
            p.x=x;
            p.y=y;
            dq.add(new Point(x,y));
            a[x][y]=0;
        }
        while (!dq.isEmpty()){
            Point v = dq.pollFirst();
            Point u = new Point();
            if (v.x-1!=-1) {
                if (a[v.x-1][v.y]>a[v.x][v.y]+1){
                    a[v.x-1][v.y]=a[v.x][v.y]+1;
                    maxi=max(maxi,a[v.x-1][v.y]);
                    u.x=v.x-1;
                    u.y=v.y;
                    dq.add(new Point(u.x,u.y));
                }
            }
            if (v.y-1!=-1) {
                if (a[v.x][v.y-1]>a[v.x][v.y]+1){
                    a[v.x][v.y-1]=a[v.x][v.y]+1;
                    maxi=max(maxi,a[v.x][v.y-1]);
                    u.y=v.y-1;
                    u.x=v.x;
                    dq.add(new Point(u.x,u.y));
                }
            }
            if (v.x+1!=n) {
                if (a[v.x+1][v.y]>a[v.x][v.y]+1){
                    a[v.x+1][v.y]=a[v.x][v.y]+1;
                    maxi=max(maxi,a[v.x+1][v.y]);
                    u.x=v.x+1;
                    u.y=v.y;
                    dq.add(new Point(u.x,u.y));
                }
            }
            if (v.y+1!=m) {
                if (a[v.x][v.y+1]>a[v.x][v.y]+1){
                    a[v.x][v.y+1]=a[v.x][v.y]+1;
                    maxi=max(maxi,a[v.x][v.y+1]);
                    u.y=v.y+1;
                    u.x=v.x;
                    dq.add(new Point(u.x,u.y));
                }
            }
        }
        for (int i =0; i<n; i++)
            for (int j =0; j<m; j++){
                if (maxi==a[i][j]) {
                    out.print((i+1) + " " + (j+1));
                    return;
                }
            }
        
      }
    
    
    
    
    
    
    

    char c[];
    
    void per (int left, int right){
        if(left == right){
            for (int i = 0; i<=right;i++){
                out.print(c[i]);
            }
            out.println();
        }
        else {
            for (int i = left; i <=right; i++){
                char k = c[left];
                c[left] = c[i];
                c[i] = k;
                per(left+1,right);
                k = c[left];
                c[left] = c[i];
                c[i] = k;
            }
        }
    }
}





