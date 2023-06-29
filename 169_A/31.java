import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @zhendeaini6001
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
        int a = in.nextInt();
        int b = in.nextInt();
        int[] input = IOUtils.readIntArray(in, n);
        Arrays.sort(input);
        int x = input[b-1];
        int y = input[b];
        out.println(y - x);
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

