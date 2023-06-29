import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		int count=1;
		while(true){
			
			
			int n= input.nextInt();
			int m= input.nextInt();
			
			if(n==0 & m==0)
				break;
			
			char[][]array=new char[n][m];
			
			for(int i=0;i<n;i++){
				String str=input.next();
				for(int j=0;j<m;j++){
					array[i][j]=str.charAt(j);
					if(array[i][j]=='*')
						continue;
					else
						array[i][j]='0';
				}
			}
			//지뢰 세기
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					if(array[i][j]=='*')
						continue;
					else{   //8범위
						for(int number=0,k=((i>0)? i-1:0); k<i+2 && k<n;k++) //범위 오류방지
							for(int p=((j>0) ? j-1:0); p<j+2 && p<m; p++)
								if(array[k][p]=='*'){
									number++;
									array[i][j]=Character.forDigit(number,10);
								}
					}
				}
			}
				
				
				
			System.out.println("Field #"+ count + ":");
			count++;
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					System.out.print(array[i][j]);
				}
				System.out.println();
			}
			
			System.out.println();
			
			
			}
	}
}