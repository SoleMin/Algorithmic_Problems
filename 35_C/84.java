import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contest35_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(in.readLine());
        s = in.readLine().split(" ");
        Point[] inp = new Point[k];
        int p = 0;
        for (int i = 0; i < k; i++) {
            inp[i] = new Point(Integer.parseInt(s[p++]),
                    Integer.parseInt(s[p++]));
        }
        int max = -1;
        int maxx = -1;
        int maxy = -1;
        int i;
        int j, dist;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                dist = 1000000;
                for (int l = 0; l < inp.length; l++) {
                    dist = Math.min(
                            Math.abs(inp[l].x - i) + Math.abs(inp[l].y - j),
                            dist);
                }
                if (dist > max) {
                    max = dist;
                    maxx = i;
                    maxy = j;
                }
            }
        }
        String res = maxx + " " + maxy + "\n";
        FileWriter out = new FileWriter(new File("output.txt"));
        out.append(res);
        out.flush();
        out.close();
    }
}