import java.util.*;
class Main {
	
	//좌우상하, 대각선까지 문자열을 검색
	//r, c : current row or column
	//_r,_c: convert to row or column direction
	// str : string we want to find
	static boolean search(char[][] char_a, int r, int c, String str, int _r, int _c){
		boolean check = true;
		for(int i = 0; i < str.length(); i++){
			if(char_a[r][c] != str.charAt(i)){
				check = false;
				break;
			}
			r += _r;
			c += _c;
		}
		return check;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.nextLine();
		in.nextLine();
		for(int re = 0; re < num; re++){
			int row = in.nextInt();
			int col = in.nextInt();
			in.nextLine();
			char[][] char_a = new char[row][col];
			for(int j = 0; j < row; j++){
				String s = in.nextLine().toLowerCase();
				for(int k = 0; k < col; k++){
					char_a[j][k] = s.charAt(k);
				}
			}
			
			int num_of_str = in.nextInt();
			in.nextLine();
			for(int j = 0; j < num_of_str; j++){
				String s = in.nextLine().toLowerCase();
			
				Loop1:
				for(int r = 0; r < row; r++){
					for(int c = 0; c < col; c++){
						if(s.charAt(0) == char_a[r][c]){
							
							int size = s.length();
							boolean up = (size-1 <= r);
							boolean down = (row-size >= r);
							boolean right = (col-size >= c);
							boolean left = (size-1 <= c);
							
							boolean[] new_case = new boolean[8];
							Arrays.fill(new_case, true);
							if(!up) for(int i = 0; i < 3; i++) new_case[i] = false;
							if(!down) for(int i = 4; i < 7; i++) new_case[i] = false;
							if(!right) for(int i = 2; i < 5; i++) new_case[i] = false;
							if(!left) {
								for(int i = 6; i < 8; i++) new_case[i] = false;
								new_case[0] = false;
							}
							
							boolean is_find = false;
				
							if(new_case[0] && !is_find)
								is_find = search(char_a,r,c,s,-1,-1);						
							if(new_case[1] && !is_find)
								is_find = search(char_a,r,c,s,-1,0);						
							if(new_case[2] && !is_find)
								is_find = search(char_a,r,c,s,-1,1);
							if(new_case[3] && !is_find)
								is_find = search(char_a,r,c,s,0,1);				
							if(new_case[4] && !is_find)
								is_find = search(char_a,r,c,s,1,1);							
							if(new_case[5] && !is_find)
								is_find = search(char_a,r,c,s,1,0);							
							if(new_case[6] && !is_find)
								is_find = search(char_a,r,c,s,1,-1);						
							if(new_case[7] && !is_find)
								is_find = search(char_a,r,c,s,0,-1);
							
							if(is_find){
								System.out.println((r+1) + " " + (c+1));
								break Loop1;
							}
						}
					}
				}
			}
			System.out.println();
		}
	}
}