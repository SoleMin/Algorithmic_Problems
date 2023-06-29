
//package que_a;

import java.io.*;
import java.util.*;
import java.math.*;

public class utkarsh {

    InputStream is;
    PrintWriter out;
    
    long mod = (long) (1e9 + 7);
    boolean SHOW_TIME;
    
    void solve() {
        //Enter code here utkarsh
        //SHOW_TIME = true;
        int n = ni();
        HashMap <String, Integer> mp = new HashMap<>();
        mp.put("M", 0);
        mp.put("S", 1); mp.put("XS", 2); mp.put("XXS", 3); mp.put("XXXS", 4);
        mp.put("L", 5); mp.put("XL", 6); mp.put("XXL", 7); mp.put("XXXL", 8);
        int a[] = new int[10];
        for(int i = 0; i < n; i++) {
            int j = mp.get(ns());
            a[j]++;
        }
        for(int i = 0; i < n; i++) {
            int j = mp.get(ns());
            a[j]--;
        }
        int ans = 0;
        for(int i = 0; i < 10; i++) {
            if(a[i] > 0)    ans += a[i];
        }
        out.println(ans);
    }

    //---------- I/O Template ----------
    
    public static void main(String[] args) { new utkarsh().run(); }
    void run() { 
        is = System.in; 
        out = new PrintWriter(System.out);
        long start = System.currentTimeMillis(); 
        solve(); 
        long end = System.currentTimeMillis();
        if(SHOW_TIME) out.println("\n" + (end - start) + " ms");
        out.flush();
    }
    
    byte input[] = new byte[1024];
    int len = 0, ptr = 0;
    
    int readByte() { 
        if(ptr >= len) { ptr = 0; 
            try { len = is.read(input); } 
            catch(IOException e) { throw new InputMismatchException(); } 
            if(len <= 0) { return -1; } 
        } return input[ptr++];
    }
    boolean isSpaceChar(int c) { return !( c >= 33 && c <= 126 ); }
    int skip() { 
        int b = readByte(); 
        while(b != -1 && isSpaceChar(b)) { b = readByte(); } 
        return b;
    }
    
    char nc() { return (char)skip(); }
    String ns() { 
        int b = skip(); 
        StringBuilder sb = new StringBuilder(); 
        while(!isSpaceChar(b)) { sb.appendCodePoint(b); b = readByte(); } 
        return sb.toString();
    }
    String nLine() { 
        int b = skip(); 
        StringBuilder sb = new StringBuilder(); 
        while( !(isSpaceChar(b) && b != ' ') ) { sb.appendCodePoint(b); b = readByte(); } 
        return sb.toString();
    }
    int ni() { 
        int n = 0, b = readByte(); 
        boolean minus = false; 
        while(b != -1 && !( (b >= '0' && b <= '9') || b == '-')) { b = readByte(); } 
        if(b == '-') { minus = true; b = readByte(); } 
        if(b == -1) { return -1; }  //no input 
        while(b >= '0' && b <= '9') { n = n * 10 + (b - '0'); b = readByte(); } 
        return minus ? -n : n;
    }
    long nl() { 
        long n = 0L;    int b = readByte(); 
        boolean minus = false; 
        while(b != -1 && !( (b >= '0' && b <= '9') || b == '-')) { b = readByte(); } 
        if(b == '-') { minus = true; b = readByte(); } 
        while(b >= '0' && b <= '9') { n = n * 10 + (b - '0'); b = readByte(); } 
        return minus ? -n : n;
    }

    double nd() { return Double.parseDouble(ns()); }
    float nf() { return Float.parseFloat(ns()); }
    int[] na(int n) { 
        int a[] = new int[n]; 
        for(int i = 0; i < n; i++) { a[i] = ni(); } 
        return a;
    }
    char[] ns(int n) { 
        char c[] = new char[n]; 
        int i, b = skip(); 
        for(i = 0; i < n; i++) { 
            if(isSpaceChar(b)) { break; } 
            c[i] = (char)b; b = readByte(); 
        } return i == n ? c : Arrays.copyOf(c,i);
    }
}