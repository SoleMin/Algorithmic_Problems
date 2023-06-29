import java.io.*;
import java.util.*;

public class Test{
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        if(n%7==0 || n%4==0 || n%47==0 || n%74==0 || n%447==0 || n%474==0 || n%477==0 || n%747==0 || n%774==0){
            System.out.println("YES");
        }else
            System.out.println("NO");
        
    }
}

