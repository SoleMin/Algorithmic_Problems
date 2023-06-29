import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		int count = 0;
		while((input = br.readLine()) != null) {
			
			int m = Integer.parseInt(input.split(" ")[0]);
			int n = Integer.parseInt(input.split(" ")[1]);
			
			if(m == 0 && n == 0) {
				break;
			}
			else {count++;}
			
			char game[][] = new char[m][n];
			char field[][] = new char[m][n];
			
			for(int i = 0; i < m; i++){
				for(int j = 0; j <n; j++) {
					field[i][j] = '0';
				}
			}
			
			for(int i = 0; i <m; i++) {
				String Row = br.readLine();
				for(int j = 0; j < n; j++) {
					game[i][j] = Row.charAt(j);
					if(Row.charAt(j) == '*'){
						field[i][j] = '*';
					}
				}
			}
			
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(field[i][j] == '*') {
						for(int r = -1; r <=1; r++) {
							for(int c = -1; c <=1; c++){
								if(r != 0 && c != 0) {
									if(i + r >= 0 && j + c >= 0 && i + r < m && j + c < n) {
										if(field[i+r][j+c] != '*') {
											field[i+r][j+c]++;
										}
									}
								}
								else if(r != 0 || c != 0){
									if(i + r >= 0 && j + c >= 0 && i + r < m && j + c < n) {
										if(field[i+r][j+c] != '*') {
											field[i+r][j+c]++;
										}
									}
								}
							}
						}
					}
				}
			}
			System.out.println("Field #" + count + ":");
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}