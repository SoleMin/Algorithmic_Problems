/**
 * Created by IntelliJ IDEA.
 * User: shakhov
 * Date: 15.06.2011
 * Time: 15:22:46
 * To change this template use File | Settings | File Templates.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CodeForces {

    public void solve() throws IOException {
        String s = nextToken();        
        Set<String> set = new HashSet<String>();
        int counter = 0;
        for (int i = 0, l = s.length(); i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                String subst = s.substring(i, j);
                if (!set.contains(subst)) {
                    set.add(subst);
                    if (counts(s.toCharArray(), subst.toCharArray()) > 1) {
                        counter = Math.max(counter, subst.length());
                    }

                }
            }
        }


        writer.print(counter);

    }

    private int counts(char[] s, char[] r) {
        int l = s.length;
        int rl = r.length;
        int arr[] = new int[26];
        Arrays.fill(arr, rl);
        for (int i = rl - 2; i > -1; i--) {
            int margin = (r[i] - 'a');
            if (arr[margin] == rl) {
                arr[margin] = rl - i - 1;
            }
        }
        //search
        int sp = 0;
        int counter = 0;
        while (sp <= l - rl) {
            int oldsp = sp;
            for (int i = rl - 1; i > -1; i--) {
                if (r[i] != s[sp + i]) {
                    if (i == rl - 1) {
                        sp += arr[s[sp + i] - 'a'];

                    } else {
                        sp++;
                    }
                    break;
                }
            }
            if (oldsp == sp) {
                counter++;
                sp++;
            }
        }
        return counter;
    }


    public static void main(String[] args) {
        new CodeForces().run();
    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter writer;

    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            //reader = new BufferedReader(new FileReader("LifeWithoutZeros.in"));
            tokenizer = null;
            writer = new PrintWriter(System.out);
            //writer = new PrintWriter(new BufferedWriter(new FileWriter("LifeWithoutZeros.out")));
            //long t=new Date().getTime();
            solve();
            //writer.println(t-new Date().getTime());
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

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}
