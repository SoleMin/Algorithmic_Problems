import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan= new Scanner(System.in);
		while(scan.hasNextLine()){
			int[] whiteHands= new int[5];
			int[] blackHands= new int[5];
			String[] card= scan.nextLine().split(" ");
			int j=0;
			
			for(int i=0;i<5;i++){
				String hands=card[i];
				int temp=ChangeNum(hands.charAt(0),hands.charAt(1));
				blackHands[i]=temp;
			}
			for(int i=5;i<10;i++){
				String hands=card[i];
				int temp=ChangeNum(hands.charAt(0),hands.charAt(1));
				whiteHands[j]=temp;
				j++;
			}
			blackHands=SelectNum(blackHands);
			whiteHands=SelectNum(whiteHands);
			
			long Bresult=StandardHands(blackHands);
			long Wresult=StandardHands(whiteHands);
			
			if(Bresult>Wresult)
				System.out.println("Black wins.");
			else if(Bresult<Wresult)
				System.out.println("White wins.");
			else
				System.out.println("Tie.");
		}
	}
	
	static int ChangeNum(char i,char j){
		int result=0;
		if(i=='T')
			result=100;
		else if(i=='J')
			result=110;
		else if(i=='Q')
			result=120;
		else if(i=='K')
			result=130;
		else if(i=='A')
			result=140;
		else
			result=Integer.parseInt(String.valueOf(i))*10;
		
		if(j=='H')
			result+=1;
		else if(j=='D')
			result+=2;
		else if(j=='S')
			result+=3;
		else if(j=='C')
			result+=4;
		
		return result;
	}
	
	static int[] SelectNum(int[] arr){
		int max=0;
		for(int i=0;i<4;i++){
			max=i;
			for(int j=i+1;j<5;j++){
				if(arr[j]>arr[max]){
					max=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[max];
			arr[max]=temp;
		}
		return arr;
	}
	
	static long StandardHands(int[] arr){
		long result= 0;
		int[] value= new int[5]; 
		int[] suit= new int[5];
			
		for(int i=0;i<5;i++){
			value[i]=arr[i]/10;
			suit[i]=arr[i]%10;
		}
		//스트레이트 플
		if(value[1]+1==value[0] && value[2]+2==value[0] && value[3]+3==value[0] && value[4]+4==value[0] 
			 && suit[1]==suit[0] && suit[2]==suit[0] && suit[3]==suit[0] && suit[4]==suit[0]){
			result= (9<<20)+(value[0]<<16);
		}
		//포카드
		else if(value[1]==value[0] && value[2]==value[0] && value[3]==value[0]){
			result=(8<<20)+(value[0]<<16);
		}else if(value[2]==value[1] && value[3]==value[1] && value[4]==value[1]){
			result=(8<<20)+(value[1]<<16);
		}
		//풀하우스
		else if(((value[1]==value[0] && value[2]==value[0]) && (value[3]==value[4]))
					||((value[1]==value[0] && value[3]==value[0]) && (value[2]==value[4]))
					||((value[1]==value[0] && value[4]==value[0]) && (value[2]==value[3]))
						
					||((value[2]==value[0] && value[3]==value[0]) && (value[1]==value[4]))
					||((value[2]==value[0] && value[4]==value[0]) && (value[1]==value[3]))
					||((value[3]==value[0] && value[4]==value[0]) && (value[1]==value[2]))){
			result=(7<<20)+(value[0]<<16);
		}else if(((value[2]==value[1] && value[3]==value[1]) && (value[0]==value[4]))
					||((value[2]==value[1] && value[4]==value[1]) && (value[0]==value[3]))){
			result=(7<<20)+(value[1]<<16);
		}else if(((value[3]==value[2] && value[4]==value[2]) && (value[0]==value[1]))){
			result=(7<<20)+(value[2]<<16);
		}
		//플러쉬
		else if(suit[1]==suit[0] && suit[2]==suit[0] && suit[3]==suit[0] && suit[4]==suit[0]){
			result=(6<<20)+(value[0]<<16)+(value[1]<<14)+(value[2]<<12)+(value[3]<<10)+(value[4]<<8);
		}
		//스트레이트
		else if((value[1]+1==value[0])&&(value[2]+2==value[0])&&(value[3]+3==value[0])&&(value[4]+4==value[0])){
			result=(5<<20)+(value[0]<<16);
		}
		//트리플
		else if((value[1]==value[0]&&value[2]==value[0]) || (value[1]==value[0]&&value[3]==value[0])
					||(value[1]==value[0]&&value[4]==value[0]) || (value[2]==value[0]&&value[3]==value[0])
					||(value[2]==value[0]&&value[4]==value[0]) || (value[3]==value[0]&&value[4]==value[0])){
			result=(4<<20)+(value[0]<<16);
		}else if((value[2]==value[1]&&value[3]==value[1]) || (value[3]==value[1]&&value[4]==value[1])){
			result=(4<<20)+(value[1]<<16);
		}else if((value[3]==value[2]&&value[4]==value[2])){
			result=(4<<20)+(value[2]<<16);
		}
		//투페어
		else if((value[1]==value[0])&&value[3]==value[2]){
			result=(3<<20)+(value[0]<<16)+(value[2]<<14)+(value[4]<<12);
		}else if((value[2]==value[1])&&(value[4]==value[3])){
			result=(3<<20)+(value[1]<<16)+(value[3]<<14)+(value[0]<<12);
		}else if((value[1]==value[0])&&(value[4])==(value[3])){
			result=(3<<20)+(value[0]<<16)+(value[3]<<14)+(value[2]<<12);
		}
		//원페어
		else if(value[1]==value[0]){
			result=(2<<20)+(value[0]<<16)+(value[1]<<14)+(value[2]<<12)+(value[3]<<10)+(value[4]<<8);
		}else if(value[2]==value[1]){
			result=(2<<20)+(value[1]<<16)+(value[2]<<14)+(value[0]<<12)+(value[3]<<10)+(value[4]<<8);
		}else if(value[3]==value[2]){
			result=(2<<20)+(value[2]<<16)+(value[3]<<14)+(value[0]<<12)+(value[1]<<10)+(value[4]<<8);
		}else if(value[4]==value[3]){
			result=(2<<20)+(value[3]<<16)+(value[4]<<14)+(value[0]<<12)+(value[1]<<10)+(value[2]<<8);
		}
		//하이카드
		else
			result=(1<<20)+(value[0]<<16)+(value[1]<<14)+(value[2]<<12)+(value[3]<<10)+(value[4]<<8);
		return result;
	}
}