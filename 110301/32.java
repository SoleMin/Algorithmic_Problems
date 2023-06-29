import java.io.*;
import java.util.*;
import java.util.Arrays;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input=new Scanner(System.in);

  	
		char[] firstline={'`','1','2','3','4','5','6','7','8','9','0','-','='};
		char[] secondline={'\t','Q','W','E','R','T','Y','U','I','O','P','[',']','\\'};
		char[] thirdline={'A','S','D','F','G','H','J','K','L',';','\''};
		char[] fourthline={'Z','X','C','V','B','N','M',',','.','/'};
		
		while(input.hasNextLine()){
			String in=input.nextLine(); //입력
			char[] arr=in.toCharArray();
			//한 배열 다 돌때까지
			for(int i=0;i<arr.length;i++){
				
				
			   for(int j=1;j<firstline.length;j++){
					 if(arr[i]==firstline[j])
						 arr[i]=firstline[j-1];
				 }
				for(int j=1;j<secondline.length;j++){
					if(arr[i]==secondline[j])
						arr[i]=secondline[j-1];
				}
				for(int j=1; j<thirdline.length;j++){
					if(arr[i]==thirdline[j])
						arr[i]=thirdline[j-1];
				}
				for(int j=1;j<fourthline.length;j++){
					if(arr[i]==fourthline[j])
						arr[i]=fourthline[j-1];
				}
					
					
			}
			
			for(int i=0; i<arr.length;i++)
			  System.out.print(arr[i]);
			
			System.out.println();
		}
	}
}