import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;
 
public class Solution35C {
        
        final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE")!=null;
        BufferedReader in;
        PrintWriter out;
        StringTokenizer tok = new StringTokenizer("");
        
        void init() throws FileNotFoundException{
                if (ONLINE_JUDGE){
            		in = new BufferedReader(new FileReader("input.txt"));
                    out = new PrintWriter("output.txt");
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
                new Solution35C().run();
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
        
        void solve() throws IOException{
        	int n = readInt();
        	int m = readInt();
        	int k = readInt();
        	Point[] focuses = new Point[k];
        	for(int i = 0; i < k; i++){
        		int a = readInt() - 1;
        		int b = readInt() - 1;
        		focuses[i] = new Point(a,b);
        	}
        	int maxI = 0, maxJ = 0;
        	int max = 0;
        	for(int i = 0; i < n; i++)
        		for(int j = 0; j < m; j++){
        			int curMin = 1000000;
        			for(int r = 0; r < k; r++)
        				if(abs(focuses[r].x - i) + abs(focuses[r].y - j) < curMin){
        					curMin = abs(focuses[r].x - i) + abs(focuses[r].y - j);
        					if(curMin < max) break;
        				}
    				if(curMin > max){
    					max = curMin;
    					maxI = i;
    					maxJ = j;
    				}              			
        		}
        	maxI++;
        	maxJ++;
        	out.println(maxI + " " + maxJ);
        }
        
        static double distance(long x1, long y1, long x2, long y2){
        	return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        }
        
        static long gcd(long a, long b){
        	while(a != b){
        		if(a < b) a -=b;
        		else b -= a;
        	}
        	return a;
        }
        
        static long lcm(long a, long b){
        	return a * b /gcd(a, b);
        }
}