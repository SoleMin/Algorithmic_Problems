import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan= new Scanner(System.in);
		
		int n=scan.nextInt();
		scan.nextLine();
		
		for(int i=0;i<n;i++){
			scan.nextLine();
			int result=0;
			int peopleNum=Integer.parseInt(scan.nextLine());
			
			int[] length=new int[peopleNum];
			for(int j=0;j<peopleNum;j++){
				length[j]=Integer.parseInt(scan.nextLine());
			}
			Arrays.sort(length);
			
			if(peopleNum==0)
				result+=length[0];
			else if(peopleNum==1)
				result+=length[0]+length[1];
			else if(peopleNum==2)
				result+=length[0]+length[1]+length[2];
			else if(peopleNum>2){
				int j=0;
				for(j=peopleNum-1;j>=3;j-=2){
					if(length[1]*2+length[0]+length[j]<length[0]*2+length[j]+length[j-1])
						result=result+length[0]+length[1]+length[j]+length[1];
					else
						result=result+length[j]+length[j-1]+length[0]+length[0];
				}
				if(j==2)
					result=result+length[0]+length[1]+length[2];
				else
					result+=length[1];
			}
			System.out.println(result);
			System.out.println("");	
		}
	}
}