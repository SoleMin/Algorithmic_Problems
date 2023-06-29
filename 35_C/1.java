import java.io.*;
import java.util.*;

public class P_35C {
    static final FS sc = new FS();
    static final PrintWriter pw = new PrintWriter(System.out);
    static int[][] g;
    static int[][] res;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    static int n, m;
    static Queue<Integer> qx;
    static Queue<Integer> qy;
    static Queue<Integer> c;
    static void bfs(){
        while(!qx.isEmpty() && !qy.isEmpty()){
            int xn = qx.poll();
            int yn = qy.poll();
            for(int i=0; i<4; i++){
                int nx = xn+dx[i];
                int ny = yn+dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<m && res[nx][ny]==-1){
                    res[nx][ny] = res[xn][yn]+1;
                    qx.add(nx);
                    qy.add(ny);
//                    c.add(pn);
                    visited[nx][ny] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> xl = new ArrayList<>();
        ArrayList<Integer> yl = new ArrayList<>();
        g = new int[n][m];
        res = new int[n][m];
        visited = new boolean[n][m];
        qx = new LinkedList<>();
        qy = new LinkedList<>();
        for(int i=0; i<k; i++){
            int xi = sc.nextInt()-1;
            int yi = sc.nextInt()-1;
//            --xi; --yi;
            qx.add(xi); qy.add(yi);
//            xl.add(xi); yl.add(yi);
            res[xi][yi] = 1;
//            g[--xi][--yi] = 1;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(res[i][j]==1) res[i][j] = 0;
                else res[i][j] = -1;
            }
        }
        bfs();
        int x = 0,y = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(res[i][j]>max){
                    max = res[i][j];
                    x = i; y = j;
                }
            }
        }


//        for(int i=0; i<n; i++) System.out.println(Arrays.toString(res[i]));
        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write((x+1)+" "+(y+1));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println((x+1)+" "+(y+1));
    }

    static class FS {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception ignored) {
                }
            }
            return st.nextToken();
        }

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
