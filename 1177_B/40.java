import java.util.*;
import java.io.*;
 
public class Main {
	public static void main(String args[]) {new Main().run();}
	
	Scanner in = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	void run(){
	    work();
	    out.flush();
	}
	void work() {
	    long r=in.nextLong();
	    long b=0;
	    for(;;b++){
	        long num=9*(long)Math.pow(10,(double)b)*(b+1);
	        if(r-num<=0){
	            break;
	        }
	        r-=num;
	    }
	    long base=(long)Math.pow(10,(double)b);
	    long c=(r-1)/(b+1);
	    int m=(int)((r-1)%(b+1));
	    base+=c;
	    
	    String str=base+"";
	    out.println(str.charAt(m));
	}
}