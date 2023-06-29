import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Main extends PrintWriter {

    static BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
    // static Scanner s=new Scanner(System.in);
    Main () { super(System.out); }
    public static void main(String[] args) throws IOException{
        Main  d1=new Main   ();d1.main();d1.flush();
    }
    void main() throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();
        PrintWriter out = new PrintWriter(System.out);
        int t=1;
//        t=i(s()[0]);
        while(t-->0) {
            //dp[i]=a[i]+max(dp[j]) S.T. j<i and h[j]<h[i];
            String[] s1 = s();
            int n = i(s1[0]);
             long[] a=new long[n];
             arr(a,n);
             HashMap<Long,Integer>[] dp=new HashMap[n];

             long[] presum=new long[n];
             for(int i=0;i<n;i++){
                 if(i==0){
                     presum[i]=a[i];
                 }else{
                     presum[i]=a[i]+presum[i-1];
                 }
             }HashMap<Long,TreeMap<Integer,Long> > tm=new HashMap<>();int ans=0;long maxsum=0;
             for(int i=0;i<n;i++){
                  dp[i]=new HashMap<>();
                 for(int j=-1;j<i;j++){
                     long sum=0;
                     if(j==-1) sum=presum[i];else sum=presum[i]-presum[j];
//                     if(sum==5&&i==5) System.out.println(tm.get(sum).floorKey(4));
                     if(tm.containsKey(sum)&&tm.get(sum).floorKey(j)!=null){
                         dp[i].put(sum,Math.max(dp[i].getOrDefault(sum,0),dp[tm.get(sum).floorKey(j)].getOrDefault(sum,0)+1));
                        if(dp[i].get(sum)>ans){
                            maxsum=sum;
                        }
                         ans=Math.max(ans,dp[i].get(sum));
                     }else if(dp[i].containsKey(sum)==false){
                         if(dp[i].getOrDefault(sum,0)<1) dp[i].put(sum,1);
                         if(dp[i].get(sum)>ans){
                             maxsum=sum;
                         }
                         ans=Math.max(ans,1);
                     }
                     long val=dp[i].getOrDefault(sum,0);
//                     if(tm.containsKey(sum)&&tm.get(sum).floorKey(i-1)!=null){
                         if(!tm.containsKey(sum)||tm.get(sum).floorKey(i-1)==null||dp[tm.get(sum).floorKey(i-1)].getOrDefault(sum,0)<val) {
//                             val = Math.max(val, dp[tm.get(sum).floorKey(i - 1)].getOrDefault(sum, 0));
                             TreeMap<Integer, Long> tt = new TreeMap<>();
                             tt.put(i, val);
                             tm.put(sum, tt);
                         }
//                     }
                     }
             }int cnt=0;int last=-1;
             for(int i=0;i<n;i++){
                 for(int j=i-1;j>=-1;j--){
                     long sum=0;
                     if(j==-1) sum=presum[i];
                     else sum=presum[i]-presum[j];
                     if(dp[i].getOrDefault(maxsum,0)>cnt&&maxsum==sum){
                         sb.append(j+2+" "+(i+1)+"\n");cnt++;
                         break;
                     }
                 }
             } System.out.println(ans);
//            System.out.println(dp[5].get(5L)+" "+dp[4].get(5L));
            System.out.println(sb);
        }

    }
    //        System.out.println(sb);
    long[] st;
    void buildtree(int i,int s,int e,long[] a){
        if(s==e){
            st[i]=a[s];
            return;
        }
        int mid=(s+e)/2;
        buildtree(2*i,s,mid,a);
        buildtree(2*i+1,mid+1,e,a);
        st[i]=Math.min(st[2*i],st[2*(i)+1]);
    }
    long query(int i,int s,int e,int qs,int qe){
        if(qs>e||qe<s) return Integer.MIN_VALUE;
        if(s>=qs&&e<=qe) return st[i];
        int mid=(s+e)/2;
        long l=query(2*i,s,mid,qs,qe);
        long r=query(2*i+1,mid+1,e,qs,qe);
        return Math.max(l,r);
    }
    void pointupdate(int i,int s,int e,int qi,long [] a){
        if(s==e){
            st[i]=a[s];return;
        }
        int mid=(s+e)/2;
        if(qi<=mid) pointupdate(2*i,s,mid,qi,a);
        else pointupdate(2*(i)+1,mid+1,e,qi,a);
        st[i]=Math.max(st[2*i],st[2*i+1]);
    }
    public void arr(long[] a,int n) throws IOException{
        //        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String[] s2=s();
        for(int i=0;i<n;i++){
            a[i]=i(s2[i]);
        }
    }
    public void sort(int[] a,int l,int h){
        if(l==h) return;
        int mid=(l+h)/2;

        sort(a,l,mid);
        sort(a,mid+1,h);
        merge(a,l,(l+h)/2,h);
    }
    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    static String[] s() throws IOException {
        return s.readLine().trim().split("\\s+");
    }

    static int i(String ss) {
        return Integer.parseInt(ss);
    }
    static long l(String ss) {
        return Long.parseLong(ss);
    }
}
class Student {
    long  a;int b;int c;
    public Student(int a,int b) {
        this.a=a;this.c=c;this.b=b;
    }
}
class Pair {
    int  a,b,c;
    public Pair(int  a,int b){
        this.a=a;this.b=b;this.c=c;}
}
class Sortbyroll implements Comparator<Student> {

    public int compare(Student a, Student b){
        if(a.b==b.b) return (int)b.a-(int)a.a;
        return   a.b-b.b;}
}