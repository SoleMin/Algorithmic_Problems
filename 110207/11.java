import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		String CaseTemp = input.nextLine();
		int cases = Integer.parseInt(CaseTemp);
		input.nextLine();
		
		for(int c=0; c<cases; c++){
			Map<Integer, Integer> totalSolve = new HashMap<Integer, Integer>();
			Map<Integer, Integer> totalTime = new HashMap<Integer, Integer>();
			Map<Integer, int[]> wrongSol = new HashMap<Integer, int[]>();
			Map<Integer, int[]> problemSolve = new HashMap<Integer, int[]>();
			
			while(input.hasNextLine()){
				String inputS = input.nextLine();
				
				if(inputS.contentEquals(""))
					break;
				
				String[] tempS = inputS.split(" ");
				
				int teamNum = Integer.parseInt(tempS[0]);
				int problemNum = Integer.parseInt(tempS[1]);
				int time = Integer.parseInt(tempS[2]);
				String right = tempS[3];
				
				int key = teamNum;
				
				if(!totalSolve.containsKey(key)){
					totalSolve.put(key, 0);
					totalTime.put(key, 0);
					int[] problems = new int[9];
					problemSolve.put(key, problems);
					int[] wrong = new int[9];
					wrongSol.put(key, wrong);
				}
				
				int getTotalSolve = totalSolve.get(key);
				int getTotalTime = totalTime.get(key);
				int[] getProblem = problemSolve.get(key);
				int[] getWrong = wrongSol.get(key);
				
				if(getProblem[problemNum-1] != 0){
					continue;
				}
				
				else{
					if(right.equals("C")){
						getProblem[problemNum-1] = time;
						getTotalTime = getTotalTime + time + getWrong[problemNum-1] * 20;
						getTotalSolve += 1;
					}
					
					else if(right.equals("I")){
						getWrong[problemNum-1] += 1;
					}
					
					else{
						continue;
					}
					
					totalSolve.put(key, getTotalSolve);
					totalTime.put(key, getTotalTime);
					problemSolve.put(key, getProblem);	
				}
			}//while 끝
			
			int keyNums = totalSolve.size();
			int[][] result = new int[keyNums][3];
			int num =0;
			Iterator<Integer> it = totalSolve.keySet().iterator();
			
			while(it.hasNext()){
				int key = it.next();
				
				result[num][0] = key;
				result[num][1] = totalSolve.get(key);
				result[num][2] = totalTime.get(key);
				num++;
			}
			
			Arrays.sort(result, (o1, o2) -> {
				if(o1[1] == o2[1]){
					if(o1[2] == o2[2])
						return Integer.compare(o1[0], o2[0]);
					else
						return Integer.compare(o1[2], o2[2]);
				}
				else{
					if(o1[1] > o2[1])
						return -1;
					else
						return 1;
				}
			});
			
			for(int i=0; i<result.length; i++){
				System.out.println(result[i][0] + " " + result[i][1] + " " + result[i][2]);
			}
			if(c != cases-1)
				System.out.println();
		}
		input.close();
	}
}