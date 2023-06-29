import java.io.*;
import java.util.*;
public class Answer17A{
    public static void main(String[] args){
	try{
	    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	    String[] tmp=reader.readLine().split(" ");
	    int n=Integer.parseInt(tmp[0]);
	    int k=Integer.parseInt(tmp[1]);
	    boolean[] m=getPrime(n);
	    ArrayList<Integer> prime=new ArrayList<Integer>();
	    for(int i=0;i<m.length;i++){
		if(m[i])prime.add(i);
	    }
	    int sum=0;
	    for(int i=2;i<=n;i++){
		if(m[i]){
		    for(int j=0;j<prime.size()-1;j++){
			if(i==prime.get(j)+prime.get(j+1)+1){
			    sum++;
			    break;
			}
		    }
		}
	    }
	    if(sum>=k){
		System.out.println("YES");
	    }else{
		System.out.println("NO");
	    }
	}catch(IOException e){
	    e.printStackTrace();
	}
    }
    public static boolean[] getPrime(int N){
	boolean[] memo=new boolean[N+1];
	Arrays.fill(memo,true);
	memo[0]=false;
	memo[1]=false;
	for(int i=2;i*i<=N;i++){
	    if(memo[i]){
		for(int j=i*i;j<=N;j+=i){
		    memo[j]=false;
		}
	    }
	}
	return memo;
    }

}
