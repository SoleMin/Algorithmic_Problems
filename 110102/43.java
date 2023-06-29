import java.util.Scanner;
class Main {
	public static void main(String[] args)  {
		Scanner sc= new Scanner(System.in);
		int num=0;
		
		while(true) {
			int y= sc.nextInt();
			int x= sc.nextInt();
			
			if(x!=0 && y!=0) {
				String [][] fieldA = new String[y][x];
				String [][] fieldB = new String[y][x];
				num++;
				
				for(int i=0; i<y; i++) {
					String s= sc.next();
					for(int j=0; j<x; j++) {
						fieldA[i][j]=s.substring(j,j+1);
					}
				}
				for(int i=0; i<y; i++) {
					for(int j=0; j<x; j++) {
						if(fieldA[i][j].equals("*")) { //지뢰일 때
							fieldB[i][j]="*";
						}
						else { //지뢰가 아닐 때
							int count=0;
							if(i>0 && j>0 && fieldA[i-1][j-1].equals("*")) //왼쪽 위
								count++;
							if(i>0 && fieldA[i-1][j].equals("*"))  //위
								count++;
							if(i>0 && j<x-1 && fieldA[i-1][j+1].equals("*")) //오른쪽 위
								count++;
							if(j>0 && fieldA[i][j-1].equals("*")) //왼쪽
								count++;
							if(j<x-1 && fieldA[i][j+1].equals("*")) //오른쪽
								count++;
							if(i<y-1 && j>0 && fieldA[i+1][j-1].equals("*")) //왼쪽 아래
								count++;
							if(i<y-1 && fieldA[i+1][j].equals("*")) //아래
								count++;
							if(i<y-1 && j<x-1 && fieldA[i+1][j+1].equals("*")) //오른쪽 아래
								count++;
							
							String StringCount= Integer.toString(count);// 문자로 변환해 넣기
							fieldB[i][j]=StringCount;
						}
						
					}
				}
			
			System.out.println("Field #"+num+":");
			for(int i=0; i<y; i++) {
				for(int j=0; j<x; j++) {
					System.out.print(fieldB[i][j]);
				}
				System.out.println();
			}
				System.out.println();
		}
		else
			break;
	}
	}
}