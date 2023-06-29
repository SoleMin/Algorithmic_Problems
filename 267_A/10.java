import java.util.Scanner;

public class Question267A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t--!=0){
            int x=sc.nextInt();
            int y=sc.nextInt();
            int max=Math.max(x,y);
            int min=Math.min(x,y);
            int ans=0;
            while (min>0 && max>0){
                int temp=max;
                ans+=temp/min;
                max=min;
                min=temp%min;
           }
            System.out.println(ans);
        }
    }
}
