// @jagrit_07
import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class Main {
    
	public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        HashMap<Integer,Integer> hm = new HashMap<>();
        //There is useless pair ))(( like this;
        //There is one use pair  ))  like this;
        // and this ((;  )(()
        String s[] = new String[n];
        for(int i =0;i<n;i++)
        {
            s[i] = sc.next();
        }
        for(int i =0;i<n;i++)
        {
            char ch[] = s[i].toCharArray();
            int open=0;
            int uo=0;
            int uc=0;
            int min=0;
            for(int j=0;j<ch.length;j++)
            {
                if(ch[j]==')')
                {
                    open--;
                }
                else
                {
                    open++;
                }
                if(open<min)
                {
                    uc++;
                    min=Math.min(open,min);
                }
                
            }
            open=0;
            min=0;
            for(int j=ch.length-1;j>=0;j--)
            {
                if(ch[j]==')')
                {
                    open++;
                }
                else
                {
                    open--;
                }
                if(open<min)
                {
                    uo++;
                    min=Math.min(open,min);
                }
            }
            //System.out.println(uo+)
            if(uo>0 && uc>0)
            {
                //this is a uselss pair;
            }
            else if(uo==0 && uc==0)
            {
                hm.put(0,hm.getOrDefault(0,0)+1);
            }
            else if(uo>0)
            {
                hm.put(uo,hm.getOrDefault(uo,0)+1);
            }
            else if(uc>0)
            {
                hm.put(-uc,hm.getOrDefault(-uc,0)+1);
            }
        }
        long count = 0;
        for(int i =0;i<n;i++)
        {
            
            char ch[] = s[i].toCharArray();
            int open=0;
            int uo=0;
            int uc=0;
            int min=0;
            for(int j=0;j<ch.length;j++)
            {
                if(ch[j]==')')
                {
                    open--;
                }
                else
                {
                    open++;
                }
                if(open<min)
                {
                    uc++;
                    min=Math.min(open,min);
                }
                
            }
            open=0;
            min=0;
            for(int j=ch.length-1;j>=0;j--)
            {
                if(ch[j]==')')
                {
                    open++;
                }
                else
                {
                    open--;
                }
                if(open<min)
                {
                    uo++;
                    min=Math.min(open,min);
                }
            }
            if(uo>0 && uc>0)
            {
                //this is a uselss pair;
            }
            else if(uo==0 && uc==0)
            {
                count = count + hm.get(uo);
            }
            else if(uo>0)
            {
                if(hm.containsKey(-uo))
                {
                    count = count + hm.get(-uo);
                }
            }
            
        }
        System.out.println(count);
        
    }


    public static int bs(int num[], long x)
    {
        int low=0;
        int high=num.length-1;
        int ans=-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(num[mid]==x)
            {
                ans = mid;
                //break;
                low = mid+1;
            }
            else if(num[mid]<x)
            {
               // ans=mid;
                ans = mid;
                low=mid+1;
            }
            else
            {
                //ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
    
    
    
    
    
    
    
    
    
    public static List<Integer> solve(char ch[], int split)
    {
        long sum = 0;
        List<Integer> l1 = new ArrayList<>();
        for(int i=0;i<split && i<ch.length;i++)
        {
            l1.add(ch[i]-'0');
        }
        List<Integer> l2 = new ArrayList<>();
        for(int i=split;i<ch.length;i++)
        {
            l2.add(ch[i]-'0');
        }
        //System.out.println(Arrays.toString(l1.toArray()));
        //System.out.println(Arrays.toString(l2.toArray()));
        int carry = 0;
        int i = l1.size()-1;
        int j = l2.size()-1;
        List<Integer> list = new ArrayList<>();
        while(i>=0 || j>=0)
        {
            int e1 = (i>=0) ? l1.get(i) : 0;
            int e2 = (j>=0) ? l2.get(j) : 0;
            i--;
            j--;
            int e3 = e1 + e2 + carry;
            if(e3>9)
            {
                list.add(e3%10);
                carry = 1;
            }
            else
            {
                list.add(e3);
                carry = 0;
            }
        }
        if(carry>0)
        {
            list.add(1);
        }
       // System.out.println(Arrays.toString(l2.toArray()));
        Collections.reverse(list);
        return list;
    }
    
    //Comparing two list;
    public static List<Integer> comp(List<Integer> l1, List<Integer> l2)
    {
        if(l1.size()<l2.size()) return l1;
        if(l2.size()<l1.size()) return l2;
        
        for(int i=0;i<l1.size();i++)
        {
            if(l1.get(i)<l2.get(i))
            {
                return l1;
            }
            else if(l2.get(i)<l1.get(i))
            {
                return l2;
            }
        }
        return l2;
    }
   
    
   
    
 
    /* to find (x^y)%p in O(log y) */
    static long power(long x, long y, int p) 
    { 
        // Initialize result 
        long ans = 1;      
         
        // Update x if it is more   
        // than or equal to p 
        x = x % p;  
  
       if (x == 0) return 0; // In case x is divisible by p;    
  
        while (y > 0) 
        { 
            if((y & 1)==1) 
            {
                 ans = ((long)(ans * x))% p;    
            }
            y = y >> 1;  //y/2; 
            x = ((long)(x * x) )% p;  
        } 
        return ans; 
    } 
    
    
    
    
    
    public static void printList(List<Integer> list)
    {
        StringBuffer bf = new StringBuffer("");
        for(int i: list) bf.append(i+" ");
        System.out.println(bf.toString());
    }
    
    
    
    
    
    public static int sum(int a[])
    {
        int sum=0;
        for(int i: a) sum=sum+i;
        return sum;
    }
    
  
    public static int getMax(int a[])
    {
        int m=Integer.MIN_VALUE;
        for(int i: a) m=Math.max(i,m);
        return m;
    }
    
    static class Pair
    {
        int x;
        int y;

        //int i;
        public Pair(int x, int  y)
        {
            this.x=x;
            this.y=y;
        }
    }
    static class Comp implements Comparator<Pair>
    {
        public int compare(Pair p1, Pair p2)
        {
            return  p1.x-p2.x;
        }
    }
    
    
    
    public static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1);
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] < pivot) 
            { 
                i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
    public static void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
    
    
    
    
    
    
    static long gcd(long a,long b)
    {
        if(b==0) return a;
        return gcd(b,a%b);
    }
    
    
    static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
    static void sort(long[] a) {
		ArrayList<Long> l=new ArrayList<>();
		for (long i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
    
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
 
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
 
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (final IOException e) {
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
			try {
				str = br.readLine();
			} catch (final IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		int[] nextIntArray(final int n) {
			final int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(next());
			}
			return a;
		}

	}	
}
//private ArrayList<String[]> action = new ArrayList<String[]>();


//Templates for Comparator and Classes - @jagrit_07
/*
Arrays.sort(newEmployees, new Comparator<Employee>() {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getName().compareTo(emp2.getName());
    }
});
class Pair
	{
		
		long i; //index;
		long l; //left;
		long c; //cost;
		public Pair(long x,long y,long z)
		{
			this.i=x;
			this.l=y;
			this.c=z;
		}
		public String toString()
		{
			return this.i+" "+this.l+" "+this.c;
		}
	}
class Comp implements Comparator<Pair>
	{
		public int compare(Pair p1, Pair p2)
		{
			if(p1.c!=p2.c)
			{
				return (int)(p1.c-p2.c); //sort acc to cost;
			}
			else{
				return (int)(p1.i-p2.i); //sort acc to index;
			}
			
		}
	}
*/

/*
System.out.println( 
      String.format("%.5f", b)); 
  HashMap - Put template - d.put(a1,d.getOrDefault(a1,0)+1);
  for (Map.Entry<String, Integer> entry : map.entrySet()) {
        System.out.println(entry.getKey() + ":" + entry.getValue());
    }
  Deque<String> deque 
            = new LinkedList<String>();  
            
  List<Integer> c[] = new ArrayList[3];          
*/