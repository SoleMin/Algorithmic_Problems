

import java.util.Scanner;

public class D {
    static long max;

    public static long[] getOneRange(long min, long max,int bit) {
        long st=(min&(((1l<<63)-1)&~((1l<<(bit+1))-1)))|(1l<<bit);
        long end=st|((1l<<(bit+1))-1);
        long interSt=Math.max(st,min);
        long interEnd=Math.min(end, max);
        if(interSt>interEnd) return null;
        return new long[]{interSt,interEnd};
    }

    public static long[] getZeroRange(long min, long max,int bit) {
        long st=min&(((1l<<63)-1)&~((1l<<(bit+1))-1));
        long end=st|((1l<<bit)-1);
        long interSt=Math.max(st,min);
        long interEnd=Math.min(end, max);
        if(interSt>interEnd) return null;
        return new long[]{interSt,interEnd};
    }

    public static void solve(int bitPosition, long min1, long max1, long min2,
            long max2, long curNum) {
        if (bitPosition == -1) {
            max = Math.max(max, curNum);
            return;
        }
        long[] firZeroRange = getZeroRange(min1, max1,bitPosition);
        long[] secZeroRange = getZeroRange(min2, max2,bitPosition);
        long[] firOneRange = getOneRange(min1, max1,bitPosition);
        long[] secOneRange = getOneRange(min2, max2,bitPosition);
        if ((firOneRange != null && secZeroRange != null)
                || (firZeroRange != null && secOneRange != null)) {
            long newNum = curNum | (1l << bitPosition);
            if (firOneRange != null && secZeroRange != null&&
                    (firOneRange[1]-firOneRange[0]+1)==1l<<bitPosition&&
                    (secZeroRange[1]-secZeroRange[0]+1)==1l<<bitPosition) {
                solve(bitPosition - 1, firOneRange[0], firOneRange[1],
                        secZeroRange[0], secZeroRange[1], newNum);
                return;
            }
            if (firZeroRange != null && secOneRange != null&&
                    (firZeroRange[1]-firZeroRange[0]+1)==1l<<bitPosition&&
                    (secOneRange[1]-secOneRange[0]+1)==1l<<bitPosition) {
                solve(bitPosition - 1, firZeroRange[0], firZeroRange[1],
                        secOneRange[0], secOneRange[1], newNum);
                return;
            }
            if (firOneRange != null && secZeroRange != null) {
                solve(bitPosition - 1, firOneRange[0], firOneRange[1],
                        secZeroRange[0], secZeroRange[1], newNum);
            }
            if (firZeroRange != null && secOneRange != null) {
                solve(bitPosition - 1, firZeroRange[0], firZeroRange[1],
                        secOneRange[0], secOneRange[1], newNum);
            }
        } else {
            solve(bitPosition - 1, min1, max1, min2, max2, curNum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long r = sc.nextLong();
        max = 0;
        solve(62, l, r, l, r, 0);
        System.out.println(max);
    }
}
