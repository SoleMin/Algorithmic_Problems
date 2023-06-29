import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int cases;		

		String key = "the quick brown fox jumps over the lazy dog";
		int len_key = key.length();

		cases = sc.nextInt();

		String blank;	
		blank = sc.nextLine();
		blank = sc.nextLine();

		for(int l = 0; l < cases; l++)		
		{

			char[][] input = new char[100][80];
			int[] size = new int[80];

			char[] after = new char[256];		

			int count1 = 0;	
			String str;
			int poss = 0;
			
			
			while(sc.hasNextLine())
			{			

				int correct = 0;				
				
				str = sc.nextLine();				
				if(str.equals(""))
					break;
				size[count1] = str.length();				

				int[] check = new int[256];
				int letter_check = 0;
				for(int i = 0; i < size[count1]; i++)
				{
					input[count1][i] = str.charAt(i);
				}

				if(size[count1] == len_key)
					correct = 1;
				else
					correct = 0;



				if(correct == 1)
				{			
					for(int i = 0; i < size[count1]; i++)
					{
						if(input[count1][i] >= 'a' && input[count1][i] <= 'z')
						{
							letter_check = (int)input[count1][i];							
							
							
							if(check[letter_check] == 0)
							{
								correct = 1;
								check[letter_check] = 1;
							}
							else
								correct = 0;
						}
					}
					if(input[count1][3] != ' ' && input[count1][9] != ' ' && input[count1][15] != ' ' && input[count1][19] != ' ' && input[count1][25] != ' ' && input[count1][30] != ' ' && input[count1][34] != ' ' && input[count1][39] != ' ')
						correct = 0;
				}

				if(correct == 1)
				{
					for(int i = 0; i < str.length(); i++)
					{						
						after[input[count1][i]] = key.charAt(i);						
					}
					poss = 1;					
				}
				count1++;
				
			}
			
			if(poss == 1)
			{
				for(int i = 0; i < count1; i++)
				{
					for(int j = 0; j < size[i]; j++)
					{
						System.out.print(after[input[i][j]]);
					}
					System.out.println();
				}
			}
			else
				System.out.println("No solution.");
			
			if(cases != 0)
				System.out.println();


		}


		sc.close();
	
	}
}