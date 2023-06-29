import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()){
			String str = input.nextLine();
			int word = 0, num = 0;
			String[] arr = str.split(" |\t");
			for(int i =0; i<arr.length;i++){
				if(arr[i].length()>0){
					word++;
					num += arr[i].length();
				}
			}
			
			System.out.println(num + " " + word);
		}
	}
}