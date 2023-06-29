import java.util.Scanner;
import java.util.Vector;
import java.util.HashMap;
import java.util.Comparator;


public class F2{
	static class Pair{
		int l;
		int r;
		Pair(int l, int r){
			this.l = l;
			this.r = r;
		}
		public String toString(){
			return "(" + l + ", " + r + ")";
		}
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n+1];
		for(int i = 1;i<=n;++i){
			a[i] = in.nextInt();
		}
		HashMap<Integer, Vector<Pair>> map = new HashMap<>();
		for(int i = 1;i<=n;++i){
			int sum = 0;
			for(int j = i;j<=n;++j){
				sum+=a[j];
				if(!map.containsKey(sum))
					map.put(sum,new Vector<>());
				map.get(sum).add(new Pair(i,j));
			}
		}
		Vector<Pair> an = null;
		for(Integer key : map.keySet()){
			Vector<Pair> vec = map.get(key);
			Vector<Pair> ans = new Vector<>();
			ans.add(vec.get(0));
			int size = 1;
			for(int i = 1;i<vec.size();++i){
				if(ans.get(size-1).r > vec.get(i).r)
					ans.set(size-1,vec.get(i));
				else if(ans.get(size-1).r < vec.get(i).l){
					ans.add(vec.get(i));
					size++;
				}
			}
			if(an == null || an.size() < size) an = ans;
		}
		StringBuilder res = new StringBuilder().append(an.size() + "\n");
		for(int i = 0;i<an.size();++i)
			res.append(an.get(i).l + " " + an.get(i).r + "\n");
		System.out.println(res);
	}
}
