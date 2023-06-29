import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		Map<Integer, int[]> hashmap = new HashMap<>();
		
		/*
		 * Clubs = 100, Diamonds = 200, Hearts = 300, Spades = 400
		 * Jack = 11, Queen = 12, King = 13, Ace = 14
		 */
		int[] init = new int[52];
		for(int i=0; i<52; i++)
			init[i] = ((i/13+1)*100)+(i%13)+2;
		
		int testCase = Integer.parseInt(input.nextLine());
		String newline = input.nextLine();
		for(int i=0; i<testCase; i++) {
			int[] cards = new int[52];
			for(int j=0; j<52; j++)
				cards[j] = j+1;
			
			int shuffle = Integer.parseInt(input.nextLine());
			String strtemp = "";
			for(int j=0; j<shuffle; j++) {
				String str = input.nextLine();
				strtemp = strtemp + str;
				if(strtemp.length() < 52)
					break;
				else {
					String[] strArr = str.split(" ");
					int[] intArr = new int[52];
					
					for(int k=0; k<52; k++)
						intArr[k] = Integer.parseInt(strArr[k]);
					hashmap.put(j, intArr);
				}
			}
			
			boolean first = true;
			while(input.hasNextLine()) {
				String str = input.nextLine();
				if(str.equals("")) break;
				
				int integer = Integer.parseInt(str);
				int[] intArr = hashmap.get(integer-1);
					
				for(int k=0; k<52; k++) {
					if(first) {
						cards = intArr.clone();
						first = false;
						break;
					}
					else {
						if(intArr[k] != k+1) {
							int temp = cards[k];
							cards[k] = cards[intArr[k]-1];
							cards[intArr[k]-1] = temp;
							
							temp = intArr[k];
							intArr[k] = intArr[temp-1];
							intArr[temp-1] = temp;
						}
					}
				}
			}
			
			for(int j=0; j<52; j++) {
				String card = " of ";
				int num = cards[j];
				int shape = init[num-1]/100;
				int value = init[num-1]%100;
				
				switch(shape)
				{
					case(1) :
						card = card + "Clubs";
						break;
					case(2) :
						card = card + "Diamonds";
						break;
					case(3) :
						card = card + "Hearts";
						break;
					case(4) :
						card = card + "Spades";
				}
				
				if(value > 10) {
					switch(value)
					{
						case(11) :
							card = "Jack" + card;
							break;
						case(12) :
							card = "Queen" + card;
							break;
						case(13) :
							card = "King" + card;
							break;
						case(14) :
							card = "Ace" + card;
					}
					System.out.println(card);
				}
				else
					System.out.println(value + card);
			}
			
			System.out.println();
		}
	}
}