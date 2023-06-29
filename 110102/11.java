import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int count=0;
		
		while(true){
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			if(m==0 && n==0) break;
			char mines[][]= new char[m][n];


			for(int i=0 ;i<m;i++){
				String st= scanner.next();
				for(int j=0; j<n;j++){
					mines[i][j]=st.charAt(j);
				}
			}
			count++;
			System.out.println("Field #"+count+ ":");

			for(int i=0; i<m;i++){
				for ( int j=0; j<n; j++){
					if(mines[i][j]=='*'){
						System.out.print('*');
					}
					else{
						int mine_num=0;
						for(int ii=( (i>0) ? i-1:0 ) ; ii<i+2 && ii<m ;ii++)
							for(int jj= ( (j>0)? j-1:0) ; jj< j+2 && jj<n ; jj++ )
								if(mines[ii][jj]=='*') mine_num+=1;

						System.out.print(mine_num);
					}
				}
				System.out.println("");
			}
			System.out.println("");
		}
	}
}