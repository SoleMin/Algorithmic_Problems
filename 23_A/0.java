import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.BigInteger;


public class Main {
	public static int a[] = new int[200005];
	public static int b[] = new int[200005];
	public static int c[] = new int[200005];
	BigInteger x;
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t,ca,i;
		String line = br.readLine();
		String[] my = myutils.allsub(line);
	   // System.out.println(Arrays.toString(my));
	    int ans = 0;
	    HashMap<String,Integer> data = new HashMap<String,Integer>();
	    for(i=0;i<my.length;i++)
	    {
	        if(data.get(my[i])==null)data.put(my[i],1);
	        else {
	            int fr = data.get(my[i]);
	            data.put(my[i],fr+1);
	        }
	    }
	    Iterator<Map.Entry<String,Integer>> iterator = data.entrySet().iterator();
	    while(iterator.hasNext())
	    {
	        int fr,len;
	        Map.Entry<String,Integer> cur =  iterator.next();
	        if(cur.getValue()>1){
	            String kk = cur.getKey();
	            if(kk.length()>ans)ans = kk.length();
	        }
	        
	    }
	    System.out.println(ans);
	}

}
class myutils{
    public static String[] allsub(String a)
    {
        int n = a.length();
        String ans[] = new String[(n*(n+1))/2];
        int i,j,in = 0;
        for(i=0;i<n;i++)
        for(j=i;j<n;j++)
        ans[in++] = a.substring(i,j+1);
        return ans;
    }
}