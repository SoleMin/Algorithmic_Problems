import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class IQTest {
	public static void main(String args[]) throws Exception {
		BufferedReader stdin =
			new BufferedReader(new InputStreamReader(System.in));
		String line;
			line = stdin.readLine();
			int n = Integer.parseInt(line);
			line = stdin.readLine();
			List even = new ArrayList();
			List odd = new ArrayList();
			String[] kk = line.split(" ");
			for(int i=0;i<n;i++) {
				if(Integer.parseInt(kk[i])%2==0)
					even.add(i);
				else
					odd.add(i);
			}
			if(even.size()==1)
				System.out.println((Integer)even.get(0)+1);
			else
				System.out.println((Integer)odd.get(0)+1);
	}
}
