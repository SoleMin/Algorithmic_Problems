import java.io.IOException;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		int count =0;	//필드번호
	
		while(true){
			
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			char[][] board = new char[n][m];
			
			if(n==0 && m==0)	//n=m=0 종료
				break;
				
			//입력받은 n,m형태의 2차원 배열 board 생성
			for(int i=0; i<n; i++){		
				String line = scanner.next();
				for(int j=0; j<m; j++){
					board[i][j] = line.charAt(j);
				}
			}
			count++;	//출력 조건 필드 번호.
			System.out.println("Field #" + count + ":");
		
			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
				
					if(board[i][j] == '*') //*이 존재하면 그대로 *출력
						System.out.print('*');
					//주위 8칸에 지뢰가 몇개인지 세는 2중 for문
					else{
						int p=0;
						for(int k=(i>0) ? i-1 : 0; k <= i+1 && k<=n-1; k++)
							for(int l=(j>0) ? j-1 : 0; l <= j+1 && l <= m-1; l++)
								if(board[k][l] == '*') p++;
						System.out.print(p); 
					}	
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
