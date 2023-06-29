import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        String[] p = in.readLine().split(" ");
        List<Integer> a = new ArrayList<Integer>();
        for (String k : p) {
            a.add(Integer.parseInt(k));
        }
        int n = a.size();
        int c1 = 0;
        int c2 = 0;
        int c1p = 0;
        int c2p = 0;
        for (int i = 0; i < n; i++) {
            if (a.get(i) % 2 == 0) {
                c1++;
                c1p = i;
            } else {
                c2++;
                c2p = i;
            }
        }
        if (c1 < c2) {
            System.out.println(c1p + 1);
        }  else {
            System.out.println(c2p + 1);
        }
    }
    
}
