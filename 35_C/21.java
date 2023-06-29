import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(new File("input.txt"));
        BufferedWriter out = new BufferedWriter(new FileWriter("output.txt")); 
        
        int r = scn.nextInt();
        int c = scn.nextInt();
        
        int[][] a = new int[r][c];
        
        for(int[] i: a)
            Arrays.fill(i, 1<<30);
        
        int k = scn.nextInt();
            
        Queue<State> q = new LinkedList<State>();
        for(int l = 0; l < k; l++){
            int i = scn.nextInt()-1;
            int j = scn.nextInt()-1;
        
            a[i][j] = 0;
            q.add(new State(i, j, 0));
        }
        
        while(!q.isEmpty()){
            State st = q.poll();
            
            a[st.i][st.j] = st.c;
            
            for(int d = 0; d < 4; d++){
                int ii = st.i + di[d];
                int jj = st.j + dj[d];
                
                if(ii < 0 || ii >= r || jj < 0 || jj >= c)continue;
                if(a[ii][jj] != 1 << 30)continue;
                
                a[ii][jj] = st.c+1;
                q.add(new State(ii, jj, st.c+1));
            }
        }
        
        int max = 0;
        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                max = Math.max(max, a[i][j]);
        
        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                if(a[i][j] == max){
//                  System.out.println(i+1 + " " + (j+1));
                    out.write((i+1)+" "+(j+1));
                    out.newLine();
                    
                    out.close();
                    
                    return;
                }
        
    }
    static int[] di = {0, 0, -1, 1};
    static int[] dj = {1, -1, 0, 0};
}

class State{
    int i, j, c;
    public State(int ii, int ji, int ci){
        i = ii;
        j = ji;
        c = ci;
    }
}