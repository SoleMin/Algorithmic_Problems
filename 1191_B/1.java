/*
If you want to aim high, aim high
Don't let that studying and grades consume you
Just live life young
******************************
If I'm the sun, you're the moon
Because when I go up, you go down
*******************************
I'm working for the day I will surpass you
****************************************

*/ 
  
import java.util.*;
import java.awt.Point;
import java.lang.Math; 
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.Comparator;
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Main {
     
	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		OutputStream outputStream = System.out;
          PrintWriter out = new PrintWriter(outputStream);
        
          int a[][] = new int[26][9];
          for(int i=0;i<3;i++){
               String S = in.n();
               a[S.charAt(1)-'a'][S.charAt(0)-'1']++;
          }
          int max = 0;
          for (int c=0; c<26; c++) {
            for (int d=0; d<9; d++) {
                max = Math.max(max, a[c][d]);
            }
          }
          int minKoutsu = 3-max;
          max = 0;
           for (int c=0; c<26; c++) {
            for (int d=2; d<9; d++) {
                int count = 0;
                for (int i=-2; i<=0; i++) {
                    if (a[c][d+i] > 0) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
        }
        int minShuntsu = 3-max;
        int answer = Math.min(minKoutsu, minShuntsu);
        System.out.println(answer);
        
          
	}
     
     private static int sumOfDigits(int number) {
        if (number <= 0) return 0;
        int sum = 0;
        while (number > 0) {
            sum += number%10;
            number /= 10;
        }
        return sum;
    }
     
     static void ruffle_sort(int[] a) {
		//shandom_ruffle
		Random r=new Random();
		int n=a.length;
		for (int i=0; i<n; i++) {
			int oi=r.nextInt(i);
			int temp=a[i];
			a[i]=a[oi];
			a[oi]=temp;
		}
		
		//sort
		Arrays.sort(a);
	}
  
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int ni() {
			return Integer.parseInt(next());
		}
		void print(int a){
		     System.out.println(a);
		}
		String n(){
		     return next();
		}
		void ps(String a) {
		        System.out.print(a);
		}
		void pls(String a) {
		        System.out.println(a);
		}
		int[] ria(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=ni();
			return a;
		}
		char[] rca(int n, String S){
		     char a[] = S. toCharArray();
		     return a;
		}
		int [][] rda(int n, int m){
		    int a[][] = new int[n][m];
		    for(int i=0;i<n;i++){
		        for(int j=0;j<m;j++){
		            a[i][j]=ni();
		        }
		    }
		    return a;
		}
		void pa(int [] a) {
			for (int i=0; i<a.length; i++)
		        System.out.print(a[i]+" ");
		}
	
		
	     void pla(int [] a) {
			for (int i=0; i<a.length; i++)
		        System.out.println(a[i]);
		}
		
		long nl() {
			return Long.parseLong(next());
		}
	}
 
	
    static int max(){
         return Integer.MAX_VALUE;
    }
    	
 
    public int factorial(int n) {
            int fact = 1;
            int i = 1;
           while(i <= n) {
             fact *= i;
             i++;
           }
            return fact;
    }
    
    

    public static long gcd(long x,long y)
    {
    	if(x%y==0)
    		return y;
    	else
    		return gcd(y,x%y);
    }
    public static int gcd(int x,int y)
    {
    	if(x%y==0)
    		return y;
    	else 
    		return gcd(y,x%y);
    }
    public static int abs(int a,int b)
    {
    	return (int)Math.abs(a-b);
    }
    public static long abs(long a,long b)
    {
    	return (long)Math.abs(a-b);
    }
    public static int max(int a,int b)
    {
    	if(a>b)
    		return a;
    	else
    		return b;
    }
    public static int min(int a,int b)
    {
    	if(a>b)
    		return b;
    	else 
    		return a;
    }
    public static long max(long a,long b)
    {
    	if(a>b)
    		return a;
    	else
    		return b;
    }
    public static long min(long a,long b)
    {
    	if(a>b)
    		return b;
    	else 
    		return a;
    }
     
     
    public static long pow(long n,long p,long m)
    {
    	 long  result = 1;
    	  if(p==0)
    	    return 1;
    	if (p==1)
    	    return n;
    	while(p!=0)
    	{
    	    if(p%2==1)
    	        result *= n;
    	    if(result>=m)
    	    result%=m;
    	    p >>=1;
    	    n*=n;
    	    if(n>=m)
    	    n%=m;
    	}
    	return result;
    }
    public static long pow(long n,long p)
    {
    	long  result = 1;
    	  if(p==0)
    	    return 1;
    	if (p==1)
    	    return n;
    	while(p!=0)
    	{
    	    if(p%2==1)
    	        result *= n;	    
    	    p >>=1;
    	    n*=n;	    
    	}
    	return result;
     
    }
     
    static long sort(int a[]){  
         int n=a.length;
    	int b[]=new int[n];	
    	return mergeSort(a,b,0,n-1);
         
    }
     
    static long mergeSort(int a[],int b[],long left,long right){
         long c=0;
         if(left<right){   
          long mid=left+(right-left)/2;
    	 c= mergeSort(a,b,left,mid);
    	 c+=mergeSort(a,b,mid+1,right);
    	 c+=merge(a,b,left,mid+1,right); 
         }	
    	return c;	 
    }
    static long merge(int a[],int  b[],long left,long mid,long right){
         long c=0;int i=(int)left;int j=(int)mid; int k=(int)left;
         while(i<=(int)mid-1&&j<=(int)right){ 
              if(a[i]<=a[j]){
                   b[k++]=a[i++]; 
              }
              else{ 
                   b[k++]=a[j++];c+=mid-i;
              }
         }
         
         while (i <= (int)mid - 1)   
                 b[k++] = a[i++]; 
         while (j <= (int)right)
                 b[k++] = a[j++];
         for (i=(int)left; i <= (int)right; i++) 
    	        a[i] = b[i];
    	        return c; 
         }
         
      static class InputReader extends BufferedReader {
        public InputReader(InputStream st) {
            super(new InputStreamReader(st));
        }
 
        public String readLine() {
            try {
                return super.readLine();
            } catch (IOException e) {
                return null;
            }
        }
 
        private int readByte() {
            try {
                return read();
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
 
        public int ni() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
 
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
 
      
 
    } 
     
  } 