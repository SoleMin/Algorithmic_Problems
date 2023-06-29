import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int scenario = input.nextInt();
		input.nextLine();
		
		for(int s=0; s<scenario; s++){
			input.nextLine();
			String numT = input.nextLine();
			int num = Integer.parseInt(numT);
			
			double[] TS = new double[num];
			int[] TSnum = new int[num];
			
			for(int i=0; i<num; i++){
				String tempS = input.nextLine();
				String[] temp = tempS.split(" ");
				TS[i] = (double)Integer.parseInt(temp[0])/Integer.parseInt(temp[1]);
				TSnum[i] = i+1;
			}
			
			for(int i=0; i<num; i++){
				int min = i;
				for(int j=i+1; j<num; j++){
					if(TS[j]<TS[min])
						min = j;
				}
				
				double temp = TS[i];
				TS[i] = TS[min];
				TS[min] = temp;
				
				int tempI = TSnum[i];
				TSnum[i] = TSnum[min];
				TSnum[min] = tempI;
			}
			
			for(int i=0; i<num; i++){
				if(i == num-1)
					System.out.print(TSnum[i]);
				else
					System.out.print(TSnum[i] + " ");
			}
			System.out.println();
			System.out.println();
		}
		input.close();
	}
}