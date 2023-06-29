import java.util.*;
import java.io.*;

public class NewYearAndCurling {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer t = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(t.nextToken());
		int R = Integer.parseInt(t.nextToken());
		int[] x = new int[N];
		t = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; ++i)
			x[i] = Integer.parseInt(t.nextToken());
		double[] y = new double[N];
		for(int i = 0; i < N; ++i) {
			double max = R;
			for(int j = 0; j < i; ++j ) {
				int xDiff = Math.abs(x[i] - x[j]);
				if(xDiff <= 2 * R)
					max = Math.max(max, y[j] + Math.sqrt(4*R*R - xDiff*xDiff));
			}
			y[i] = max;
		}
		out.print(y[0]);
		for(int i = 1; i < N; ++i)
			out.print(" " + y[i]);
		out.println();
		in.close();
		out.close();
	}
}