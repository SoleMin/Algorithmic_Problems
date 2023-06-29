import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class P113A {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintStream out = System.out;
        //CODING TAIM

        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Team> l = new ArrayList<Team>();
        for (int i = 0; i < n; i++) {
            l.add(new Team(sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(l, new Comparator<Team>() {
                public int compare(Team a, Team b) {
                    if (a.s == b.s)
                        return a.t - b.t;
                    return b.s - a.s;
                }
                });
        int f = k - 1;
        int la = k - 1;
        Team p = l.get(k - 1);
        while (la < n && l.get(la).s == p.s && l.get(la).t == p.t) la++;
        while ( f >= 0 && l.get(f).s == p.s && l.get(f).t == p.t) f--;
        out.println(la - f - 1);
    }

  static   class Team {
        int s;
        int t;
        public Team(int a, int b) { s = a; t = b; }
    }



}
