import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
 
public class C {
        
        final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE")!=null;
        BufferedReader in;
        PrintWriter out;
        StringTokenizer tok = new StringTokenizer("");
        
        void init() throws FileNotFoundException{
                if (ONLINE_JUDGE){
                        in = new BufferedReader(new InputStreamReader(System.in));
                        out = new PrintWriter(System.out);
                }else{
                        in = new BufferedReader(new FileReader("input.txt"));
                        out = new PrintWriter("output.txt");
                }
        }
        
        String readString() throws IOException{
                while(!tok.hasMoreTokens()){
                        tok = new StringTokenizer(in.readLine());
                }
                return tok.nextToken();
        }
        
        int readInt() throws IOException{
                return Integer.parseInt(readString());
        }
        
        long readLong() throws IOException{
                return Long.parseLong(readString());
        }
        
        double readDouble() throws IOException{
                return Double.parseDouble(readString());
        }
        
        public static void main(String[] args){
                new C().run();
        }
        
        public void run(){
                try{
                        long t1 = System.currentTimeMillis();
                        init();
                        solve();
                        out.close();
                        long t2 = System.currentTimeMillis();
                        System.err.println("Time = "+(t2-t1));
                }catch (Exception e){
                        e.printStackTrace(System.err);
                        System.exit(-1);
                }
        }
        
       
        void solve() throws IOException{
        	int n = readInt();
        	int[] a = new int[n];
        	for(int i = 0; i < n; i++){
        		a[i] = readInt();
        	}
        	boolean c = true;
        	for(int i = 0; i < n; i++){
        		if(a[i] != 1){
        			c = false;
        			break;
        		}
        	}
        	if(c){
        		for(int i = 0; i < n-1; i++){
        			out.print(a[i] + " ");
        		}
        		out.println(2);
        		return;
        	}
        	Utils.mergeSort(a);
        	out.print(1 + " ");
        	for(int i = 1; i < n; i++){
        		out.print(a[i-1] + " ");
        	}
        }
        
        int[] zFunction(char[] s){
        	int[] z = new int[s.length];
        	z[0] = 0;
        	for (int i=1, l=0, r=0; i<s.length; ++i) {
        		if (i <= r)
        			z[i] = min (r-i+1, z[i-l]);
        		while (i+z[i] < s.length && s[z[i]] == s[i+z[i]])
        			++z[i];
        		if (i+z[i]-1 > r){
        			l = i; 
        			r = i+z[i]-1;
        		}
        	}	
        	return z;
        }
        
        int[] prefixFunction(char[] s){
        	int[] pr = new int[s.length];
        	for (int i = 1; i< s.length; ++i) {
        		int j = pr[i-1];
        		while (j > 0 && s[i] != s[j])
        			j = pr[j-1];
        		if (s[i] == s[j])  ++j;
        		pr[i] = j;
        	}
        	return pr;
        }
        
        int ModExp(int a, int n, int mod){
        	int res = 1;
        	while (n!=0)
        		if ((n & 1) != 0) {
        			res = (res*a)%mod;
        			--n;
        		}
        		else {
        			a = (a*a)%mod;
        			n >>= 1;
        		}
        	return res;
        }
        
        
        static class Utils {
 
                private Utils() {}
 
                public static void mergeSort(int[] a) {
                        mergeSort(a, 0, a.length - 1);
                }
 
                private static void mergeSort(int[] a, int leftIndex, int rightIndex) {
                        final int MAGIC_VALUE = 50;
                        if (leftIndex < rightIndex) {
                                if (rightIndex - leftIndex <= MAGIC_VALUE) {
                                        insertionSort(a, leftIndex, rightIndex);
                                } else {
                                        int middleIndex = (leftIndex + rightIndex) / 2;
                                        mergeSort(a, leftIndex, middleIndex);
                                        mergeSort(a, middleIndex + 1, rightIndex);
                                        merge(a, leftIndex, middleIndex, rightIndex);
                                }
                        }
                }
 
                private static void merge(int[] a, int leftIndex, int middleIndex, int rightIndex) {
                        int length1 = middleIndex - leftIndex + 1;
                        int length2 = rightIndex - middleIndex;
                        int[] leftArray = new int[length1];
                        int[] rightArray = new int[length2];
                        System.arraycopy(a, leftIndex, leftArray, 0, length1);
                        System.arraycopy(a, middleIndex + 1, rightArray, 0, length2);
                        for (int k = leftIndex, i = 0, j = 0; k <= rightIndex; k++) {
                                if (i == length1) {
                                        a[k] = rightArray[j++];
                                } else if (j == length2) {
                                        a[k] = leftArray[i++];
                                } else {
                                        a[k] = leftArray[i] <= rightArray[j] ? leftArray[i++] : rightArray[j++];
                                }
                        }
                }
 
                private static void insertionSort(int[] a, int leftIndex, int rightIndex) {
                        for (int i = leftIndex + 1; i <= rightIndex; i++) {
                                int current = a[i];
                                int j = i - 1;
                                while (j >= leftIndex && a[j] > current) {
                                        a[j + 1] = a[j];
                                        j--;
                                }
                                a[j + 1] = current;
                        }
                } 
        }
        
       
        
        boolean isPrime(int a){
        	for(int i = 2; i <= sqrt(a); i++)
        		if(a % i == 0) return false;
        	return true;
        }
        
        static double distance(long x1, long y1, long x2, long y2){
        	return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        }
        
        static long gcd(long a, long b){
        	if(min(a,b) == 0) return max(a,b);
        	return gcd(max(a, b) % min(a,b), min(a,b));
        }
        
        static long lcm(long a, long b){
        	return a * b /gcd(a, b);
        }
}