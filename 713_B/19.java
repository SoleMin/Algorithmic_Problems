import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br;
	static int[] ans;
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		ans = new int[8];
		int n = Integer.parseInt(br.readLine());
		System.out.println("?"+"1 1 "+n+" "+n);
		System.out.flush();
		int q = Integer.parseInt(br.readLine());
		cut(n);
		System.out.print("! ");
		for(int i=0 ; i<8 ; i++)	System.out.print(ans[i]+" ");
		System.out.println();
	}
	
	public static void solve(int x1, int y1, int x2, int y2, int t) throws Exception{
		int l=x1, r=x2;
		int xx1,yy1,xx2,yy2;
		while(l<r){
			int mid = (l+r)/2;
			if(query(x1,y1,mid,y2)==1)	r=mid;
			else	l=mid+1;
		}
		xx2 = l;
		l=x1; r=x2;
		while(r>l){
			int mid = (l+r+1)/2;
			if(query(mid,y1,x2,y2)==1)	l = mid;
			else r=mid-1;
		}
		xx1 = l;
		l=y1; r=y2;
		while(l<r){
			int mid = (l+r)/2;
			if(query(x1,y1,x2,mid)==1)	r=mid;
			else	l=mid+1;
		}
		yy2=l;
		l=y1;r=y2;
		while(r>l){
			int mid = (l+r+1)/2;
			if(query(x1,mid,x2,y2)==1)	l=mid;
			else	r=mid-1;
		}
		yy1 = l;
		ans[t] = xx1;	ans[t+1] = yy1 ; ans[t+2] = xx2;	ans[t+3] = yy2;
	//	System.out.println("!"+xx1+" "+yy1+" "+xx2+" "+yy2);
	}
	public static void cut(int n) throws Exception{
		int l=1, r=n;
		while(l<r){
			int mid = (l+r)/2;
			if(query(1,1,n,mid)==0)	l=mid+1;
			else	r = mid;
		}
		if(query(1,1,n,l)==1 && query(1,l+1,n,n)==1){
			solve(1,1,n,l,0);
			solve(1,l+1,n,n,4);
			return;
		}
		l=1;r=n;
		while(l<r){
			int mid = (l+r)/2;
			if(query(1,1,mid,n)==0)	l=mid+1;
			else	r=mid;
		}
		solve(1,1,l,n,0);
		solve(l+1,1,n,n,4);
	}
	public static int query(int x1, int y1, int x2, int y2) throws Exception{
		System.out.println("?"+x1+" "+y1+" "+x2+" "+y2);
		System.out.flush();
		int q = Integer.parseInt(br.readLine());
		return q;
	}
}