import java.io.*;
import java.util.*;

class Wheels {
	int a,b,c,d,count;
	public Wheels(int a,int b, int c, int d, int count) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.count = count;
	}
}
class Main {
	static Set<String> wrong = new HashSet<>();
	static Map<String,Integer> cnt = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tastcase = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < tastcase; i++) {
			sc.nextLine();
			String[] s1 = sc.nextLine().split(" ");
			String[] s2 = sc.nextLine().split(" ");
			int[] start = new int[4];
			String res = s2[0] + s2[1] + s2[2] + s2[3];
			
			
			for(int j = 0; j < start.length; j++) {
				start[j] = Integer.parseInt(s1[j]);
			}
			cnt.put(("" + start[0] + start[1] + start[2] + start[3]),0);
			
			int n = sc.nextInt();
			sc.nextLine();
			
			for(int j = 0; j < n; j++) {
				String w = "";
				s1 = sc.nextLine().split(" ");
				for(int k = 0; k < s1.length; k++) {
					w += s1[k];
				}
				wrong.add(w);
			}
		
			bfs(start);
			if(!cnt.containsKey(res)) System.out.println(-1);
			else System.out.println(cnt.get(res));
			wrong.clear();
			cnt.clear();
	
		}
	}
	
	public static void bfs(int[] start) {
		Queue<Wheels> q = new LinkedList<>();
		q.add(new Wheels(start[0],start[1],start[2],start[3],0));
		while(!q.isEmpty()) {
			Wheels cur = q.poll();
			int[] arr = {cur.a,cur.b,cur.c,cur.d};
			
			for(int i = 0; i < arr.length; i++) {
				int temp = arr[i];
				
				arr[i]++;
				arr[i] = arr[i] % 10;
				
				Wheels wheels = new Wheels(arr[0],arr[1],arr[2],arr[3],cur.count+1);
				String info = ""+wheels.a+wheels.b+wheels.c+wheels.d;
				if(!wrong.contains(info) && (!cnt.containsKey(info) || cur.count+1 < cnt.get(info))) {
					cnt.put(info,cur.count+1);
					q.add(wheels);
				}
				
				arr[i] = temp-1;
				if(arr[i] == -1) arr[i] = 9;
				
				wheels = new Wheels(arr[0],arr[1],arr[2],arr[3],cur.count+1);	
				info = ""+wheels.a+wheels.b+wheels.c+wheels.d;
				if(!wrong.contains(info) && (!cnt.containsKey(info) || cur.count+1 < cnt.get(info))) {
					cnt.put(info,cur.count+1);
					q.add(wheels);
				}	 
				
				arr[i] = temp;
			}
		}
	}
}