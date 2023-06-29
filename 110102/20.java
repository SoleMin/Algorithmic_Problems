import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int FieldCount = 1;
		
		while(input.hasNextLine()){
			String s = input.nextLine();
			int row=s.charAt(0)-48, col=s.charAt(2)-48;
			if(row != 0 && col != 0) {
				char[][] array1 = new char[row][col];
				char[][] array2 = new char[row][col];
				
				for(int i = 0; i < row; i++){
					s = input.nextLine();
					for(int j = 0; j < col; j++){
						array1[i][j] = s.charAt(j);
					}
				}
				
				System.out.println("Field #"+FieldCount+":");
				for(int i = 0; i < row; i++){
					for(int j = 0; j < col; j++){
						if(array1[i][j] == '*')
							array2[i][j] = '*';
						else{
							int count = 0, kf = i-1, kl = i+1, lf = j-1, ll = j+1;
							if(i-1 < 0)
								kf=i;
							if(i+1 >= row)
								kl=row-1;
							if(j-1 < 0)
								lf=j;
							if(j+1 >= col)
								ll=col-1;
							for(;kf <= kl; kf++){
								for(int g = lf; g <= ll; g++)
									if(array1[kf][g] == '*')
										count++;
								array2[i][j] = Character.forDigit(count, 10);
							}
						}
						System.out.print(array2[i][j]);
					}
					System.out.println();
				}
				FieldCount++;
			}
			System.out.println();
		}
	}
}