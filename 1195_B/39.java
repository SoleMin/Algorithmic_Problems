//package learning;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class NitsLocal {
    static ArrayList<String> s1;
    static boolean[] prime;
    static int n = (int)1e7;
     static void sieve() {
Arrays.fill(prime	, true);
prime[0] = prime[1] = false;
for(int i = 2 ; i * i <= n ; ++i) {
if(prime[i]) {
for(int k = i * i; k<= n ; k+=i) {
prime[k] = false;
}
}
}

}
    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);
        
           prime  = new boolean[n + 1];
sieve();
                prime[1] = false;
         
          
             long n = sc.nl();
             long k = sc.nl();
             long b = 2*n + 3;
             long c = n*n - 2*k + n;
             long q1 = (b + (long)Math.sqrt(b*b - 4*c))/2;
             long q2 = (b - (long)Math.sqrt(b*b - 4*c))/2;
             if(q1 >= q2 && q1 <= n)
                 w.println(q1);
             else
                 w.println(q2);
                 
                
       
             
       w.close();
        
    }
    static int nextPowerOf2(int n) 
    { 
        int count = 0; 
  
        // First n in the below  
        // condition is for the  
        // case where n is 0 
        if (n > 0 && (n & (n - 1)) == 0) 
            return n; 
  
        while(n != 0) 
        { 
            n >>= 1; 
            count += 1; 
        } 
  
        return 1 << count; 
    } 
    
   static long sum1(int t1,int t2,int x,int []t)
   {
       int mid = (t2-t1+1)/2;
  if(t1==t2)
      return 0;
    
   else
   return sum1(t1,mid-1,x,t) + sum1(mid,t2,x,t);
    
     
   }
  
   
    static String replace(String s,int a,int n)
    {
        char []c = s.toCharArray();
        for(int i=1;i<n;i+=2)
        {
            int num = (int) (c[i] - 48);
            num += a;
            num%=10;
            c[i] = (char) (num+48);
        }
        return new String(c);
    }
    static String move(String s,int h,int n)
    {
        h%=n;
        char []c = s.toCharArray();
        char []temp = new char[n];
        for(int i=0;i<n;i++)
        {
            temp[(i+h)%n] = c[i];
        }
        return new String(temp);
    }
    
     public static int ip(String s){
return Integer.parseInt(s);
}
     static class multipliers implements Comparator<Long>{
  
         
  public int compare(Long a,Long b) {
   if(a<b)
    return 1;
   else if(b<a)
    return -1;
   else
    return 0;
  }
 }
     static class multipliers1 implements Comparator<Student>{
  
  public int compare(Student a,Student b) {
   if(a.y<b.y)
    return 1;
   else if(b.y<a.y)
    return -1;
   else
   {
       if(a.id < b.id)
           return 1;
       else if(b.id<a.id)
           return -1;
       else
           return 0;
           
    //return 0;
   }
  }
 }
    // Java program to generate power set in 
// lexicographic order. 

    
    
    
      static class InputReader {
 
private final InputStream stream;
private final byte[] buf = new byte[8192];
private int curChar, snumChars;
 
public InputReader(InputStream st) {
this.stream = st;
}
 
public int read() {
if (snumChars == -1)
throw new InputMismatchException();
if (curChar >= snumChars) {
curChar = 0;
try {
snumChars = stream.read(buf);
} catch (IOException e) {
throw new InputMismatchException();
}
if (snumChars <= 0)
return -1;
}
return buf[curChar++];
}
 
public int ni() {
int c = read();
while (isSpaceChar(c)) {
c = read();
}
int sgn = 1;
if (c == '-') {
sgn = -1;
c = read();
}
int res = 0;
do {
res *= 10;
res += c - '0';
c = read();
} while (!isSpaceChar(c));
return res * sgn;
}
 
public long nl() {
int c = read();
while (isSpaceChar(c)) {
c = read();
}
int sgn = 1;
if (c == '-') {
sgn = -1;
c = read();
}
long res = 0;
do {
res *= 10;
res += c - '0';
c = read();
} while (!isSpaceChar(c));
return res * sgn;
}
 
public int[] nia(int n) {
int a[] = new int[n];
for (int i = 0; i < n; i++) {
a[i] = ni();
}
return a;
}
 
public String rs() {
int c = read();
while (isSpaceChar(c)) {
c = read();
}
StringBuilder res = new StringBuilder();
do {
res.appendCodePoint(c);
c = read();
} while (!isSpaceChar(c));
return res.toString();
}
 
public String nextLine() {
int c = read();
while (isSpaceChar(c))
c = read();
StringBuilder res = new StringBuilder();
do {
res.appendCodePoint(c);
c = read();
} while (!isEndOfLine(c));
return res.toString();
}
 
public boolean isSpaceChar(int c) {
return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
}
 
private boolean isEndOfLine(int c) {
return c == '\n' || c == '\r' || c == -1;
}
 
}





   
static PrintWriter w = new PrintWriter(System.out);
                  static class Student
    {
        int id;
        //int x;
       
        int y;
        //long z;
        
        Student(int id,int y)
        {
            this.id = id;
            //this.x = x;
            //this.s = s;
            this.y = y;
           // this.z = z;
            
            
            
        }
        
    }
}
