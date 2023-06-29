import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);	
		int num = 1;
		
		String s = input.nextLine();
		int[] dx = {-1,0,1,-1,1,-1,0,1};
		int[] dy = {-1,-1,-1,0,0,1,1,1};
		
		while(input.hasNextLine() && s != "0 0") {
			String[] str = s.split(" ");
			int num1 = Integer.parseInt(str[0]);
			int num2 = Integer.parseInt(str[1]);
			char[][] arr = new char[num1][num2];
			
			for(int i = 0; i<num1; i++) {
				s = input.nextLine();
				for(int j = 0; j<num2; j++) {
					arr[i][j]= s.charAt(j);
				}
			}
			
			System.out.println("Field #" + num + ":");
			num++;
			
			char [][] res = new char[num1][num2];
			
			for(int i = 0; i<num1; i++) {
				for(int j = 0; j<num2; j++) {
					/**조건
					1.i가 시작일 시 + i가 마지막일시
					2.j가 시작일 시 + j가 끝일시
					**/
					int cnt =0;
					for(int h=0; h<8;h++) {
						int x=i+dx[h];
						int y=j+dy[h];
						
						
						if((0<=x && x<num1)&&(0<=y&&y<num2)) {
							if(arr[x][y] == '*') {
								cnt++;
							}
						}
					}
					res[i][j] = Character.forDigit(cnt,10);
					if(arr[i][j] == '*') {
						res[i][j] ='*';
					}
					System.out.print(res[i][j]);
				}
				System.out.print("\n");
			}
			System.out.print("\n");
			/**dx,dy 테그닉 쓰는 문제**/
			s = input.nextLine();
		}
		
		

	}
}