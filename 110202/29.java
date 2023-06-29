import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String bcards[] = new String[5];
	String wcards[] = new String[5];
		
	while(scan.hasNext()){
		Integer[] bnumcard = new Integer[5];
		Integer[] wnumcard = new Integer[5];
		for(int i = 0; i < 10 ; i++){
			if(i < 5){
				bcards[i] = scan.next();
				bcards[i] = bcards[i].replace("T","10");
				bcards[i] = bcards[i].replace("J","11");
				bcards[i] = bcards[i].replace("Q","12");
				bcards[i] = bcards[i].replace("K","13");
				bcards[i] = bcards[i].replace("A","14");
				bcards[i] = bcards[i].replace("H","1");
				bcards[i] = bcards[i].replace("D","2");
				bcards[i] = bcards[i].replace("S","3");
				bcards[i] = bcards[i].replace("C","4");
				bnumcard[i] = Integer.parseInt(bcards[i]);
			} else {
				wcards[i-5] = scan.next();
				wcards[i-5] = wcards[i-5].replace("T","10");
				wcards[i-5] = wcards[i-5].replace("J","11");
				wcards[i-5] = wcards[i-5].replace("Q","12");
				wcards[i-5] = wcards[i-5].replace("K","13");
				wcards[i-5] = wcards[i-5].replace("A","14");
				wcards[i-5] = wcards[i-5].replace("H","1");
				wcards[i-5] = wcards[i-5].replace("D","2");
				wcards[i-5] = wcards[i-5].replace("S","3");
				wcards[i-5] = wcards[i-5].replace("C","4");
				wnumcard[i-5] = Integer.parseInt(wcards[i-5]);
			}
		}
		Arrays.sort(bnumcard,Collections.reverseOrder());
		Arrays.sort(wnumcard,Collections.reverseOrder());
		long bscore = Rank.sum(bnumcard);
		long wscore = Rank.sum(wnumcard);
	if(bscore>wscore){
		System.out.println("Black wins.");
	} else if(bscore<wscore){
		System.out.println("White wins.");
	} else{
		System.out.println("Tie.");
	}
	}
	}
}
																				class Rank{
																					static long sum(Integer[] abc){
																						int[] value = new int[5];
																						int[] suit = new int[5];
																						long result;
																						for(int i = 0; i < 5;i++){
																							value[i] = abc[i]/10;
																							suit[i] = abc[i]%10;
																							}
																							//스트레이트 플러쉬
																							if(value[1]+1 == value[0]&&suit[1]==suit[0]
																							&& value[2]+2==value[0]&&suit[2]==suit[0]
																							&& value[3]+3==value[0]&&suit[3]==suit[0]
																							&& value[4]+4==value[0]&&suit[4]==suit[0])
																							result = (9 << 20) + (value[0] << 16);
																							//포카드
																							else if(value[1]==value[0]
																											&&value[2]==value[0]
																											&&value[3]== value[0])
																								result = (8<<20) + (value[0] << 16);
																							else if(value[2]==value[1]
																											&& value[3]==value[1]
																											&& value[4]==value[1]
																										 )
																								result = (8<<20) + (value[1] << 16);
																							//풀하우스
																							else if(value[1]==value[0]&&value[2]==value[0]&&value[3]==value[4])
																								result = (7<<20) + (value[0]<<16);
																						else if(value[2]==value[3]&&value[2]==value[4]&&value[0]==value[1])
																							result = (7<<20)+ (value[2]<<16);
																						//플러쉬
																						else if(suit[0]==suit[1] && suit[0]==suit[2] && suit[0]==suit[3] && suit[0]==suit[4])
																							result = (6<<20)+(value[0]<<16);
																						//스트레이트
																						else if(value[1]+1 == value[0] && value[0] == value[2]+2 && value[0] == value[3]+3 && value[0] ==value[4]+4)
																							result = (5<<20)+(value[0]<<16);
																						//쓰리 카드
																						else if(value[0]==value[1]&&value[0]==value[2])
																							result = (4<<20)+(value[0]<<16);
																						else if(value[2]==value[3]&&value[2]==value[4])
																							result = (4<<20)+(value[2]<<16);
																						//투 페어
																						else if(value[0]==value[1]&&value[2]==value[3])
																							result = (3<<20)+(value[0]<<16);
																						else if(value[0]==value[1]&&value[3]==value[4])
																							result = (3<<20)+(value[0]<<16);
																						else if(value[1]==value[2]&&value[3]==value[4])
																							result = (3<<20)+(value[1]<<16);
																						//원 페어
																						else if(value[0]==value[1])
																							result = (2<<20)+(value[0]<<16);
																						else if(value[1]==value[2])
																							result = (2<<20)+(value[1]<<16);
																						else if(value[2]==value[3])
																							result = (2<<20)+(value[2]<<16);
																						else if(value[3]==value[4])
																							result = (2<<20)+(value[3]<<16);
																						//하이 카드
																						else 
																							result = (1<<20) + (value[0]<<16)+(value[1]<<12)+(value[2]<<8)+(value[3]<<4)+value[4];
																						return result;	
																					}
																					
																				}
