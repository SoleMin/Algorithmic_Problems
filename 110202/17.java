import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
class Main {
	
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()){
			String[] s= input.nextLine().split(" ");
			Integer[] black=new Integer[5];
			Integer[] white=new Integer[5];
			
			for(int i=0; i<s.length; i++){
				if(i<5)
					black[i]=cardNum(s[i]);
				else
					white[i-5]=cardNum(s[i]);
			}
			Arrays.sort(black,Collections.reverseOrder());
			Arrays.sort(white,Collections.reverseOrder());
			
			int bRank=rank(black);
			int wRank=rank(white);
			if(bRank>wRank)
				System.out.println("Black wins.");
			else if (bRank<wRank)
				System.out.println("White wins.");
			else
				System.out.println("Tie.");
		}
		input.close();
	}
	
	public static int cardNum(String ss){
		int result=0;
		if(ss.charAt(0)=='T')
			result=100;
		else if (ss.charAt(0)=='J')
			result=110;
		else if (ss.charAt(0)=='Q')
			result=120;
		else if (ss.charAt(0)=='K')
			result=130;
		else if (ss.charAt(0)=='A')
			result=140;
		else
			result=(ss.charAt(0)-'0')*10;
		
		if (ss.charAt(1)=='H')
			result+=1;
		else if (ss.charAt(1)=='D')
			result+=2;
		else if (ss.charAt(1)=='S')
			result+=3;
		else if (ss.charAt(1)=='C')
			result+=4;
		
		return result;
	}
	
	public static int rank(Integer[] a){
		int result=0;
		int[] value=new int[5];
		int[] suit=new int[5];
		
		for(int i=0; i<5; i++){
			value[i]=a[i]/10;
			suit[i]=a[i]%10;
		}
		
		if (value[1]+1==value[0] && suit[1]==suit[0]
			&& value[2]+2==value[0] && suit[2]==suit[0]
			&& value[3]+3==value[0] && suit[3]==suit[0]
			&& value[4]+4==value[0] && suit[4]==suit[0])
			result=(9<<20)+(value[0]<<16);
		
		else if (value[0]==value[3] || value[1]==value[4])
			result=(8<<20)+(value[1]<<16);
		
		else if (value[0]==value[2] && value[3]==value[4])
			result=(7<<20)+(value[0]<<16);
		else if (value[0]==value[1] && value[2]==value[4])
			result=(7<<20)+(value[2]<<16);
		
		else if (suit[0]==suit[1] && suit[0]==suit[2] && suit[0]==suit[3] && suit[0]==suit[4])
			result=(6<<20)+(value[0]<<16)+(value[1]<<12)+(value[2]<<8)+(value[3]<<4)+value[4];
		
		else if (value[1]+1==value[0] && value[2]+2==value[0] && value[3]+3==value[0] && value[4]+4==value[0])
			result=(5<<20)+(value[0]<<16);
		
		else if (value[0]==value[2] || value[1]==value[3] || value[2]==value[4])
			result=(4<<20)+(value[2]<<16);
		
		else if (value[0]==value[1] && value[2]==value[3])
			result=(3<<20)+(value[0]<<16)+(value[2]<<12)+(value[4]<<8);
		else if (value[0]==value[1] && value[3]==value[4])
			result=(3<<20)+(value[0]<<16)+(value[3]<<12)+(value[2]<<8);
		else if (value[1]==value[2] && value[3]==value[4])
			result=(3<<20)+(value[1]<<16)+(value[3]<<12)+(value[0]<<8);
		
		else if (value[0]==value[1])
			result=(2<<20)+(value[0]<<16)+(value[2]<<12)+(value[3]<<8)+(value[4]<<4);
		else if (value[1]==value[2])
			result=(2<<20)+(value[1]<<16)+(value[0]<<12)+(value[3]<<8)+(value[4]<<4);
		else if (value[2]==value[3])
			result=(2<<20)+(value[2]<<16)+(value[0]<<12)+(value[1]<<8)+(value[4]<<4);
		else if (value[3]==value[4])
			result=(2<<20)+(value[3]<<16)+(value[1]<<12)+(value[1]<<8)+(value[2]<<4);
		
		else 
			result=(1<<20)+(value[0]<<16)+(value[1]<<12)+(value[2]<<8)+(value[3]<<4)+value[4];
		
		return result;
		
	}
}