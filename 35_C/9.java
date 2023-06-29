import java.io.*;
import java.util.*;

public class C35C_BFS_Fire {
    public static boolean[][] burning;
    public static LinkedList<int[]> LitTrees; //which is best to use
    public static int N, M;
    public static int[] lastTree;
    public static void main(String[] args) throws IOException {
        // InputStreamReader stream = new InputStreamReader(System.in);
        // BufferedReader input = new BufferedReader(stream);

        BufferedReader input = new BufferedReader(new FileReader("input.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));

        StringTokenizer dataR = new StringTokenizer(input.readLine());
        N = Integer.parseInt(dataR.nextToken());
        M = Integer.parseInt(dataR.nextToken());
        burning = new boolean[N+1][M+1];

        StringTokenizer dataR1 = new StringTokenizer(input.readLine());
        int K = Integer.parseInt(dataR1.nextToken());

        StringTokenizer dataR2 = new StringTokenizer(input.readLine());
        LitTrees = new LinkedList<int[]>();
        for (int j = 0; j < K; j++){
            int x = Integer.parseInt(dataR2.nextToken());
            int y = Integer.parseInt(dataR2.nextToken());
            int[] coord = {x, y};
            LitTrees.add(coord);
            burning[x][y] = true;
        }

        spread();

        out.println(lastTree[0] + " " + lastTree[1]);
        out.close();

    }

    public static void spread(){
        while(!LitTrees.isEmpty()){
            int[] studying = LitTrees.remove(); //is iterator faster
            LinkedList<int[]> ll = new LinkedList<int[]>();

            if(studying[0]-1 >= 1) ll.add(new int[]{studying[0]-1, studying[1]});
            if(studying[1]-1 >= 1) ll.add(new int[]{studying[0], studying[1]-1});
            if(studying[1]+1 < M+1) ll.add(new int[]{studying[0], studying[1]+1});
            if(studying[0]+1 < N+1) ll.add(new int[]{studying[0]+1, studying[1]});

            while(!ll.isEmpty()) {
                int[] focus = ll.remove();
                if(!burning[focus[0]][focus[1]]) {
                    LitTrees.add(focus);
                    burning[focus[0]][focus[1]] = true;
                }
            }

            lastTree = studying; 
        }        
    }
    
}