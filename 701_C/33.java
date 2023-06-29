import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Daniil on 5/29/2016.
 */
public class TaskB {


    public static int strIndex;
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        char[] s = scanner.next().toCharArray();

        int[][] r = new int[n][54];

        Set<Character> chars = new HashSet<>();

        for (int i= 0 ;i < n; ++ i)chars.add(s[i]);

        List<Character> all = new ArrayList<>();

        for (Character c: chars)all.add(c);

        for (int i = n - 1; i >= 0; -- i){
            for (int j = 0;j < 54; ++ j){
                if (i == n - 1){
                    r[i][j] = -1;
                }else {
                    r[i][j] = r[i + 1][j];
                }
            }
            r[i][getCode(s[i])] = i;
        }

        int res = n;


        for (int i =0; i < n; ++ i){
            int mx = 1;
            boolean fl = false;
            for (Character c: all){
                if (r[i][getCode(c)] == -1){
                    fl = true;
                    break;
                }
                mx = Math.max(mx, r[i][getCode(c)] - i + 1);
            }
            if (fl){
                System.out.println(res);
                return;
            }
            res = Math.min(res, mx);
        }
        System.out.println(res);

        scanner.close();
        //reader.close();
    }

    public static int getCode(char a){
        if (Character.isUpperCase(a))return a - 'A';
        return (a - 'a') + 26;
    }

    public static int getLetter(int n){
        if (n > 25)return (char)((n - 26) + 'a');
        return (char)((n) + 'A');
    }



    static class IO{


        BufferedReader reader;
        StringTokenizer tokenizer;
        PrintWriter writer;

        public void init() {
            try {
                reader = new BufferedReader(new InputStreamReader(System.in),8*1024);
                writer = new PrintWriter(System.out);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(261);
            }
        }

        void destroy() {
            writer.close();
            System.exit(0);
        }

        void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        void println(Object... objects) {
            print(objects);
            writer.println();
        }

        String nextLine() throws IOException {
            return reader.readLine();
        }

        String nextToken() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(nextLine());
            return tokenizer.nextToken();
        }

        int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(nextToken());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(nextToken());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.parseDouble(nextToken());
        }
    }


}
