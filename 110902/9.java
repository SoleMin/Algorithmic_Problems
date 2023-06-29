import java.util.*;

public class Main {
	
	static int[] visit = new int[100001];
	static int[] sign = new int[100001];
	
	public static void main(String argv[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int casenum = sc.nextInt();
		int a,b,c,d;
		
		for (int cs = 0; cs < casenum; cs++) {
			
			Arrays.fill(visit,0);
			Arrays.fill(sign,0);
			
			a = sc.nextInt(); //초기번호 입력
			b = sc.nextInt();
			c = sc.nextInt();
			d = sc.nextInt();
			int firstn = 1000*a + 100*b + 10*c + d; //초기번호를 4자리 숫자로 변경
			
			a = sc.nextInt(); //최종번호 입력
			b = sc.nextInt();
			c = sc.nextInt();
			d = sc.nextInt();
			int endn = 1000*a + 100*b + 10*c + d; //최종번호를 4자리 숫자로 변경
			
			int flagnum = sc.nextInt(); //금지된 케이스 입력
			for (int fn = 0; fn < flagnum; fn++) {
				a = sc.nextInt();
				b = sc.nextInt();
				c = sc.nextInt();
				d = sc.nextInt();
				sign[1000*a + 100*b + 10*c + d] = 1;
			}
			
			System.out.println(bfs(firstn, endn));
		}
		
	}
	
	static int bfs (int firstn, int endn) {
		
		int a,b,c,d;
		int[] temp0 = new int[2];
		temp0[0] = firstn;
		temp0[1] = 0;
		int[] temp1 = new int[2];
		int[] temp2 = new int[2];
		Queue<int[]> q = new LinkedList<>();
		q.clear();
		q.add(temp0);
		
		while (!(q.isEmpty())) {
			temp1[0] = q.peek()[0];
			temp1[1] = q.peek()[1];
			q.poll();
			if (temp1[0] == endn) {
				return temp1[1];
			}
			a = temp1[0]/1000;
			b = temp1[0]/100%10;
			c = temp1[0]/10%10;
			d = temp1[0]%10;
			temp2[1] = temp1[1] + 1;
			
			temp2[0] = 1000*((a+1)%10) + 100*b + 10*c + d;
			if (visit[temp2[0]] == 0 && sign[temp2[0]] == 0) {
				q.add(temp2.clone());
			}
			visit[temp2[0]] = 1;
			temp2[0] = 1000*((10+a-1)%10) + 100*b + 10*c + d;
			if (visit[temp2[0]] == 0 && sign[temp2[0]] == 0) {
				q.add(temp2.clone());
			}
			visit[temp2[0]] = 1;
			///
			temp2[0] = 1000*a + 100*((b+1)%10) + 10*c + d;
			if (visit[temp2[0]] == 0 && sign[temp2[0]] == 0) {
				q.add(temp2.clone());
			}
			visit[temp2[0]] = 1;
			temp2[0] = 1000*a + 100*((10+b-1)%10) + 10*c + d;
			if (visit[temp2[0]] == 0 && sign[temp2[0]] == 0) {
				q.add(temp2.clone());
			}
			visit[temp2[0]] = 1;
			///
			temp2[0] = 1000*a + 100*b + 10*((c+1)%10) + d;
			if (visit[temp2[0]] == 0 && sign[temp2[0]] == 0) {
				q.add(temp2.clone());
			}
			visit[temp2[0]] = 1;
			temp2[0] = 1000*a + 100*b + 10*((10+c-1)%10) + d;
			if (visit[temp2[0]] == 0 && sign[temp2[0]] == 0) {
				q.add(temp2.clone());
			}
			visit[temp2[0]] = 1;
			///
			temp2[0] = 1000*a + 100*b + 10*c + ((d+1)%10);
			if (visit[temp2[0]] == 0 && sign[temp2[0]] == 0) {
				q.add(temp2.clone());
			}
			visit[temp2[0]] = 1;
			temp2[0] = 1000*a + 100*b + 10*c + (10+d-1)%10;
			if (visit[temp2[0]] == 0 && sign[temp2[0]] == 0) {
				q.add(temp2.clone());
			}
			visit[temp2[0]] = 1;
		}
		return -1;
	}
}