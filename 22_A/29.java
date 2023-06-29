import java.io.*;
import java.util.*;

public class A {

    void run()throws IOException{
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        int i;
        int[] ar = new int[n];
        for(i=0; i<n; i++){
            ar[i] = sc.nextInt();
        }
        Arrays.sort(ar);
        int min = ar[0];
        for(i=1;i<n;i++){
            if(ar[i]>min) break;
        }
        if(i<n) System.out.println(ar[i]);
        else System.out.println("NO");
    }
    
    public static void main(String[] args)throws IOException {
        new A().run();
    }
}
