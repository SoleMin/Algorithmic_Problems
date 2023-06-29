import java.util.Scanner;
class Main {
	int entry = 0;
	int[] panelty = new int[10];
	int solvedNum = 0;
	int sum_of_panelty = 0;
	int tryNum = 0;
	boolean[] solved = {false, false, false, false, false, false, false, false, false, false};
	
	private static void sort(Main[] teams, int length){
		Main tem;
		for(int i = length - 1; i > 0; i--)
			for(int k = 0; k < i; k++){
				if(teams[k].solvedNum < teams[k+1].solvedNum){
					tem = teams[k];
					teams[k] = teams[k+1];
					teams[k+1] = tem;
				}
			}
		for(int i = length - 1; i > 0; i--)
			for(int k = 0; k < i; k++){
				if((teams[k].solvedNum == teams[k+1].solvedNum) && (teams[k].sum_of_panelty > teams[k+1].sum_of_panelty)){
					tem = teams[k];
					teams[k] = teams[k+1];
					teams[k+1] = tem;
					}
			}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int entry, q, time;
		String isCorrect;
		Main[] teams = new Main[101];
		
		int testCase = sc.nextInt();
		String tem = sc.nextLine();
		tem = sc.nextLine();
		for(int z = 0; z < testCase; z++){
			for(int i = 0; i < 101; i++){
				teams[i] = new Main();
				teams[i].entry = i;
			}
			
			while(sc.hasNextLine()){
				tem = sc.nextLine();
				if(tem.length() == 0)
					break;
				String[] temp = tem.split(" ");
				entry = Integer.parseInt(temp[0]);
				q = Integer.parseInt(temp[1]);
				time = Integer.parseInt(temp[2]);
				isCorrect = temp[3];
				
				switch(isCorrect){
					case "C": if(!teams[entry].solved[q]){teams[entry].solved[q]=true; teams[entry].panelty[q] += time; teams[entry].tryNum++; teams[entry].solvedNum++; teams[entry].sum_of_panelty += teams[entry].panelty[q];} break;
					case "I" : teams[entry].panelty[q] += 20; teams[entry].tryNum++;break;
					case "R" :
					case "L" :
					case "U" :
					case "E" : teams[entry].tryNum++;break;
				}
			}
				sort(teams, 101);
				
				for(int i = 0; i < 101; i++){
					if(teams[i].tryNum > 0)
						System.out.println(teams[i].entry + " " + teams[i].solvedNum + " " + teams[i].sum_of_panelty);
				}
				
				System.out.println();
			
		}
	}
}