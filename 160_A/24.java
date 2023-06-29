import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class A {

    int n;
    int[] a;
    public void run() throws IOException{
        Scanner s = new Scanner(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = s.nextInt();
        a =  new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
            sum+=a[i];
        }
        
        Arrays.sort(a);
        
        long mysum = 0;
        int count = 0;
        for (int i = n-1; i > -1; i--) {
            if (mysum > sum)
                break;
            
            count++;
            mysum+=a[i];
            sum-=a[i];
        }
        
        
        System.out.println(count);
        
    }
    
    public static void main(String[] args) throws IOException {
        (new A()).run();
    }

}