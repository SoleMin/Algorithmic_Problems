import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		int testcase = input.nextInt();
		input.nextLine();
		input.nextLine();
		
		for(int t=0; t<testcase; t++){
			
			int team[][] = new int [100][4];
			int arr[][] = new int[100][9];
			int arr2[][] = new int[100][9];
			
			for(int i=1; i<=100; i++){
				team[i-1][2]=i;
			}
			
			for(int i=0;i<100;i++){
				for(int j=0;j<9;j++){
					arr[i][j]=1;
				}
			}
			
			while(input.hasNextLine()){
				
				String string = input.nextLine();
				
				if(string.equals("")){
					break;
				}
				String list[]= string.split(" ");
				int teamNum = Integer.parseInt(list[0])-1;
				int time = Integer.parseInt(list[2]);
				int pro = Integer.parseInt(list[1]);
				char c =list[3].charAt(0);
				
				if(c=='C' && arr[teamNum][pro]==1){
					team[teamNum][0]++;
					team[teamNum][1]+=time;
					team[teamNum][1]+=arr2[teamNum][pro];
					arr[teamNum][pro]--;
				}else if(c=='I' && arr[teamNum][pro]==1){
					arr2[teamNum][pro]+=20;
				}
				
				team[teamNum][3]++;
				
			}
			
			Arrays.sort(team, new Comparator<int[]>(){
				@Override
				public int compare(int[] o1,int[] o2){
					if(o1[0]==o2[0]){
						if(o1[1]==o2[1]){
							return o1[2]-o2[2];
						}else{
							return o1[1]-o2[1];
						}
					}else{
						return o2[0]-o1[0];
					}
				}
			});
			
			
			for(int i=0;i<100;i++){
				if(team[i][3]!=0){
					System.out.printf("%d %d %d\n",team[i][2],team[i][0],team[i][1]);
				}
			}
			System.out.println();
		}

	}
}