import java.util.Scanner;

public class subtractions {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        while(n-->0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            
            int c=0;
            while(a!=0 && b!=0){
                if(a>b){
                    int t=a;
                    a=b;
                    b=t;
                }
                c+=b/a;
                b=b%a;
            }
            System.out.println(c);
        }
    }
}
