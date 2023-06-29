import javax.sound.sampled.Line;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);


        while(scan.hasNextLine()) {
            Queue<Character> inputA = new LinkedList<>();
            LinkedList<Character> inputB = new LinkedList<>();
            LinkedList<String> result = new LinkedList<>();
            String str = scan.nextLine();
            int index = 0;
            for(int i = 0; i < str.length(); i++) {
                inputA.add(str.charAt(i));
            }
            str= scan.nextLine();
            for(int i = 0; i < str.length(); i++) {
                inputB.add(str.charAt(i));
            }
            inputB.sort(null);
            while(!inputA.isEmpty()) {
                char temp = inputA.poll();
                for(int i = 0; i < inputB.size(); i++) {
                    if(temp == inputB.get(i)) {
                        result.add(temp + "");
                        inputB.remove(i);
                        break;
                    }
                }
            }
            result.sort(null);
            for(int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
            }
            System.out.println();
        }

    }
}