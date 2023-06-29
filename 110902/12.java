import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int start[], end[], reject[][], rejectN, count;
    static boolean result;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-->0){
            br.readLine();
            start = new int[4];
            end = new int[4];


            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                start[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                end[i] = Integer.parseInt(st.nextToken());
            }

            if(start[0]==end[0] && start[1]==end[1] && start[2]==end[2] && start[3]==end[3]){
                System.out.println(0);
                continue;
            }

            rejectN = Integer.parseInt(br.readLine());
            reject = new int[rejectN][4];

            for(int i=0; i<rejectN; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<4; j++){
                    reject[i][j] = Integer.parseInt(st.nextToken());
                }
            }

//            System.out.println(Arrays.toString(start));
//            System.out.println(Arrays.toString(end));
//            for(int i=0; i<rejectN; i++){
//                System.out.println(Arrays.toString(reject[i]));
//            }
            result = false;
            set = new HashSet<>();
            BFS();
            if(result) System.out.println(count);
            else System.out.println(-1);



            /////// if (start==end) 처리










        }


    }
    static Set<String> set;
    public static void BFS(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        count = 0;
        int tmp = 1;

        while(!queue.isEmpty()){
//            System.out.println("count = "+count);
            /////////////
//            System.out.println();
//            for(int i=0; i<queue.size(); i++){
//                int[] tmpp = queue.poll();
//                System.out.println(Arrays.toString(tmpp));
//                queue.add(tmpp);
//            }

            tmp--;
            if(tmp==0){
                tmp = queue.size();
                count++;
            }

            int[] current = queue.poll();
//            System.out.println("current = ");
//            System.out.println(Arrays.toString(current));

            // left
            for(int i=0; i<4; i++) {
                StringBuilder sb = new StringBuilder();
                int[] next = Arrays.copyOf(current, 4);
                next[i] = (next[i] + 9) % 10;
                for (int j = 0; j < 4; j++) {
                    sb.append(next[j]);
                }
                if (set.contains(sb.toString())) continue;
                boolean isReject = false;
                for (int j = 0; j < rejectN; j++) {
                    if (reject[j][0] == next[0] && reject[j][1] == next[1] && reject[j][2] == next[2] && reject[j][3] == next[3]) {
                        isReject = true;
                        break;
                    }
                }
                if (isReject) continue;

                if (end[0] == next[0] && end[1] == next[1] && end[2] == next[2] && end[3] == next[3]) {
                    result = true;
                    return;
                }
                queue.add(next);
                set.add(sb.toString());
            }

            // right
            for(int i=0; i<4; i++) {
                StringBuilder sb = new StringBuilder();
                int[] next = Arrays.copyOf(current, 4);
                next[i] = (next[i] + 1) % 10;
                for (int j = 0; j < 4; j++) {
                    sb.append(next[j]);
                }
                if (set.contains(sb.toString())) continue;
                boolean isReject = false;
                for (int j = 0; j < rejectN; j++) {
                    if (reject[j][0] == next[0] && reject[j][1] == next[1] && reject[j][2] == next[2] && reject[j][3] == next[3]) {
                        isReject = true;
                        break;
                    }
                }
                if (isReject) continue;

                if (end[0] == next[0] && end[1] == next[1] && end[2] == next[2] && end[3] == next[3]) {
                    result = true;
                    return;
                }
                queue.add(next);
                set.add(sb.toString());
            }



//                else {
//                    boolean isReject = false;
//                    for (int j = 0; j < rejectN; j++) {
//                        if (reject[j][0] == next[0] && reject[j][1] == next[1] && reject[j][2] == next[2] && reject[j][3] == next[3]) {
//                            isReject = true;
//                            break;
//                        }
//                    }
//                    if (end[0] == next[0] && end[1] == next[1] && end[2] == next[2] && end[3] == next[3]) {
//                        result = true;
//                        return;
//                    }
//                    set.add(sb.toString());
//                    queue.add(next);
//                }




                // right
//                next[i] = (next[i] + 2)%10;
//                for(int j=0; j<4; j++){
//                    sb.append(next[j]);
//                }
//                if(set.contains(sb.toString())) continue;
//                else{
//                    if(end[0]==next[0] && end[1]==next[1] && end[2]==next[2] && end[3]==next[3]){
//                        result = true;
//                        return;
//                    }
//                    set.add(sb.toString());
//                    queue.add(next);
//                }


        }






    }
}