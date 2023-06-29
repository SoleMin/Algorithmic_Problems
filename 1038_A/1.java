import java.util.ArrayList;
 import java.util.*;
public class Main {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int ar[] = new int[26];
        int n = sc.nextInt(), k = sc.nextInt();
        String s = sc.next();
        for(char c : s.toCharArray()){
            int z = c - 'A';
            ar[z]++;
        }
        int m = n;
        for(int i = 0;i<k;i++){
            m = Math.min(m,ar[i]);
        }
        System.out.println(m*k);
       
        
        
        
    }
}
    

