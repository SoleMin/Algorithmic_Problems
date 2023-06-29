import java.util.*;

public class A {

    int n;
    int[] arr;
    
    void run(){
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        arr = new int[n];
        int even, odd;
        even = 0;
        odd = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            if(arr[i]%2==0)even++;
            else odd++;
        }
        if(even>odd){
        
            
            for (int i = 0; i < n; i++) {
                if(arr[i]%2==1){
                    System.out.println(i+1);
                    System.exit(0);
                }
            }
        }
        
        else{

            for (int i = 0; i < n; i++) {
                if(arr[i]%2==0){
                    System.out.println(i+1);
                    System.exit(0);
                }
            }

        }
        
        
    }
    public static void main(String[] args) {
        new A().run();
    }
}
