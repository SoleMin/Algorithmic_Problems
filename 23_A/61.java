import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P19 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
        String str = in.next();
        int len = str.length();
        int maxCurrent = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = 1; j <= len; ++j) {
                if (i + j > len) continue;
                //System.out.format("Adding from %d to %d -> %s\n",i, i+j,str.substring(i, i + j));
                int hashCode = str.substring(i, i + j).hashCode();
                Integer current = mapa.get(hashCode);
                if (current == null)
                    current = 0;
                current++;
                mapa.put(hashCode, current);
                if (current > 1)
                    maxCurrent = Math.max(maxCurrent, j);
            }
        }

        out.println(maxCurrent);

        out.flush();
        out.close();
    }
}
