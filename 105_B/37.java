import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class ProblemB {
	public static int _gnum;
	public static int _cnum;
	public static int _needs;
	public static int _level;
	
	public static double _maxans = 0;
	
	public static double votedfs(int[][] grl, int g, int votes) {
		if (votes >= _needs) {
			return 1.0d;
		}
		if (g >= _gnum) {
			return 0.0d;
		}
		double agrees = (double)grl[g][1] / 100;
		return agrees * votedfs(grl, g+1, votes+1) + (1.0d - agrees) * votedfs(grl, g+1, votes);
	}
	
	public static double battledfs(int[][] grl, int g, int votes, int levels) {
		if (votes >= _needs) {
			return 0.0d;
		}
		if (g >= _gnum) {
			return (double)_level / (_level + levels);
		}
		double agrees = (double)grl[g][1] / 100;
		return agrees * battledfs(grl, g+1, votes+1, levels) + (1.0d - agrees) * battledfs(grl, g+1, votes, levels + grl[g][0]);
	}
	
	public static void candydfs(int[][] grl, int g, int n) {
		if (g >= _gnum) {
			double na = votedfs(grl, 0, 0) + battledfs(grl, 0, 0, 0);
			_maxans = Math.max(_maxans, na);
			return;
		}
		
		int rem = grl[g][1];
		candydfs(grl, g+1, n);
		for (int i = 1 ; i <= n ; i++) {
			if (grl[g][1] < 100) {
				grl[g][1] += 10;
				candydfs(grl, g+1, n-i);
			}
		}
		grl[g][1] = rem;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] d = line.split(" ");
        int gnum = Integer.valueOf(d[0]);
        int cnum = Integer.valueOf(d[1]);
        int level = Integer.valueOf(d[2]);
        _gnum = gnum;
        _cnum = cnum;
        _needs = (gnum + 1) / 2;
        if (gnum % 2 == 0) {
        	_needs += 1;
        }
        _level = level;
        
        int[][] grl = new int[gnum][2];
        for (int g = 0 ; g < gnum ; g++) {
        	line = br.readLine();
        	String[] gg = line.split(" ");
        	grl[g][0] = Integer.valueOf(gg[0]);
        	grl[g][1] = Integer.valueOf(gg[1]);
        }
        
        for (int a = 0 ; a < gnum ; a++) {
            for (int b = 0 ; b < gnum - 1 ; b++) {
            	if (grl[b][1] < grl[b+1][1]) {
            		int tmp = grl[b][0];
            		grl[b][0] = grl[b+1][0];
            		grl[b+1][0] = tmp;
            		tmp = grl[b][1];
            		grl[b][1] = grl[b+1][1];
            		grl[b+1][1] = tmp;
            	}
            } 	
        }
        
        int ag = 0;
        int xnum = cnum;
        for (int g = 0 ; g < gnum ; g++) {
        	int needs = (100 - grl[g][1]) / 10;
        	int roy = 0;
        	if (needs <= xnum) {
        		xnum -= needs;
        		roy = 100;
        	} else {
        		roy = grl[g][1] + xnum * 10;
        		xnum = 0;
        	}
        	if (roy >= 100) {
        		ag++;
        	}
        }
        if (ag >= _needs) {
        	System.out.println(1.0);
        	return;
        }
        
        candydfs(grl, 0, _cnum);
        
        System.out.println(_maxans);
        br.close();
	}
}
