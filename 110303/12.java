import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
			
		
		String input1 , input2;		
	
		
		while(sc.hasNext())
		{	
			int[] ascii1 = new int[256];
			int[] ascii2 = new int[256];
			input1 = sc.next();
			input2 = sc.next();
			
			
			
			for(int i = 0; i < input1.length(); i++)
			{
				ascii1[(int)input1.charAt(i)]++;
			}
			
			for(int i = 0; i < input2.length(); i++)
			{
				ascii2[(int)input2.charAt(i)]++;
			}
			
			
			for(int i = 0; i < 256; i++)
			{				
				if(ascii1[i] < ascii2[i])
				{
					for(int j = 0; j < ascii1[i]; j++)
						System.out.print((char)i);
				}
				else
					for(int j = 0; j < ascii2[i]; j++)
						System.out.print((char)i);					
			}
			System.out.println();
			
		}
	
		sc.close();		
	}
}