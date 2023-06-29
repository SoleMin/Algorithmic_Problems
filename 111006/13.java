import java.io.*;
import java.util.*;
class City {
	List<City> adjacency;
	String name;
	int order;
	public City(String name) {
		adjacency = new ArrayList<>();
		this.name = name;
		this.order = 0;
	}
	
	public void add(City c) {
		adjacency.add(c);
	}
}

class Main {
	static Map<String,City> cities;
	static List<String> cutV;
	static int o;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		cities = new HashMap<>();
		cutV = new LinkedList<>();
		int count = 1;
		while(sc.hasNextLine()) {
			int n = sc.nextInt();
			if(n == 0) break;
			sc.nextLine();
			o = 1;
			City root = new City(sc.nextLine());
			cities.put(root.name,root);
			
			for(int i = 0; i < n-1; i++) {
				String c = sc.nextLine();
				cities.put(c,new City(c));
			}
			int k = sc.nextInt();
			sc.nextLine();
			for(int i = 0; i < k; i++) {
				City c1 = cities.get(sc.next());
				City c2 = cities.get(sc.next());
				
				c1.add(c2);
				c2.add(c1);
			} 
			dfs(root,null,true);
			print(count);
			count++;
			cities.clear();
			cutV.clear();
		}
	}
	
	public static int dfs(City cur,City parent,boolean isRoot) {
        cur.order = o++;
        int ret = cur.order;
        int child=0;
 
        for (City next : cur.adjacency) {
					  if(next == parent) continue;
            if(next.order==0) {
                child++; 
                int prev = dfs(next,cur,false);
                if(!isRoot && prev >= cur.order)
                    if(!cutV.contains(cur.name))
											  cutV.add(cur.name);
                ret = Math.min(ret,prev);
            }else
                ret = Math.min(ret,next.order);
        }
 
        if(isRoot && child>=2)
            cutV.add(cur.name);
        return ret;
    
	}
	
	public static void print(int cnt) {
		System.out.printf("City map #%d: %d camera(s) found\n",cnt,cutV.size());
		cutV.sort(Comparator.naturalOrder());
		for(String name : cutV) {
			System.out.println(name);
		}
		System.out.println();
	}
	
}