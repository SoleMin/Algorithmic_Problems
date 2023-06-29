import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int k=1; k<=testCase; k++){
            int nameCount = 0;
//            Map<Integer, String> getName = new HashMap<>();
            Map<String, Integer> getNumber = new HashMap<>();
            int e = Integer.parseInt(br.readLine());
//            endV_startT_travelT[][] edge = new endV_startT_travelT[100][100];


            List<endV_startT_travelT>[] list = new ArrayList[100];

            for(int i=0; i<e; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String start = st.nextToken();
                String end = st.nextToken();
//                System.out.println("start = "+start);
                int startT = Integer.parseInt(st.nextToken());
                int travelT = Integer.parseInt(st.nextToken());
                startT %= 24;
                if((startT >= 6 && startT<18) || (startT < 6 && travelT > 6-startT) ||
                        (startT >=18 && travelT>30-startT)){
                    continue;
                }
                startT = (startT + 12) % 24;
                getNumber.putIfAbsent(start, nameCount++);
                getNumber.putIfAbsent(end, nameCount++);


//                if(!getNumber.containsKey(start)){
////                    getName.put(nameCount, start);
//                    getNumber.put(start, nameCount++);
//                }
//                if(!getNumber.containsKey(end)){
////                    getName.put(nameCount, end);
//                    getNumber.put(end, nameCount++);
//                }
                try{
                    list[getNumber.get(start)].add(new endV_startT_travelT(getNumber.get(end), startT, travelT));
                }
                catch(NullPointerException ignore){
                    list[getNumber.get(start)] = new ArrayList<>();
                    list[getNumber.get(start)].add(new endV_startT_travelT(getNumber.get(end), startT, travelT));
                }
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();
            getNumber.putIfAbsent(start, nameCount++);
            getNumber.putIfAbsent(end, nameCount++);

            boolean result = false;
            // bfs
            Queue<Integer> queue = new LinkedList<>();
            queue.add(getNumber.get(start));
//            System.out.println("start = "+start);


            // 0 : 혈액량 ( 날짜 ) , 1 : 도착시간
            int[][] check = new int[nameCount][2];
            for(int i=0; i<nameCount; i++){
                check[i][0] = (int)1e9;
            }
            check[getNumber.get(start)][0] = 0;
            while(!queue.isEmpty()){
//                System.out.println(queue);
                int startI = queue.poll();
                int nowBlood = check[startI][0];
                int endT = check[startI][1];

                if(startI==getNumber.get(end)){
                    result = true;
                    break;
                }

                if(list[startI]==null) continue;
                for(int i=0; i<list[startI].size(); i++){
//                    System.out.println("i ="+i);
                    endV_startT_travelT tmp = list[startI].get(i);
//                    System.out.println("now[0] = "+startI);
//                    System.out.println("now[1] = "+nowBlood);
//                    System.out.println("now[2] = "+endT);
//                    System.out.println("endV = "+tmp.endV);
//                    System.out.println("startT = "+tmp.startT);
//                    System.out.println("travelT = "+tmp.travelT);
                    if(endT <= tmp.startT && (check[tmp.endV][0] > nowBlood || (check[tmp.endV][0] == nowBlood && check[tmp.endV][1] > tmp.startT + tmp.travelT))){
                        queue.add(tmp.endV);
                        check[tmp.endV][0] = nowBlood;
                        check[tmp.endV][1] = tmp.startT + tmp.travelT;
                    }
                    else if(endT > tmp.startT && (check[tmp.endV][0] > nowBlood+1 || (check[tmp.endV][0] == nowBlood+1 && check[tmp.endV][1] > tmp.startT + tmp.travelT))){
                        queue.add(tmp.endV);
                        check[tmp.endV][0] = nowBlood+1;
                        check[tmp.endV][1] = tmp.startT + tmp.travelT;
                    }
                }

            }
            System.out.printf("Test Case %d.\n", k);
            if(result) System.out.println("Vladimir needs " + check[getNumber.get(end)][0] + " litre(s) of blood.");
            else System.out.println("There is no route Vladimir can take.");





        }




    }
    static class endV_startT_travelT{
        int endV, startT, travelT;
        public endV_startT_travelT(int endV, int startT, int travelT){
            this.endV = endV;
            this.startT = startT;
            this.travelT = travelT;
        }
    }
}