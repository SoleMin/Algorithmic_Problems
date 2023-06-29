import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int field = 1;
		while(true){
			int n = input.nextInt();
			int m = input.nextInt();
			
			if(n == 0&& m == 0)
				break;
			char[][] map = new char[n][m];
			input.nextLine();
			for(int i = 0; i < n; i++){
				String s = input.nextLine();
					for(int j = 0; j < m; j++){
						map[i][j] = s.charAt(j);
						if(map[i][j] == '.')
							map[i][j] = '0';
					}
			}
			
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++)
					if(map[i][j] == '*'){
						for(int x = i-1; x <= i+1; x++){
							for(int y = j-1; y<= j+1; y++){
								if(x >= 0 && x < n && y >= 0 && y < m && map[x][y] != '*')
									map[x][y]++;
							}
						}
							
					}
			}
			if(field != 1)
				System.out.println();
			System.out.println("Field #" + (field++) + ":");
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++)
					System.out.print(map[i][j]);
				System.out.println();
			}
		}
	}
}