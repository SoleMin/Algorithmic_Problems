
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static List <Elephant> elephants = new ArrayList<>();
    static int answer [];
    static int size, answerSize, answerCount;
    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }
    public static void input() throws IOException {
        String buf;
        StringTokenizer token;
        int a, b;
        for (int i = 1; i <= 1000; i++){
            if ((buf = input.readLine()) == null || buf.isEmpty())
                break;
            token = new StringTokenizer(buf);
            a= Integer.parseInt(token.nextToken());
            b= Integer.parseInt(token.nextToken());
            Elephant e = new Elephant(a, b, i);
            elephants.add(e);

        }
        Collections.sort(elephants);
        size = elephants.size();
    }
    public static void solve(){
        int pre[] =new int [size];
        Arrays.fill(pre, -1);
        answer = Arrays.copyOf(pre, size);
        answerSize = size;
        answerCount = 1;
        int pref;
        for (int start = 0; start < size; start++) {
            pre[0] = elephants.get(start).getNumber();
            pref = start;
            backtracking(start, 1, pre, pref);
        }

    }
    public static void backtracking(int start, int count, int [] pre, int pref) {
        boolean change = false;
        if (answerCount < count) {
            answer = Arrays.copyOf(pre, answerSize);
            answerCount = count;
        }
        else if (answerCount == count){
            for (int i = 0; i < answerSize; i++) {
                if (answer[i] < pre[i] && answer[i] != -1) {
                    change = false;
                    break;
                } else if (answer[i] > pre[i] || (answer[i] == -1 && pre[i] != -1)) {
                    change = true;
                    break;
                }
            }
            if (change == true) {
                answer = Arrays.copyOf(pre, answerSize);
                answerCount = count;
            }
        }

        for (int i = start; i < size; i++)
            if (prove(i, pref)) {
                pre[count] = elephants.get(i).getNumber();
                backtracking(i + 1, count + 1, pre, i);
                pre[count] = -1;
            }
    }
    public static boolean prove (int a, int pref){
        return elephants.get(pref).getIntel() > elephants.get(a).getIntel() && elephants.get(pref).getWeight() < elephants.get(a).getWeight();
    }
    public static void print(){
        System.out.println(answerCount);
        if (answerSize > 0) {
            for (int i = 0; i < answerCount; i++)
                System.out.println(answer[i]);
        }
    }
}

class Elephant implements Comparable <Elephant>{
    int weight;
    int intel;
    int number;

    public int getWeight() {
        return weight;
    }

    public int getIntel() {
        return intel;
    }

    public int getNumber() {
        return number;
    }

    public Elephant(int weight, int intel, int number) {
        this.weight = weight;
        this.intel = intel;
        this.number = number;
    }

    @Override
    public int compareTo(Elephant o) {
        return (this.weight >= o.weight)? 1 : -1;
    }
}