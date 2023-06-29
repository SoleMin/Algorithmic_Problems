import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a1113 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int lastCity = Integer.parseInt(strings[0]);
        int tankSize = Integer.parseInt(strings[1]);
        int money = 0, oil = 0;

        for (int currentCity = 1; currentCity < lastCity; ) {
            if (lastCity - currentCity <= oil) {
                break;
            } else {
                int needOil = tankSize > lastCity - currentCity ? lastCity - currentCity - oil : tankSize - oil;
                money += needOil * currentCity;
                oil += needOil;
                currentCity++;
                oil--;
            }
        }
        System.out.println(money);
        reader.close();
    }
}
