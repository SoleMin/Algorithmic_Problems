import java.util.Scanner;
import java.io.*;
class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in); // 입력받아서 정수로 쪼개
		//사용할 변수 정의하기
		int sum = 1;
		while(true){
		String num = input.nextLine();
			int n = Integer.parseInt(num.split(" ")[0]);
			int m = Integer.parseInt(num.split(" ")[1]);
			if(n == 0){
				break;
			}
						// 지뢰주변
			int [][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}; 
			// 지뢰좌표
			int [][] position_mine = new int [n * m][2];
			// 지뢰개수
			int num_mine = 0;
			// 맵
			int [][] map = new int [n][m];
			char [] arr = new char[m];

			// n개수만큼 받음 한줄씩 받아서 * 있는 경우 먼저 처리 
			for(int i=0; i<n; i++){
				String buf = input.nextLine();
				if(buf.contains("*")){
					arr = buf.toCharArray();
					for(int j=0; j<m; j++){
						if(arr[j] == '*'){
							position_mine[num_mine][0] = i;
							position_mine[num_mine++][1] = j;
							map[i][j] = -1;
						}
					}
				}
			}
			// 지뢰 개수에 따른 위치 count 하기
			for(int i=0; i<num_mine; i++){
				int mine_x;
				int mine_y;
				for(int j=0; j<8; j++){
					mine_x = position_mine[i][0] + direction[j][0];
					mine_y = position_mine[i][1] + direction[j][1];
					if(mine_x >= n || mine_x < 0 || mine_y >= m || mine_y < 0 || map[mine_x][mine_y] == -1)
						continue;
					else
						map[mine_x][mine_y]++;
				}
			}
	
						// 출력하기
			System.out.println("Field #"+sum+":");
				for(int i=0; i<n; i++){
					for(int j=0; j<m; j++){
						if(map[i][j] == -1){
							System.out.print('*');
						}
						else{
							// System.out.print("Field #1:");
							System.out.print(map[i][j]);
						}
					}
					System.out.println();
				}
				System.out.println();
				sum++;
			}
		}
	}
		
// 입력받아서 정수로 쪼개기
// 배열 만들기
// * 가 어느 위치에 있는지 파악하기
// 돌면서 *와 . 의 위치 파악하기
// 출력하기