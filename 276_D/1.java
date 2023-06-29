
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Rnd276D {
    Scanner in = new Scanner(System.in);

    private Rnd276D() throws IOException {
        //in.nextLine();
        long l = in.nextLong();
        long r = in.nextLong();
        int[] arrL = long2Arr(l);
        int[] arrR = long2Arr(r);
        int[] res = new int[arrL.length];
        int i = -1;
        for(i = 0; i < res.length; i++) {
            if(arrL[i] != arrR[i]) {
                break;
            }
        }
        if(i >= res.length) {
            out(0);
            return;
        }
        for(; i < res.length; i++)
            res[i] = 1;
        long tp = arr2Long(res);
        out(tp);
    }
    private int[] long2Arr(long val){
        int[] res = new int[64];
        for(int i = 0; i < res.length; i++) {
            if((val & (1L << i)) != 0L) 
                res[res.length - 1 - i] = 1;
        }
        return res;
    }
    private long arr2Long(int[] arr) {
        long res = 0L;
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == 1)
                res = res + (1L << (arr.length - 1 - i));
        }
        return res;
    }
    
    private int[] ns(int n) {
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = in.nextInt();
        }
        return res;
    }
    private int[][] getMat(int m, int n) {//m rows and n cols
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                res[i][j] = in.nextInt();
        return res;
    }
    private static void out(Object x) {
        System.out.println(x);
    }
    public static void main(String[] args) throws IOException {
        new Rnd276D();
    }
}
