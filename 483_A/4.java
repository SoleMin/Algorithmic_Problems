import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by Egor on 24/10/14.
 */
public class TaskA {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        String[] input = reader.readLine().split(" ");

        long l = Long.parseLong(input[0]);
        long r = Long.parseLong(input[1]);
        if (l % 2 == 0) {
            if (r >= l + 2) {
                writer.println(l + " " + (l + 1) + " " + (l + 2));
            } else {
                writer.println(-1);
            }
        } else {
            if (r >= l + 3) {
                writer.println((l + 1) + " " + (l + 2) + " " + (l + 3));
            } else {
                writer.println(-1);
            }
        }

        writer.close();
    }

}
