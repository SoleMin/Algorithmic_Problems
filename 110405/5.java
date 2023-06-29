import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		scanner.nextLine();
		
		for(int j=0; j<n;j++){
			scanner.nextLine();
			
			int len = scanner.nextInt();
			scanner.nextLine();
			
			int[] T = new int[len];
			int[] P = new int[len];
			int[] priority= new int[len];
			
			for(int i=0; i<len; i++){
				T[i]= scanner.nextInt();
				P[i]= scanner.nextInt();
				priority[i]= i;
			}
			
			for(int x=1; x<len; x++){
				for(int y=0; y<len-x;y++){
					if(T[priority[y]]*P[priority[y+1]]>T[priority[y+1]]*P[priority[y]]){
						int tmp= priority[y];
						priority[y]=priority[y+1];
						priority[y+1]=tmp;
					}
				}
			}
			
			for(int i=0; i<len; i++){
				System.out.print((priority[i]+1)+" ");
			}
			
			System.out.println("");
			if(j<n)
				System.out.println("");
		}
		
		scanner.close();
		
	}
}