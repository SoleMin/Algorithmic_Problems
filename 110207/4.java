import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input= new Scanner(System.in);
		
		String s = input.nextLine();
		int n=Integer.parseInt(s);
		input.nextLine();
		while(n!=0){
			boolean[][] test=new boolean[100][9];//제출했는지 여부 ->맞은 문제 확인
			int[][] time=new int[100][9];//문제당 시간
			int[] correctTime=new int[100];//맞은 문제만 시간을 더함
			int[] solve=new int[100];//푼 문제수
			
			int[] res=new int[100];//제출한 팀들의 순위를 매긴다
			
			//int[] result=new int[100];
			
			while(input.hasNextLine()){
				s= input.nextLine();
				if(s.equals(""))
					break;
				String[] team=s.split(" ");//인덱스 0-팀 번호 1-문제 2-시간 3-상황
				int t=Integer.parseInt(team[0])-1;
				int p=Integer.parseInt(team[1])-1;
				int penalty=Integer.parseInt(team[2]);
				
				res[t]=t+1;//
				switch(team[3]){
					case "I": time[t][p]+=20;break;//팀의 p번째 문제풀이시간 +20
					case "C": if(test[t][p]==true){break;}
						correctTime[t]+=time[t][p]+penalty;	solve[t]++;	test[t][p]=true; break;//팀t의 시간벌점은 문제를 틀린횟수*20+ 답 제출한데 걸린시간, 푼 문제+1
				}
				//t에 해당하는 팀을 true로 /////////////////////
			}
			int temp;
			int k=0;
			
			/*for(int i=0;i<100;i++){
				if(res[i]==0){continue;}
				for(int j=0;j<9;j++){
					System.out.println(res[i]+" "+j+" "+test[i][j]+" "+correctTime[i]);
				}
			}*/
			for(int i=0;i<100-1;i++){
				if(res[i]==0)//제출한 팀만 살펴봄
					continue;
				//result[k]=i+1;
				for(int j=i+1;j<100;j++){
					if(res[j]==0)
						continue;
					if(solve[j]>solve[i] || ((solve[j]==solve[i])&&(correctTime[j]<correctTime[i])) || (solve[j]==solve[i] && correctTime[j]==correctTime[i] && res[i]>res[j])){
						//result[k]=j+1;//
						temp=res[i];
						res[i]=res[j];
						res[j]=temp;
						
						temp=solve[i];
						solve[i]=solve[j];
						solve[j]=temp;
						
						temp=correctTime[i];
						correctTime[i]=correctTime[j];
						correctTime[j]=temp;
					}
				}
				k++;
			}
			
			for(int i=0;i<100;i++){
				//int m=result[i];
				if(res[i]==0)
					continue;
				System.out.println((res[i])+" "+solve[i]+" "+correctTime[i]);
				/*if(m==0)
					break;
				System.out.println(m+" "+solve[m-1]+" "+correctTime[m-1]);*/
			}
			System.out.println();
			n--;
		}
	}
}