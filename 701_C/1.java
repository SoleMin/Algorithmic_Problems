import java.io.*;

import java.util.*;

/*
4 3
2 1
1 3
4 3

 
 */
public class A {
	static FastReader sc=null;
	
	public static void main(String[] args) {
		sc=new FastReader();
		int n=sc.nextInt();
		char line[]=sc.next().toCharArray();
		int l=1,r=n,mid=0;
		while(l+1<r) {
			mid=(l+r)/2;
			if(go(line,mid))r=mid;
			else l=mid;
		}
		if(go(line,l))System.out.println(l);
		else System.out.println(r);
	
	}
	static boolean go(char line[],int k) {
		int n=line.length;
		Map<Character,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++) {
			if(!map.containsKey(line[i]))map.put(line[i],0);
		}
		//for(int e:map.values())System.out.print(e+" ");
		//System.out.println();
		for(int i=0;i<k;i++) {
			int c=map.get(line[i]);
			map.put(line[i],++c);
		}
		boolean done=true;
		//System.out.print(0+" "+k+" :");
		for(int e:map.values()) {
			//System.out.print(e+" ");
			if(e==0) {
				done=false;
			}
		}
		//System.out.println();
		if(done)return true;
		for(int i=k;i<n;i++) {
			done=true;
			int c=map.get(line[i-k]);
			map.put(line[i-k], --c);
			int c2=map.get(line[i]);
			map.put(line[i], ++c2);
			//System.out.print(i+" "+(i+k)+" :");
			for(int e:map.values()) {
				//System.out.print(e+" ");
				if(e==0) {
					done=false;
				}
			}
			//System.out.println();
			if(done)return true;
		}
		return false;
	}
	
	static int[] reverse(int a[]) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i:a)al.add(i);
		Collections.sort(al,Collections.reverseOrder());
		for(int i=0;i<a.length;i++)a[i]=al.get(i);
		return a;
	}
	static long gcd(long a,long b) {
		if(b==0)return a;
		else return gcd(b,a%b);
	}
	
	static void print(long a[]) {
		for(long e:a) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
	
	
	
	
	static void print(int a[]) {
		for(int e:a) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
	
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
        int[] readArray(int n) {
    		int a[]=new int [n];
    		for(int i=0;i<n;i++) {
    			a[i]=sc.nextInt();
    		}
    		return a;
    	}
    } 
}






