import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int[] taskTime, taskMoney, taskResult;
		int testcase;
		int i, j, k, temp, task;
		
		testcase = input.nextInt();
		
		for(i=0; i < testcase; i++) {
			task = input.nextInt();
			taskTime = new int[task];
			taskMoney = new int[task];
			taskResult = new int[task];
			
			for(j=0; j < task; j++) {
				taskTime[j] = input.nextInt();
				taskMoney[j] = input.nextInt();
				taskResult[j] = j;
			}
			
			for(j=1; j < task; j++) 
				for(k=0; k < task - 1; k++) {
					if(taskTime[taskResult[k]]*taskMoney[taskResult[k+1]] > 
						 taskTime[taskResult[k+1]]*taskMoney[taskResult[k]]) {
						temp = taskResult[k];
						taskResult[k] = taskResult[k+1];
						taskResult[k+1] = temp;
					}
				}
			
			for(j=0; j < task; j++)
				System.out.print((taskResult[j] + 1) + " ");
			System.out.println("\n");
		}
		input.close();
	}
}