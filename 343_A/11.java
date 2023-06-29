import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long a=s.nextLong(), b=s.nextLong();
        long c=0;
        while(true)  {
            if(a==b ){
                System.out.println(c+a);
                return ;
            } else if(b==a+1){
                c+=1;
                b=a;
            } else if(b<a){

                long h = a/b-1;
                if(h<=0){
                    a-=b;c++;continue;
                }
                a-=b*h;
                c+=h;
            } else{
                if(a==1){
                    long t = b-a;
                    b = t;
                    c+=t;
                    b = a;
                    continue;
                }
                long t = b-a;
                long h = b/a - 1 ;
                if(h<=0){
                    b = t;
                    c+=1;continue;
                }
                c+=h;b-=h*a;
//                b = a;
            }
        }

//        System.out.println(c);
    }
}
