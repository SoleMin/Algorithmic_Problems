import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt(),even = 0,odd = 0,evI = 0,OdI = 0;      
        for (int i = 0; i < n; i++) {
            if(sc.nextInt()%2 == 1){
                odd++;
                OdI = i+1;
            }else{
                even++;
                evI = i+1; 
            }
        }
        if(even < odd)
            System.out.println(evI);
        else
            System.out.println(OdI);
        
    }
}
