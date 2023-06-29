
import java.io.*;
import java.util.*;

public class CodeForce {
    
    private void solve() throws IOException {
        final int N = nextInt();
        int []A = new int[N];
        for(int i = 0; i < N; i++) A[i] = nextInt();
        Arrays.sort(A);
        if(A[N-1] == 1) A[N-1] = 2;
        else            A[N-1] = 1;
        Arrays.sort(A);
        for(int i = 0; i < N; i++)
            System.out.print(A[i] + " ");
    }
    
    public static void main(String[] args) {
        new CodeForce().run();
    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter writer;

    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            writer = new PrintWriter(new FileOutputStream(new File("output.txt")));
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
    
    String nextLine() throws IOException {
        return reader.readLine();
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}
