import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String t = s.substring(i, j);
                if (s.indexOf(t, i + 1)>=0) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        System.out.println(ans);
    }   

}
