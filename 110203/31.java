import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan= new Scanner(System.in);
			int test= scan.nextInt();
			
			for(int i=0;i<test;i++){
				int day=scan.nextInt();
				int partyNum=scan.nextInt();
				int[] pauseDay=new int[partyNum];
				int hartals=0;
				
				for(int j=0;j<partyNum;j++){
					pauseDay[j]=scan.nextInt();
				}
				
				for(int a=1;a<=day;a++){
					if(a%7==6||a%7==0){
						continue;
					}
					for(int b=0;b<pauseDay.length;b++){
						if(a%pauseDay[b]==0){
							hartals++;
							break;
						}
					}
				}
				System.out.println(hartals);
		}
	}
}