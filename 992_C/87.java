import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
public class Main{   
    public long power(long x, long y, long p)
    {

        long res = 1;     
  
     
        while (y > 0)
        {
            if((y & 1)==1)
                res = (res * x) % p;
            y = y >> 1; 
            x = (x * x) % p; 
        }
        return res;
    }
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);  
        Main mm=new Main(); 
        long x=sc.nextLong();
            long k=sc.nextLong();
            if(x==0) {
                System.out.println(0);
            }
            else {
            long temp=mm.power(2, k, 1000000007);
            long temp1=(2*x-1)%(1000000007);
            long temp3=(temp1*temp)%(1000000007);
            System.out.println((temp3+1)%1000000007);
            }
    }
 }
    
class trienode{
    trienode[] next=new trienode[26];
    int count;
    char value;
    boolean last;
    trienode() {
        this.value='0';
        this.count=0;
    }
    trienode(char x) {
        this.value=x;
        this.count=1;
    }
 
}
class trie{
    trienode root=new trienode();
    public void insert(String s) {
        trienode temp=root;
        int length=s.length();
        for(int i=0;i<length;i++) {
            char c=s.charAt(i);
            int index=c-'a';
            if(temp.next[index]==null) {
                temp.next[index]=new trienode(c);
            }
            else {
                temp.next[index].count++;
            }
            if(i==length-1) {
                temp.next[index].last=true;
            }
            temp=temp.next[index];
 
        }
 
    }
    public String find(String s) {
        trienode temp=root;
        String ans="";
        int pos=0;
        char c=s.charAt(pos);
        int index=c-'a';
        while(temp.next[index]!=null) {
            temp=temp.next[index];
            ans+=temp.value;
            if(pos==s.length()-1) {
                break;
            }
            c=s.charAt(++pos);
            index=c-'a';
            
        }
        while(temp.last!=true) {
            int position=-1;
            for(int i=0;i<26;i++) {
            if(temp.next[i]!=null) {
                ans+=temp.next[i].value;
                position=i+0;
                break;
            }
                
        }
            temp=temp.next[position];
        }
        return ans;
    }
}
class node{
    int index;
    int a;
    int b;
    node(int index,int a,int b){
        this.a=a;
        this.b=b;this.index=index;
        
    }
}
class comp implements Comparator<node>{
    public int compare(node n1,node n2) {
        if(n1.b>n2.b) {
            return 1;
        }
        else if(n1.b<n2.b) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
class cc implements Comparator<node>{
    public int compare(node n1,node n2) {
        if(n1.index>n2.index) {
            return 1;
        }
        else if(n1.index<n2.index) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

 
 
 
/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
 
    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
 
    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
 
    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}