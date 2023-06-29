import java.io.*;
import java.util.*;


public class A {
    
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int so[]= new int[n];
        for(int i=0;i<n;i++) so[i]=in.nextInt();
        Arrays.sort(so);
        if(m<=k) {
            System.out.println("0");
            return;
        }
        int sum=0;
        int socUsed=0;
        int cont=0;
        for(int i=n-1;i>=0;i--){
            cont++;
            sum+=so[i]; 
            if(sum>=m || sum+(k-1)>=m){
                System.out.println(cont);
                return;
            }   
            sum--;  
        }   
        System.out.println("-1");
    }
}
