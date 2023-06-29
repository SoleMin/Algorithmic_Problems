import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int casenum = scan.nextInt();
		scan.nextLine();
		scan.nextLine();
		
		for(int i = 0; i < casenum ; i++){
			
			int[][] problem = new int[100][9];
			char[][] countans = new char[100][9];
			int[] answer = new int[100];
			for(int v=0;v<100;v++){
			Arrays.fill(countans[v],'a');
 			Arrays.fill(problem[v], 0);
			}
			int[] sumpt = new int[100];
			boolean[] bool = new boolean[100];
			Arrays.fill(bool, false);
			
			while(scan.hasNextLine()){
				String input = new String();
				input = scan.nextLine();
				if(input.equals("")) break;
				String[] incase = input.split(" ");
				int prnum = Integer.parseInt(incase[1]);
				int team = Integer.parseInt(incase[0]);
				int pt = Integer.parseInt(incase[2]);
				bool[team-1] = true;	
				
				switch(incase[3]){
					case "I":
						//if (countans[team-1][prnum-1] !='C')
						problem[team-1][prnum-1] += 20;
						break;
					case "C":
						//if (countans[team-1][prnum-1] != 'C'){
						problem[team-1][prnum-1] += pt;
						countans[team-1][prnum-1] = 'C';
						//}
						break;
					case "R":
					case "L":
					case "E":
						break;
				}
			}
			
			int total_team = 0;
			int sum = 0;
			for(int j = 0; j< 100;j ++)
				if (bool[j]) total_team++;
			team[] set_team = new team[total_team];
			for(int j = 0; j < 100;j++ ){
				int cnt = 0;
				for(int x = 0; x < 9 ; x++){
					if(countans[j][x] == 'C') cnt++;
				}
				answer[j] = cnt;
			}
			
			for(int q = 0; q <100;q++){
				for(int w = 0; w<9;w++){
					if(countans[q][w] == 'a')
						problem[q][w] = 0;
					sum += problem[q][w];
				}
				sumpt[q] = sum;
				sum = 0;
			}
			int temp = 0;
			for(int k = 0; k < 100; k++){
				if(bool[k])
				set_team[temp++] = new team(k+1 , answer[k], sumpt[k]);
			}
			Arrays.sort(set_team);
			for(int y = 0; y < total_team; y++)
				System.out.println(set_team[y].teamnum + " " +set_team[y].correctnum+ " "+set_team[y].timepenalty );
			System.out.println();
		}	
		System.out.println();
	}
}

class team implements Comparable<team>{
	int teamnum;
	int correctnum;
	int timepenalty;
	
	public team(int a, int b, int c){
		teamnum = a;
		correctnum = b;
		timepenalty = c;
	}
	
	public int compareTo(team B){
		if (this.correctnum != B.correctnum){
			return B.correctnum - this.correctnum;
		}
		
		if (this.timepenalty != B.timepenalty){
			return this.timepenalty - B.timepenalty;
		}
		
		return this.teamnum - B.teamnum;
		
		
	}
	
	
	
	
}