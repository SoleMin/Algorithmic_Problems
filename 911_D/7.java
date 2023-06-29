import java.io.*;
import java.util.*;

public class Problem911D {
        public static void main(String args[]) throws IOException {
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt(), i, j;
                int ar[] = new int[n];
                int inv = 0;
                
                for(i = 0; i < n; i++) {
                        ar[i] = sc.nextInt();
                }
                
                for(i = 0; i < n; i++) {
                        for(j = 0; j < n; j++) {
                                if(i > j && ar[i] < ar[j]) {
                                        inv = (inv + 1) % 2;
                                }
                        }
                }
                
                int q = sc.nextInt();
                
                for(i = 0; i < q; i++) {
                        int l = sc.nextInt();
                        int r = sc.nextInt();
                        
                        int c = ( ((r-l)*(r-l+1))/2 ) % 2;
                        inv = (inv + c) % 2;
                        
                        if(inv == 0)
                                System.out.println("even");
                        else
                                System.out.println("odd");

                }
        }
}