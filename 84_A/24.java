import java.util.Scanner;

public class MainA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        
        int count = 0;
        
        count = n/2;
        
        count = count + (n - n/2);
        
        n = n - n/2;
            
        count = count + n;  

        
        System.out.println(count);
        
    }
}
