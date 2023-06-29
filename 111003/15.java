import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-->0){
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());
            int[] fArray = new int[f];
            boolean[] fBool = new boolean[I];
            // 소방 노드 번호 -1
            for(int i=0; i<f; i++){
                fArray[i] = Integer.parseInt(br.readLine())-1;
                fBool[fArray[i]] = true;
            }

            // 교차로 번호 -1
            int[][] arr = new int[I][I];
            for(int i=0; i<I; i++){
                Arrays.fill(arr[i], (int)1e9);
                arr[i][i] = 0;
            }
            for(int i=0; i<I; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken())-1;
                int end = Integer.parseInt(st.nextToken())-1;
                int weight = Integer.parseInt(st.nextToken());
                arr[start][end] = weight;
                arr[end][start] = weight;
            }

//            for(int i=0; i<I; i++){
//                System.out.println(Arrays.toString(arr[i]));
//            }

            // i 노드 허용
            for(int i=0; i<I; i++){
                for(int j=0; j<I; j++){
                    for(int k=0; k<I; k++){
                        arr[j][k] = Math.min(arr[j][k], arr[j][i]+arr[i][k]);
                    }
                }
            }


            int[] s_l = new int[I];
            int max_s_l = 0;
            for(int i=0; i<I; i++){
                s_l[i] = (int)1e9;
                for(int j=0; j<f; j++){
                    s_l[i] = Math.min(s_l[i], arr[i][fArray[j]]);
                }
                max_s_l = Math.max(max_s_l, s_l[i]);
            }
//            System.out.println(Arrays.toString(s_l));
//            for(int i=0; i<I; i++){
//                System.out.println(Arrays.toString(arr[i]));
//            }


            int resultIndex = -1;
            int max_min = (int) 1e9;
            // 소방서 없는 노드에 설치 후 가장 먼 노드의 값이 최소가 되는 경우 찾기
            for(int i=0; i<I; i++){
                // 소방서인경우 패스
                if(fBool[i]) continue;
//                System.out.println(i+" 노드에 설치");
                // i 노드에 소방서 설치하고 최소 갱신
                int tmpMax = 0;
                for(int j=0; j<I; j++){
                    // 소방서 위치는 패스
                    if(fBool[j] || j==i) continue;
                    tmpMax = Math.max(tmpMax, arr[i][j]);
                    tmpMax = Math.min(tmpMax, s_l[j]);
                }
                if(tmpMax<max_min){
                    resultIndex = i;
                    max_min = tmpMax;
                }
//                System.out.println(tmpMax);
            }
            System.out.println(resultIndex+1);
            System.out.println();



        }
    }
}