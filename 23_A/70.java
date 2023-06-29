

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        for (int i = s.length() - 1; i > 0; i--)
            for (int j = 0; j <= s.length() - i; j++)
                if (s.substring(0, j + i - 1).contains(s.substring(j, j + i))
                        || s.substring(j + 1).contains(s.substring(j, j + i))) {
                    System.out.println(i);
                    return;
                }
        System.out.println(0);
    }
}
