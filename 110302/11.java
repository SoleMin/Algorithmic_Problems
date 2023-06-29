import java.util.Scanner;
class Main {
	public static boolean find(int i, int k, int col, int row, String word, char[][] input){
		int cmax = i+1;
		int cmin = i-1;
		int rmax = k+1;
		int rmin = k-1;
		if(cmax >= col)
			cmax = col-1;
		if(cmin < 0)
			cmin = 0;
		if(rmax >= row)
			rmax = row-1;
		if(rmin < 0)
			rmin = 0;
		
		for(int c = cmin; c <= cmax; c++){
			for(int r = rmin; r <= rmax; r++){
				if(input[c][r] == word.charAt(1))
					if(findend(c, r, (i-c)*(-1), (k-r)*(-1), word.substring(2), input, col, row))
						return true;
			}
		}
		return false;
	}
	
	public static boolean findend(int i, int k, int gc, int gr, String word, char[][] input, int col, int row){
		for(int n = 0; n < word.length(); n++){
			i = i+gc;
			k = k+gr;
			if((i<0 || k<0) || (i >= col || k >= row))
				return false;
			else if(input[i][k] != word.charAt(n))
				return false;
		}
		return true;

	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(; testcase > 0; testcase--){
			int col = sc.nextInt();
			int row = sc.nextInt();
			char[][] input = new char[col][row];
			sc.nextLine();
			
			for(int i = 0; i < col; i++){
				String line = sc.nextLine().toUpperCase();
				for(int k = 0; k < row; k++)
					input[i][k] = line.charAt(k);
			}
			
			String s = sc.nextLine();
			if(s.length() == 0)
				break;
			int wordnum = Integer.parseInt(s);
			String word;
			
			for(;wordnum > 0; wordnum--){
				boolean end = false;
				word = sc.next().toUpperCase();
				for(int i = 0; i < col; i++){
					for(int k = 0; k < row; k++)
						if(word.length() == 1){
							if(word.charAt(0) == input[i][k]){
								System.out.println(i+1+ " "+ (k+1));
								end = true;
								break;
							}
						}
						else if(word.charAt(0) == input[i][k] && find(i, k, col, row, word, input)){
							System.out.println(i+1 + " " + (k+1));
							end = true;
							break;
						}
					if(end)
						break;
				}
			}
			System.out.println();
		}
	}
}