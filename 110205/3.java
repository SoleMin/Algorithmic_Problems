import java.io.*;
import java.util.*;


class Main {
	
	public static void main(String[] args) throws Exception {
		
		
		
		Scanner scanner = new Scanner(System.in);
		int testcase_num = scanner.nextInt();
		
		scanner.nextLine();
		scanner.nextLine();
		
		for(int i=0; i<testcase_num; i++){
			
			int n=scanner.nextInt();
			scanner.nextLine();
			int mix[][]=new int[n][52];
			
			for(int j=0; j<n;j++){
				for(int k=0; k<52;k++){
					mix[j][k]= scanner.nextInt()-1;		
				}
				scanner.nextLine();
			}	
			
			int mix_od[] = new int[52];
			
			for(int y=0; y<52;y++)
				mix_od[y]=y;
			
			String[] pair = new String[52];
			
			String[] card_num = {"2","3","4","5","6", "7", "8", "9","10", "Jack", "Queen", "King", "Ace"};
			String[] card_class = {"Clubs","Diamonds", "Hearts", "Spades"};
			int index=0;
			
			for(int j=0; j<4; j++){
				for(int k=0;k<13;k++){
						pair[index++] = card_num[k]+" of "+card_class[j];
				}
			}
			


			
			while(scanner.hasNextLine()){
				String seq= scanner.nextLine();
				if(seq.equals("")){
					break;
				}

				
				int sequence = Integer.parseInt(seq)-1;
				
				int[] newMix = new int[52];
				
				for(int j=0; j<52;j++)
					newMix[j]= mix_od[mix[sequence][j]];

				
				mix_od =newMix.clone();
				
			}
			
			for(int j=0; j<52; j++){
				System.out.println(pair[mix_od[j]]);
			}
			
			System.out.println("");
			
		}

	}

}