import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class CodeChef2 {
   
	static class FastReader 
    { 
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
	
//    
//	static class Line{
//		Point p1;
//		Point p2;
//	
//		Line(Point p1,Point p2){
//			this.p1=p1;
//			this.p2=p2;
//		}
//		
//	    static Boolean intersects(Line l1,Line l2) 
//	    { 
//	    	Point A=l1.p1, B=l1.p2,C=l2.p1,D=l2.p2;
//	    	
//	        long a1 = B.y - A.y; 
//	        long b1 = A.x - B.x; 
//	        long c1 = a1*(A.x) + b1*(A.y); 
//	       
//	        long a2 = D.y - C.y; 
//	        long b2 = C.x - D.x; 
//	        long c2 = a2*(C.x)+ b2*(C.y); 
//	       
//	        long determinant = a1*b2 - a2*b1; 
//	       
//	        if (determinant == 0) 
//	        { 
//	            return false; 
//	        } 
//	        else
//	        { 
//	            long x = (b2*c1 - b1*c2)/determinant; 
//	            long y = (a1*c2 - a2*c1)/determinant; 
//	            
//	            if(x>=0 || x<=1) {
//	            	return true;
//	            }
//	            return false;
//	        } 
//	    }
//	    
//	    static Point getSlope(Line l) {
//	    	long num=l.p1.y - l.p2.y;
//	    	long den=l.p1.x - l.p2.x;
//	    	
//	    	long gcd=gcd(num,den);
//	    	return new Point(num/gcd,den/gcd);
//	    }
//
//		private static long gcd(long a, long b) {
//			return b==0?a:gcd(b,a%b);
//		}
//	    
//	}
	
	static class Pair{
		int x;
		long y;
		
		Pair(int x,long y, Integer integer, int i){
			this.y=y;
			this.x=x;
		}

		@Override
		public String toString() {
			return "(" + x +" "+ y+")";
		} 
		
		
	}
	
	static class Edge{
		int src;
		int dest;
		int cost;
		int val;
		
		Edge(int src,int dest,int cost,int val){
			this.src=src;
			this.dest=dest;
			this.cost=cost;
			this.val=val;
		}

		public String toString() {
			return "(" + src +" "+ dest+": "+ cost +" , "+val+")";
		} 
		
		
	}
	
    static class Pair2{
    	Pair node;
    	int dist;
    	
    	Pair2(Pair p,int dist){
    		node=p;
    		this.dist=dist;
    	}
    }
    
    static long M=1000000007l;
    static HashMap<Character,ArrayList<Character>> dirs;
    
    public static void main(String[] args) throws Exception {
        FastReader sc=new FastReader();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        
//        ArrayList<Integer> prime=getPrimeSieve();
        int t=sc.nextInt();
        int po=0;
        
        dirs=new HashMap<>();
        dirs.put('U', new ArrayList<>());
        dirs.get('U').addAll(Arrays.asList('U','R','D','L'));
        dirs.put('L', new ArrayList<>());
        dirs.get('L').addAll(Arrays.asList('L','U','R','D'));
        dirs.put('D', new ArrayList<>());
        dirs.get('D').addAll(Arrays.asList('D','L','U','R'));
        dirs.put('R', new ArrayList<>());
        dirs.get('R').addAll(Arrays.asList('R','D','L','U'));
//        
        outer:while(t-- >0) {
        	po++;
        	int n=sc.nextInt();
        	int x=(int) Math.sqrt(n/2);
        	int y=(int) Math.sqrt(n/4);
        	
        	if(x*x*2 == n || y*y*4==n)
        		bw.append("YES\n");
        	else {
        		bw.append("NO\n");
        	}
//        	int x=sc.nextInt();
//        	Integer[] arr=new Integer[n];
//        	long sum=0;
//        	
//        	for(int i=0;i<n;i++) {
//        		arr[i]=sc.nextInt();
//        		sum+=arr[i];
//        	}
//        	
//        	if(sum==x) {
//    			bw.append("NO\n");
//    			continue outer;
//        	}
//
//        	Arrays.sort(arr,Collections.reverseOrder());
//        	
//        	sum=0;
//        	for(int i=0;i<n-1;i++) {
//        		sum+=arr[i];
//        		
//        		if(sum==x) {
//        			int temp=arr[i];
//        			arr[i+1]=arr[i];
//        			arr[i]=temp;
//            		sum=sum-arr[i+1]+arr[i];
//        		}
//        	}
//        	bw.append("YES\n");
        	
//        	for(int i=0;i<n;i++) {
//        		bw.append(arr[i]+" ");
//        	}
//        	bw.append("\n");
//        	bw.append("Case #"+po+": "+0+"\n");
        }
        bw.close();
    }
    
    
    
	private static int abs(int i) {
		if(i<0) {
			return -i;
		}
		return i;
	}



	private static String getRoaring2(String s) {
		String res="";
		String max="";
		
		for(int i=1;i<=s.length()/2;i++) {
			
			long prev=Long.parseLong(s.substring(0, i));
			res=Long.toString(prev);
			long prev1=Long.parseLong(res);
			long ans=Long.parseLong(s);
			long next=prev+1;
			
			while(prev1 <= ans) {
				prev1=Long.parseLong(res+Long.toString(next));
				res+=Long.toString(next);
				next++;
			}
			if(max.length() == 0) {
				max=res;
				res="";
			}else {
				Long a=Long.parseLong(max);
				long m=Math.max(a, prev1);
				max=Long.toString(m);
			}
		}
		return max;
	}

	private static String getRoaring(String s) {
		int val=-1;
		for(int i=1;i<=s.length()/2;i++) {
			long prev=Long.parseLong(s.substring(0, i));
			int j=i,update=i;
			
			while(j<s.length()) {
				if(numDigit(prev+1) > numDigit(prev)) {
					update++;
				}
				if(j+update > s.length()) {
					break;
				}
				long cur=Long.parseLong(s.substring(j, j+update));
				if(cur != prev+1) {
					break;
				}	
				prev=cur;
				j+=update;
			}
			
			if(j>= s.length()) {
				val=i;
				break;
			}
		}

		if(val==-1) {
			return "";
		}else {
			String res="";
			long prev=Long.parseLong(s.substring(0, val));
			res=Long.toString(prev+1);
			System.out.println(res+ " ");
			
			long prev1=Long.parseLong(res);
			
			long ans=Long.parseLong(s);
			
			long next=prev+1;
			
			while(prev1 <= ans) {
				prev1=Long.parseLong(res+Long.toString(next));
				next++;
			}
			return Long.toString(prev1);
		}
		
	}

	private static boolean isRoaring(String s) {
		for(int i=1;i<=s.length()/2;i++) {
			long prev=Long.parseLong(s.substring(0, i));
//			System.out.println("prev= "+prev+" ");
			int j=i,update=i;
			
			while(j<s.length()) {
				if(numDigit(prev+1) > numDigit(prev)) {
					update++;
				}
				if(j+update > s.length()) {
					break;
				}
				long cur=Long.parseLong(s.substring(j, j+update));
//				System.out.println("cur= "+cur+" ");
				if(cur != prev+1) {
					break;
				}	
				prev=cur;
				j+=update;
			}
			
			if(j>= s.length()) {
				return true;
			}
		}
		return false;
	}
	
	private static long numDigit(long ans) {
		long sum=0;
		while(ans > 0) {
			sum++;
			ans/=10;
		}
		return sum;
	}

	private static boolean go(int i, int j, long n, long m, Integer k, HashMap<Integer, Boolean>[][] dp) {
		if(i==n && j==m && k==0) {
			return true;
		}
		if(i<1 || j<1 || i>n || j>m || k<0) {
			return false;
		}
		if(dp[i][j].containsKey(k)) {
			return dp[i][j].get(k);
		}
		
		boolean down=go(i+1,j,n,m,k-j,dp);
		boolean left=go(i,j+1,n,m,k-i,dp);
		
		dp[i][j].put(k, left||down);
		return left||down;
	}


	private static long getDigitSum(long ans) {
		long sum=0;
		while(ans > 0) {
			sum+=ans%10;
			ans/=10;
		}
		return sum;
	}

	private static boolean getAns2(int l, long[] prefix, long x) {
		
		for(int i=l;i<prefix.length-1;i++) {
			if((x^prefix[i]) == (prefix[prefix.length-1]^prefix[i])) {
				return true;
			}
		}
		return false;
	}

	private static boolean getAns(long[] prefix) {
		
		for(int i=0;i<prefix.length-1;i++) {
			if(prefix[i] == (prefix[prefix.length - 1]^prefix[i])) {
				return true;
			}
		}
		
		return false;
	}

	private static void rotate(ArrayList<Integer> arr, int i) {
		reverse(arr,0,i-1);
		reverse(arr,i,arr.size()-1);
		reverse(arr,0,arr.size()-1);
	}

	private static void reverse(ArrayList<Integer> arr, int l, int m) {
		while(l<m) {
			int temp=arr.get(l);
			arr.set(l,arr.get(m));
			arr.set(m, temp);
			l++;
			m--;
		}
	}

	static int modInverse(int a, int m)
    {
        int m0 = m;
        int y = 0, x = 1;
 
        if (m == 1)
            return 0;
 
        while (a > 1) {
            int q = a / m;
 
            int t = m;

            m = a % m;
            a = t;
            t = y;

            y = x - q * y;
            x = t;
        }
 
        if (x < 0)
            x += m0;
 
        return x;
    }
   

	private static long isPerfectSquare(long num) {
		long l=1,h=num;
		
		while(l<=h) {
			long mid=l+(h-l)/2;
			
			if(mid*mid == num) {
				return mid;
			}else if(mid*mid < num) {
				l=mid+1;
			}else {
				h=mid-1;
			}
		}
		return -1;
	}


	private static void rightmax(long[] arr, long n,int[] res,int[] rightmax) {
    	
		Deque<Integer> stack=new ArrayDeque<>();
		
		stack.clear();
		for(int i=(int) (n-1);i>=0;i--) {
			while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}
			
			rightmax[i]=(stack.isEmpty()?Integer.MAX_VALUE:stack.peek());
			stack.addFirst(i);
		}
	}
	
	

	private static boolean rotatedSorted(long[] arr, int min) {
		reverse(arr,0,min-1);
		reverse(arr,min,arr.length-1);
		reverse(arr,0,arr.length-1);
		
		if(isSorted(arr)) {
			return true;
		}
		return false;
	}

	private static boolean isSorted(long[] arr) {
		for(int i=1;i<arr.length;i++) {
			if(arr[i] < arr[i-1]) {
				return false;
			}
		}
		return true;
	}

	private static int countDigit(long x) {
		int count=0;
		while(x > 0) {
			x/=10;
			count++;
		}
		return count;
	}

	private static boolean isSub(String s, String c) {
		int l=0;
		
		for(int i=0;i<s.length();i++) {
			if(l < c.length() && c.charAt(l)==s.charAt(i)) {
				l++;
			}
			if(l==c.length()) {
				break;
			}
		}
		if(l==c.length()) {
			return true;
		}
		return false;
	}

	static long power(long a, long d, long n)
	 {
		    long res = 1; 
		    a = a % n;
		    if (a == 0)
		      return 0; 
		 
		    while (d > 0)
		    {
		 
		      if ((d & 1) != 0)
		        res = (res * a) % n;
		 
		      d = d >> 1;
		      a = (a * a) % n;
		    }
		    return res;
		  }

	private static void reverse(long[] arr,int l,int m) {
		while(l<m) {
			long temp=arr[l];
			arr[l]=arr[m];
			arr[m]=temp;
			l++;
			m--;
		}
	}

	
	 static int UpperBound(ArrayList<Integer> a, int x) {// x is the key or target value
		    int l=-1,r=a.size();
		    while(l+1<r) {
		       int m=(l+r)>>>1;
		       if(a.get(m)<=x) l=m;
		       else r=m;
		    }
		    return l+1;
	 }

	private static void printMat(int[][] dp) {
		
    	System.out.println("--------------------------------------------------------------------");
		for(int i=0;i<dp.length;i++) {
    		for(int j=0;j<dp[0].length;j++) {
    			System.out.print(dp[i][j]+" ");
    		}
    		System.out.println();
    	}
		System.out.println("--------------------------------------------------------------------");
	}
   
	private static int highestOneBit(long n) {
		long x=Long.highestOneBit(n);
		int c=0;
		while(x >0) {
			x=x/2;
			c++;
		}
		return c-1;
	}
	
	private static int bitcount(long l) {
		int count=0;
		
    	while(l>0) {
			l-=(l&(-l));
			count++;
		}
		return count;
	}


	private static void bfs(HashMap<Integer, HashSet<Integer>> tree, int start) {
    	Queue<Integer> q=new LinkedList<>();
		q.offer(start);
		HashSet<Integer> visited=new HashSet<>();
		
		System.out.print(q.peek()+"\n");
		
		while(!q.isEmpty()) {
			int parent=q.poll();
			
			if(visited.contains(parent)) {
				continue;
			}
			visited.add(parent);
			int flag=0;

			for(int child:tree.get(parent)) {
				if(!visited.contains(child)) {
					q.offer(child);
					System.out.print(child+" ");
					flag=1;
				}
			}
			
			if(flag==0) {
				continue;
			}
			System.out.println();
		}
	}

	static int par;
	private static HashMap<Integer, HashSet<Integer>> getTreeInputLevel(StringTokenizer st) {
		Queue<Integer> q=new LinkedList<>();
		
		HashMap<Integer, HashSet<Integer>> tree=new HashMap<>();
		q.offer(Integer.parseInt(st.nextToken()));
		
		par=q.peek();
		
		while(!q.isEmpty()) {
			int parent=q.poll();
			
			if(!tree.containsKey(parent)) {
				tree.put(parent, new HashSet<Integer>());
			}
			
			int left=-1,right=-1;
			
			if(st.hasMoreElements())
				left=Integer.parseInt(st.nextToken());
			
			if(st.hasMoreElements())
				right=Integer.parseInt(st.nextToken());
			
			if(left != -1) {
				tree.get(parent).add(left);
				if(!tree.containsKey(left)) {
					tree.put(left, new HashSet<Integer>());
				}
				tree.get(left).add(parent);
				q.offer(left);
			}
			
			if(right != -1) {
				tree.get(parent).add(right);
				if(!tree.containsKey(right)) {
					tree.put(right, new HashSet<Integer>());
				}
				tree.get(right).add(parent);
				q.offer(right);
			}
			
		}
		tree.remove(-1);
		return tree;
	}






	private static int containsString(String s1,String s2) {
		String s=s1+"#"+s2;
		int[] z=getZfunc(s);
		
		boolean flag=false;
		for(int i=0;i<s.length();i++) {
			if(z[i]==s1.length()) {
				flag=true;
			}
		}
		int count=0;
		
		for(int i=s1.length();i<z.length;i++) {
//			System.out.print(z[i]+" ");
			if(z[i]==s1.length()) {
				count++;
			}
		}
//		System.out.println();
		return count;
	}


	private static int[] getZfunc(String s) {
		int[] z=new int[s.length()];
		 int l=0,r=0;
		 
		 for(int i=1;i<s.length();i++) {
			 
			 if(i <= r) {
				 z[i]=Math.min( z[i-l] , r-i+1);
			 }
			 while(i+z[i] < s.length() && s.charAt(z[i])==s.charAt(i+z[i])) {
				 z[i]++;
			 }
			 if(i+z[i] -1 > r) {
				 l=i;
				 r=i+z[i]-1;
			 }
			 
		 }
		return z;
	}


	
	private static long ceil(long n,long k) {
		long ans;
		if(n%k==0) {
			ans=n/k;
		}else {
			ans=n/k+1;
		}
		return ans;
	}


	static ArrayList<Integer> getDivisor(int n){
    	ArrayList<Integer> div=new ArrayList<>();
    	
        for (int i=1; i*i <= n; i++) 
        { 
            if (n%i==0) 
            { 
                if (n/i == i) 
                    div.add(i); 
                else { 
                    div.add(i);
                    div.add(n/i);
                }
            } 
        }
        
        return div;
    }
	
    static long gcd(long x,long y) {
    	return (y==0?x:gcd(y,x%y));
    }
    
	static int MAXN = 1000001;
	static int[] spf=new int[MAXN];
	
    static void sieveSmallestFactor() 
    { 
        spf[1] = 1;
        
        for (int i=2; i<MAXN; i++) 
        	spf[i] = i;
        
        for (int i=4; i<MAXN; i+=2) 
            spf[i] = 2; 
       
        
        for (int i=3; i*i<MAXN; i++) 
        { 
            if (spf[i] == i) 
            { 
                for (int j=i*i; j<MAXN; j+=i) 
                    if (spf[j]==j) 
                        spf[j] = i; 
            } 
        } 
    } 
    
    
	private static HashMap<Integer,Integer> PrimeFactorizationmap(long n) {
		int count=0;
		
		HashMap<Integer,Integer> factors=new HashMap<>();
		if(n==1) {
			factors.put( 1,1);
			return factors;
		}else {
			for(long i=2; i*i <= n ;i++) {
				long z=n;
				if(z%i==0) {
					count=0;
					while(z%i==0) {
						count++;
						z=z/i;
					}
					factors.put((int) (i+0),count);
				}
			}
			if(n>1) {
				factors.put((int) (n+0),1);
			}
		}
		return factors;
	}
	

    
    static HashMap<Integer,Integer> getprimeFactors(int n) 
    {
        HashMap<Integer,Integer> ret = new HashMap<>();
        while (n > 1) 
        { 
        	if(ret.containsKey(spf[n])) {
        		ret.put(spf[n],ret.get(spf[n])+1);
        	}else {
        		ret.put(spf[(int) n],1);
        	}
            n = n / spf[n]; 
        }
        
        return ret; 
    }
    
    static ArrayList<Integer> getPrimeSieve(){
		int primesieve[]=new int[1000005];
		
		Arrays.fill(primesieve,0);
		
		for(int i=2;i*i<primesieve.length;i++) {
			if(primesieve[i]==0)	
				for(int j=i*i;j<primesieve.length;j+=i) {	
						primesieve[j]=1;
				}
		}
		
		ArrayList<Integer> prime=new ArrayList<>();
		for(int i=2;i<primesieve.length;i++) {
			if(primesieve[i]==0) {
				prime.add(i);
			}
		}
		return prime;
    }
    
    
    
    
	private static boolean checkPrimeRM(long n,int k) {
		if(n<=4) {
			return n==2||n==3;
		}
		
		int s=0;
		long d=n-1;
		
		while((d&1) != 1) {
			d=d/2;
			s++;
		}
		
		for(int i=0;i<k;i++) {
			long a=2+(int)Math.random()*(n-4);
			if(isComposite(a,s,d,n)) {
				return false;
			}
		}

		return true;
	}

	private static boolean isComposite(long a, int s, long d, long n) {
		long x=power(a,d,n);
		
		if(x==1 || x==n-1) {
			return false;
		}
		
		for(int i=0;i<s;i++){
			if(x%(n-1)==0) {
				return false;
			}
			x=(x*x)%n;
		}
		
		return true;
	}
    
    public static HashSet<Long> getPrimeLtoR(int l,int r,List<Integer> prime) {
		if(l==1) l++;
		
		int[] arr=new int[r-l+1];
		
		Arrays.fill(arr,0);
		
		for(int i: prime ){

			if(i*i<=r) {
				
				int j=(l/i)*i;
				if(j<l) 
					j+=i;
				for(;j<=r;j+=i) {
					if(j!=i)
						arr[j-l]=1;
				}
			}else {
				break;
			}
			
		}
		
		HashSet<Long> primeLtoR=new HashSet<>();
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				primeLtoR.add((i+l+0l));
			}
		}
		return primeLtoR;
	}
}