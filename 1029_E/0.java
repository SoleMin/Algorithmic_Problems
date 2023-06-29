import java.util.*;
import java.io.*;
public class EdB {
	static long[] mods = {1000000007, 998244353, 1000000009};
	static long mod = mods[0];
	public static MyScanner sc;
    public static PrintWriter out;
    static int[] depth;
    static int[] parent;
    static ArrayList<HashSet<Integer>> tree;
	public static void main(String[] omkar) throws Exception{
		// TODO Auto-generated method stub
 		sc = new MyScanner();
 		out = new PrintWriter(System.out);
 		tree = new ArrayList<HashSet<Integer>>();
 		int n = sc.nextInt();
 		for(int j =0;j<=n;j++){
 			tree.add(new HashSet<Integer>());
 		}
 		depth = new int[n+1];
 		parent = new int[n+1];
 		for(int j =0 ;j<n-1;j++){
 			int v1 = sc.nextInt();
 			int v2 = sc.nextInt();
 			tree.get(v1).add(v2);
 			tree.get(v2).add(v1);
 		}
 		dfs(1, -1);
 		
 		ArrayList<Integer> left = new ArrayList<Integer>();
 		for(int j =1;j<=n;j++){
 			if (depth[j] > 2)
 				left.add(j);
 		}
 		Collections.sort(left, 
 				
 				new Comparator<Integer>(){
 			public int compare(Integer x, Integer y){
 				return Integer.compare(depth[(int)y], depth[(int)x]);
 			}
 		});
 		
 		int ans = 0;
 		boolean[] done = new boolean[n+1];
 		for(int j : left){
 			if (!done[j]){
 				ans++;
 				done[parent[j]] = true;
 				for(int k : tree.get(parent[j]))
 					done[k] = true;
 			}
 		}
 		out.println(ans);
 		out.close();	
 	}
	
	public static void dfs(int v, int p){
		for(int child : tree.get(v)){
			if (child == p)
				continue;
			depth[child] = depth[v]+1;
			parent[child] =v ;
			dfs(child, v);
		}
	}
	public static void sort(int[] array){
		ArrayList<Integer> copy = new ArrayList<Integer>();
		for (int i : array)
			copy.add(i);
		Collections.sort(copy);
		for(int i = 0;i<array.length;i++)
			array[i] = copy.get(i);
	}
	static String[] readArrayString(int n){
		String[] array = new String[n];
		for(int j =0 ;j<n;j++)
			array[j] = sc.next();
		return array;
	}
	static int[] readArrayInt(int n){
    	int[] array = new int[n];
    	for(int j = 0;j<n;j++)
    		array[j] = sc.nextInt();
    	return array;
    }
	static int[] readArrayInt1(int n){
		int[] array = new int[n+1];
		for(int j = 1;j<=n;j++){
			array[j] = sc.nextInt();
		}
		return array;
	}
	static long[] readArrayLong(int n){
		long[] array = new long[n];
		for(int j =0 ;j<n;j++)
			array[j] = sc.nextLong();
		return array;
	}
	static double[] readArrayDouble(int n){
		double[] array = new double[n];
		for(int j =0 ;j<n;j++)
			array[j] = sc.nextDouble();
		return array;
	}
	static int minIndex(int[] array){
		int minValue = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int j = 0;j<array.length;j++){
			if (array[j] < minValue){
				minValue = array[j];
				minIndex = j;
			}
		}
		return minIndex;
	}
	static int minIndex(long[] array){
		long minValue = Long.MAX_VALUE;
		int minIndex = -1;
		for(int j = 0;j<array.length;j++){
			if (array[j] < minValue){
				minValue = array[j];
				minIndex = j;
			}
		}
		return minIndex;
	}
	static int minIndex(double[] array){
		double minValue = Double.MAX_VALUE;
		int minIndex = -1;
		for(int j = 0;j<array.length;j++){
			if (array[j] < minValue){
				minValue = array[j];
				minIndex = j;
			}
		}
		return minIndex;
	}
	static long power(long x, long y){
		if (y == 0)
			return 1;
		if (y%2 == 1)
			return (x*power(x, y-1))%mod;
		return power((x*x)%mod, y/2)%mod;
	}
	static void verdict(boolean a){
        out.println(a ? "YES" : "NO");
    }
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try{
                str = br.readLine();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        
    }	
}

//StringJoiner sj = new StringJoiner(" "); 
//sj.add(strings)
//sj.toString() gives string of those stuff w spaces or whatever that sequence is