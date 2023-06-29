import java.util.Scanner;

public class digits
{
	public static void main(String[] args) 
	{
		long k = (new Scanner(System.in)).nextLong();

		//k = 56
		//League 1: 0 - 9
		//League 2: 10 - 99
		//League 3: 100 - 999..
		//System.out.println("k = "+k);
		long league = 1;
		long irrelevancy = 0;
		while(true)
		{	
			irrelevancy += league * (Math.pow(10, league) - Math.pow(10, league-1));
			if(k > irrelevancy)
				league ++;
			//league = 1 : k = 56 > 9
			//league = 2 : k = 56 < 99
			//therefore league = 2
			else
				break;
		}
		//System.out.println("League = "+league);
		irrelevancy = 0;
		for(long i=1; i<league; i++)
			irrelevancy += i * (Math.pow(10, i) - Math.pow(10, i-1));

		//irrelevancy = 1 * (10^1 - 10^0) = 9

		long modified_k = k - irrelevancy;

		//modified_k = 56 - 9 = 47
		//System.out.println("modified k = "+ modified_k);
		long number = (long)(Math.pow(10, league-1)) - 1 + modified_k / league;
		//System.out.println("number = "+number);

		if(modified_k % league == 0)
			System.out.println(number % 10);
		else
		{
			number ++;
			long position_of_digit = (long)(modified_k % league);
			//System.out.println(position_of_digit);
			//number = 24
			//position_of_digit = 47 % 2 = 1
			System.out.println((Long.toString(number)).charAt((int)position_of_digit-1));
		}
	}


}