import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = new String(in.readLine());
        String[] t=s.split(" ");
        int n = Integer.parseInt(t[0]);
        int k = Integer.parseInt(t[1]);
        boolean[] prime=new boolean[n+1];
        for (int i=2;i<Math.sqrt(n);i++) {
        	for (int j=i+i;j<=n;j=j+i) {
        		prime[j]=true;
        	}
        }
        int size=0;
        for (int i=2;i<=n;i++) {
        	if (!prime[i]) {
        		size++;
        	}
        }
        int[] pn=new int[size];
        int index=0;
        for (int i=2;i<=n;i++) {
        	if (!prime[i]) {
        		pn[index]=i;
        		index++;
        	}        	
        }
        for (int i=2;i<size;i++) {
        	for (int j=0;j<i;j++) {
        		if (pn[i]==pn[j]+pn[j+1]+1) {
//       			System.out.println(pn[i]+"="+pn[j]+"+"+pn[j+1]+"+1");
        			k--;
        		}
        	}
        }
        if (k<=0) {
        	System.out.println("YES");
        } else {
        	System.out.println("NO");
        }
	}

}
