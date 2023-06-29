import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Round111A {

    public static void main(String[] args) throws IOException {
        new Round111A().run();
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader);
        PrintWriter writer = new PrintWriter(System.out);

        int n = scanner.nextInt();
        int sum = 0;
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            sum += a[i];
        }
        Arrays.sort(a, Collections.reverseOrder());

        int s = 0;
        int i = 0;
        while (i < n && (s <= sum / 2)) {
            s += a[i];
            i++;
        }

        writer.print(i);

        scanner.close();
        writer.close();
    }
}
