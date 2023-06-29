import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args)  {
		
		Scanner input=new Scanner(System.in);
		while(input.hasNext()){
			
			
			String[] black=new String[5];
			String[] white=new String[5];
			
			int[] bhand=new int[5];
			int[] whand=new int[5];
			
			int bvalue,wvalue;
			for(int i=0;i<5;i++)
				black[i]=input.next();
			for(int i=0;i<5;i++)
				white[i]=input.next();
			
			for(int i=0;i<5;i++){
				char[] bcard=black[i].toCharArray();
				bhand[i]=encode_card(bcard);
				char[] wcard=white[i].toCharArray();
				whand[i]=encode_card(wcard); 
			}
			for(int i=0;i<4;i++){//카드정렬
				int max=i;
				for(int j=i+1;j<5;j++)
					if(bhand[j]>bhand[max])
						max=j;
				int temp=bhand[i];
				bhand[i]=bhand[max];
				bhand[max]=temp;
			}
			for(int i=0;i<4;i++){
				int max=i;
				for(int j=i+1;j<5;j++)
					if(whand[j]>whand[max])
						max=j;
				int temp=whand[i];
				whand[i]=whand[max];
				whand[max]=temp;
			}
			bvalue=get_hand_value(bhand);
			wvalue=get_hand_value(whand);
			
			if(bvalue != wvalue){
				if(bvalue>wvalue)
					System.out.println("Black wins.");
			  else if(bvalue<wvalue)
					System.out.println("White wins.");
				else
					System.out.println("Tie.");
			}
			else{
				if(bvalue==2){
					if(bhand[1]/10 > whand[1]/10)
						System.out.println("Black wins.");
					else if(bhand[1]/10 < whand[1]/10)
						System.out.println("White wins.");
					else
						System.out.println("Tie.");
					
				}else if(bvalue==8 || bvalue ==7 || bvalue ==3){
					if(bhand[2]/10>whand[2]/10)
						System.out.println("Black wins.");
					else if(bhand[2]/10 < whand[2]/10)
						System.out.println("White wins.");
					else
						System.out.println("Tie.");
					
				}else if(bvalue==0){
					
					int k=0;
					if(bhand[0]/10 != whand[0]/10){
						while((bhand[k]/10)  != (whand[k]/10)){
							if(bhand[k]/10 > whand[k]/10){
								System.out.println("Black wins.");
								break;}


							else if(bhand[k]/10 < whand[k]/10){
								System.out.println("White wins.");
								break;}

							k++;
					  }
					}else	
				    System.out.println("Tie.");	  
					
				}else{
					if(bhand[0]/10>whand[0]/10)
						System.out.println("Black wins.");
					else if(bhand[0]/10<whand[0]/10)
						System.out.println("White wins.");
					else
						System.out.println("Tie.");
				}
				
			}
		}
		
	}
	public static Integer get_hand_value(int[] hand){
		int i,j;
		int[] value=new int[5];
		int[] suit=new int[5];
		int result;
		
		for(i=0;i<5;i++){
			value[i]=hand[i]/10; //숫자
			suit[i]=hand[i]%10;	//무늬
		}
		//스트레이트 플래쉬
		if(value[1]+1==value[0] && value[2]+2==value[0] && value[3]+3==value[3] && value[4]+4 ==value[0]&&suit[1]==suit[0]&&suit[2]==suit[0] && suit[3]==suit[0] &&suit[4]==suit[0])
			result=9;
		//포카드
		else if(value[0]==value[1] && value[0]==value[2] &&value[0]==value[3]&&value[0]==value[4])
			result=8;
		//풀하우스
		else if(value[0]==value[2]&&value[3]==value[4]||value[2]==value[4] && value[0]==value[1])
			result=7;
		//플러쉬
		else if(suit[1]==suit[0] && suit[2]==suit[0]&&suit[3]==suit[0]&&suit[4]==suit[0])
			result=6;
		//스트레이트
		else if(value[1]+1==value[0] && value[2]+2==value[0]&&value[3]+3==value[0]&&value[4]+4==value[0])
			result=5;
		//쓰리 카드
		else if(value[0]==value[2]||value[1]==value[3] || value[2]==value[4])
			result=3;
		//투페어
		else if(value[0]==value[1]&&value[2]==value[3])
			result=2;
		else if(value[0]==value[1]&&value[3]==value[4])
			result=2;
		else if(value[1]==value[2]&&value[3]==value[4])
			result=2;
		//원페어
		else if(value[0]==value[1])
			result=1;
		else if(value[1]==value[2])
			result=1;
		else if(value[2]==value[3])
			result=1;
		else if(value[3]==value[4])
			result=1;
		//하이 카드
		else 
			result=0;
		
		return result;
	}
	public static Integer encode_card(char[] card){
		int result;
		
		switch(card[0]){
			case 'T':
				result=100;
				break;
			case 'J':
				result=110;
				break;
			case 'Q':
				result=120;
				break;
			case 'K':
				result=130;
				break;
			case 'A':
				result=140;
				break;
			default:
				result=(card[0]-'0')*10; //문자열숫자 int로 변환
		}
		switch (card[1]){
			case 'H':
				result +=1;
				break;
			case 'D':
				result +=2;
				break;
			case 'S':
				result +=3;
				break;
			case 'C':
				result +=4;
				break;
		}  
		return result;
	}
	
}