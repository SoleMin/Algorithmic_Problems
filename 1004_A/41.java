

import java.util.*;
import java.io.*;
import java.math.*;

public class Test5 {

    static StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
    static int[] m;

    public static void main(String[] z) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        Scanner s = new Scanner(System.in);
        int a = ni(), b=ni(), o=2;
        m = new int[a];
        for(int q=0; q<a; q++) m[q] = ni();
        Arrays.sort(m);
        for(int q=1; q<a; q++){
            if(m[q]-m[q-1]==b*2) o++;
            else if(m[q]-m[q-1]>b*2) o+=2;
        }
        System.out.println(o);
        pw.flush();
    }

    static int ni() throws Exception{
        st.nextToken();
        return (int)st.nval;
    }

    static String ns() throws Exception{
        st.nextToken();
        return st.sval;
    }

    static long gcd(long a, long b){
        for(; a>0 && b>0;)
            if(a>b) a%=b;
        else b%=a;
        return a+b;
    }

    static class PyraSort {

        private static int heapSize;

        public static void sort(int[] a) {
            buildHeap(a);
            while (heapSize > 1) {
                swap(a, 0, heapSize - 1);
                heapSize--;
                heapify(a, 0);
            }
        }

        private static void buildHeap(int[] a) {
            heapSize = a.length;
            for (int i = a.length / 2; i >= 0; i--) {
                heapify(a, i);
            }
        }

        private static void heapify(int[] a, int i) {
            int l = 2 * i + 2;
            int r = 2 * i + 1;
            int largest = i;
            if (l < heapSize && a[i] < a[l]) {
                largest = l;
            }
            if (r < heapSize && a[largest] < a[r]) {
                largest = r;
            }
            if (i != largest) {
                swap(a, i, largest);
                heapify(a, largest);
            }
        }

        private static void swap(int[] a, int i, int j) {
            a[i] ^= a[j] ^= a[i];
            a[j] ^= a[i];
        }
    }
}
