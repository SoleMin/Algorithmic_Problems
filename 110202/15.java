import java.util.Scanner;
class Main {
		public static int get_value(int x){
			return x/10;
		}
		public static int get_suit(int x){
			return x%10;
		}
		
		public static int encode(char[] card){
			int result;
			switch(card[0]){
				case 'T': result=100; break;
				case 'J': result=110; break;
				case 'Q': result=120; break;
				case 'K': result=130; break;
				case 'A': result=140; break;
				default : result=(card[0]-'0')*10;
			}
			switch(card[1]){
				case 'H': result += 1; break;
				case 'D': result += 2; break;
				case 'S': result += 3; break;
				case 'C': result += 4; break;
			}
			return result;
		}
		
		public static int isFourCard(int[] value){
			if((value[0] == value[1] && value[0] == value[2] && value[0] == value[3]) ||
				 (value[0] == value[1] && value[0] == value[2] && value[0] == value[4]) ||
				 (value[0] == value[1] && value[0] == value[3] && value[0] == value[4]) ||
				 (value[0] == value[2] && value[0] == value[3] && value[0] == value[4]))
				return value[0];
			else if(value[1] == value[2] && value[1] == value[3] && value[1] == value[4])
				return value[1];
			return 0;
		}
		
		public static int[] makeCount(int[] value){
			int n;
			int count[] = new int[15];
			for(int i = 0; i < 5; i++){
				n = value[i];
				count[n]++;
			}
			return count;
		}
		
		public static int isFullHouse(int[] count){
			int have3=0, have2=0;
			for(int i = 2; i <= 14; i++){
				if(count[i] == 3)
					have3 = i;
				else if(count[i] == 2)
					have2 = i;
			}
			if(have3>0 && have2>0)
				return have3;
			return 0;
		}
		
		public static int isThreeCard(int[] count){
			for(int i = 2; i <= 14; i++)
				if(count[i] == 3)
					return i;
			return 0;
		}
		
		public static int isTwoPair(int[] count){
			int have2=0, count2=0;
			for(int i = 2; i <= 14; i++){
				if(count[i] == 2){
					have2 = i;
					count2++;
				}
			}
			if(count2 == 2)
				return have2;
			return 0;
		}
		
		public static int twoPair(int[] countB, int[] countW){
			int nB=0, nW=0;
			for(int i = 2; i <= 14; i++){
				if(countB[i] == 1)
					nB=i;
				if(countW[i] == 1)
					nW=i;
				if(countB[i] == 2 && countW[i] != 2){
					System.out.println("White wins.");
					return 0;
				}
				else if(countB[i] != 2 && countW[i] == 2){
					System.out.println("Black wins.");
					return 0;
				}
			}
			if(nB > nW)
				System.out.println("Black wins.");
			else if(nB < nW)
				System.out.println("White wins.");
			else
				System.out.println("Tie.");
			return 0;
		}
		
		public static int isOnePair(int[] count){
			for(int i = 2; i <= 14; i++)
				if(count[i] == 2)
					return i;
			return 0;
		}
		
		public static int hi(int[] black, int[] white){
			for(int i = 0; i < 5; i++){
				black[i] = black[i]/10;
				white[i] = white[i]/10;
				if(black[i] > white[i]){
					System.out.println("Black wins.");
					return 0;
				}
				else if(black[i] < white[i]){
					System.out.println("White wins.");
					return 0;
				}
			}
			System.out.println("Tie.");
			return 0;
		}
		
		public static int[] get_hand_value(int[] hand){
			int i,j, max, temp;
			for(i = 0; i < 4; i++){
				max = i;
				for(j = i+1; j < 5; j++)
					if(hand[j] > hand[max])
						max = j;
				temp = hand[i];
				hand[i] = hand[max];
				hand[max] = temp;
			}
			return hand;
		}
		
		public static long final_result(int[] hand){
			int[] value = new int[5];
			int[] suit = new int[5];
			int[] count;
			long result = 0;
			for(int i = 0; i < 5; i++){
				value[i] = get_value(hand[i]);
				suit[i] = get_suit(hand[i]);
			}
			count=makeCount(value);
			
			if(value[1]+1 == value[0] && suit[1] == suit[0]
				&& value[2]+2 == value[0] && suit[2] == suit[0]
				&& value[3]+3 == value[0] && suit[3] == suit[0]
				&& value[4]+4 == value[0] && suit[4] == suit[0])
				result = (9 << 20) + (value[0] << 16);
			else if(isFourCard(value) > 0)
				result=(8 << 20) + (isFourCard(count) << 16);
			else if(isFullHouse(count) > 0)
				result = (7 << 20) + (isFullHouse(count) << 16);
			else if(suit[0] == suit[1] &&
						 suit[0] == suit[2] &&
						 suit[0] == suit[3] &&
						 suit[0] == suit[4])
				result = (6 << 20);
			else if(value[1] + 1 == value[0]
						 && value[2] + 2 == value[0]
						 && value[3] + 3 == value[0]
						 && value[4] + 4 == value[0])
				result = (5 << 20) + (value[0] << 16);
			else if(isThreeCard(count) > 0)
				result = (4 << 20) + (isThreeCard(count) << 16);
			else if(isTwoPair(count) > 0)
				result = (3 << 20) + (isTwoPair(count) << 16);
			else if(isOnePair(count) > 0)
				result = (2 << 20) + (isOnePair(count) << 16);
			else
				result = (1 << 20);
			return result;
		}
		
		public static void main(String[] args) throws Exception {
			Scanner input = new Scanner(System.in);
			int[] black = new int[5];
			int[] white = new int[5];
			int[] black_value= new int[5];
			int[] white_value = new int[5];
			char[] temp = new char[2];
			int i;
			long rb, rw;
			String s;
			while(input.hasNext()){
				for(i = 0; i < 5; i++){
					s = input.next();
					temp[0] = s.charAt(0);
					temp[1] = s.charAt(1);
					black[i] = encode(temp);
				}
				for(i = 0; i < 5; i++){
					s = input.next();
					temp[0] = s.charAt(0);
					temp[1] = s.charAt(1);
					white[i] = encode(temp);
				}
				black_value = get_hand_value(black);
				white_value = get_hand_value(white);
				rb = final_result(black_value);
				rw = final_result(white_value);
				if(rb == rw){
					if(rb > (3 << 20) && rb < (4 << 20)){
						for(i = 0; i <= 4; i++){
							black_value[i] = get_value(black_value[i]);
							white_value[i] = get_value(white_value[i]);
						}
						twoPair(makeCount(black_value), makeCount(white_value));
					}
					else
						hi(black, white);
				}
				else if(rb > rw)
					System.out.println("Black wins.");
				else if(rb < rw)
					System.out.println("White wins.");
				else
					System.out.println("Tie.");
			}
	
	}
}