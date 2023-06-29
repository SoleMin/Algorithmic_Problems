import java.util.Scanner;

public class Main
{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        String s = sc.next();
        String t = sc.next();

        int i = 0;
        while(i < n && i < m &&  s.charAt(i) == t.charAt(i)){
            i ++;
        }

        if(n - m > 1){
            System.out.println("NO");
        }
        else if(i == n){
            if(i == m){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else if(s.charAt(i) == '*'){
            i ++;
            while(i < n && s.charAt(i) == t.charAt(i + m - n)){
                i ++;
            }
            if(i == n){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }else {
            System.out.println("NO");
        }
    }
}