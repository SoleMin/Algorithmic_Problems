import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        int n = line.length();
        int maxlenght = 0;
        for (int i = 0; i < n; i++) {
            int j = line.indexOf(line.charAt(i), i + 1);
            while (j != -1) {
                int k = i;
                int l = j;
                while (k < n && l < n && line.charAt(k) == line.charAt(l)) {
                    k++;
                    l++;
                }
                if (k - i > maxlenght) {
                    maxlenght = k - i;
                }
                j = line.indexOf(line.charAt(i), j + 1);
            }
        }
        System.out.println(maxlenght);
    }
}