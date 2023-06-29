import java.io.*;
import java.util.*;

public class Main {
	static HashMap<String, List<String>> set;
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		int casenum = scan.nextInt();
		scan.nextLine();
		for(int i= 0; i < casenum; i++){
			String np = scan.nextLine();
			String[] npnum = np.split(" ");
			int N = Integer.parseInt(npnum[0]);
			int P = Integer.parseInt(npnum[1]);
			int cnt = 0;
			set = new HashMap<String, List<String>>();
			
			for(int j = 0; j < N ; j++){
				String inpaper = scan.nextLine();
				String[] paper1 = inpaper.split(":");
				String[] paper2 = paper1[0].split(", ");
				String[] name = new String[paper2.length /2];
				
				for(int k = 0; k < paper2.length; k += 2){
					name[k/2] = paper2[k] + ", "+ paper2[k+1];
				}
				for(int k = 0; k < paper2.length; k += 2){
					List<String> list = new ArrayList<>();
					for(int l = 0; l<paper2.length; l+=2){
						if(name[k/2] != name[l/2]){
							list.add(name[l/2]);
						}
					}
					if(set.containsKey(name[k/2])){
						list.removeAll(set.get(name[k/2]));
						list.addAll(set.get(name[k/2]));
						set.put(name[k/2], list);
					}else{
						set.put(name[k/2],list);
					}
				}
			}
			System.out.println("Scenario "+(i+1));
			String[] scholar = new String[P];
			for(int a = 0; a < P ;a++){
				scholar[a] = scan.nextLine();
				int result = bfs(scholar[a]);
				if(result == -1){
					System.out.println(scholar[a]+ " infinity");
				} else {
					System.out.println(scholar[a]+" "+ result);
				}
			}
			set.clear();
		}
	}
	public static int bfs(String abc){
		HashMap<String, Integer> settrue = new HashMap<String, Integer>();
		Queue<String> q = new LinkedList<>();
		q.add(abc);
		int dept = 0;
		int count = 0;
		int dep_node = 0;
		int access = 0;
		boolean dep = false;
		List<String> cklist = new ArrayList<>();

		while(!q.isEmpty()){
			String node = q.poll();
			settrue.put(node,1);
			if(dep_node == access)
				dep = true;
			if(node.equals("Erdos, P.")){
				return dept;
			} else{
				cklist.addAll(set.get(node));
				for(int d = 0; d < cklist.size(); d++){
					if(!settrue.containsKey(cklist.get(d))){
						q.add(cklist.get(d));
						count++;
					}
				}
				cklist.clear();
			}
			if(dep){
				dep_node = count;
				dep = false;
				dept++;
			}
			access++;
		}
		return -1;
	}
}