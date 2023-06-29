import java.util.*;

public class Main {
	
	public static class node implements Comparable<node>{
		int l,r;
		node(){}
		node(int l,int r) {
			this.l=l;
			this.r=r;
		}
		@Override
		public int compareTo(node rhs) {
			return r-rhs.r;
		}
	}
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int x[] = new int[a];
		for(int n=0;n<a;n++){
			x[n] = in.nextInt();
		}
		int max = 1;
		int t = 0;
		HashMap<Integer, ArrayList<node>> map = new HashMap<Integer, ArrayList<node>>();
		for(int n=0;n<a;n++){
			int num = 0;
			for(int m=n;m<a;m++){
				num += x[m];
				node node = new node(n, m);
				if(!map.containsKey(num)){
					ArrayList<node> list = new ArrayList<node>();
					list.add(node);
					map.put(num, list);
					if(max == 1)t = num;
				}
				else{
					ArrayList<node> list = map.get(num);
					int left = 0;
					int right = list.size()-1;				
					int res = list.size();
					while(left <= right){
						int mid = (left + right) >> 1;
						//System.out.println(mid +" "+ left +" " +right);
						if(list.get(mid).r >= n){
							res = mid;
							right = mid - 1;
						}
						else{
							left = mid + 1;
						}
					}
					if(res == list.size()){
						list.add(node);
						if(max < res+1){
							max = res+1;
							t = num;
						}
					}
					else if(list.get(res).r>m){
						list.set(res, node);
						if(max < res){
							max = list.size();
							t = num;
						}
					}
					
				}
			}
		}
		System.out.println(max);
		for(int n=0;n<max;n++){
			System.out.println((map.get(t).get(n).l+1)+" "+(map.get(t).get(n).r+1));
		}
		
	}
}