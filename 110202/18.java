import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			String[] black = new String[5];
			String[] white = new String[5];
			
			int blackResult = 0;
			int whiteResult = 0;
			
			int whoWin = 0;
			
			String inputS = input.nextLine();
			String[] tempS = inputS.split(" ");
			
			for(int i=0; i<10; i++){
				if(i<5)
					black[i] = tempS[i];
				else
					white[i-5] = tempS[i];
			}
			
			int[] blackValue = get_Value(black);
			int[] blackSuit = get_Suit(black);
			
			int[] whiteValue = get_Value(white);
			int[] whiteSuit = get_Suit(white);
			
			Arrays.sort(blackValue);
			Arrays.sort(whiteValue);
			
			blackResult = get_Result(blackValue, blackSuit);
			whiteResult = get_Result(whiteValue, whiteSuit);
			
			if(blackResult > whiteResult)
				whoWin = 1;
			else if(blackResult < whiteResult)
				whoWin = 2;
			else{
				if(blackResult == 9 || blackResult == 8 || blackResult == 7 || blackResult == 5 || blackResult == 4){
					if(blackValue[2] > whiteValue[2])
						whoWin = 1;
					else
						whoWin = 2;
				}
				
				if(blackResult == 6 || blackResult == 1){
					for(int i=4; i>=0; i--){
						if(blackValue[i] > whiteValue[i]){
							whoWin = 1;
							break;
						}
						if(blackValue[i] < whiteValue[i]){
							whoWin = 2;
							break;
						}
						else
							continue;
					}
				}
				
				if(blackResult == 3){
					if(blackValue[3] > whiteValue[3])
						whoWin = 1;
					else if(blackValue[1] > whiteValue[1])
						whoWin = 1;
					else if(blackValue[3] == whiteValue[3] && blackValue[1] == blackValue[1]){
						int tempIB = find_tempIndex(blackValue);
						int tempIW = find_tempIndex(whiteValue);
						if(blackValue[tempIB] > whiteValue[tempIW])
							whoWin = 1;
						else if(blackValue[tempIB] < whiteValue[tempIW])
							whoWin = 2;
						else
							whoWin = 0;
					}
					else
						whoWin = 2;
				}
				
				if(blackResult == 2){
					int[] tempB = find_tempIndex2(blackValue);
					int[] tempW = find_tempIndex2(whiteValue);
					for(int i=2; i>=0; i--){
						if(tempB[i] > tempW[i]){
							whoWin = 1;
							break;
						}
						if(tempB[i] < tempW[i]){
							whoWin = 2;
							break;
						}
						else
							continue;
					}
				}
			}
			
			if(whoWin == 1)
				System.out.println("Black wins.");
			else if(whoWin == 2)
				System.out.println("White wins.");
			else
				System.out.println("Tie.");
		}
		
		input.close();
	}
	
	public static int[] get_Value(String[] arr){
		int[] valueArr = new int[5];
		
		for(int i=0; i<5; i++){
			int value = 0;
			
			if(arr[i].charAt(0) == 'T')
				value = 10;
			else if(arr[i].charAt(0) == 'J')
				value = 11;
			else if(arr[i].charAt(0) == 'Q')
				value = 12;
			else if(arr[i].charAt(0) == 'K')
				value = 13;
			else if(arr[i].charAt(0) == 'A')
				value = 14;
			else
				value = Character.getNumericValue(arr[i].charAt(0));
			
			valueArr[i] = value;	
		}
		return valueArr;
	}
	
	public static int[] get_Suit(String[] arr){
		int[] suitArr = new int[5];
		
		for(int i=0; i<5; i++){
			int suit = 0;
			
			if(arr[i].charAt(1) == 'C')
				suit = 1;
			else if(arr[i].charAt(1) == 'D')
				suit = 2;
			else if(arr[i].charAt(1) == 'H')
				suit = 3;
			else if(arr[i].charAt(1) == 'S')
				suit = 4;
			
			suitArr[i] = suit;
		}
		return suitArr;
	}
	
	public static int get_Result(int[] Value, int[] Suit){
		int result = 0;
		
		if(Suit[0] == Suit[1] && Suit[1] == Suit[2] && Suit[2] == Suit[3] && Suit[3] == Suit[4]){
			result = 6;
			
			if(Value[4] - 1 == Value[3] && Value[3] - 1 == Value[2] && Value[2] - 1 == Value[1] && Value[1] - 1 == Value[0])
				result = 9;
		}
		
		if(result == 6 || result == 9)
			return result;
		
		else{
			if(Value[0] == Value[3] || Value[1] == Value[4])
				result = 8;
			else if((Value[0] == Value[2] && Value[3] == Value[4]) || (Value[0] == Value[1] && Value[2] == Value[4]))
				result = 7;
			else if(Value[4] - 1 == Value[3] && Value[3] - 1 == Value[2] && Value[2] - 1 == Value[1] && Value[1] - 1 == Value[0])
				result = 5;
			else if(Value[0] == Value[2] || Value[1] == Value[3] || Value[2] == Value[4])
				result = 4;
			else if((Value[0] == Value[1] && Value[2] == Value[3]) || (Value[0] == Value[1] && Value[3] == Value[4]) || (Value[1] == Value[2] && Value[3] == Value[4]))
				result = 3;
			else if(Value[0] == Value[1] || Value[1] == Value[2] || Value[2] == Value[3] || Value[3] == Value[4])
				result = 2;
			else
				result = 1;
		}
		return result;
	}
	
	public static int find_tempIndex(int[] Value){
		int tempI = 0;
		if(Value[2] == Value[1])
			tempI = 0;
		else if(Value[2] == Value[3])
			tempI = 4;
		else
			tempI = 3;
		
		return tempI;
	}
	
	public static int[] find_tempIndex2(int[] Value){
		int tempI = 0;
		int[] tempArr = new int[3];
		
		if(Value[0] == Value[1])
			tempI = 1;
		else if(Value[1] == Value[2])
			tempI = 2;
		else if(Value[2] == Value[3])
			tempI = 3;
		else if(Value[3] == Value[4])
			tempI = 4;
		
		for(int i=0; i<5; i++){
			if(tempI != i && tempI-1 != i)
				tempArr[i] = Value[i];
		}
		return tempArr;
	}
}