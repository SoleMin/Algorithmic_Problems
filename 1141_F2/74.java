import java.util.*;
import java.util.Map.Entry;
import java.io.*;
public class Main {
	public static class node implements Comparable<node> {
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
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer sa=new StringTokenizer(in.readLine());
		int n=Integer.parseInt(sa.nextToken());
		sa=new StringTokenizer(in.readLine());
		int[] a=new int[n];
		TreeMap<Integer,ArrayList<node>> mp=new TreeMap();
		for (int i=0;i<n;++i) a[i]=Integer.parseInt(sa.nextToken());
		for (int i=0;i<n;++i) {
			int tmp=0;
			for (int j=i;j<n;++j) {
				tmp+=a[j];
				if (!mp.containsKey(tmp)) {
					ArrayList t=new ArrayList();
					t.add(new node(i,j));
					mp.put(tmp,t);
				} else {
					ArrayList<node> t=mp.get(tmp);
					int left=0,right=t.size()-1,res=t.size();
					while (left<=right) {
						int mid=(left+right)>>1;
						if (t.get(mid).r>=i) {
							res=mid;
							right=mid-1;
						} else left=mid+1;
					}
					if (res==t.size()) t.add(new node(i,j));
					else if (t.get(res).r>j) t.set(res,new node(i,j));
				}
			}
		}
		int res=0;
		for (Entry<Integer,ArrayList<node>> entry:mp.entrySet())
			res=Math.max(res,entry.getValue().size());
		out.println(res);
		for (Entry<Integer,ArrayList<node>> entry:mp.entrySet())
			if (entry.getValue().size()==res) {
				ArrayList<node> tmp=entry.getValue();
				for (int i=0;i<tmp.size();++i)
					out.printf("%d %d\n",tmp.get(i).l+1,tmp.get(i).r+1);
				out.flush();
				return;
			}
	}
}