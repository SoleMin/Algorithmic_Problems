import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
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
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		int[] fs = IOUtils.readIntArray(in, n);
		Arrays.sort(fs);
		int ptr = fs.length - 1;
		int res = 0;
		while (ptr >= 0 && k < m) {
			k += fs[ptr--] - 1;
			res++;
		}
		if (k < m) out.println(-1);
		else out.println(res);
	}
}

class IOUtils {
    public static int[] readIntArray(Scanner in, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = in.nextInt();
        return array;
    }

    }

