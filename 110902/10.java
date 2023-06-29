import java.util.*;
class Main {
		public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		
		int scenario = Integer.parseInt(input.nextLine()); //시나리오 갯수입력
		

		for(int k=0; k<scenario; k++) {
			input.nextLine();
			String startT = input.nextLine();
			String[] start = startT.split(" ");
			int s1 = Integer.parseInt(start[0]);
			int s2 = Integer.parseInt(start[1]);
			int s3 = Integer.parseInt(start[2]);
			int s4 = Integer.parseInt(start[3]);
			int startnum = s1*1000 + s2*100 + s3*10 + s4;
			//System.out.println(startnum);
			
			String finalT = input.nextLine();			
			String[] finalnums = finalT.split(" ");
			int f1 = Integer.parseInt(finalnums[0]);
			int f2 = Integer.parseInt(finalnums[1]);
			int f3 = Integer.parseInt(finalnums[2]);
			int f4 = Integer.parseInt(finalnums[3]);
			int finalnum = f1*1000 + f2*100 + f3*10 + f4;
			//System.out.println(finalnum);
			
			int[] checkBFS = new int[10001];
			
			String numT = input.nextLine();
			int num = Integer.parseInt(numT);

			for(int i=0; i<num; i++) {
				String cannotNum = input.nextLine();
				String[] cannotNums = cannotNum.split(" ");
				int c1 = Integer.parseInt(cannotNums[0]);
				int c2 = Integer.parseInt(cannotNums[1]);
				int c3 = Integer.parseInt(cannotNums[2]);
				int c4 = Integer.parseInt(cannotNums[3]);
				int cannot = c1*1000 + c2*100 + c3*10 + c4;
				checkBFS[cannot] = -1;
			}
			
			checkBFS[startnum] = 1;
			Queue<Integer> BFSQ = new LinkedList<Integer>();
			BFSQ.add(startnum);
			BFS(BFSQ, checkBFS, finalnum);
			System.out.println(checkBFS[finalnum]-1);
		}
		input.close();
	}

	public static void BFS(Queue<Integer> BFSQ, int[] checkBFS, int finalnum) {
		
		while(BFSQ.size() != 0) {
			
			int p1l = 0, p1r = 0, p2l = 0, p2r = 0, p3l = 0, p3r = 0, p4l = 0, p4r = 0;
			int node = BFSQ.poll();
			int p1 = node/1000;
			int p2 = (node - p1*1000)/100;
			int p3 = (node - p1*1000 - p2*100)/10;
			int p4 = (node - p1*1000 - p2*100 - p3*10);
			int sck = checkBFS[node];
//			System.out.println(node + "      " + sck);
//			System.out.println(p1 + " " + p2 + " " + p3 + " " + p4);

			//다음 p1
			if(p1 == 0) {
				p1r = 9;
				p1l = p1+1;
			}
			else if(p1 == 9) {
				p1l = 0;
				p1r = p1-1;
			}
			else {
				p1r = p1-1;
				p1l = p1+1;
			}

			//다음 p2
			if(p2 == 0) {
				p2r = 9;
				p2l = p2+1;
			}
			else if(p2 == 9) {
				p2l = 0;
				p2r = p2-1;
			}
			else {
				p2r = p2-1;
				p2l = p2+1;
			}

			//다음 p3
			if(p3 == 0) {
				p3l = p3+1;
				p3r = 9;
			}
			else if(p3 == 9) {
				p3l = 0;
				p3r = p3-1;
			}
			else {
				p3r = p3-1;
				p3l = p3+1;
			}

			//다음 p4
			if(p4 == 0) {
				p4l = p4+1;
				p4r = 9;
			}
			else if(p4 == 9) {
				p4l = 0;
				p4r = p4-1;
			}
			else {
				p4r = p4-1;
				p4l = p4+1;
			}

			//p1l
			if(checkBFS[1000*p1l + 100*p2 + 10*p3 + p4] == 0) {
				checkBFS[1000*p1l + 100*p2 + 10*p3 + p4] = sck + 1;
				BFSQ.add(1000*p1l + 100*p2 + 10*p3 + p4);
			}

			//p1r
			if(checkBFS[1000*p1r + 100*p2 + 10*p3 + p4] == 0) {
				checkBFS[1000*p1r + 100*p2 + 10*p3 + p4] = sck + 1;
				BFSQ.add(1000*p1r + 100*p2 + 10*p3 + p4);
			}

			//p2l
			if(checkBFS[1000*p1 + 100*p2l + 10*p3 + p4] == 0) {
				checkBFS[1000*p1 + 100*p2l + 10*p3 + p4] = sck + 1;
				BFSQ.add(1000*p1 + 100*p2l + 10*p3 + p4);
			}

			//p2r
			if(checkBFS[1000*p1 + 100*p2r + 10*p3 + p4] == 0) {
				checkBFS[1000*p1 + 100*p2r + 10*p3 + p4] = sck + 1;
				BFSQ.add(1000*p1 + 100*p2r + 10*p3 + p4);
			}

			//p3l
			if(checkBFS[1000*p1 + 100*p2 + 10*p3l + p4] == 0) {
				checkBFS[1000*p1 + 100*p2 + 10*p3l + p4] = sck + 1;
				BFSQ.add(1000*p1 + 100*p2 + 10*p3l + p4);
			}

			//p3r
			if(checkBFS[1000*p1 + 100*p2 + 10*p3r + p4] == 0) {
				checkBFS[1000*p1 + 100*p2 + 10*p3r + p4] = sck + 1;
				BFSQ.add(1000*p1 + 100*p2 + 10*p3r + p4);
			}
			
			//p4l
			if(checkBFS[1000*p1 + 100*p2 + 10*p3 + p4l] == 0) {
				checkBFS[1000*p1 + 100*p2 + 10*p3 + p4l] = sck + 1;
				BFSQ.add(1000*p1 + 100*p2 + 10*p3 + p4l);
			}

			//p4r
			if(checkBFS[1000*p1 + 100*p2 + 10*p3 + p4r] == 0) {
				checkBFS[1000*p1 + 100*p2 + 10*p3 + p4r] = sck + 1;
				BFSQ.add(1000*p1 + 100*p2 + 10*p3 + p4r);
			}
		}
	}
}