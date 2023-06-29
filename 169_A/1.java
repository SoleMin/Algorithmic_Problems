import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chores {

    public static void main(String [] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        
        int ans = 0;
        int [] h = new int [n];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i<n; i++)
            h[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(h);
        
        ans = h[b]-h[b-1];
        
        bw.write(Integer.toString(ans)); 
        bw.flush();
    }
    
}
