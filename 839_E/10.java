import java.util.*;
import java.io.*;
public class E {
    void solve(BufferedReader in) throws Exception {
        int[] xx = toInts(in.readLine());
        int n = xx[0];
        double k = xx[1];
        int[][] board = new int[n][n];
        for(int i = 0; i<n; i++) board[i] = toInts(in.readLine());
        int fst = n/2;
        int snd = n - fst;
        int[] maxc = new int[1<<fst];
        int max = 1;
        for(int i = 0; i<(1<<fst); i++) {
            for(int j = 0; j<fst; j++) {
                if((i&(1<<j)) != 0) maxc[i] = Math.max(maxc[i], maxc[i^(1<<j)]);
            }
            boolean ok = true;
            for(int a = 0; a<fst; a++) if(((1<<a)&i) != 0) {
                for(int b = a+1; b<fst; b++) if(((1<<b)&i) != 0) {
                    if(board[a][b] == 0) ok = false;
                }
            }
            if(ok) {
                maxc[i] = Integer.bitCount(i);
                max = Math.max(max, maxc[i]);
            }
        }
        for(int i = 0; i<(1<<snd); i++) {
            boolean ok = true;
            for(int a = 0; a<snd; a++) if(((1<<a)&i) != 0) {
                for(int b = a+1; b<snd; b++) if(((1<<b)&i) != 0) {
                    if(board[a+fst][b+fst] == 0) ok = false;
                }
            }
            if(!ok) continue;
            int mask = 0;
            for(int a = 0; a<fst; a++) {
                ok = true;
                for(int b = 0; b<snd; b++) {
                    if(((1<<b)&i) != 0) {
                        if(board[a][b+fst] == 0) ok = false;
                    }
                }
                if(ok) mask |= (1<<a);
            }
            max = Math.max(Integer.bitCount(i) + maxc[mask], max);
        }
        System.out.println(k*k*(max-1.0)/(2*max));
    }
    int toInt(String s) {return Integer.parseInt(s);}
    int[] toInts(String s) {
        String[] a = s.split(" ");
        int[] o = new int[a.length];
        for(int i = 0; i<a.length; i++) o[i] = toInt(a[i]);
        return o;
    }
    void e(Object o) {
        System.err.println(o);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        (new E()).solve(in);
    }
}
