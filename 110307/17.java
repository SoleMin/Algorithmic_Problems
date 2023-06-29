import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Arrays;

class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void initialize(ArrayList<String> dict, ArrayList<String> topBottom){
		while(true){
			String str = sc.nextLine();
			if(str.equals("")) break;
			dict.add(str);
		}
		while (sc.hasNextLine()) {
			ArrayList<String> aryLst = new ArrayList<String>();
			String line = sc.nextLine();
			if (line.equals("")) break;
			aryLst.add(line);// 여기서 단어 쌍 입력.
			
			bfs(aryLst, dict);
		} //여기서 단어쌍 입력 첫단어 끝단어
	}
	public static void bfs(ArrayList<String> line, ArrayList<String> dict){
		for (String str : line) {
			String[] list = str.split(" "); // 입력받은 단어 쌍 분리.
			if (!dict.contains(list[0]) || !dict.contains(list[1])) {
				System.out.println("No solution.");
				System.out.println();
				continue;
			}
			Queue<String> q = new LinkedList<String>(); // 탐색용 큐 생성.
			int[] isVisitedBy = new int[dict.size()]; // 사전 크기와 같은 배열.
			int[] vertexNum = new int[dict.size()]; // 거리를 체크할 배열.
			Arrays.fill(isVisitedBy, -1); // 배열 -1로 초기화.
			Arrays.fill(vertexNum, -1); // 거리 배열 -1로 초기화.
			vertexNum[dict.indexOf(list[0])] = 0; // 거리 배열에 (입력받은 단어쌍의 위치 에 해당하는 인덱스에) 0 삽입.
			q.add(list[0]); // 큐에 0번째 단어 삽입. // 0번째 단어부터 탑색.
			int idx = -1;
			while (!q.isEmpty()) {
				String present = q.remove(); 
				int x = dict.indexOf(present);
				if (present.equals(list[1])) {
					idx = x;
					break;
				}
				for (int i = 0; i < present.length(); i++) { // now의 길이만큼 반복.
					for (int j = 0; j < 26; j++) { 
						if (present.charAt(i) != 'a' + j) {
							String blank = "";
							blank += present.substring(0, i);
							blank += Character.toString((char) ('a' + j));
							blank += present.substring(i + 1);
							int y = -1;
							y = dict.indexOf(blank);
							if (y != -1 && vertexNum[y] == -1) {
								vertexNum[y] = vertexNum[x] + 1;
								isVisitedBy[y] = x;
								q.add(blank);
							}
						}
					}
				}
			}
			if (idx == -1) {
				System.out.println("No solution.");
				//System.out.println();
			}
			else {
				Stack<String> stack = new Stack<String>();
				while (idx != -1) {
					stack.push(dict.get(idx));
					idx = isVisitedBy[idx];
				}
				while (!stack.isEmpty())
					System.out.println(stack.pop());
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		ArrayList<String> dict = new ArrayList<String>();
		ArrayList<String> topBottom = new ArrayList<String>();
		initialize(dict, topBottom);
	}
	
	
	
	
}