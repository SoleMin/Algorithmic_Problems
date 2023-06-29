import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
public class USACO {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine()," ");
        int n= Integer.parseInt(st.nextToken());
        int r= Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(reader.readLine()," ");
        double[][] coord = new double[n][2];
        for (int i=0;i<n;i++) {
            coord[i][0] = Integer.parseInt(st2.nextToken());
            double y=r;
            for (int j=0;j<i;j++) {
                if (coord[j][0]<=coord[i][0]+2*r&&coord[j][0]>=coord[i][0]-2*r) {
                    if (coord[j][1]+Math.sqrt(4*r*r-(coord[i][0]-coord[j][0])*(coord[i][0]-coord[j][0]))>y) {
                        y=coord[j][1]+Math.sqrt(4*r*r-(coord[i][0]-coord[j][0])*(coord[i][0]-coord[j][0]));
                    }
                }
            }
            coord[i][1]=y;
        }
        for (int i=0;i<n;i++) {
            System.out.print(coord[i][1]);
            if (i<n-1) {
                System.out.print(" ");
            } else {
                System.out.print("\n");
            }
        }
        reader.close();
    }
}