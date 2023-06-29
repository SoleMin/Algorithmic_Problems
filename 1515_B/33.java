import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//        int t = scan.nextInt();
        int t= Integer.parseInt(br.readLine());
        while (t-->0)
        {
            String[] s1= br.readLine().split(" ");
            int n= Integer.parseInt(s1[0]);
//            Integer[] a= new Integer[n];
//            String[] s2= br.readLine().split(" ");
//            long sum=0;
//            for (int i=0;i<n;i++){
//                a[i]= Integer.parseInt(s2[i]);
//                sum+= Math.abs(a[i]);
//            }

            int x= 1;
            boolean ans=true;
            while (n%2==0){
                x*=2;
                n/=2;
            }
            if (x==1) ans= false;
            int z= (int)Math.sqrt(n);
            if (z*z!=n) ans= false;

            if (ans) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
