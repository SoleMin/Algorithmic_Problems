import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int x, y; //행과 열
		int count = 1;
		
		while(true) {
			y = sc.nextInt();
			x = sc.nextInt();
			if(x==0 && y==0)
				break;
			
			//입력 받기 + 출력 저장
			char infield[][] = new char[y+2][x+2];
			int outfield[][] = new int[y+2][x+2];
			for(int i=1; i<y+1; i++) {
				String temp = sc.next();
				for(int j=1; j<x+1; j++) {
					infield[i][j] = temp.charAt(j-1);
					
					if(infield[i][j] == '*') {
						for(int a=i-1; a<=i+1; a++)
							for(int b=j-1; b<=j+1; b++)
								if(outfield[a][b] != -1)
									outfield[a][b]++;
						outfield[i][j] = -1;
					}
				}
			}
			
			//출력
			System.out.println("Field #" + count + ":");
			for(int i=1; i<y+1; i++) {
				for(int j=1; j<x+1; j++) {
					if(outfield[i][j] != -1) {
						System.out.print(outfield[i][j]);
						continue;
					}
					else
						System.out.print("*");
				}
				System.out.println();
			}
			System.out.println();
			
			count++;
		}
		
		sc.close();
	}
}