import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		
		for(int t=0;t<testCase;t++){
			
			int days = input.nextInt();
			int party = input.nextInt();
			
			int arr[]= new int[party];
			
			for(int i=0;i<party;i++){
				arr[i]=input.nextInt();
			}
			
			int count=0;
			
			for(int i=1;i<=days;i++){
				if(i%7 == 6 ||i%7 ==0){
				}else{
				for(int j =0;j<party;j++){
					if(i%arr[j]==0){
						count++;
						break;
					}
				}
				}
			}
			System.out.println(count);
		}
	}
}