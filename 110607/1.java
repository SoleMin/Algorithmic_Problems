import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int[] F = new int[10000000];
		
		F[0]=1;
		F[1]=2;
		F[2]=4;
		F[3]=6;
		int index=4;
		int many=3;
		while(F[index-1]<=2000000000){
			int count = F[many] - F[many-1];
			while(count>0 && F[index-1]<=2000000000){
				F[index] = F[index-1]+many;
				index++;
				count--;
			}
			many++;
		}
		

		//System.out.print(Arrays.toString(F));

		while(scanner.hasNextInt()){
			int find = scanner.nextInt();
			scanner.nextLine();
			if(find==0)
				break;
			
			for(int i=0;i<F.length;i++){
				if(F[i]>find){
					System.out.println(i);
					break;
				}
			}
			
		}
		
		//System.out.println(F[6]);
		
	}
}