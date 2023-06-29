import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PaintTheNumbers {
    public static void main(String[] args) throws IOException {
        int[] colors = new int[101];
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < N; i++) {
            colors[Integer.parseInt(st.nextToken())]++;
        }
        int colorCount = 0;
        for (int i = 1; i <= 100; i++) {
            if (colors[i] != 0) {
                colors[i] = 0;
                for (int multiple = 2; multiple * i <= 100; multiple++) {
                    colors[i*multiple] = 0;
                }
                colorCount++;
            }
        }
        System.out.println(colorCount);
    }
}
