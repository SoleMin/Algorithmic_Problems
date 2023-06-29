import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tCCnt=Integer.parseInt(br.readLine());

		String[] suit=new String[] {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] value=new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10","Jack", "Queen", "King", "Ace"};
		String[] oldDeck=new String[52];
		StringBuilder sb;
		
		for(int i=0; i<suit.length; i++){
			for(int j=0; j<value.length; j++){
				sb=new StringBuilder();
				sb.append(value[j]);
				sb.append(" of ");
				sb.append(suit[i]);
				oldDeck[i * value.length + j] = sb.toString();	
			}
		}
		br.readLine();
		String s;
		for(int tc=1; tc<=tCCnt; tc++){
			int n=Integer.parseInt(br.readLine());
			int[][] com=new int[n][52];
			
			StringTokenizer st=new StringTokenizer("");
			for(int i=0; i<n; i++){
				for(int j=0; j<52; j++){
					if(!st.hasMoreTokens()){
						st=new StringTokenizer(br.readLine());
					}
					com[i][j] = Integer.parseInt(st.nextToken()) - 1;
				}
			} 
			String[] nowDeck = Arrays.copyOf(oldDeck, oldDeck.length);
			while(true){
				s = br.readLine();
				if(s==null || s.equals("")){
					break;
				}
				int combi = Integer.parseInt(s) - 1;
				String[] newDeck = new String[52];
				for(int i=0; i<52; i++){
					newDeck[i] = nowDeck[com[combi][i]];
				}
				nowDeck = newDeck;
			}
			sb=new StringBuilder();
			for(int i=0; i<nowDeck.length; i++){
				sb.append(nowDeck[i]);
				sb.append("\n");
			}
			if(tc<tCCnt){
				sb.append("\n");
			}
			System.out.print(sb.toString());
		}
		
		
	}
}