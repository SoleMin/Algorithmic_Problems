import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Main {
	static final long MOD=1000000007;
	static final long MOD1=998244353;
	static int R=0;
	public static void main(String[] args){
		PrintWriter out = new PrintWriter(System.out);
		InputReader sc=new InputReader(System.in);
		int N=sc.nextInt();
		int Q=sc.nextInt();
		IntRangeSet set=new IntRangeSet();
		set.addAll(1, N);
		for (int i = 0; i < Q; i++) {
			int l=sc.nextInt();
			int r=sc.nextInt();
			int k=sc.nextInt();
			if (k==1) {
				N-=set.removeAll(l, r);
			}else {
				N+=set.addAll(l, r);
			}
			out.println(N);
		}
		out.flush();
	}
	static class InputReader { 
		private InputStream in;
		private byte[] buffer = new byte[1024];
		private int curbuf;
		private int lenbuf;
		public InputReader(InputStream in) {
			this.in = in;
			this.curbuf = this.lenbuf = 0;
		}
		public boolean hasNextByte() {
			if (curbuf >= lenbuf) {
				curbuf = 0;
				try {
					lenbuf = in.read(buffer);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (lenbuf <= 0)
					return false;
			}
			return true;
		}
 
		private int readByte() {
			if (hasNextByte())
				return buffer[curbuf++];
			else
				return -1;
		}
 
		private boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}
 
		private void skip() {
			while (hasNextByte() && isSpaceChar(buffer[curbuf]))
				curbuf++;
		}
 
		public boolean hasNext() {
			skip();
			return hasNextByte();
		}
 
		public String next() {
			if (!hasNext())
				throw new NoSuchElementException();
			StringBuilder sb = new StringBuilder();
			int b = readByte();
			while (!isSpaceChar(b)) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}
 
		public int nextInt() {
			if (!hasNext())
				throw new NoSuchElementException();
			int c = readByte();
			while (isSpaceChar(c))
				c = readByte();
			boolean minus = false;
			if (c == '-') {
				minus = true;
				c = readByte();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = res * 10 + c - '0';
				c = readByte();
			} while (!isSpaceChar(c));
			return (minus) ? -res : res;
		}
 
		public long nextLong() {
			if (!hasNext())
				throw new NoSuchElementException();
			int c = readByte();
			while (isSpaceChar(c))
				c = readByte();
			boolean minus = false;
			if (c == '-') {
				minus = true;
				c = readByte();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = res * 10 + c - '0';
				c = readByte();
			} while (!isSpaceChar(c));
			return (minus) ? -res : res;
		}
 
		public double nextDouble() {
			return Double.parseDouble(next());
		}
 
		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}
 
		public long[] nextLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}
 
		public char[][] nextCharMap(int n, int m) {
			char[][] map = new char[n][m];
			for (int i = 0; i < n; i++)
				map[i] = next().toCharArray();
			return map;
		}
	}
}
class IntRangeSet{//連続する区間を管理(insert時繋がる区間は繋げる)
	static class ClosedRange implements Comparable<ClosedRange>{
    	public int l;
    	public int r;
    	public ClosedRange(int l,int r) {
    		this.l=l;
    		this.r=r;
    	}
    	@Override
    	public boolean equals(Object obj) {
    		if(obj instanceof ClosedRange) {
    			ClosedRange other = (ClosedRange) obj;
    			return other.l==this.l && other.r==this.r;
    		}
    		return false;
    	}//同値の定義
    	@Override
    	public int hashCode() {
    		return Objects.hash(this.l,this.r);
    	}
    	@Override
    	public int compareTo( ClosedRange p){
    		if (this.l>p.l) {
    			return 1;
    		}
    		else if (this.l<p.l) {
    			return -1;
    		}
    		else {
    			return 0;
    		}
    	}//lが同じなら同値とみなされるので注意
    }
	private final int INF=Integer.MAX_VALUE;
	private final TreeSet<ClosedRange> set;
	public IntRangeSet() {
        this.set = new TreeSet<>();
        set.add(new ClosedRange(-INF, -INF));
        set.add(new ClosedRange(+INF, +INF));
    }
	public void clear() {
        set.clear();
        set.add(new ClosedRange(-INF, -INF));
        set.add(new ClosedRange(+INF, +INF));
    }
	public ClosedRange getInclusingRange(int x) {
        assert -INF < x && x < +INF;
        ClosedRange m = new ClosedRange(x, x);
        ClosedRange l = set.floor(m);
        return x <= l.r ? l : null;
    }//xを含む区間を返す。なければnull
	public boolean contains(int x) {
        return getInclusingRange(x) != null;
    }
	public boolean add(int x) {
        assert -INF < x && x < +INF;
        ClosedRange m = new ClosedRange(x, x);
        ClosedRange l = set.floor(m);
        if (x <= l.r) return false;
        ClosedRange r = set.ceiling(m);
        int lx = x, rx = x;
        if (l.r + 1 == x) {
            set.remove(l);
            lx = l.l;
        }
        if (x + 1 == r.l) {
            set.remove(r);
            rx = r.r;
        }
        set.add(new ClosedRange(lx, rx));
        return true;
    }//区間[x,x]を挿入、もともと入っていればfalseを返す。
	public boolean remove(int x) {
        assert -INF < x && x < +INF;
        ClosedRange m = new ClosedRange(x, x);
        ClosedRange l = set.floor(m);
        if (l.r < x) return false;
        if (x + 1 <= l.r) {
            set.add(new ClosedRange(x + 1, l.r));
        }
        if (l.l <= x - 1) {
            l.r = x - 1;
        } else {
            set.remove(l);
        }
        return true;
    }//区間[x,x]を削除、入っていなければfalseを返す。
	public boolean containsAll(int l, int r) {
        assert -INF < l && r < +INF;
        if (r < l) return false;
        ClosedRange m = new ClosedRange(l, l);
        ClosedRange f = set.floor(m);
        return r <= f.r;
    }//[l.r]を含むかどうか
	public int addAll(int l, int r) {
        assert -INF < l && r < +INF;
        if (r < l) return 0;
        ClosedRange m = new ClosedRange(l, r);
        ClosedRange f = set.floor(m);
        if (m.r <= f.r) return 0;//挿入区間が既に完全に含まれている
        if (m.l - 1 <= f.r) {
            set.remove(f);
            m.l = f.l;
            l = f.r + 1;
        }//左端のはみ出している区間の処理
        int added = 0;
        while (true) {//[l,r]に含まれる区間を削除
            ClosedRange c = set.ceiling(m);
            if (m.r < c.l - 1) {
                added += m.r - l + 1;
                break;
            } else {
                added += c.l - l;
                set.remove(c);
                l = c.r + 1;
                if (l > m.r) {
                    m.r = c.r;
                    break;
                }//右端の処理
            }
        }
        set.add(m);
        return added;
    }//区間[l.r]を挿入して増えた要素数を返す。完全に含まれる区間は削除
	public int removeAll(int l, int r) {
        assert -INF < l && r < +INF;
        if (r < l) return 0;
        ClosedRange m = new ClosedRange(l, r);
        ClosedRange f = set.floor(m);
        if (m.r <= f.r) {//[l.r]を完全に含んでいる区間がある場合
            if (m.r + 1 <= f.r) {
                set.add(new ClosedRange(m.r + 1, f.r));
            }//右側を処理
            if (f.l <= m.l - 1) {
                f.r = m.l - 1;//左側を処理
            } else {
                set.remove(f);
            }
            return m.r - m.l + 1;
        }
        int removed = 0;
        if (m.l <= f.r) {
            removed += f.r - m.l + 1;
            if (f.l <= m.l - 1) {
                f.r = m.l - 1;
            } else {
                set.remove(f);
            }
        }//左端の処理
        while (true) {
            ClosedRange c = set.ceiling(m);
            if (m.r < c.l) {
                break;
            } else {
                if (m.r >= c.r) {
                    removed += c.r - c.l + 1;
                    set.remove(c);
                } else {
                    removed += m.r - c.l + 1;
                    set.remove(c);
                    c.l = m.r + 1;
                    set.add(c);
                    break;
                }//右端の処理
            }
        }
        return removed;
    }
	public int intersectionSize(int l, int r) {
		assert -INF < l && r < +INF;
		if (r < l) return 0;
		ClosedRange m = new ClosedRange(l, r);
		ClosedRange f = set.floor(m);
		int intersection = 0;
		if (m.l <= f.r) {
			intersection += f.r - m.l + 1;
			m.l = f.r + 1;
		}
		while (true) {
			ClosedRange c = set.ceiling(m);
			if (m.r < c.l) {
				break;
			} else {
				if (m.r >= c.r) {
					intersection += c.r - c.l + 1;
					m.l = c.r + 1;
				} else {
					intersection += m.r - c.l + 1;
					break;
				}
			}
		}
		return intersection;
	}//[l.r]に重なっている要素数を返す。
}