import java.io.*;
import java.util.*;

public class Soln {
	
	public static int[] io(int n) {
    	int[] d = new int[n];
    	for (int i=0;i<n;i++) d[i] = f.nextInt();
    	return d;
	}
	public static int binlog( int bits ){
        int log = 0;
        if( ( bits & 0xffff0000 ) != 0 ) { bits >>>= 16; log = 16; }
        if( bits >= 256 ) { bits >>>= 8; log += 8; }
        if( bits >= 16  ) { bits >>>= 4; log += 4; }
        if( bits >= 4   ) { bits >>>= 2; log += 2; }
        return log + ( bits >>> 1 );
    }
	static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
	}
	public static final long mod = (long)Math.pow(10, 9) + 7;
	static FastReader f=new FastReader();
	
	public static void main (String[] args) throws IOException{
		int n = f.nextInt();
		int[] a = io(n);
		HashMap<Integer,ArrayList<ivl>> hm = new HashMap<>();
		for (int i=0;i<n;i++) {
			int sum = 0;
			for (int j=i;j<n;j++) {
				sum+=a[j];
				if (hm.get(sum)==null) hm.put(sum,new ArrayList<ivl>());
				hm.get(sum).add(new ivl(i,j));
			}
		}
		HashSet<ivl> hs = new HashSet<ivl>();
		
		for (ArrayList<ivl> arr : hm.values()) {
			Collections.sort(arr,new comp());
			HashSet<ivl> temp = new HashSet<ivl>();
			temp.add(arr.get(0));
			int lastr = arr.get(0).r;
			int num = 1;
			for (ivl curr:arr) {
				if (curr.l>lastr) {
					lastr = curr.r;
					num++;
					temp.add(curr);
				}
			}
			if (temp.size()>hs.size()) hs = temp;
		}
		
		System.out.println(hs.size());
		for (ivl curr:hs) {
			System.out.println((curr.l+1)+" "+(curr.r+1));
		}
    }
	
	static class ivl{
		int l,r;
		ivl(int l,int r){
			this.l=l;this.r=r;
		}
	}
	
	static class comp implements Comparator<ivl>{
		public int compare(ivl a,ivl b) {
			if (a.r - b.r == 0) return a.l-b.l;
			return a.r-b.r;
		}
	}
}