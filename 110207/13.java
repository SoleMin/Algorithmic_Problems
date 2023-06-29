import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		br.readLine();
		StringBuilder sb = new StringBuilder();
		
		while(testCase-->0){
			//index = teamNumber, value = solvedCount
			int[] solved = new int[101];
			Arrays.fill(solved, -1);
			
			//index = teamNumber, value = penaltyTime
			int[] penaltyTime = new int[101];
			
			//index r = teamNumber, index c = pNumber, value = incorrectCount
			int[][] incorrect = new int[101][10];
			StringTokenizer st;
			int teamCount=0;
			while(true){
				int team, pNumber, time;
				try{
					st = new StringTokenizer(br.readLine());
					team = Integer.parseInt(st.nextToken());
					pNumber = Integer.parseInt(st.nextToken());
					time = Integer.parseInt(st.nextToken());
				}
				catch(NoSuchElementException | NullPointerException e){
					break;
				}
				// 제출이 처음인 팀은 0으로 참가 표시.
				if(solved[team]==-1){
					teamCount++;
					solved[team]=0;
				}
				char c = st.nextToken().charAt(0);
				if(c=='I') incorrect[team][pNumber]++;
				else if(c=='C'){
					solved[team]++;
					penaltyTime[team] += time + 20*incorrect[team][pNumber];
				}
				
			}
			// result[i][0] = teamNumber, result[i][1] = solved, result[i][2] = penaltyTime
			int[][] result = new int[teamCount][3];
			int size=0;
			for(int i=1; i<=100; i++){
				if(solved[i]!=-1){
					result[size][0] = i;
					result[size][1] = solved[i];
					result[size++][2] = penaltyTime[i];
				}
			}
			
			// 1순위 solved : o[1], 2순위 delay : o[2], 3순위 teamNumber : o[0]
			Arrays.sort(result, (o1,o2) ->{
				if(o1[1]==o2[1]){
					if(o1[2]==o2[2]) return Integer.compare(o1[0],o2[0]);
					else return Integer.compare(o1[2],o2[2]);
				}
				else return Integer.compare(o2[1],o1[1]);
			});
			
			for(int i=0; i<teamCount; i++){
				sb.append(result[i][0]).append(' ').append(result[i][1]).append(' ').append(result[i][2]).append('\n');
			}
			sb.append('\n');
			
			
			
			
		}
		System.out.println(sb);
		
		
		
		
		
	}
}
