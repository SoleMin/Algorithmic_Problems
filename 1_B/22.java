import java.util.*;
import java.math.*;
import java.io.*;

public class b implements Runnable{
	PrintWriter out = null;
	public int toint(String s){
		int res = 0;
		for (int i = 0; i < s.length(); i++){
			res *= 10;
			res += s.charAt(i)-'0';
		}
		return res;
	}

	public void tostr(int k){
		if (k == 0) return;
		tostr((k-1)/26);
		out.print((char)(('A'+((k-1)%26))));
	}

	public int fromstr(String s){
		if (s.length() == 0) return 0;
		int r = s.charAt(s.length()-1)-'A'+1;
		r += 26*(fromstr(s.substring(0,s.length()-1)));
		return r;
	}

        public void run(){
                try{
                        Scanner in = new Scanner(System.in);
                        out = new PrintWriter(System.out);
                        int n = in.nextInt();
						for (int t = 0; t < n; t++){
							int rp = -1;
							int cp = -1;
							String s = in.next();
							for (int i = 0; i < s.length(); i++)
								if (s.charAt(i) == 'R') rp = i;
								else if (s.charAt(i) == 'C') cp = i;
							boolean good = true;
							if (rp == 0 && cp > 1){
								for (int i = 0; i <= cp; i++)
									if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
										good = false;
							}
							if (good){
								int k = 0;
								for (;s.charAt(k) < '0' || s.charAt(k) > '9'; k++);
								int r = toint(s.substring(k,s.length()));
								int c = fromstr(s.substring(0,k));
								out.print('R');
								out.print(r);
								out.print('C');
								out.println(c);
							} else {
								int r = toint(s.substring(1,cp));
								int c = toint(s.substring(cp+1,s.length()));
								tostr(c);
								out.println(r);
							}
						}
                        in.close();
                        out.close();
                } catch(Exception e){
                        e.printStackTrace();
                }
        }

        public static void main(String[] args){
                new Thread(new b()).start();
        }
}


