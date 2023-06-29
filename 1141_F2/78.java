import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class F1141 {
	
	private static class Interval {
		public int l;
		public int r;
		
		public Interval(int l,int r) {
			this.l = l;
			this.r = r;
		}
	}

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("F:/books/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(s);
		long[] a = new long[n];
		String[] as = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			a[i] = Long.parseLong(as[i]);
		}
		StringBuffer sb = solve(a,n);
		System.out.println(sb.toString());
	}

	private static StringBuffer solve(long[] a, int n) {
		StringBuffer ret = new StringBuffer("");
		Map<Long,List<Interval>> mp = new HashMap<Long,List<Interval>>();
		long max = 0,maxId = -1;
		for(int i=n-1;i>=0;i--) {
			long s=0;
			long prev = 1;
			for(int j=i;j<n;j++) {
				s+=a[j];
//				System.out.println(i+","+j);
				Interval inter = new Interval(i,j);
//				if(prev==1 || prev==-1) {
					List<Interval> ints = mp.get(s);
					if(ints==null) ints = new ArrayList<Interval>();
					if(ints.size()==0 || ints.get(0).l>j) {
						ints.add(0,inter);
					}
					if(ints.size()>max) {
						max = ints.size();
						maxId = s;
					}
					mp.put(s, ints);
//				}
				if(j<n-1) prev =  a[j+1]-a[j];
			}
		}
		List<Interval> l = mp.get(maxId);
		ret.append(l.size()+ "\n");
		for(Interval inter : l) {
			ret.append((inter.l+1) + " " + (inter.r+1) + "\n");
		}
		return ret;
	}

}
