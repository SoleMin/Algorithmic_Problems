//contest 23. You're Given A String
import java.util.*;
public class ProblemA
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		boolean con = false;
		for( int i = input.length()-1; i > 0 ; i--)
		{	
			for ( int j = 0; j+i< input.length(); j++ )
				for( int k = j+1; k+i <= input.length(); k++ )
					if( input.substring(j,j+i).equals( input.substring(k,k+i) ) ) 
					{
						System.out.print(i+"\n");
						k = input.length()+1;
						j = input.length();
						i = -1;
						con = true;
					}
		}
		if( con == false )
			System.out.print(0+"\n");
	}	
}