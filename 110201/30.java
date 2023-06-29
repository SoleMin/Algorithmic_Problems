import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	while(scan.hasNextInt()){
		
		int num = scan.nextInt();
		
		int[] fj = new int[num];
		int[] nfj = new int[num-1];
		for(int i = 0; i < num; i++){
			fj[i] = scan.nextInt();
		}
		if(num == 1){
			System.out.println("Jolly");
		} 
		else {
		//int[] nfj = new int[num-1];
			for(int i = 0; i < num-1 ; i++){
				nfj[i] = Math.abs(fj[i] - fj[i+1]);
			}
		
			
			int[] setnum = new int[num-1];	
			for(int i = 0; i < num-1; i++){
				setnum[i] = i+1;
			}

			ArrayList<Integer> arl = new ArrayList<Integer>();
			for(int i = 0; i<num-1; i++){
				int item = nfj[i];
				if(!arl.contains(item))
					arl.add(item);
			}

			Collections.sort(arl);
			int[] snfj = new int[arl.size()];
			int size = 0;
			for(Integer temp : arl){
				snfj[size++] = temp;
			}
			Arrays.sort(setnum);

			if(Arrays.equals(snfj, setnum)){
				System.out.println("Jolly");
			} else{
				System.out.println("Not jolly");
			}
		}	
		}
	






}
}

