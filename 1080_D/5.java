import javafx.util.*;
import java.util.*;
import java.io.*;
import java.math.*;


public class Test4 {

    PrintWriter pw = new PrintWriter(System.out); InputStream is = System.in;
    Random rnd = new Random();
    int a;

    void run(){
        a = ni();
        for(int q=0; q<a; q++){
            long nj = ni(), kj = nl();
            BigInteger n = BigInteger.valueOf(nj), k = BigInteger.valueOf(kj);
            if((nj<40 && (k.compareTo(BigInteger.valueOf(2).pow(2*(int)nj).divide(BigInteger.valueOf(3)))>0))){
                System.out.println("NO");
                continue;
            }
            if(nj>=40){
                System.out.println("YES "+(nj-1));
                continue;
            }
            long log=nj;
            BigInteger maxop = BigInteger.valueOf(2).pow(2*(int)nj).divide(BigInteger.valueOf(3)), pth = BigInteger.ONE;
            for(BigInteger c = BigInteger.ONE; log>0; log--, c=c.multiply(BigInteger.valueOf(2)).add(BigInteger.ONE)){
                if(k.compareTo(c)<0) break;
                pth = c.multiply(BigInteger.valueOf(2)).add(BigInteger.ONE);
                k=k.subtract(c);
                maxop=maxop.subtract(c);
            }
            maxop = maxop.subtract(pth.multiply(BigInteger.valueOf(2).pow(2*(int)log).divide(BigInteger.valueOf(3))));
            if(k.compareTo(maxop)<=0) System.out.println("YES "+log);
            else System.out.println("NO");
        }
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

    public static void main(String[] args) {
        new Test4().run();
    }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte()
    {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }

    private double nd() { return Double.parseDouble(ns()); }
    private char nc() { return (char)skip(); }

    private String ns()
    {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n)
    {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m)
    {
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = ns(m);
        return map;
    }

    private int[] na(int n)
    {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = ni();
        return a;
    }

    private int ni()
    {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl()
    {
        long num = 0;
        int b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
}