import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        long b=0;long p=1;
        Scanner s=new Scanner(System.in);
        long m=s.nextLong();
        long x=1;
        do{
            p=(m+b)/x;
            b=10*b+10;
            x++;
        }while(p/(long)Math.pow(10, x-1)!=0);
        rest :
        x--;b=b/10-1;
        b=x*p-b;
        b=m-b;
        b=x-b-1;
        p/=(long)Math.pow(10, b);
        p%=10;
        System.out.println(p);
    }
}