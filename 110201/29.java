import java.util.*;
import java.lang.Math;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Boolean jolly;
		while(sc.hasNextLine()){
			jolly = true;
			int num = 0;
			String input = sc.nextLine();
			String [] all = input.split(" ");
			num = Integer.parseInt(all[0]);
			int [] num_arr = new int[num];
			for(int i=1; i<num+1; i++){
				num_arr[i-1] = Integer.parseInt(all[i]);
			}
			
			if(num == 1){
				System.out.println("Jolly");
				continue;
			}
			
			int diff;
			int [] count = new int[num];
			for(int i=0; i<num-1; i++){
				diff = Math.abs(num_arr[i] - num_arr[i+1]);
				try{
					count[diff]++;
				}
				catch(ArrayIndexOutOfBoundsException e){
					jolly = false;
					break;
				}
			}
			
			if(jolly){
				for (int i=1; i<num; i++){
					if(count[i] != 1){
						jolly = false;
						break;
					}
				}
				if(count[0] != 0){
					jolly = false;
				}
				if(count[0] != 0)
					jolly = false;
			}
			
			if(jolly){
				System.out.println("Jolly");
			}
			else{
				System.out.println("Not jolly");
			}
		}
	}
}
