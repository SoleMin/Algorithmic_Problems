
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    //<editor-fold desc="input parse" defaultstate="collapsed">

    private static StringTokenizer st;
    private static java.io.BufferedReader reader;
    private static java.io.BufferedWriter writer;

    private static long nextLong() {
        return Long.parseLong(st.nextToken());
    }

    private static int nextInt() {
        return Integer.parseInt(st.nextToken());
    }

    private static double nextDouble() {
        return Double.parseDouble(st.nextToken());
    }

    private static short nextShort() {
        return Short.parseShort(st.nextToken());
    }

    private static byte nextByte() {
        return Byte.parseByte(st.nextToken());
    }

    private static void initTokenizer() throws Exception {
        st = new StringTokenizer(reader.readLine());
    }

    //</editor-fold>
    

    public static void main(String[] args) throws Exception {
	reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in), 1 << 20);
	writer = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
	//reader = new java.io.BufferedReader(new java.io.FileReader("input.txt"), 1 << 20);
	//writer = new java.io.BufferedWriter(new java.io.FileWriter("output.txt"));
	
	initTokenizer();
	int n = nextInt();
	int m = nextInt();
	int k = nextInt();
	
	initTokenizer();
	int[] a = new int[n];
	
	for (int i = 0; i < n; i++) {
	    a[i] = nextInt();
	}
	
	Arrays.sort(a);
	
	int total = k;
	int cnt = 0;
	
	while (total < m && cnt < a.length) {
	    total += a[a.length - 1 - cnt] - 1;
	    cnt++;
	}
	
	if (total >= m) System.out.println(cnt);
	else System.out.println(-1);
    }
}