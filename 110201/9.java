import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		int i,j=0;
		int n=0;
		int[] present=null;
		int diff;
		int cur, pre;
		boolean jolly=true;
		
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()){
			jolly = true;
			String s = input.nextLine();
			String num[] = s.split(" ");
			//System.out.println(num.length);
			n = Integer.parseInt(num[0]);//숫자 개수
			present = new int[n];
			pre = Integer.parseInt(num[1]);
			
			for(i=2; i<n+1;i++){
				cur = Integer.parseInt(num[i]);
				diff = cur - pre;
				if(diff<0)
					diff= -diff;
				if(diff==0 || diff>=n || present[diff]==1){
					jolly=false;
					break;
				}
				present[diff] =1;
				pre = cur;
			}
			if(jolly)
				System.out.println("Jolly");
			else
				System.out.println("Not jolly");
			
			
			
			/*for(i=0;i<s.length();i++){
				if(s.charAt(i)==' '){
					n = Integer.parseInt(s.substring(0,i));
					present = new int[n];
					
				}
			}
			for(i=0; i<)*/
		}
	}
}