import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, rule;
    static boolean tf;
    static int[] preCell;
    static String iWant_result;
    static StringBuilder stringR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (s != null) {
            StringTokenizer st = new StringTokenizer(s);
            rule = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            iWant_result = st.nextToken();
            stringR = new StringBuilder(Integer.toBinaryString(rule));
            while (stringR.length() < 8) {
                stringR.insert(0, 0);
            }

//            System.out.println(stringR);


            preCell = new int[n];

            tf = false;
            for (int i = 0; i < 8; i++) {
                if (stringR.charAt(i) == iWant_result.charAt(1)) {
                    preCell[0] = (i / 4) % 2;
                    preCell[1] = (i / 2) % 2;
                    preCell[2] = i % 2;
                    backTracking(2);
                    if (tf) break;
                }
            }


            if (tf) sb.append("REACHABLE");
            else sb.append("GARDEN OF EDEN");
            sb.append('\n');


            s = br.readLine();
        }
        System.out.println(sb);


    }

    public static void backTracking(int depth) {
        if (depth == n - 1) {
            // 중간들 값은 판별 됐으므로 LSB, MSB 만 판별하고 결과 반환.
            if (stringR.charAt(preCell[depth - 1] * 4 + preCell[depth] * 2 + preCell[0]) == iWant_result.charAt(depth) &&
                    stringR.charAt(preCell[depth] * 4 + preCell[0] * 2 + preCell[1]) == iWant_result.charAt(0)) {
                tf = true;
            }
            return;
        }


        int index = preCell[depth - 1] * 4 + preCell[depth] * 2;

        if(stringR.charAt(index) == iWant_result.charAt(depth)){
            preCell[depth+1] = index%2;
            backTracking(depth+1);
        }

        if(!tf && stringR.charAt(index+1)==iWant_result.charAt(depth)){
            preCell[depth+1] = (index+1)%2;
            backTracking(depth+1);
        }



    }
}