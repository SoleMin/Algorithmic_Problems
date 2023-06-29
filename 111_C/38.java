import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class P111C{
	Scanner sc=new Scanner(System.in);

	int INF=1<<28;
	double EPS=1e-9;

	int h, w;

	void run(){
		h=sc.nextInt();
		w=sc.nextInt();
		solve();
	}

	void shuffle(int[] is){
		Random rand=new Random();
		for(int i=is.length-1; i>=1; i--){
			int j=rand.nextInt(i+1);
			int t=is[i];
			is[i]=is[j];
			is[j]=t;
		}
	}

	void solve(){
		n=w*h;
		g=new long[n];
		int[] dx={0, 0, -1, 1};
		int[] dy={-1, 1, 0, 0};
		for(int y=0; y<h; y++){
			for(int x=0; x<w; x++){
				for(int k=0; k<4; k++){
					int x2=x+dx[k];
					int y2=y+dy[k];
					if(x2>=0&&x2<w&&y2>=0&&y2<h){
						g[y*w+x]|=1L<<(y2*w+x2);
					}
				}
			}
		}
		candidate=new int[n];
		xs=new Xorshift();
		mds=(1L<<n)-1;
		mds(0, 0, 0);
		println((n-Long.bitCount(mds))+"");
	}

	int n;
	long[] g;
	long mds;
	int[] candidate;
	Xorshift xs;

	void mds(long choosed, long removed, long covered){
		if(Long.bitCount(choosed)>=Long.bitCount(mds))
			return;
		if(covered==((1L<<n)-1)){
			if(Long.bitCount(choosed)<Long.bitCount(mds))
				mds=choosed;
			return;
		}
		
		{
			long s=covered;
			for(long remained=~removed&((1L<<n)-1); remained!=0; remained&=remained-1){
				int i=Long.numberOfTrailingZeros(remained);
				s|=(1L<<i)|g[i];
			}
			if(s!=((1L<<n)-1)){
				return;
			}
		}

		int index=0;
		int k=-1;
		for(long remained=~removed&((1L<<n)-1); remained!=0; remained&=remained-1){
			int i=Long.numberOfTrailingZeros(remained);
			if((covered>>>i&1)==1){
				if(Long.bitCount(g[i]&~covered)==0){
					mds(choosed, removed|(1L<<i), covered);
					return;
				}else if(Long.bitCount(g[i]&~covered)==1
						&&(g[i]&~covered&~removed)!=0){
					mds(choosed, removed|(1L<<i), covered);
					return;
				}
			}else{
				if(Long.bitCount(g[i]&~removed)==0){
					mds(choosed|(1L<<i), removed|(1L<<i), covered|(1L<<i)|g[i]);
					return;
				}else if(Long.bitCount(g[i]&~removed)==1
						&&((g[i]&~removed)|(g[i]&~covered))==(g[i]&~removed)){
					int j=Long.numberOfTrailingZeros(g[i]&~removed);
					mds(choosed|(1L<<j), removed|(1L<<i)|(1L<<j), covered
							|(1L<<j)|g[j]);
					return;
				}
			}
			// if(k==-1||Long.bitCount(g[i]&~covered)>Long.bitCount(g[k]&~covered))
			// k=i;
			if(k==-1||Long.bitCount(g[i]&~covered)>Long.bitCount(g[k]&~covered)){
				index=0;
				candidate[index++]=i;
				k=i;
			}else if(Long.bitCount(g[i]&~covered)==Long.bitCount(g[k]&~covered)){
				candidate[index++]=i;
			}
		}
		if(k==-1)
			return;

		// k=candidate[xs.nextInt(index)];

		mds(choosed|(1L<<k), removed|(1L<<k), covered|(1L<<k)|g[k]);
		mds(choosed, removed|(1L<<k), covered);
	}

	class Xorshift{

		int x, y, z, w;

		public Xorshift(){
			x=123456789;
			y=362436069;
			z=521288629;
			w=88675123;
		}

		public Xorshift(int seed){
			x=_(seed, 0);
			y=_(x, 1);
			z=_(y, 2);
			w=_(z, 3);
		}

		int _(int s, int i){
			return 1812433253*(s^(s>>>30))+i+1;
		}

		// 32bit signed
		public int nextInt(){
			int t=x^(x<<11);
			x=y;
			y=z;
			z=w;
			return w=w^(w>>>19)^t^(t>>>8);
		}

		// error = O(n*2^-32)
		public int nextInt(int n){
			return (int)(n*nextDouble());
		}

		// [0, 1) (53bit)
		public double nextDouble(){
			int a=nextInt()>>>5, b=nextInt()>>>6;
			return (a*67108864.0+b)*(1.0/(1L<<53));
		}

	}

	void println(String s){
		System.out.println(s);
	}

	void print(String s){
		System.out.print(s);
	}

	void debug(Object... os){
		System.err.println(Arrays.deepToString(os));
	}

	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		new P111C().run();
	}

}
