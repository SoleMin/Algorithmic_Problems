import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    
    public static void main(String[] args) throws Exception {
        int i,j,k;
        int counter[] = new int[2];
        int a[] = new int[200];
        int needed;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (i=1;i<=N;i++) {
            a[i] = Integer.parseInt(st.nextToken());
            counter[a[i]%2]++;
        }
        
        if (counter[0] == 1) {
            needed = 0;
        } else {
            needed = 1;
        }
        
        for (i=1;i<=N;i++) {
            if (a[i]%2 == needed) {
                System.out.println(i);
                return;
            }
        }
        
    }

}
