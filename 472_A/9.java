import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
    public class Main
    {
        public static void main(String[] args)
        {
        Scanner sc =new Scanner(System.in);    
        long a=sc.nextLong();
        if(a%4==0){System.out.println(a/2 + " " + a/2);}
        if(a%4==1){System.out.println(9 + " " + (a-9));}
        if(a%4==2){System.out.println(6 + " " + (a-6));}
        if(a%4==3 && a>15){System.out.println(15 + " " + (a-15));}
        if(a==15){System.out.println("6 9");}
        
        }
    }
