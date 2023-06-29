import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	  static int Inf = 9999999;

    static int[] F_pos = new int[101];
   static int[][] Dis = new int[501][501];

    static void initialize(int N){
        for(int i=1;i<=N;++i){
            for(int j=1;j<=N;++j)
                Dis[i][j] = Inf;
            Dis[i][i]=0;
        }
    }
    static void floyd(int N){
        for(int k=1;k<=N;++k)
            for(int i=1;i<=N;++i)
                for(int j=1;j<=N;++j)
                    if(Dis[i][k]+Dis[k][j] < Dis[i][j])
                        Dis[i][j] = Dis[i][k] + Dis[k][j];
    }

	
	public static void main(String[] args) throws Exception {
	   int test_case,num_fs,num_is;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        test_case = Integer.parseInt(br.readLine());
        br.readLine();
        while (test_case !=0){
            test_case--;
            String[] input = br.readLine().split(" ");
            num_fs = Integer.parseInt(input[0]);
            num_is = Integer.parseInt(input[1]);

            for(int i=0;i<num_fs;++i){
                String in = br.readLine();
                F_pos[i] = Integer.parseInt(in);
            }

            initialize(num_is);

            String str=br.readLine();
            while(str!=null && str.length() !=0) {
                input = str.split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                int L = Integer.parseInt(input[2]);
                Dis[x][y] = L;
                Dis[y][x] = L;
                str=br.readLine();
            }

            floyd(num_is);

            int[] s_l = new int[501];
            int max_s_l =0;
            for(int i=1;i<=num_is;++i){
                s_l[i] = Inf;
                for(int j=0;j<num_fs;++j)
                    s_l[i] = Math.min(s_l[i],Dis[i][F_pos[j]]);
                max_s_l = Math.max(max_s_l,s_l[i]);
            }

            int Ans =1;
            for(int i=1;i<=num_is;++i){
                int new_length =0;
                for(int j=1;j<=num_is;++j){
                    int shorter = Math.min(Dis[i][j],s_l[j]);
                    new_length = Math.max(new_length,shorter);
                }
                if(new_length<max_s_l){
                    max_s_l = new_length;
                    Ans =i;
                }
            }
            System.out.println(Ans);
					System.out.println();
        }
	}
}