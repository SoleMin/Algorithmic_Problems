import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int t=input.nextInt();
		input.nextLine();
		input.nextLine();
		for(int i=0; i<t; i++){
			ArrayList<Integer> array=new ArrayList<Integer>();
			int[] answer=new int[101];
			int[][] a= new int[101][10];
			int[][] b=new int[101][3];
			while(input.hasNext()) {
				String s=input.nextLine();
				if(s.equals(""))
					break;
				String[] ss=s.split(" ");
				int team=Integer.parseInt(ss[0]);
				int num=Integer.parseInt(ss[1]);
				int min=Integer.parseInt(ss[2]);
				char result=ss[3].charAt(0);
				b[team][0]=team;
				if(result=='C'){
					b[team][1]++;
					b[team][2]+=a[team][num]+min;
				}
				else if (result=='I')
					a[team][num]+=20;
			}
			
			for(int j=1; j<101; j++){
				if(b[j][0]!=0){
					int k=((9-b[j][1]<<16)+(b[j][2]<<8)+b[j][0]);
					array.add(k);
					answer[j]=k;
				}
			}
			
			Collections.sort(array);
			
			for(int x=0; x<array.size(); x++){
				for(int y=0; y<101; y++){
					if(answer[y]==array.get(x))
						System.out.println(b[y][0]+" "+b[y][1]+" "+b[y][2]);
				}
			}
			System.out.println();
			
		}
		input.close();
	}
}