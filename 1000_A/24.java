import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class JavaApplication2 {

    
    public static void main(String[] args) throws IOException {
     
        BufferedReader sc= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine().split(" ")[0]);
        ArrayList<String> tshr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            tshr.add(sc.readLine());
        }
        for (int i = 0; i < n; i++) {
            tshr.remove(sc.readLine());
        }
        System.out.println(tshr.size());
        
        
        
        
        
        
    }
    
}