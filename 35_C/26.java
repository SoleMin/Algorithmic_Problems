import java.util.*;
import java.io.*;

public class C{
	public static void main(String args[]) throws Exception{
		Scanner in = new Scanner(new FileReader("input.txt"));
		PrintWriter out = new PrintWriter(new File("output.txt"));

		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();

		int[] X = new int[K], Y = new int[K];
		for (int i = 0; i < K; i++){
			X[i] = in.nextInt();
			Y[i] = in.nextInt();
		}

		int d = -1;
		int a = -1; int b = -1;
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++){
				int h = Integer.MAX_VALUE;
				for (int p = 0; p < K; p++)
					h = Math.min(h,Math.abs(i-X[p]) + Math.abs(j-Y[p]));
				if (h > d){
					d = h; a = i; b = j;
				}
			}


		out.print(a + " " + b);
		out.close();
	}
}