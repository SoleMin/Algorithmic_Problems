import java.util.Scanner;

public class Main {
    static int n;
    static int[] colorArr;
    static int[][] connected;
    static boolean colorable;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {

            int n = sc.nextInt();
            if (n == 0) break;
            //n바이n 배열 선언. 연결 되어있는지 검토하기 위한 배열
            connected = new int[n][n];
            colorArr = new int[n];

            int edge = sc.nextInt(); //모서리 개수 입력받음

            for (int i = 0; i < edge; i++) {
                //모서리 개수만큼 a와 b를 입력받으며, 그들이 연결됨을 배열에 저장할 것
                int a = sc.nextInt();
                int b = sc.nextInt();
                connected[a][b] = 1;
                connected[b][a] = 1;
            }
            colorable = true;
            dfs(0, 1, n);
            if (colorable == false) System.out.println("NOT BICOLORABLE.");
            else System.out.println("BICOLORABLE.");
        }
    }

    static void dfs(int node, int c, int n) {
        colorArr[node] = c;
        for (int i = 0; i < n && colorable == true; i++) {
            if (connected[node][i] == 0) continue;
            if(colorArr[i] == 0)
                dfs(i, c % 2 + 1, n);
            else{
                if (colorArr[i] == c) {
                    //만약 color[i]가 c와 같다면.. --> 왔던 노드와 현재 노드의 색이 같은지를 판별
                    colorable = false; //그렇다면 colorable을 0으로. --> 그리고 리턴 --> 그럼 NOT BICOLORABLE
                    return;
                }
            }
        }
    }
}
