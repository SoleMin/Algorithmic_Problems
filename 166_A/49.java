import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author hheng
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int N = in.nextInt();
        int k = in.nextInt();
        Team[] t = new Team[N];
        for (int i=0; i<N; i++) t[i] = new Team(in.nextInt(), in.nextInt());
        Arrays.sort(t);
        int p_k = t[k-1].p, t_k = t[k-1].t;
        int count = 0;
        for (int i=0; i<N; i++) if (t[i].p==p_k && t[i].t ==t_k) count++;
        out.println(count);
	}
}

class Team implements Comparable<Team>{
    int p, t;
    Team(int a, int b) { p=a; t=b;}
    public int compareTo(Team g) {
        if (p < g.p) return 1;
        if (p > g.p) return -1;
        if (t < g.t) return -1;
        if (t > g.t) return 1;
        return 0;
    }
    
}
