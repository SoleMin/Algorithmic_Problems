import java.util.*;
import java.io.*;
  
public class A1 {   
 
	public static BufferedReader br;
    public static StringTokenizer st;
    public static String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }
 
    public static Integer nextInt() {
        return Integer.parseInt(next());
    }
 
    public static Long nextLong() {
        return Long.parseLong(next());
    }
 
    public static Double nextDouble() {
        return Double.parseDouble(next());
    }
 
    static long fast_pow(long base,long n,long M)
    {
        if(n==0)
           return 1;
        if(n==1)
        return base;
        long halfn=fast_pow(base,n/2,M);
        if(n%2==0)
            return ( halfn * halfn ) % M;
        else
            return ( ( ( halfn * halfn ) % M ) * base ) % M;
    }
 
    static long finextDoubleMMI_fermat(long n,int M)
    {
        return fast_pow(n,M-2,M);
    }
 
    static long nCrModPFermat(int n, int r, int p) 
    { 
        if (r == 0) 
            return 1; 
        long[] fac = new long[n+1]; 
        fac[0] = 1;           
        for (int i = 1 ;i <= n; i++) 
            fac[i] = fac[i-1] * i % p;       
        return (fac[n]* finextDoubleMMI_fermat(fac[r], p)% p * finextDoubleMMI_fermat(fac[n-r], p) % p) % p; 
    } 
 
    static void merge(int arr[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
        int i = 0, j = 0; 
        
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    static void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
            merge(arr, l, m, r); 
        } 
    } 
 
    static void sort(int arr[]) 
    { 
        int l=0;
        int r=arr.length-1;
        if (l < r) 
        { 
            int m = (l+r)/2; 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
            merge(arr, l, m, r); 
        } 
    } 

    static long gcd(long a, long b){
        if(a%b==0)
            return b;
        if(b%a==0)
            return a;
        if(a>b)
            return gcd(a%b,b);
        return gcd(a,b%a);
    }
 
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
 
    public static void main(String args[])throws IOException{
    	int i,j;
        br = new BufferedReader(new InputStreamReader(System.in));
        int n=nextInt();
        int a[]=new int[n];
        for(i=0;i<n;i++)
            a[i]=nextInt();
        Arrays.sort(a);
        int l=0;
        for(i=0;i<n;i++){
            if(a[i]!=-1){
                int p=a[i];
                for(j=i;j<n;j++){
                    if(a[j]%p==0)
                        a[j]=-1;
                }
                l++;
            }
        }
        pw.println(l);
        pw.close();
    }
}	




