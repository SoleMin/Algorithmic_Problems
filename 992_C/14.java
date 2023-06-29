import java.io.*;
import java.util.*;
import java.math.*;



public class C
{


   
   
      
   


            
            
      



      
	

	
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        BigInteger x = sc.nextBigInteger();
        BigInteger k = sc.nextBigInteger();
        BigInteger zero = new BigInteger("0");
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger modulo = new BigInteger("1000000007");
        BigInteger ans = two.modPow(k.add(one),modulo);
        ans = ans.multiply(x);
        ans = ans.subtract(two.modPow(k,modulo));
        ans = ans.add(one);
        ans = ans.mod(modulo);
        if (x.equals(zero))
        {
         System.out.println(0);
         }
         else
         {
        System.out.println(ans);
        }
    }
}   
        