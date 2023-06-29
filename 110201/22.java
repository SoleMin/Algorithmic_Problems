import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan= new Scanner(System.in);
		while(scan.hasNextLine()){
			String[] strArr= scan.nextLine().split(" ");
			boolean[] isSel=new boolean[3000];
			int numStart= Integer.parseInt(strArr[0]);
			int[] numArr= new int[numStart];
			int jolly=1;
			for(int i=0;i<numStart;i++){
				numArr[i]=Integer.parseInt(strArr[i+1]);
			}
			for(int j=1;j<numStart;j++){
				int result=Math.abs(numArr[j-1]-numArr[j]);
				if(result<=0||result>=numStart||isSel[result]==true){
					jolly=0;
					break;
				}
				isSel[result]=true;
			}
			if(jolly==0){
				System.out.println("Not jolly");
			}else{
				System.out.println("Jolly");
			}
			
		}
	}
}