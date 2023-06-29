import java.util.*;

public class C{
	static String s;
	static long val[];
	static int N,size;
	static int index(char c){
		if(c <= 'Z'){
			return c - 'A';
		}else{
			return c - 'a' + ('Z' - 'A' + 1);
		}
	}

	static int l(int i){
		return (i<<1)+1;
	}
	static int r(int i){
		return (i<<1)+2;
	}

	static void setup(int l, int r, int i){
		if(l==r){
			val[i] = (1L<<index(s.charAt(l)));
		}else{
			int mid = (l+r)/2;
			setup(l,mid,l(i));
			setup(mid+1,r,r(i));
			val[i] = val[l(i)] | val[r(i)];
		}
	}

	static long query(int min, int max, int l, int r, int i){
		if(min <= l && r <= max){
			return val[i];
		}
		if(max < l || r < min)
			return 0;
		int mid = (l+r)/2;
		return query(min,max,l,mid,l(i)) | query(min,max,mid+1,r,r(i));
	}
	static long query(int min, int max){
		return query(min,max,0,N-1,0);
	}

	static int binarySearch(int start, long toFind){
		int max = N-1;
		int min = start;
		if(query(start,max) != toFind)
			return 1<<29;
		if(query(start,start) == toFind){
			return 1;
		}
		int ret = max - min + 1;
		while(min + 1 < max){
			int mid = (min+max)/2;
			if(query(start,mid) == toFind){
				max = mid;
			}else{
				min = mid;
			}
		}
		return max-start+1;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		s = sc.next();
		int size = 1;
		while(size <= N) size*=2;
		val = new long[size*2];
		setup(0,N-1,0);

		long toFind = query(0,N-1,0,N-1,0);
		long ans = 1L<<29;
		for(int i = 0; i < N; i++)
			ans = Math.min(ans,binarySearch(i,toFind));
		System.out.println(ans);
	}
}