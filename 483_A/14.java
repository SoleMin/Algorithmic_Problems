import java.util.Scanner;


public class A {

	public static void main(String[] args) {
		Scanner sc =new Scanner (System.in);
        long a=sc.nextLong(); long b=sc.nextLong();
        
        if(b-a <=1)
        	System.out.println("-1");
        else if(b-a==2 && a%2==1)
        	System.out.println("-1");
        else
        {
        	if(a%2==1)
        		System.out.println((a+1)+" "+(a+2)+" "+(a+3));
        	else
        		System.out.println((a)+" "+(a+1)+" "+(a+2));
        }
        sc.close();
	}

}
