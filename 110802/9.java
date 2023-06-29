import java.util.*;
class Main {
		static char[] moveChar = {'U', 'R', 'D', 'L'};
	static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean solved = false; //퍼즐풀렸는지
	static Stack<Integer> moveStack = new Stack<>(); //정답스택
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String t = input.nextLine();
		int sc = Integer.parseInt(t);
		
		for(int s=0; s<sc; s++) {
			int[][] puzzle = new int[4][4];
			
			for(int line=0; line<4; line++) {
				String lineN = input.nextLine();
				String[] lineNum = lineN.split(" ");
				for(int i=0; i<4; i++) {
					puzzle[line][i] = Integer.parseInt(lineNum[i]);
				}
			}		
			
			solved = false;
			moveStack.clear();
			
			solve(puzzle);
			
			//System.out.println("solved" + solved);
			if(solved == true) {
				//System.out.println(moveStack.size());
				int[] moveArr = new int[moveStack.size()];
				
				int i=0;
				while(moveStack.empty() == false) {
					moveArr[i] = moveStack.pop();
					i++;
				}
				for(int k=0; k<moveArr.length; k++) {
					System.out.print(moveChar[moveArr[moveArr.length - 1 - k]]);
				}
				System.out.println();
			}
			else {
				System.out.println("This puzzle is not solvable.");
			}
		}
		
		input.close();
	}
	
	public static int cost(int[][] puzzle) {
		int md1 = 0;
		int md2 = 0;
		
//		int value = 1;
//		System.out.println("체크");
//		for(int k=0; k<4; k++) {
//			for(int j=0; j<4; j++) {
//				if(k==3 && j==3) {
//					if(puzzle[k][j] == 0)
//						continue;
//				}
//				else {
//					if(puzzle[k][j] == value) {
//						System.out.println(puzzle[k][j] + "  " + value);
//						value++;
//						continue;
//					}
//					else
//						break;
//					
//				}
//			}
//		}
//				
//		if(value == 15) {
//			System.out.println("value 15");
//			return 0;
//		}
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(puzzle[i][j] != 0) {
					md1 += Math.abs(i-((puzzle[i][j]-1)/4));
				}
			}
		}
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(puzzle[i][j] != 0) {
					md1 += Math.abs(i-((puzzle[i][j]-1)%4));
				}
			}
		}		
		return md1+md2;
	}

	
	public static void solve(int[][] puzzle) {
		int value = 0;
		int x = 0;
		int y = 0;
		int l;
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(puzzle[i][j] == 0) {
					value += i;
					x = i;
					y = j;
				}
				for(int k=i; k<4; k++) {
					if(k == i)
						l = j + 1;
					else
						l = 0;
					for(; l<4; l++) {
						if(puzzle[k][l] != 0 && puzzle[i][j]>puzzle[k][l])
							value++;
					}
				}
			}
		}
		if(value%2 == 0)
			return;
		
		int[][] puzzleT = new int[4][4];
		for(int k=0; k<4; k++) {
			for(int p=0; p<4; p++) {
				puzzleT[k][p] = puzzle[k][p];
			}
		}	
		
		int maxDepth;
		for(maxDepth = cost(puzzle); maxDepth<=50; maxDepth+=2) {
			for(int k=0; k<4; k++) {
				for(int p=0; p<4; p++) {
					puzzle[k][p] = puzzleT[k][p];
				}
			}	
			moveStack.clear();
			//System.out.println("maxdepth : " + maxDepth);
			if(solved == false) {
				back(puzzle, maxDepth, 0, x, y);
				if(solved == true)
					return;
			}
				
		}
	}
	
	public static void back(int[][]puzzle, int maxDepth, int a, int nowx, int nowy) {
		int nextx, nexty;
		
		int c = cost(puzzle);
//		System.out.println("back 시작");
//		System.out.println("cost : " + c + " a : " + a);			
		
		if(c==0) {
			solved = true;
			//System.out.println("c==0 return");
			return;
		}
		
		if(a+c > maxDepth) {
			//System.out.println("a+c return");
			return;
		}
			
		
		for(int i=0; i<4; i++) {
			if(!moveStack.empty()) {
				int movePeek = moveStack.peek();
				if((movePeek == 0 && i == 2) || (movePeek == 1 && i == 3) ||
						(movePeek == 2 && i == 0) || (movePeek == 3 && i == 1)) {
					continue;
				}
			}		
			
			nextx = nowx + move[i][0];
			nexty = nowy + move[i][1];
			
			
			if(nextx<0 || nextx>=4 || nexty<0 || nexty >= 4)
				continue;
			
			
			int[][] puzzleT = new int[4][4];
			for(int k=0; k<4; k++) {
				for(int p=0; p<4; p++) {
					puzzleT[k][p] = puzzle[k][p];
				}
			}	
			
//			System.out.println("nowx : " + nowx + " nowy : " + nowy);
//			System.out.println("nextx : " + nextx + " nexty : " + nexty);
			
			puzzle[nowx][nowy] = puzzle[nextx][nexty];
			puzzle[nextx][nexty] = 0;
			
			moveStack.add(i);
			
		
//			System.out.println(moveStack);
//			for(int k=0; k<4; k++) {
//				for(int p=0; p<4; p++) {
//					System.out.print(puzzle[k][p] + " ");
//				}
//				System.out.println();
//			}	
//			System.out.println();
			
			int value = 1;
			//System.out.println("체크");
			for(int k=0; k<4; k++) {
				for(int j=0; j<4; j++) {
					if(k==3 && j==3) {
						if(puzzle[k][j] == 0)
							continue;
					}
					else {
						if(puzzle[k][j] == value) {
							//System.out.println(puzzle[k][j] + "  " + value);
							value++;
							continue;
						}
						else
							break;
						
					}
				}
			}
					
			if(value == 16) {
				//System.out.println("value 15");
				solved = true;
				return;
			}
			
			back(puzzle, maxDepth, a+1, nextx, nexty);
			
			if(solved == true) {
				//System.out.println("solved return" + moveStack);
				return;
			}
				
			for(int k=0; k<4; k++) {
				for(int p=0; p<4; p++) {
					puzzle[k][p] = puzzleT[k][p];
				}
			}
			moveStack.pop();
			
		}
	}
}