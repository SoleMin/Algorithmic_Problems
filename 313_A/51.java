import java.io.*;
import java.util.*;

public class TaskA  {
    public void run() {
        InputReader reader = new InputReader(System.in);
        PrintWriter writer = new PrintWriter(System.out, true);

        reader.nextLine();
        String statement = reader.next();

        if (!statement.startsWith("-")) {
            writer.println(statement);
        } else {
            try {
                int statement1 = Integer.parseInt(statement.substring(0, statement.length() - 1));
                int statement2 = Integer.parseInt(statement.substring(0, statement.length() - 2) + statement.charAt(statement.length() - 1));
                writer.println(Math.max(statement1, statement2));
            } catch (Exception e) {
                writer.println(statement);
            }
        }

        writer.close();
    }
    public static void main(String[] args) {
        new TaskA().run();
    }
    private class InputReader {
        BufferedReader reader;
        StringTokenizer token;

        private InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        private String next() {
            return token.nextToken();
        }

        private int nextInt() {
            return Integer.parseInt(this.next());
        }

        private double nextDouble() {
            return Double.parseDouble(this.next());
        }

        private long nextLong() {
            return Long.parseLong(this.next());
        }

        private String nextLine() {
            String line = "";
            try {
                line = reader.readLine();
                token = new StringTokenizer(line, " ");

            } catch(IOException e) {

            }
            return line;
        }
    }
}
