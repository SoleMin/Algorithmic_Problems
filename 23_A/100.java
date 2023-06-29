import java.io.*;
import java.util.*;
public class Answer23A{
    public static void main(String[] args){
	BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	new Kai(reader).solve();
    }
}
class Kai{
    BufferedReader reader;
    public Kai(BufferedReader reader){
	this.reader=reader;
    }
    public void solve(){
	//TODO
	String s=read();
	int max=0;
	for(int i=1;i<=s.length()-1;i++){
	    for(int j=0;j<=s.length()-i;j++){
		String h=s.substring(j,j+i);
		for(int k=j+1;k<=s.length()-i;k++){
		    if(h.equals(s.substring(k,k+i))){
			max=i;
		    }
		}
	    }
	}
	pln(max);
			
    }
    //tools//////////////////////////////////////////////////
    public String read(){
	String s=null;
	try{
	    s=reader.readLine();
	}catch(IOException e){
	    e.printStackTrace();
	}
	return s;
    }
    public int[] to_i(String[] s){
	int[] tmp=new int[s.length];
	for(int i=0;i<s.length;i++){
	    tmp[i]=to_i(s[i]);
	}
	return tmp;
    }
    public long[] to_l(String[] s){
	long[] tmp=new long[s.length];
	for(int i=0;i<s.length;i++){
	    tmp[i]=to_l(s[i]);
	}
	return tmp;
    }
    public int to_i(String s){
	return Integer.parseInt(s);
    }
    public long to_l(String s){
	return Long.parseLong(s);
    }
    public void p(Object s){
	System.out.print(s);
    }
    public void pln(Object s){
	System.out.println(s);
    }
    public void debug(Object s){
	System.err.print(s);
    }
    public void debugln(Object s){
	System.err.println(s);
    }
}