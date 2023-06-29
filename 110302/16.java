import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		String Casetemp = input.nextLine();
		int cases = Integer.parseInt(Casetemp);
		
		for(int c=0; c<cases; c++){
			input.nextLine();
			String MNtemp = input.nextLine();
			String[] MNtempp =	MNtemp.split(" ");
			
			int M = Integer.parseInt(MNtempp[0]);
			int N = Integer.parseInt(MNtempp[1]);
			
			String[][] greedt = new String[M][N];
			Character[][] greed = new Character[M][N];
			
			for(int i=0; i<M; i++){
				String linet = input.nextLine();
				String line = linet.toLowerCase();
				greedt[i] = line.split("");
			}
			
			for(int i=0; i<M; i++){
				for(int j=0; j<N; j++){
					greed[i][j] = greedt[i][j].charAt(0);
				}
			}
			
			String findNtemp = input.nextLine();
			int findN = Integer.parseInt(findNtemp);
			
			for(int n=0; n<findN; n++){
				String findWordt = input.nextLine();
				String findWord = findWordt.toLowerCase();
				
				boolean found = false;
				
				int row = 0;
				int col = 0;
				
				int rowD = 0;
				int colD = 0;
				
				for(int i=0; i<M; i++){
					for(int j=0; j<N; j++){
						if(greed[i][j] == findWord.charAt(0)){
							row = i;
							col = j;
							char firstCh = findWord.charAt(1);
							
							if(i-1>=0 && j-1>=0 && found == false && greed[i-1][j-1] == firstCh){
								rowD = -1; colD = -1;
								found = findWordDir(findWord, greed, row, col, rowD, colD);
								if(found == true)
									break;
							}
							
							if(i-1>=0 && found == false && greed[i-1][j] == firstCh){
								rowD = -1; colD = 0;
								found = findWordDir(findWord, greed, row, col, rowD, colD);
								if(found == true)
									break;
							}
							
							if(i-1>=0 && j+1<N && found == false && greed[i-1][j+1] == firstCh){
								rowD = -1; colD = 1;
								found = findWordDir(findWord, greed, row, col, rowD, colD);
								if(found == true)
									break;
							}
							
							
							if(j-1>=0 && found == false && greed[i][j-1] == firstCh){
								rowD = 0; colD = -1;
								found = findWordDir(findWord, greed, row, col, rowD, colD);
								if(found == true)
									break;
							}
							
							if(j+1<N && found == false && greed[i][j+1] == firstCh){
								rowD = 0; colD = 1;
								found = findWordDir(findWord, greed, row, col, rowD, colD);
								if(found == true)
									break;
							}
							
							
							if(i+1<M && j-1>=0 && found == false && greed[i+1][j-1] == firstCh){
								rowD = 1; colD = -1;
								found = findWordDir(findWord, greed, row, col, rowD, colD);
								if(found == true)
									break;
							}
							
							if(i+1<M && found==false && greed[i+1][j] == firstCh){
								rowD = 1; colD = 0;
								found = findWordDir(findWord, greed, row, col, rowD, colD);
								if(found == true)
									break;
							}
							
							if(i+1<M && j+1<N && found == false && greed[i+1][j+1] == firstCh){
								rowD = 1; colD = 1;
								found =findWordDir(findWord, greed, row, col, rowD, colD);
								if(found == true)
									break;
							}
						}
					}
					if(found == true)
						break;
				}
				System.out.println((row+1) + " " + (col+1));
			}
			System.out.println();
		}
		input.close();
	}
	
	public static boolean findWordDir(String word, Character[][] greed, int startRow, int startCol, int rowD, int colD){
		int row = startRow + rowD;
		int col = startCol + colD;
		int wordIndex = 1;
		
		while(row>=0 && col>=0 && row<greed.length && col<greed[0].length){
			if(word.charAt(wordIndex) == greed[row][col]){
				row += rowD;
				col += colD;

				if(wordIndex == word.length()-1)
					return true;
				
				wordIndex++;
			}
			else
				return false;
		}
		return false;
	}
}












