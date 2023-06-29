import java.util.Arrays;
import java.util.Scanner;


public class A113 {

    public static void main(String[] args) {
        new A113().run();
    }
    
    public void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Team[] teams = new Team[n];
        for (int i = 0; i < teams.length; i++) {
            teams[i] = new Team(in.nextInt(), in.nextInt());
        }
        Arrays.sort(teams);
        int counter = 1;
        int index = k-2;
        while (index >= 0 && teams[index].p == teams[k-1].p && teams[index].t == teams[k-1].t) {
            index--;
            counter++;
        }
        index = k;
        while (index < n && teams[index].p == teams[k-1].p && teams[index].t == teams[k-1].t) {
            index++;
            counter++;
        }
        System.out.println(counter);
    }
    
    private class Team implements Comparable<Team> {
        int p;
        int t;
        
        public Team(int pp, int tt) {
            p = pp; t = tt;
        }

        @Override
        public int compareTo(Team o) {
            if (o.p - this.p == 0)
                return this.t - o.t;
            return o.p - this.p;
        }
    }
}
