import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan= new Scanner(System.in);
		while(scan.hasNextLine()){
		int num= scan.nextInt();
		scan.nextLine();
		int[] f=new int[1000000];
		f[0]=0;
		f[1]=1;
		int temp= f[1];
		if(num==1){
			System.out.println("1");
			return;
		}else{
			for(int i=2;i<num+1;i++){
				f[i]=1+f[i-f[f[i-1]]];
				temp+=f[i];
				if(temp>=num){
					System.out.println(i);
					break;
				}
			}
		}
		}
	}
}