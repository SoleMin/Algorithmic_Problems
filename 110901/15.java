import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int v, e, edge[][];
    static boolean result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            v = Integer.parseInt(br.readLine());
            if(v==0) break;
            e = Integer.parseInt(br.readLine());
            result = true;
            edge = new int[v][v];
            for (int i = 0; i < v; i++) {
                Arrays.fill(edge[i], -1);
            }



            for (int i = 0; i < e; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                edge[start][end] = 1;
                edge[end][start] = 1;
            }

            BFS();
            if(result) sb.append("BICOLORABLE.");
            else sb.append("NOT BICOLORABLE.");
            sb.append('\n');


//            for (int i = 0; i < v; i++) {
//                System.out.println(Arrays.toString(edge[i]));
//            }

        }
        System.out.println(sb);




    }
    public static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        int[] color = new int[v];
        // -1 : 빈칸 , 0 : 빨강, 1 : 파랑.
        Arrays.fill(color, -1);
        color[0] = 0;
        for(int i=0; i<v; i++){
            if(edge[0][i]!=-1){
                queue.add(i);
                color[i] = 1;
            }
        }

        while(!queue.isEmpty()){
            int startV = queue.poll();
            int c = color[startV];
            for(int i=0; i<v; i++){
                if(edge[startV][i]!=-1){
                    if(color[i]==c){
                        result = false;
                        return;
                    }
                    else if(color[i]==-1) {
                        color[i] = (c+1)%2;
                        queue.add(i);
                    }
                }
            }
        }

    }
}