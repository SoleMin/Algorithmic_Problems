import java.util.Arrays;
import java.util.Scanner;

public class A {

    void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        boolean dif = false;
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        Arrays.sort(a);
        if(n==1){
            System.out.println(a[0]==1?2:1);return;
        }
        int[] m = new int[n];
        for(int i=1;i<n;i++)if(a[i]!=a[i-1])dif=true;
        m[0] = 1;
        for(int i=1;i<n;i++)m[i]=a[i-1];
        if(!dif&&a[0]==1)m[n-1]++;
        
        for(int i=0;i<n;i++)System.out.print(m[i]+(i==n-1?"\n":" "));
    }
    
    public static void main(String[] args) {
        new A().run();
    }
}