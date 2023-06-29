import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.util.Set;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.File;
import java.io.Writer;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author jarek
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int[] a = IOUtils.readIntArray(in, n);
        Set<Integer> cnt = new HashSet<Integer>();
        int i = 0;
        while (i < n && cnt.size() < k) {
            cnt.add(a[i]);
            if (cnt.size() < k)
                ++i;
        }
        if (cnt.size() < k)
            out.print("-1 -1");
        else {
            int r = i;
            cnt = new HashSet<Integer>();
            while (i >= 0 && cnt.size() < k) {
                cnt.add(a[i]);
                if (cnt.size() < k) --i;
            }
            out.print(i + 1, r + 1);
        }
    }
}

class InputReader {
    BufferedReader br;
    StringTokenizer st;

    public InputReader(File f) {
        try {
            br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public InputReader(InputStream f) {
        br = new BufferedReader(new InputStreamReader(f));
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    }

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void close() {
        writer.close();
    }
}

class IOUtils {

    public static int[] readIntArray(InputReader in, int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = in.nextInt();
        return array;
    }

    }

