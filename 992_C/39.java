

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Test5{

    static long mod=1000000007;

    public static void main(String[] z) throws Exception{
        Scanner s = new Scanner(System.in);
        long a = s.nextLong(), b=s.nextLong(), c=(a*2-1)%mod, i=binpow(2,b)%mod;
        System.out.println(a<1 ? a : (c*i+1)%mod);
    }

    static long binpow(long c, long step){
        if(step==0) return 1;
        if(step==1) return c%mod;
        if(step%2<1){
            return binpow(((c%mod)*(c%mod))%mod, step/2)%mod;
        }
        else{
            return (c%mod)*(binpow(c%mod, step-1)%mod);
        }
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
