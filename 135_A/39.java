import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class ProblemA {

	private void solve() throws IOException {
		Scanner stdin = new Scanner(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        
        int n = Integer.valueOf(stdin.nextInt());
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
        	p[i] = stdin.nextInt();
        }
        
        Arrays.sort(p);
        if (p[n-1] == 1) {
        	p[n-1] = 2;
        } else {
        	p[n-1] = 1;
        	out.print(p[n-1] + " ");
        	n--;
        }
        
        for (int i = 0; i < n; i++) {
        	out.print(p[i] + " ");
        }
        
        
        out.flush();
        out.close();
	}
	
	public static void main(String[] args) throws IOException {
		ProblemA solver = new ProblemA();
        solver.solve();
	}
}
