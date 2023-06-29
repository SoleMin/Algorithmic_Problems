
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A23 {

    static int solve(String s) {
        for(int i = s.length(); i > 0; --i) {
            for(int start = 0; start < s.length() - i; ++start) {
                String str = s.substring(start, start + i);
                int firstIndex = s.indexOf(str);
                int lastIndex = s.lastIndexOf(str);
                if(firstIndex != lastIndex)
                    return i;
            }
        }
        return 0;
    }

    public static String[] EX = new String[] { "abcd", "ababa", "zzz", "qwertyuiopasdfghjklzxcvbnmqwepriuwpoep"};
    public static int[] EX_A = new int[] { 0, 3, 2, 3};
    
    public static void main(String[] args) throws IOException {
        if(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            System.out.println(solve(s));
        }
        else {
            for(int i = 0; i < EX.length; ++i) {
                int result = solve(EX[i]);
                System.out.println(i + ": " + result + " " + (result == EX_A[i]? "ja" : "NEJ"));
            }
        }
    }

}
