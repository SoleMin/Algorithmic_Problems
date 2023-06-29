import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input	= new Scanner(System.in);
		
		while(input.hasNextLine()){
			String inputS = input.nextLine();
			String[] tempNums = inputS.split(" ");
			int numsLength = Integer.parseInt(tempNums[0]);
			boolean isJolly = true;
			
			int[] nums = new int[numsLength];
			
			for(int i=1; i<numsLength+1; i++){
				nums[i-1] = Integer.parseInt(tempNums[i]);
			}
			
			int[] difference = new int[numsLength -1];
			
			for(int i=0; i<numsLength-1; i++){
				int diff = nums[i] - nums[i+1];
				if(diff < 0)
					diff = -diff;
				
				if(diff >numsLength-1){
					isJolly = false;
					break;
				}
				difference[i] = diff;
			}
			
			if(isJolly == true){
				Arrays.sort(difference);
				for(int i=0; i<numsLength-1; i++){
					if(difference[i] != i+1){
						isJolly = false;
						break;
					}
				}
			}
			
			if(isJolly == true)
				System.out.println("Jolly");
			else
				System.out.println("Not jolly");
		}
		input.close();
	}
}