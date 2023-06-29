import java.util.Scanner;

class Main {
	static class Hand{
		int value=0;
		char suit=' ';
		long result=0;
	}
	public static void main(String[] args) throws Exception {
		Scanner input=new Scanner(System.in);
		
		while(input.hasNextLine()){
			int count =0;
		String cards = input.nextLine();
			String card[] = cards.split(" ");
			Hand[] Black = new Hand[5];
			for(int i =0;i<Black.length;i++){
				Black[i] = new Hand();
			}
			Hand[] White = new Hand[5];
			for(int i =0;i<White.length;i++){
				White[i] = new Hand();
			}
			for(int i =0;i<Black.length;i++){
				Black[i].value = card[i].charAt(0) -'0';
				Black[i].suit = card[i].charAt(1);
			}
			for(int i =5;i<10;i++){
				White[count].value=card[i].charAt(0)-'0';
				White[count++].suit = card[i].charAt(1);
			}
			encode_card(Black);
			encode_card(White);
			
			if(get_hand_value(Black)>get_hand_value(White))
				System.out.println("Black wins.");
			else if (get_hand_value(Black)<get_hand_value(White))
				System.out.println("White wins.");
			else if(get_hand_value(Black)==get_hand_value(White)){
				long Bvalue[] = new long[5];
				long Wvalue[] = new long[5];
				for(int i =0;i<5;i++){
					Bvalue[i] = Black[i].result/10;
					Wvalue[i] = White[i].result/10;
				}
				if(2000<=get_hand_value(Black)&&get_hand_value(Black)<=14000){
					if(Bvalue[3]>Wvalue[3]) System.out.println("Black wins.");
					else if(Bvalue[3]<Wvalue[3]) System.out.println("White wins.");
					else System.out.println("Tie.");
					continue;
				}
				String k="";
				for(int i =1;i<5;i++){
					if(Bvalue[i]>Wvalue[i]){
						k="Black wins.";
						System.out.println("Black wins."); break;
					}
					else if(Bvalue[i]<Wvalue[i]){
						k="White wins.";
						System.out.println("White wins."); break;
					}
				}
				if(k=="Black wins."||k=="White wins.") continue;
			System.out.println("Tie."); continue;

			}
			
							
			}
	}
	public static void encode_card(Hand hand[]){
		for(int i =0;i<hand.length;i++){
			switch(hand[i].value){
				case 36: hand[i].result +=100; break;
				case 26: hand[i].result +=110; break;
				case 33: hand[i].result +=120; break;
				case 27: hand[i].result +=130; break;
				case 17: hand[i].result +=140; break;
				default: hand[i].result +=hand[i].value*10; break;
			}
			switch(hand[i].suit){
				case 'H' : hand[i].result +=1; break;
				case 'D' : hand[i].result +=2; break;
				case 'S' : hand[i].result +=3; break;
				case 'C' : hand[i].result +=4; break;
			}
		}
	}
	public static long get_hand_value(Hand hand[]){
		int max;
		Hand[] temp = new Hand[5];
		for(int i=0;i<temp.length;i++){
			temp[i] = new Hand();
		}
		long result;
		long[] value = new long[5];
		int[] suit = new int[5];
		for(int i =0;i<4;i++){
			max=i;
			for(int j=i+1;j<5;j++){
				if(hand[j].result>hand[max].result)
					max=j;
			}
			temp[i]=hand[i];
			hand[i]=hand[max];
			hand[max]=temp[i];
		}
		for(int i=0;i<5;i++){
			value[i] = hand[i].result/10;
			suit[i] = hand[i].suit%10;
		}
		
		if(value[1]+1 == value[0] && suit[1]==suit[0]
			&&value[2]+2 == value[0] &&suit[2] == suit[0]
			&&value[3]+3 == value[0] &&suit[3] == suit[0]
			&&value[4]+4 == value[0] &&suit[4]==suit[0])
			return result = hand[0].result*100000000;
		
		if(value[1]==value[0] && value[2]==value[0]&&value[3]==value[0])
			return result = hand[0].result*10000000;
		if(value[2]==value[1]&&value[3]==value[1]&&value[4]==value[1])
			return result= hand[1].result*10000000;
		if(value[1]==value[0]&&value[2]==value[0]&&value[3]==value[4])
			 return result = hand[0].result*1000000;
			if(value[1]==value[0]&&value[3]==value[2]&&value[4]==value[2])
			return result= hand[2].result*1000000;
	if(suit[1]==suit[0]&&suit[2]==suit[0]&&suit[3]==suit[0]&&suit[4]==suit[0])
			return result = hand[0].result*100000;
		if(value[1]+1 == value[0]&&value[2]+2==value[0]
			&&value[3]+3==value[0]&&value[4]+4==value[0])
			return result=hand[0].result*10000;
		if(value[1]==value[0]&&value[2]==value[0])
			return result= hand[0].result*1000;
		if(value[3]==value[2]&&value[4]==value[2])
			return result= hand[2].result*1000;
		if(value[2] == value[1]&&value[3]==value[1])
			return result = hand[1].result*1000;
		if(value[1]==value[0]&&value[2]==value[3])
			return result =value[0]*1000;
		if(value[1]==value[2]&&value[3]==value[4])
			return result= value[1]*1000;
		if(value[1]==value[0]&& value[4]==value[3])
			return result = value[0]*1000;
		if(value[1]==value[0]) return result = value[0]*100;
		if(value[2]==value[1]) return result = value[1]*100;
		if(value[3]==value[2]) return result = value[2]*100;
		if(value[4]==value[3]) return result = value[3]*100;
		
		return value[0];
			
	}
}