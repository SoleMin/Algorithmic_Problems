import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(r.readLine());
        
        String[] line = r.readLine().split("[ ]+");
        
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(line[i]);
        
        
        Arrays.sort(a);
        
        boolean found = false;
        for(int i = 0; i < n && !found; i++)
            if(a[i] != 1)found = true;
        
        
        if(found){
            System.out.println(1);
            for(int i = 1; i < n; i++)
                System.out.println(a[i-1]);
        }else{
            for(int i = 0; i < n-1; i++)
                System.out.println(1);
            System.out.println(2);
        }
    }
}
