import java.util.*;
import java.io.*;
public class MyClass {
    public static void main(String args[]) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt(), st=0, sum=0;
        int arr[] = new int[26];
        String str = sc.next();
        for(int i=0; i<n; i++) {
            arr[str.charAt(i)-97] += 1;
        }
        for(int i=0; i<26; i++) {
            if(arr[i] > 0) {
                st += 1;
                sum += (i+1);
                if(st == k)
                    break;
                i += 1;    
            }
        }
        if(st == k) 
            System.out.println(sum);
        else
            System.out.println(-1);
        sc.close();
    }
}