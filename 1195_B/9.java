import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CF1195B {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(reader.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long put = (-3 + (long)Math.sqrt((long)9 + 8 * k + 8 * n)) / 2;
        long eat = n - put;
        writer.write(Long.toString(eat));
        writer.newLine();
        writer.flush();
    }

}
