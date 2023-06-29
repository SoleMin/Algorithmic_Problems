import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int count = 0;
		String[] dict = new String[25143];
		boolean end = false;
		while(!end){
			dict[count] = input.nextLine();
			if(dict[count].equals(""))
				end = true;
			count++;
		}
		
		// 사전의 단어들의 더블릿 관계를 나타내는 그래프를 만든다.
		boolean[][] matrix = new boolean[count][count];
		for(int i=1; i<count; i++)
			for(int j=0; j<i; j++)
				if(dict[i].length() == dict[j].length()) {
					int diff = 0;
					for(int k=0; k<dict[i].length(); k++)
						if(dict[i].charAt(k) != dict[j].charAt(k))
							diff++;
					if(diff == 1) {
						matrix[i][j] = true;
						matrix[j][i] = true;
					}
				}
		
		boolean second = false;
		while(input.hasNextLine()) {
			// 두번째 출력부터는 출력 전에 빈줄을 출력한다.
			if(second)
				System.out.println();
			// 단어의 길이가 다르면 "No solution."을 출력한다.
			String[] split = input.nextLine().split("\\s+");
			if(split[0].length() != split[1].length()) {
				System.out.println("No solution.");
				second = true;
				continue;
			}
			
			// 단어를 한 쌍 입력받는다.
			int startIndex=-1, endIndex=1;
			for(int i=0; i<count; i++)
				if(dict[i].equals(split[0])) {
					startIndex = i;
					break;
				}
			for(int i=0; i<count; i++)
				if(dict[i].equals(split[1])) {
					endIndex = i;
					break;
				}
			
			// 만에 하나 찾는 단어가 사전에 없는 경우를 처리한다.
			if(startIndex==-1 || endIndex==-1) {
				System.out.println("사전에 해당 단어가 존재하지 않음.");
				continue;
			}
			
			// dijkstra 알고리즘을 통해 최단경로를 구한다.
			Queue<Integer> q = new LinkedList<Integer>();
			int[] d = new int[count];	// 시작 노드에서 해당 노드까지의 최단거리
			int[] p = new int[count];	// 최단 루트를 탈 경우 지나는 바로 이전의 노드
			d[endIndex] = 0;
			p[endIndex] = endIndex;
			for(int i=0; i<count; i++) {
				d[i] = -1;
				p[i] = -1;
			}
			q.add(endIndex);
			while(!q.isEmpty()) {
				int from = q.poll();
				for(int i=0; i<count; i++)
					if(matrix[from][i]) {
						if(d[i] == -1) {
							p[i] = from;
							d[i] = d[from] + 1;
							q.add(i);
						}
						if(d[i] > d[from]+1) {
							p[i] = from;
							d[i] = d[from] + 1;
						}
					}
			}
			
			// 결과를 출력한다.
			if(d[startIndex] == -1) {
				System.out.println("No solution.");
			} else {
				int printIndex = startIndex;
				System.out.println(dict[printIndex]);
				while(printIndex != endIndex) {
					printIndex = p[printIndex];
					System.out.println(dict[printIndex]);
				}
			}
			
			second = true;
		}
		input.close();
	}
}