//package code;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;


/**
 *
 * @author malek
 */

public class MainA {

    public static void main(String[] args) throws Exception {
        //String cwd = System.getProperty("user.dir") + "\\";
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintStream out = new PrintStream(System.out);
        //Scanner in = new Scanner(new BufferedInputStream(new FileInputStream(cwd + "src\\code\\in.in")));
        //PrintStream out = new PrintStream(cwd + "src\\code\\out.out");
        //=======================
        Solution solution = new Solution(in, out);
        solution.solve();
        //=======================
        in.close();
        out.close();
    }
    static private class Solution {
        final int inf = (int)1e9;
        //final int MAX_N = 1000 * 1000 + 100;
        int n, x, y, c;

        int f(int u, int r, int sec){
            if(u == 0 && r == 0)
                return 0;
            if(u == 0){
                return r - 1;
            }
            if(r == 0){
                return u - 1;
            }
            return Math.min(sec - 1, u - 1 + r - 1);
        }

        boolean isok(int sec){
            int up = x - 1;
            int down = n - x;
            int right = n - y;
            int left = y - 1;
            int u = 0, d = 0, r = 0, l = 0;
            int total = 1;
            int add = 4;
            for(int i = 1; i <= sec; i++){
                int cc = 0;
                if(i > up && ++cc > 0) u++;
                if(i > down && ++cc > 0) d++;
                if(i > right && ++cc > 0) r++;
                if(i > left && ++cc > 0) l++;
                total += add - cc;
                total -= Math.max(0, f(u, r, i));
                total -= Math.max(0, f(u, l, i));
                total -= Math.max(0, f(d, r, i));
                total -= Math.max(0, f(d, l, i));
                if(total >= c) return true;
                add += 4;
            }
            return false;
        }

        public void solve() {
            n = in.nextInt();
            x = in.nextInt();
            y = in.nextInt();
            c = in.nextInt();
            if(c == 1){
                out.println(0);
                return;
            }
            int lo = 0, hi = 60000;
            while(lo < hi){
                int mid = (lo + hi)/2;
                if(isok(mid)){
                    hi = mid;
                }
                else{
                    lo = mid + 1;
                }
            }
            out.println(lo);
        }

        public Solution(Scanner in, PrintStream out) {
            this.in = in;
            this.out = out;
        }

        Scanner in;
        PrintStream out;
    }
}

