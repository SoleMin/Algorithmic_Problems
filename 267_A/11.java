import java.util.Scanner;


public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T!=0){
            T--;
            int a = in.nextInt();
            int b = in.nextInt();
            int ans=0;
            while(a>0&&b>0){
                if(a>b){
                    int c = a;
                    a = b;
                    b = c;
                }
                ans += (b-(b%a))/a;
                b = b%a;
            }
            System.out.println(ans);
        }
    }
    
}
