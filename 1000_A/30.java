

import java.math.*;
import java.util.*;
import java.io.*;

public class Test5 {
    public static void main(String[] z){
        StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        Scanner s = new Scanner(System.in);
        int a = s.nextInt(), o=0;
        String i = "";
        ArrayList<String> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        for(int q=0; q<a; q++){
            l1.add(s.next());
        }
        for(int q=0; q<a; q++){
            i = s.next();
            if(l1.contains(i)) l1.remove(i);
            else l2.add(i);
        }
        Collections.sort(l1);
        Collections.sort(l2);

        for(int q=0; q<l1.size(); q++){
            if(l1.get(q).charAt(l1.get(q).length()-1)!=l2.get(q).charAt(l2.get(q).length()-1)) o++;
        }
        System.out.println(o);
        pw.flush();
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
