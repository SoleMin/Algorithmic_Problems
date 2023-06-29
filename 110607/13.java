import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();


        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            if(s.equals("0")){
                break;
            }
            int n=1;
            int m=1;

            while (true)
            {
                if (Integer.parseInt(s) > n){
                    hashMap.put(n,m);
                    try {
                        n += hashMap.get(m);
                        m++;

                    } catch (Exception e){
                        for (int i = m; i > 0; i--) {
                            if (hashMap.containsKey(i)){
                                n += hashMap.get(i);
                                m++;
                                break;
                            }
                        }
                    }
                } else{
                    break;
                }
            }
            if (Integer.parseInt(s) ==n) {
                System.out.println(m);

            } else{
                System.out.println(m-1);
            }
        }
    }
}
