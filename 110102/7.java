import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int n, m, mapNumber=1;
		while(true) {
			String s = input.nextLine();
			Scanner cutter = new Scanner(s);
			n = cutter.nextInt();
			m = cutter.nextInt();
			cutter.close();
			
			if(n==0 && m==0)
				break;
			
			if(mapNumber != 1)
				System.out.println();
			
			System.out.println("Field #" + mapNumber++ + ":");
			String[][] map = new String[n][m];
			for(int i=0; i<n; i++) {
				s = input.nextLine();
				for(int j=0; j<m; j++)
					map[i][j] = s.substring(j, j+1);
			}
			
			for(int i=0; i<n; i++)
				for(int j=0; j<m; j++)
					if(map[i][j].equals(".")) {
						int count = 0;
						for(int k=i-1; k<i+2; k++)
							for(int l=j-1; l<j+2; l++) {
								if(k<0 || k>=n || l<0 || l>=m)
									continue;
								if(map[k][l].equals("*"))
									count++;
							}
						map[i][j] = count + "";
					}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++)
					System.out.print(map[i][j]);
				System.out.println();
			}
		}
	}
}