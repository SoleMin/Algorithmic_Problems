import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * May 13, 2011 
 * @author parisel
 */
public class ToyArmy {
    int N;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] tok;
    String s;

    private String[] getTok() throws IOException {return br.readLine().split(" ");}
    private int getInt() throws IOException {return Integer.valueOf(br.readLine());}
    private int[] getInt(int N) throws IOException {
        int[] data= new int[N]; tok= br.readLine().split(" ");
        for (int i=0; i<N; i++) data[i]= Integer.valueOf(tok[i]);
        return data;
    }

    public void solve() throws IOException {
        int i=0, j=0;
        N= getInt();

        long kill= (3*N)/2;

        System.out.printf("%d\n", kill);

    }


    public static void main(String[] args) throws IOException {
        new ToyArmy().solve();
    }
}
