
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
	static int MAXN = 100;
    static int n;
    static int[] check = new int[MAXN];
    static double[][] dot = new double[MAXN][2];
    static double[] minival = new double[MAXN];
    static double result;
    static BufferedReader br;

    static void input() throws IOException {
        String input = br.readLine();
        n = Integer.parseInt(input);

        for(int i =0;i<n;i++){
            input= br.readLine();
            String[] inputs = input.split(" ");
            dot[i][0] = Double.parseDouble(inputs[0]);
            dot[i][1] = Double.parseDouble(inputs[1]);
        }
    }
    static double dist(int a,int b){
        return Math.sqrt(Math.pow(dot[a][0]-dot[b][0],2) +Math.pow(dot[a][1]-dot[b][1],2));
    }
    static void solve(){
        boolean[] intree = new boolean[MAXN];

        for(int i =0;i<n;i++){
            intree[i] =false;
        }

        result=0;
        for(int i =0;i<n;i++){
            check[i] = 0;
        }
        check[0] =1;
        for(int i=1;i<n;i++){
            minival[i] = dist(0,i);
        }

        intree[0] =true;

        for(int i=0;i<n-1;i++){
            int idxNext = -1;
            for(int j=0;j<n;j++){
                if(intree[j]) continue;
                if(idxNext ==-1 || minival[idxNext]>minival[j])
                    idxNext = j;
            }

            result += minival[idxNext];
            intree[idxNext] = true;

            for(int j=0;j<n;j++){
                if(intree[j]) continue;
                double dist = dist(idxNext,j);
                if(minival[j]>dist)
                    minival[j] = dist;
            }
        }

    }
	
	public static void main(String[] args) throws Exception {
	 br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int t = Integer.parseInt(input);
        br.readLine();
        for(int i =0;i<t;i++){
            input();
					br.readLine();
            solve();
            if(i>0)
                System.out.println();
            System.out.printf("%.2f\n",result);
        }

	}
}