import java.io.BufferedReader;
import java.io.InputStreamReader;


public class OverlapedString {
	public static void main(String args[]) throws Exception {
		OverlapedString os = new OverlapedString();
		BufferedReader stdin =
			new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = stdin.readLine()) != null) {
			System.out.println(os.handleOverlap(line));
		}
	}
	private int handleOverlap(String str) {
		int len = str.length();
		int count = 0;
		for(int i=0;i<len;i++)
			for(int j=i+1;j<len;j++) {
				String _tmp = str.substring(i,j);
				if(_tmp!=null&&_tmp.length()>0) {
					if(getOverlapCount(str,_tmp)>1)
					{
						if(_tmp.length()>count)
							count = _tmp.length();
					}
				}
			}
		return count;
	}
	private int getOverlapCount(String str,String sub) {
		int start = 0;
		int count = 0;
		while(start<str.length()) {
			start = str.indexOf(sub,start);
			if(start==-1)
				break;
			else {
				start++;
				count++;
			}
		}
		return count;
	}
}
