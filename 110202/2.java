import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			String[] strArr = input.nextLine().split(" ");
			int[] black = new int[5];
			int[] white = new int[5];
			
			for(int i=0; i<10; i++) {
				char c1 = strArr[i].charAt(1);
				char c2 = strArr[i].charAt(0);
				if(i<5)
					black[i] = getShape(c1) + getValue(c2);
				else
					white[i-5] = getShape(c1) + getValue(c2);
			}
			
			/* array sorting */
			int maxb = 0, maxw= 0, temp = 0;
			for(int i=0; i<4; i++) {
				maxb = i;
				maxw = i;
				for(int j=i+1; j<5; j++) {
					if(black[j]%100 > black[maxb]%100)
						maxb = j;
					if(white[j]%100 > white[maxw]%100)
						maxw = j;
				}
				
				temp = black[i];
				black[i] = black[maxb];
				black[maxb] = temp;
				
				temp = white[i];
				white[i] = white[maxw];
				white[maxw] = temp;
			}
			
			int blackHigh = 0, whiteHigh = 0;
			int blackResult = grade(black);
			int whiteResult = grade(white);
			
			blackHigh = blackResult%100;
			whiteHigh = whiteResult%100;
			
			int result = (blackResult/100) - (whiteResult/100);
			
			if(result > 0)
				System.out.println("Black wins.");
			else if(result < 0)
				System.out.println("White wins.");
			else {
				// High Card
				if(blackHigh == 0) {
					int comp = 0;
					for(int i=0; i<5; i++) {
						comp = black[i]%100 - white[i]%100;
						if(comp > 0) {
							System.out.println("Black wins.");
							break;
						}
						else if(comp < 0) {
							System.out.println("White wins.");
							break;
						}
						
						if(i == 4)
							System.out.println("Tie.");
					}
				}
				else {
					int comp = blackHigh - whiteHigh;
					if(comp > 0)
						System.out.println("Black wins.");
					else if(comp < 0)
						System.out.println("White wins.");
					else
						System.out.println("Tie.");
				}
			}
		}
	}
	
	static int grade(int[] arr) {
		int high = 0;
		int[] shape = new int[5];
		int[] value = new int[5];
		
		for(int i=0; i<arr.length; i++) {
			shape[i] = arr[i]/100;
			value[i] = arr[i]%100;
		}
		
		/* flush */
		if(shape[0] == shape[1] && shape[1] == shape[2] && shape[2] == shape[3] && shape[3] == shape[4]) {
			/* straight flush */
			if(value[0] == value[1]+1 && value[0] == value[2]+2 && value[0] == value[3]+3 && value[0] == value[4]+4) {
				high = value[0];
				return 800 + high;
			}
			
			high = value[0];
			return 500 + high;
		}
		
		/* straight */
		if(value[0] == value[1]+1 && value[0] == value[2]+2 && value[0] == value[3]+3 && value[0] == value[4]+4) {
			high = value[0];
			return 400 + high;
		}
		
		/* four card, full house, three card, two pair, one pair, high card */
		int count = 0;
		for(int i=0; i<4; i++)
			for(int j=i+1; j<5; j++)
				if(value[i] == value[j])
					count++;
		
		int score = 0;
		switch(count)
		{
			case 6:
				score = 700;
				break;
			case 4:
				score = 600;
				if(value[2] == value[0])
					high = value[0];
				else
					high = value[2];
				break;
			case 3:
				score = 300;
				break;
			case 2:
				score = 200;
				int max = 0;
				for(int i=0; i<4; i++) {
					for(int j=i+1; j<5; j++) {
						if(value[i] == value[j])
							if(max < value[i])
								max = value[i];
					}
				}
				high = max;
				break;
			case 1:
				score = 100;
				break;
		}
		
		if(count == 6 || count == 3 || count == 1)
			for(int i=0; i<4; i++)
				for(int j=i+1; j<5; j++)
					if(value[i] == value[j])
						high = value[i];
		
		return score + high;
	}
	
	static int getShape(char c1) {
		int result = 0;
		switch (c1) {
			case 'H': result = 100; break;
			case 'D': result = 200; break;
			case 'S': result = 300; break;
			case 'C': result = 400; break;
		}
		return result;
	}
	
	static int getValue(char c2) {
		int result = 0;
		switch (c2) {
			case 'T': result = 10; break;
			case 'J': result = 11; break;
			case 'Q': result = 12; break;
			case 'K': result = 13; break;
			case 'A': result = 14; break;
			default: result = c2 - '0';
		}
		return result;
	}
}