import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan= new Scanner(System.in);
		while(scan.hasNextLine()){
			String input1=scan.nextLine();
			String input2=scan.nextLine();
			
			int[] temp1=new int[1000];
			int[] temp2=new int[1000];
			
			for(int i=0;i<input1.length();i++){
				temp1[input1.charAt(i)]++;
			}
			for(int i=0;i<input2.length();i++){
				temp2[input2.charAt(i)]++;
			}
			
			for(int a=97;a<123;a++){
				int num=Math.min(temp1[a],temp2[a]);
				for(int b=0;b<num;b++){
					System.out.print((char)a);
				}
			}
			System.out.println("");
		}
	}
}