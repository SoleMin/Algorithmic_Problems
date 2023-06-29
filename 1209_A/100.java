import java.awt.*;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        boolean vis[]=new boolean[n];
        int c=0;
        for (int i=0;i<n;i++){
            int min=200;
            for (int j=0;j<n;j++){
                if (!vis[j] && min>arr[j]){
                    min=arr[j];
                }
            }
            for (int j=0;j<n;j++){
                if (!vis[j]&&arr[j]%min==0){
                    vis[j]=true;
//                    System.out.println(arr[j]);
                }
            }
            if (min!=200){
                c++;
//                System.out.println(min+" k");
            }else break;
        }
        System.out.println(c);
    }
}