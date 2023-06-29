import java.io.*;
import java.util.*;
public class a{
    static int a;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        int n = sc.nextInt();
        int p = n;
        int m = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt() - 1;
        }
        Arrays.sort(a);
        int j =0;
        for(int i=0; i<n; i++){
            if(m > k){
                k = k + a[n-i-1];
                j++;
            }
        }
        if(m > k)
            System.out.println(-1);
        else
            System.out.println(j);
    }
    
}