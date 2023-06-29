import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		
		final int MAX_N = 100;
		final int MAX_M = 100;
		
		String[] row = new String[MAX_M+1];
		int n, m, i, j, i2, j2, field_id;
		
		char [][]mf = new char[MAX_N + 2][MAX_M + 2];
		
		field_id = 1;
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		while(n != 0 && m != 0)
		{
			
			for(i = 0; i <=n; i++)
				for(j = 0; j <= m; j++)
					mf[i][j] = '0';
			
			for(i = 1; i <= n; i++)
			{
				row[i] = sc.next();
				
				for(j = 1; j <= m; j++)
				{
					if(row[i].charAt(j - 1) == '*')
					{
						for(i2 = i - 1; i2 <= i + 1; i2++)
							for(j2 = j - 1; j2 <= j + 1; j2++)
								if(mf[i2][j2] != '*')
								{
									int temp;
									temp = Character.getNumericValue(mf[i2][j2]);
									temp++;
									mf[i2][j2] = (char)(temp + '0');
								}
						mf[i][j] = '*';
					}
				}
			}
			
			if(field_id > 1)
				System.out.println();
			System.out.println("Field #" + field_id++ + ":");
			for(i = 1; i <= n; i++)
			{
				for(j = 1; j <= m; j++)
					System.out.print(mf[i][j]);
				System.out.println();
			}
			
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			
		}
		sc.close();
	}
}