import java.util.Scanner;


public class CodeforcesRound176B {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner  kde =new Scanner (System.in);
		Long n = kde.nextLong(); //дома  и кол труб 
		Long k = kde.nextLong();  // разветлители 
		if(((k-1)*(k-2)+2*k)<(n*(long)2))
		{
			System.out.println(-1);
			return;
		}	
		Long a,b;
		 if(n==1)
		 {
			 System.out.println(0);
			 return;
		 }
		
		 if(k>=n)
		 {
			 System.out.println(1);
			 return;
		 }
		 else
		 {
			a=(long)2;
			b=k-1;  
		 }	 
		 boolean flag =false;
		while(true)
		{
			if(a>=b)
			{
				
				break;
				
			
			}
			 long	c =(a+b)/2;
			 if(2*(k-c+1)+(k-1+k-c+1)*(c-1)<(n*2)) 
			 {
				 a=c+1;
			 }
			 else
			 {
				 b=c;
			 }	
			 flag=true;
		}
		if(flag==true )
		{
			System .out.println(a);
		}
		else
		{
			System .out.println(a);	
		}	

		
		
	}

}
