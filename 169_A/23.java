import java.io.*;
import java.util.*;

/**
 * @author Vaibhav Mittal
 */

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int testCases = 1;
        Task solver = new Task();
        for (int i = 1; i <= testCases; ++i)
            solver.solve(in, out);

        out.close();
    }
}

class Task {
    public void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[] complexity = new int[n];
        for (int i = 0; i < n; ++i)
            complexity[i] = in.nextInt();
        Arrays.sort(complexity);
        out.println(complexity[b] - complexity[b - 1]);
    }
}