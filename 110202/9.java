import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		int black[]=null;
		int white[]=null;
		long bScore=0, wScore=0;
		int i=0;
		int j=0;
		while(input.hasNextLine()){
			black=new int[5];
			white=new int[5];
			String s= input.nextLine();
			String[] card=s.split(" ");
			for(i=0;i<5;i++){
				black[i]=encode_card(card[i]);
			}
			for(i=5;i<10;i++){
				white[i-5]=encode_card(card[i]);
			}
			bScore=get_hand_value(black);
			wScore=get_hand_value(white);
			
			if(bScore>wScore)
				System.out.println("Black wins.");
			else if(bScore<wScore)
				System.out.println("White wins.");
			else
				System.out.println("Tie.");
			//System.out.println(j);
			j++;
		}
	}
	static int sum(int a, int b){
		return a+b;
	}
	static int encode_card(String card){
		int result;
			
		switch(card.charAt(0)){
			case 'T': result=100; break;
			case 'J': result=110; break;
			case 'Q': result=120; break;
			case 'K': result=130; break;
			case 'A': result=140; break;
			default: result = (card.charAt(0)-'0')*10;
		}
		switch(card.charAt(1)){
			case 'H': result+=1; break;
			case 'D': result+=2; break;
			case 'S': result+=3; break;
			case 'C': result+=4; break;
		}
		return result;
	}
	static long get_hand_value(int hand[]){
		int i,j, max, temp;
		int value[] = new int[5];
		int suit[] = new int[5];
		long result=0;
		for(i=0;i<4;i++){
			max=i;
			for(j=i+1;j<5;j++)
				if(hand[j]>hand[max])
					max=j;
			temp=hand[i];
			hand[i]=hand[max];
			hand[max]=temp;
		}
		for(i=0;i<5;i++){
			value[i]=get_value(hand[i]);
			suit[i]=get_suit(hand[i]);
		}
		
		if(value[1]+1==value[0] && suit[1]==suit[0] && value[2]+2==value[0] && suit[2]==suit[0] && value[3]+3==value[0] && suit[3]==suit[0] && value[4]+4==value[0] && suit[4]==suit[0]){
			result = (9<<20) + (value[0]<<16); //System.out.println(1);
		}else if((value[0]==value[1] && value[0]==value[2] && value[0]==value[3]) || (value[4]==value[3] && value[4]==value[2] && value[4]==value[1])){//포카드
			result =(8<<20) + (value[2]<<16);//System.out.println(2);
		}else if((value[0]==value[1] && value[0]==value[2] && value[3]==value[4]) || (value[4]==value[3] && value[4]==value[2] && value[1]==value[0])){//풀하우스
			result = (7<<20) + (value[2]<<16);//System.out.println(3);
		}else if(suit[0]==suit[1] && suit[0]==suit[2] && suit[0]==suit[3] && suit[0]==suit[4]){//플러시
			result = (6<<20) + (value[0]<<16);//System.out.println(4);
		}else if(value[1]+1==value[0] && value[2]+2==value[0] && value[3]+3==value[0] && value[4]+4==value[0]){//스트레이트
			result = (5<<20) +(value[0]<<16);//System.out.println(5);
		}else if((value[0]==value[1] && value[0]==value[2]) || (value[4]==value[3] && value[4]==value[2])){//쓰리카드
			result = (4<<20) + (value[2]<<16);//System.out.println(6);
		}else if((value[0]==value[1] && value[2]==value[3]) || (value[0]==value[1] && value[3]==value[4]) || (value[1]==value[2] && value[3]==value[4])){
			int m=0;
			if(value[0]==value[1] && value[2]==value[3])
				m=value[4];
			else if(value[0]==value[1] && value[3]==value[4])
				m=value[2];
			else
				m=value[0];
			result = (3<<20) + (value[1]<<16) + (m<<12);//System.out.println(7);
		} else if(value[0]==value[1] || value[1]==value[2] || value[2]==value[3] || value[3]==value[4]){
			int m=0,n=value[0];
			for(i=0;i<4;i++){
				if(value[i]==value[i+1]){
					m=value[i];
					if(i==0)
						n=value[i+2];/////////////
					break;
				}
			}
			result = (2<<20)+(m<<16)+(n<<12);//System.out.println(8);
		}else
			result = (1<<20) + (value[0]<<16) + (value[1]<<12)+ (value[2]<<8) + (value[3]<<4) + (value[4]); //System.out.println(9);
		
		return result;
	}
	static int get_value(int hand){
		return hand/10;
	}
	static int get_suit(int hand){
		return hand%10;
	}
}



