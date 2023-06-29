import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CF {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int n = in.nextInt();
        if (n >= 0) {
            out.println(n);
        } else {
            int res = n;
            n = Math.abs(n);

            String s = String.valueOf(Math.abs(n));
            if (s.length() == 1) {
                res = 0;
            } else {
                res = Math.max(-Integer.parseInt(s.substring(0, s.length() - 1)), res);
                res = Math.max(-Integer.parseInt(s.substring(0, s.length() - 2) + s.charAt(s.length() - 1)), res);
            }

            out.println(res);
        }

        out.close();
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

}