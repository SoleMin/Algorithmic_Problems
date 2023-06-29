import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int testcase = Integer.parseInt(input.nextLine());
		for(int i=0; i<testcase; i++) {
			String newline = input.nextLine();
			String[] mn = input.nextLine().split(" ");
			int m = Integer.parseInt(mn[0]);
			int n = Integer.parseInt(mn[1]);
			
			String[][] grid = new String[m][n];
			for(int j=0; j<m; j++) {
				String str = input.nextLine();
				grid[j] = str.split("");
			}
			
			int wordcase = Integer.parseInt(input.nextLine());
			for(int j=0; j<wordcase; j++) {
				String str = input.nextLine();
				String w1 = "" + str.charAt(0);
				String w2 = "";
				if(str.length() != 1)
					w2 = "" + str.charAt(1);
				
				int mcount = 0, ncount = 0;
				while(true) {
					if(mcount > m-1) break;
						
					Stack<String> stk = new Stack();
					if(w1.equalsIgnoreCase(grid[mcount][ncount])) {
						if(str.length() == 1) {
							System.out.println((mcount+1) + " " + (ncount+1));
							break;
						}
						for(int k=-1; k<=1; k++){
							for(int l=-1; l<=1; l++) {
								if(k==0 && l==0) continue;
								if((mcount+k<0)||(mcount+k>=m)||(ncount+l<0)||(ncount+l>=n)) continue;
								if(grid[mcount+k][ncount+l].equalsIgnoreCase(w2)) {
									String dir = "" + (k+2) + (l+2);
									stk.push(dir);
								}
							}
						}
						if(stk == null) continue;
						
						int row = 0, column = 0;
						while(!stk.empty()) {
							String direction = stk.pop();
							int r = direction.charAt(0)-'0'-2;
							int c = direction.charAt(1)-'0'-2;
							
							boolean check = false;
							int mul = str.length()-1;
							if((mcount+r*mul<0)||(mcount+r*mul>=m)||(ncount+c*mul<0)||(ncount+c*mul>=n)) continue;
							for(int k=1; k<str.length(); k++) {
								if(!((""+str.charAt(k)).equalsIgnoreCase(grid[mcount+r*k][ncount+c*k]))) break;
								if(k == str.length()-1)	check = true;
							}
							
							if(check) {
								row = mcount+1;
								column = ncount+1;
								break;
							}
						}
						
						if(row != 0) {
							System.out.println(row + " " + column);
							break;
						}
					}
					
					ncount++;
					if(n==1) {
						mcount++;
						ncount = 0;
						continue;
					}
					if(ncount!=1&&(ncount%(n-1)==1)) {
						mcount++;
						ncount = 0;
					}
				}
			}
			System.out.println();
		}
	}
}