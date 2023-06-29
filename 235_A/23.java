import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static boolean bg = true;

    public static void main(String[] args) throws Exception {
        long n1 = Integer.parseInt(scan.next());
        if (n1==1){
            System.out.println(1);
            System.exit(0);
        }
        if (n1==2){
            System.out.println(2);
            System.exit(0);
        }
        if (n1==3){
            System.out.println(6);
            System.exit(0);
        }
        if (n1%2==0){
            if (n1%3==0){
                n1-=1;
                n1 = n1*(n1-1)*(n1-2);
                System.out.println(n1);
            }
            else {
                n1 = n1*(n1-1)*(n1-3);
                System.out.println(n1);
            }
        }
        else {
            n1 = n1*(n1-1)*(n1-2);
            System.out.println(n1);
        }
    }
}
