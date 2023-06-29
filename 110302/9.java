import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		String s= input.nextLine(); //케이스 수
		int num=Integer.parseInt(s);
		int i,j,k;
		
		while(num!=0){
			s=input.nextLine();//빈줄 넣기
			s=input.nextLine();
			String[] sizeMN = s.split(" ");
			int m = Integer.parseInt(sizeMN[0]);
			int n = Integer.parseInt(sizeMN[1]);
			char[][] grid= new char[m][n];
			
			for(i=0;i<m;i++){//문자열 저장
				s=input.nextLine();
				String lower=s.toLowerCase();//소문자로 만들기
				for(j=0;j<n;j++){
					grid[i][j]=lower.charAt(j);
				}
			}
			/*for(i=0;i<m;i++){
				for(j=0;j<n;j++){
					System.out.print(grid[i][j]);
				}
				System.out.println();
			}*/
			
			s=input.nextLine();
			int kNum=Integer.parseInt(s);
			while(kNum!=0){ //k번 반복
				s=input.nextLine();
				int x=0;//정답
				int y=0;
				boolean find =false;
				
				String lower=s.toLowerCase();//단어 소문자로 만들기
				char c =lower.charAt(0);
				for(i=0;i<m;i++){
					for(j=0;j<n;j++){
						
						
						if(c==grid[i][j]){
							int ic=i, jc=j;
							int l = lower.length();
							for(k=1;k<lower.length();k++){
								jc++;
								if(jc>=n || lower.charAt(k)!=grid[ic][jc])//다르면 다음 단계
									break;
								if(k==lower.length()-1){
									x=i;
									y=j;
									find=true;
								}
							}
							if(!find){
								ic=i; jc=j;
								for(k=1;k<l;k++){
									ic++; jc++;
									if(ic>=m || jc>=n || lower.charAt(k)!=grid[ic][jc])
										break;
									if(k==l-1){
										x=i;
										y=j;
										find=true;
									}
								}
							}
							if(!find){
								ic=i; jc =j;
								for(k=1;k<l;k++){
									ic++;
									if(ic>=m || lower.charAt(k)!=grid[ic][jc])
										break;
									if(k==l-1){
										x=i;
										y=j;
										find=true;
									}
								}
							}
							if(!find){
								ic=i;jc=j;
								for(k=1;k<l;k++){
									ic++;jc--;
									if(ic>=m || jc<0 || lower.charAt(k)!=grid[ic][jc])
										break;
									if(k==l-1){
										x=i;
										y=j;
										find=true;
									}
								}
							}
							if(!find){
								ic=i;jc=j;
								for(k=1;k<l;k++){
									jc--;
									if(jc<0 || lower.charAt(k)!=grid[ic][jc])
										break;
									if(k==l-1){
										x=i;
										y=j;
										find=true;
									}
								}
							}
							if(!find){
								ic=i;jc=j;
								for(k=1;k<l;k++){
									ic--;jc--;
									if(ic<0 || jc<0 || lower.charAt(k)!=grid[ic][jc])
										break;
									if(k==l-1){
										x=i;
										y=j;
										find=true;
									}
								}
							}
							if(!find){
								ic=i;jc=j;
								for(k=1;k<l;k++){
									ic--;
									if(ic<0 || lower.charAt(k)!=grid[ic][jc])
										break;
									if(k==l-1){
										x=i;
										y=j;
										find=true;
									}
								}
							}
							if(!find){
								ic=i;jc=j;
								for(k=1;k<l;k++){
									ic--;jc++;
									if(ic<0 || jc>=n || lower.charAt(k)!=grid[ic][jc])
										break;
									if(k==l-1){
										x=i;
										y=j;
										find=true;
									}
								}
							}
							
							
						}
						
						if(find){
							i=m;
							j=n;
						}
							
					}
				}
				x++;
				y++;
				System.out.println(x+" "+y);
				kNum--;
			}
			System.out.println();//케이스를 나눔
			num--;
		}
	}
}