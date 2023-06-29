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

        // while(ExistsAliveTree()){
        //     spread();
        // }

        spread();

        // System.out.println(LitTrees.getLast()[0] + " " + LitTrees.getLast()[1]);
        out.println(lastTree[0] + " " + lastTree[1]);
        out.close();

    }

    public static void spread(){
        while(!LitTrees.isEmpty()){
            int[] studying = LitTrees.removeFirst(); //is iterator faster
            int[] studying1 = {studying[0]-1, studying[1]};
            int[] studying2 = {studying[0], studying[1]-1};
            int[] studying3 = {studying[0], studying[1]+1};
            int[] studying4 = {studying[0]+1, studying[1]};
            if (studying1[0] >= 1 && !burning[studying1[0]][studying1[1]]){
                LitTrees.add(studying1);
                burning[studying1[0]][studying1[1]] = true;
            }
            if (studying2[1] >= 1 && !burning[studying2[0]][studying2[1]]){
                LitTrees.add(studying2);
                burning[studying2[0]][studying2[1]] = true;
            }
            if (studying3[1] < M+1 && !burning[studying3[0]][studying3[1]]){
                LitTrees.add(studying3);
                burning[studying3[0]][studying3[1]] = true;
            }
            if (studying4[0] < N+1 && !burning[studying4[0]][studying4[1]]){
                LitTrees.add(studying4);
                burning[studying4[0]][studying4[1]] = true;
            }
            lastTree = studying; 
        }        
    }
    

    public static boolean ExistsAliveTree() {
        if (LitTrees.size() == N*M){
            return false;
        } else{
            return true;
        }
    }
}