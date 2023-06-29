import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int[] y = {-1, 0, 1, 1, 1, 0, -1, -1};
		int[] x = {-1, -1, -1, 0, 1, 1, 1, 0};
		int ts = scan.nextInt();
		scan.nextLine();
		
		while(ts-- > 0)
		{
			// 데이터 입력.
			int m = scan.nextInt();
			int n = scan.nextInt();
			scan.nextLine();
			
			char[][] data = new char[m][n];	// 분석할 데이터.
			
			for(int i=0; i < m; i++) 
				data[i] = scan.nextLine().toLowerCase().toCharArray();
			
			// 문장 입력
			int str_num = scan.nextInt();
			scan.nextLine();
			for(int i=0; i < str_num; i++)
			{
				String s = scan.nextLine().toLowerCase();
				int s_idx = 0; // 시작 인덱스.
				int start_m = -1; int start_n = -1;
				int check_y; int check_x;
				int move_y; int move_x;
				boolean end = false;
				
				// (j, z) -> (m, n)
				for(int j=0; j < m; j++)
				{
					for(int z=0; z < n; z++)
					{
						if(data[j][z] == s.charAt(s_idx))
						{
							int len = s.length();
							start_m = j; start_n = z;
							for(int k=0; k < 8; k++)
							{
								boolean check = true;
								check_y = j + y[k]*len;
								check_x = z + x[k]*len;
								if(check_y >= -1 && check_x >= -1 && check_y <= m && check_x <= n)
								{
									move_y = j;
									move_x = z;
									for(int t=0; t < len; t++)
									{
										if(data[move_y][move_x] != s.charAt(t)) {
											check = false;
											break;
										}
										move_y += y[k];
										move_x += x[k];
									}
									if(check) {
										end = true;
										break;
									}
								}
							}
							if(end) break;
						}
					}
					if(end) break;
				}
				System.out.println((start_m + 1) + " " + (start_n + 1));
			}
			System.out.println();
		}
	}
}







