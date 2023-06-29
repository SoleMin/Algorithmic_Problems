import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			try{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int[] white = new int[5];
				int[] black = new int[5];
				for(int i=0; i<5; i++){
					String s = st.nextToken();
					black[i] = score(s);
				}
				for(int i=0; i<5; i++){
					String s = st.nextToken();
					white[i] = score(s);
				}
				Arrays.sort(white);
				Arrays.sort(black);
				
				
				int whiteScore = straightFlush(white);
				int blackScore = straightFlush(black);
				if(whiteScore==0 && blackScore==0){
					whiteScore = straightFlush(white);
					blackScore = straightFlush(black);
				}
				
				if(whiteScore==0 && blackScore==0){
					whiteScore = foreCard(white);
					blackScore = foreCard(black);
				}
				
				if(whiteScore==0 && blackScore==0){
					whiteScore = fullHouse(white);
					blackScore = fullHouse(black);
				}
				
				if(whiteScore==0 && blackScore==0){
					whiteScore = flush(white);
					blackScore = flush(black);				
				}
				
				if(whiteScore==0 && blackScore==0){
					whiteScore = straight(white);
					blackScore = straight(black);
				}
				
				if(whiteScore==0 && blackScore==0){
					whiteScore = threeCard(white);
					blackScore = threeCard(black);
				}
				
				if(whiteScore==0 && blackScore==0){
					whiteScore = twoPare(white);
					blackScore = twoPare(black);
				}
				
				if(whiteScore==0 && blackScore==0){
					whiteScore = onePare(white);
					blackScore = onePare(black);
				}
				
				if(whiteScore==0 && blackScore==0){
					for(int i=4; i>=0; i--){
						whiteScore = white[i]/10;
						blackScore = black[i]/10;
						if(whiteScore != blackScore) break;
					}
				}
				if(whiteScore > blackScore) sb.append("White wins.");
				else if(whiteScore < blackScore) sb.append("Black wins.");
				else sb.append("Tie.");
				sb.append('\n');
				
				
				
				
				
				
			}
			catch(NullPointerException ignore){
				break;
			}
		}
		System.out.println(sb);
	}
	public static int score(String s){
		int score = 0;
		switch(s.charAt(0)){
			case 'T': score = 100; break;
			case 'J': score = 110; break;
			case 'Q': score = 120; break;
			case 'K': score = 130; break;
			case 'A': score = 140; break;
			default: score = (s.charAt(0)-'0')*10;
		}
		switch(s.charAt(1)){
			case 'C': score += 1; break;
			case 'D': score += 2; break;
			case 'H': score += 3; break;
			case 'S': score += 4; break;
		}
		return score;
	}
	
	public static int straightFlush(int[] array){
		int color = array[0]%10;
		for(int i=1; i<5; i++){
			if(array[i]%10 != color) return 0;
		}
		if(array[4]/10 - array[0]/10 != 4) return 0;
		
		return array[4]/10;
	}
	
	public static int foreCard(int[] array){
		if(array[0]/10==array[1]/10 && array[1]/10==array[2]/10 && array[2]/10==array[3]/10)
			return array[0]/10;
		else if(array[1]/10==array[2]/10 && array[2]/10==array[3]/10 && array[3]/10==array[4]/10)
			return array[1]/10;
		return 0;
	}
	
	public static int fullHouse(int[] array){
		if(array[0]/10==array[1]/10 && array[1]/10==array[2]/10 && array[3]/10==array[4]/10)
			return array[0]/10;
		else if(array[0]/10==array[1]/10 && array[2]/10==array[3]/10 && array[3]/10==array[4]/10)
			return array[2]/10;
		
		return 0;
	}
	
	public static int flush(int[] array){
		int color = array[0]%10;
		for(int i=1; i<5; i++){
			if(array[i]%10 != color) return 0;
		}
		return array[4]/10;
	}
	
	public static int straight(int[] array){
		for(int i=1; i<5; i++){
			if(array[i]/10 -array[i-1]/10 != 1) return 0;
		}
		return array[4]/10;
	}
	
	
	public static int threeCard(int[] array){
		if(array[0]/10==array[1]/10 && array[1]/10==array[2]/10) return array[0]/10;
		else if(array[1]/10==array[2]/10 && array[2]/10==array[3]/10) return array[1]/10;
		else if(array[2]/10==array[3]/10 && array[3]/10==array[4]/10) return array[2]/10;
		
		return 0;
	}
	
	public static int twoPare(int[] array){
		if(array[0]/10==array[1]/10){
			if(array[2]/10==array[3]/10 || array[3]/10==array[4]/10) 
				return Math.max(array[0]/10, array[3]/10);
		}
		else if(array[1]/10==array[2]/10){
			if(array[3]/10==array[4]/10) return Math.max(array[1]/10, array[3]/10);
		}
		return 0;
	}
	
	public static int onePare(int[] array){
		if(array[0]/10==array[1]/10) return array[0]/10;
		else if(array[1]/10==array[2]/10) return array[1]/10;
		else if(array[2]/10==array[3]/10) return array[2]/10;
		else if(array[3]/10==array[4]/10) return array[3]/10;
		return 0;
	}
	

	
	
}