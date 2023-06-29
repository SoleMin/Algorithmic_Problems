import java.util.*;
import java.lang.*;
import java.math.*;

public class Main{

    Scanner sc=new Scanner(System.in);
    
    void run(){
        int n = sc.nextInt();
        
        int x[] = new int [n];
        
        for (int i=0;i<n;i++) 
            x[i] = sc.nextInt();
        
        java.util.Arrays.sort(x);
        
        int i = 0;
        
        for(i=0;i<n-1;i++) {
            if (x[i] != x[i+1]) {
                System.out.println( x[i+1] );
                return;
            }
        }

        System.out.println("NO");
        
        return;
        
    }
    
    public static void main(String[] args){
        new Main().run();
    }
}