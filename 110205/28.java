import java.io.*;
import java.util.*;
class Main {
	static String[] number = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	static String[] color = {"Clubs", "Diamonds", "Hearts", "Spades"};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		br.readLine();
		StringTokenizer st;
		String[] first = new String[52];
		for(int i=0; i<4; i++){
			int startI = 13*i;
			for(int j=0; j<13; j++){
				first[startI+j] = number[j]+" of "+color[i];
			}
		}
		StringBuilder sb = new StringBuilder();
		while(testCase-->0){
			int size = Integer.parseInt(br.readLine());
			int[][] mix = new int[size+1][52];
			for(int i=1; i<=size; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<52; j++){
					mix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		
		
			String[] result = Arrays.copyOf(first, 52);
			while(true){
				int n;
				try{
					n = Integer.parseInt(br.readLine());
				}
				catch(NumberFormatException e){
					break;
				}
			
				String[] tmp = new String[52];
				for(int i=0; i<52; i++){
					tmp[i] = result[mix[n][i]-1];
				}
				result = Arrays.copyOf(tmp, 52);
			}	
			for(int i=0; i<52; i++){
				sb.append(result[i]).append('\n');
			}
			sb.append('\n');
	
		}
		System.out.println(sb);
		
		
	}
}