import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String input = br.readLine();
		//("Hello Goorm! Your input is " + input);
		
		Scanner input = new Scanner(System.in);
		int i = 0 , j = 0, n = 0, m = 0;
		int pNum=0;//게임수
		char[][] c=null;
		char[][] answer=null;
		while(input.hasNextLine()){
			String s= input.nextLine();
			if(s.charAt(0)>='0' && s.charAt(0)<='9'){//현재 줄이 숫자면 배열 생성
				pNum++;
				int space=0;
				for(int k=0;k<s.length();k++){
					if(s.charAt(k)==' ')
						space=k;
				}
				m=Integer.parseInt(s.substring(0,space));
				n=Integer.parseInt(s.substring(space+1));
				c= new char[m][n];
				answer= new char[m][n];
				for(i=0;i<m;i++)
					for(j=0;j<n;j++)
						answer[i][j]='0';
				i=0;
				j=0;
			}else{
				for(j=0;j<n;j++){
					if(s.charAt(j)=='*'){
							answer[i][j]='*';
							for(int a=i-1;a<i+2;a++){
								for(int b=j-1;b<j+2;b++){
									if(a>=0 && a<m && b>=0 && b<n && answer[a][b]!='*'){
										int num = answer[a][b] - '0';
										num= num+49;//아스키 코드 48=0 거기에 1 더해주기
										answer[a][b]=(char)num;
									}
								}
							}
						}
					}
				i++;
				if(i==m){
					System.out.println("Field #"+pNum+":");
					for(int a=0;a<m;a++){
						for(int b=0;b<n;b++){
							System.out.print(answer[a][b]);
						}
						System.out.println();
					}
					System.out.println();
				}
			}
		}
	}
}