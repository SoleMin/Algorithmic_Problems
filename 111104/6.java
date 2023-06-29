import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static int max(Turtle[] t) {

        int[] pre = new int[t.length+1];
        int[] dp = new int[t.length+1];


        for (int i = 0; i< pre.length; i++) {
            pre[i] = Integer.MAX_VALUE;
        }

        pre[1] = t[0].w;
        dp[0]= Integer.MAX_VALUE;
        int max = 1;
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < dp.length; j++){
                int nuse =  pre[j];
                int use = (t[i].r >= pre[j-1]) ? pre[j-1] + t[i].w : Integer.MAX_VALUE;
                dp[j] = Math.min (use, nuse);
                if (dp[j] != Integer.MAX_VALUE){
                    max = Math.max(max, j);
                }
            }
            int[] tmp = pre;
            pre = dp;
            dp = tmp;
        }
        return max;
    }

    private static class Turtle implements Comparable<Turtle> {
        
        int w,s,r;

        @Override
        public int compareTo(Turtle t) {
            if (s < t.s) return -1;
            if (s > t.s) return 1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Turtle> turtles = new ArrayList<>();
        while (sc.hasNextInt()) {
            Turtle t = new Turtle();
            t.w = sc.nextInt();
            t.s = sc.nextInt();
            t.r = t.s - t.w;
            turtles.add(t);
        }
        Collections.sort(turtles);
        Turtle[] a = new Turtle[turtles.size()];
        turtles.toArray(a);
        System.out.println(max(a));
    }
}