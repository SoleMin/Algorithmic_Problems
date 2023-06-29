import java.util.*;
import java.lang.*;
// StringBuilder uses java.lang
 
 
public class mC {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder st = new StringBuilder();
        int t = 1;
        for (int test = 0; test < t; test++) {
            int n = sc.nextInt();
            int MOD = sc.nextInt();

            long[] factorial = new long[1000];
            long[] powerOfTwo = new long[1000];
            factorial[0]=1;
            powerOfTwo[0]=1;
            for (int i=1;i<1000;i++) {
                factorial[i]=i*factorial[i-1];
                factorial[i] %= MOD;
                powerOfTwo[i]=2*powerOfTwo[i-1];
                if (powerOfTwo[i]>=MOD) {
                    powerOfTwo[i]-=MOD;
                }
            }
            long[] oneOverFactorial = new long[500];
            oneOverFactorial[0]=1;
            oneOverFactorial[1]=1;
            for (int i=2;i<450;i++) {
                oneOverFactorial[i] = fastPow(factorial[i],MOD-2,MOD);
            }
            long dp[][] = new long[n+3][n+3]; // first value number of computers considered
                                // second value number of computers manually on
            
            dp[1][1]=1;
            for (int i=2;i<=n;i++) { // from left to right, over first i computers
                dp[i][i]=powerOfTwo[i-1];
                for (int j=1;j<i-1;j++) { // number of computers turned on manually
                    for (int k=1;k<=j;k++) {
                        // want to add dp[j][k]*factorial[k+(i-j-1)]*oneOverFactorial[k]*oneOverFactorial[i-j-1]*powerOfTwo[i-j-2]
                        long add = dp[j][k]*factorial[k+(i-j-1)];
                        add %= MOD;
                        add *= oneOverFactorial[k];
                        add %= MOD;
                        add *= oneOverFactorial[i-j-1];
                        add %= MOD;
                        add *= powerOfTwo[i-j-2];
                        add %= MOD;
                        dp[i][k+(i-j-1)]+=add;
                        dp[i][k+(i-j-1)]%=MOD;
                    }
                }
            }
            long ans = 0;
            for (int i=1;i<=n;i++) {
                ans+=dp[n][i];
            }
            ans %= MOD;
            System.out.println(ans);
        }
        
        //System.out.print(st.toString());
    }
    
    public static int goodLeft(int n, int[] p) { // i.e. ... 4 5 6
        int begin = 0;
        for (int i=0;i<n;i++) {
            if (n-i==p[n-i-1]) {
                begin++;
            } else {
                break;
            }
        }
        return begin;
    }
    public static int goodRight(int n, int[] p) { // i.e. 6 5 4 ...
        int end = 0;
        for (int i=n-1;i>=0;i--) {
            if (i==p[i]) {
                end++;
            } else {
                break;
            }
        }
        return end;
    }
    public static int findNthInArray(int[] arr,int val,int start,int o) {
        if (o==0) {
            return start-1;
        } else if (arr[start] == val) {
            return findNthInArray(arr,val,start+1,o-1);
        } else {
            return findNthInArray(arr,val,start+1,o);
        }
    }
    public static ArrayList<Integer> dfs(int at,ArrayList<Integer> went,ArrayList<ArrayList<Integer>> connect) {
        for (int i=0;i<connect.get(at).size();i++) {
            if (!(went.contains(connect.get(at).get(i)))) {
                went.add(connect.get(at).get(i));
                went=dfs(connect.get(at).get(i),went,connect);
            }
        }
        return went;
    } public static int[] bfs (int at, int[] went, ArrayList<ArrayList<Integer>> queue, int numNodes, ArrayList<ArrayList<Integer>> connect) {
        if (went[at]==0) {
            went[at]=queue.get(numNodes).get(1);
            for (int i=0;i<connect.get(at).size();i++) {
                if (went[connect.get(at).get(i)]==0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(connect.get(at).get(i));
                    temp.add(queue.get(numNodes).get(1)+1);
                    queue.add(temp);
                }
            }
            
        }
        if (queue.size()==numNodes+1) {
            return went;
        } else {
            return bfs(queue.get(numNodes+1).get(0),went, queue, numNodes+1, connect);
        }
    }
    public static long fastPow(long base,long exp,long mod) {
        if (exp==0) {
            return 1;
        } else {
            if (exp % 2 == 1) {
                long z = fastPow(base,(exp-1)/2,mod);
                return ((((z*base) % mod) * z) % mod);
            } else {
                long z = fastPow(base,exp/2,mod);
                return ((z*z) % mod);
            }
        }
    }
    public static int fastPow(int base,long exp) {
        if (exp==0) {
            return 1;
        } else {
            if (exp % 2 == 1) {
                int z = fastPow(base,(exp-1)/2);
                return ((((z*base)) * z));
            } else {
                int z = fastPow(base,exp/2);
                return ((z*z));
            }
        }
    }
    public static int firstLarger(long val,ArrayList<Long> ok,int left,int right) {
        
        if (ok.get(right)<=val) {
            return -1;
        }
        if (left==right) {
            return left;
        } else if (left+1==right) {
            if (val<ok.get(left)) {
                return left;
            } else {
                return right;
            }
        } else {
            int mid = (left+right)/2;
            if (ok.get(mid)>val) {
                return firstLarger(val,ok,left,mid);
            } else {
                return firstLarger(val,ok,mid+1,right);
            }
        }
    }
    public static int binSearchArr(long val,ArrayList<Integer> ok,long[] arr,int left,int right) {
        
        if (arr[ok.get(right)]<=val) {
            return -1;
        }
        if (left==right) {
            return left;
        } else if (left+1==right) {
            if (val<arr[ok.get(left)]) {
                return left;
            } else {
                return right;
            }
        } else {
            int mid = (left+right)/2;
            if (arr[ok.get(mid)]>val) {
                return binSearchArr(val,ok,arr,left,mid);
            } else {
                return binSearchArr(val,ok,arr,mid+1,right);
            }
        }
    }
    public static long gcd(long a, long b) {
        if (b>a) {
            return gcd(b,a);
        }
        if (b==0) {
            return a;
        }
        if (a%b==0) {
            return b;
        } else {
            return gcd(b,a%b);
        }
    }
}