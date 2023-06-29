import java.util.*;
class Main {
	
	static int[] TI, SI, R;
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int cases, i, num;
		
		cases = input.nextInt();
		while(cases-- > 0){
			num = input.nextInt();
			TI = new int[num];
			SI = new int[num];
			R = new int[num];
			
			for(i = 0; i < num; i++){
				TI[i] = input.nextInt();
				SI[i] = input.nextInt();
				R[i] = i;
			}
			sort(num);
			for(i = 0; i < num-1; i++)
				System.out.print((R[i]+1) + " ");
			System.out.println(R[i]+1 + "\n");
		}
	}
	
	static void sort(int size){
		int i, j, temp;
		for(i = 1; i < size; i++){
			for(j = 0; j < size-1; j++){
				if(TI[R[j]] * SI[R[j+1]] > TI[R[j+1]] * SI[R[j]]){
					temp = R[j];
					R[j] = R[j+1];
					R[j+1] = temp;
				}
			}
		}
	}
}