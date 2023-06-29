import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int edge[][];
		List<String> city_s;	//도시 이름들을 문자열로 저장
		List<String> cctv;
		int city[];					//도시 이름들을 순서대로 0부터 지정
		Boolean check[];			//bfs탐색 시 탐색 여부 저장
		int city_num;
		int edge_num;
		int scenario=1;
		while (true) {
			city_s = new ArrayList<String>();
			cctv = new ArrayList<>();
			city_num = scan.nextInt();
			scan.nextLine();
			city=new int[city_num];
			check=new Boolean[city_num];
			if (city_num == 0)
				return;
			for (int i = 0; i < city_num; i++) {
				city_s.add(scan.nextLine());
			}
			edge_num = scan.nextInt();
			scan.nextLine();
			edge = new int[edge_num*2][2];
			for (int i = 0; i < edge_num*2; i+=2) {
				String c = scan.nextLine();
				String ci[] = c.split(" ");
				edge[i][0] = city_s.indexOf(ci[0]);
				edge[i][1] = city_s.indexOf(ci[1]);
				edge[i+1][1] = city_s.indexOf(ci[0]);
				edge[i+1][0] = city_s.indexOf(ci[1]);
			}
			
			for(int i=0;i<city_num;i++) {//노드를 하나씩 제거
				Queue<Integer> q = new LinkedList<>();for(int j=0;j<city_num;j++) check[j]=false;
				//i번째 노드를 제외하고 bfs를 돌렸을 때, check가 하나라도 false라면 i는 cctv설치 장소.
				check[i]=true;	//i번째 노드 제외하기위해 이미 탐색했다고 판단
				check[i==0? 1:i-1]=true; //i번째 노드를 제외한 것들중 앞에서 부터 추가.
				q.add(i==0? 1:i-1);
				while(!q.isEmpty()) {
					int node = q.poll();
					for(int index=0;index<edge_num*2;index++) {
						if(edge[index][0]==node) {
							if(check[edge[index][1]]==false) {
								q.add(edge[index][1]);
								check[edge[index][1]]=true;
							}
						}
					}
				}
				for(int ch=0;ch<city_num;ch++) if(!check[ch]) {if(!cctv.contains(city_s.get(i)))cctv.add(city_s.get(i));break;} 
			}
			System.out.println("City map #"+scenario+++": "+cctv.size()+" camera(s) found");
			Collections.sort(cctv);
			for(int i=0;i<cctv.size();i++)
				System.out.println(cctv.get(i));
			System.out.println();
		}
	}
}
