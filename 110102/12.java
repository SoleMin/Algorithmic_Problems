import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int row, column;
		int Field=1;
		while(input.hasNextInt()){
			row=input.nextInt();
			column = input.nextInt();
			input.nextLine();
			if(row==0 || column==0) continue;
			char charmatrix[][] = new char[row][column];
			int Intmatrix[][] = new int[row][column];
			String complexmatrix[][] = new String[row][column];
			
				for(int i=0;i<row;i++){
					for(int j=0;j<column;j++){
						Intmatrix[i][j]=0;
					}
				}
		for(int i=0;i<row;i++){
			String state = input.nextLine();
			for(int j=0;j<column;j++) charmatrix[i][j]= state.charAt(j);
		}
			for(int i=0;i<row;i++){
				for(int j=0;j<column;j++){
					if(column>0){
						if(j!=0&&charmatrix[i][j-1]=='*') ++Intmatrix[i][j];
						if(i!=(row-1)&&j!=0&&charmatrix[i+1][j-1]=='*' ) ++Intmatrix[i][j];
					}
					if(row>0){
						if(i!=0&&charmatrix[i-1][j]=='*') ++Intmatrix[i][j];
						if(i!=0&&!(j==column-1)&&charmatrix[i-1][j+1]=='*') ++Intmatrix[i][j];
					}
					if(!(j==column-1)&&charmatrix[i][j+1]=='*') ++Intmatrix[i][j];
					if(!(i==row-1)&&charmatrix[i+1][j]=='*') ++Intmatrix[i][j];
					if(column>0 &&row>0){
						if(i!=0&&j!=0&&charmatrix[i-1][j-1]=='*') ++Intmatrix[i][j];
					}
					if(i!=(row-1)&&!(j==column-1)&&charmatrix[i+1][j+1]=='*') ++Intmatrix[i][j];
				}
			}
			for(int i =0;i<row;i++){
				for(int j =0;j<column;j++){
					if(charmatrix[i][j]=='*') complexmatrix[i][j]="*";
					else complexmatrix[i][j]=Integer.toString(Intmatrix[i][j]);
				}
			}
			System.out.println("Field #"+(Field++)+":");
			for(int i=0;i<row;i++){
				for(int j=0;j<column;j++){
					System.out.print(complexmatrix[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}