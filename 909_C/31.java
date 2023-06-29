import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class C {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<String> commands = IntStream.range(0, n).boxed().map(x -> s.next()).collect(Collectors.toList());
        List<Integer> ways = new ArrayList<>();
        ways.add(1);
        boolean lastWasS = false;
        for (String command : commands) {
            boolean isS = "s".equals(command);

            if (lastWasS) {
                for (int i = 1; i < ways.size(); ++i) {
                    int waysNumber = (ways.get(i-1) + ways.get(i)) % 1_000_000_007;
                    ways.set(i, waysNumber);
                }
            }

            if (!isS) {
                ways.add(0);
            }

            lastWasS = isS;
        }
        System.out.println(ways.stream().reduce(0, (a, b) -> (a + b) % 1_000_000_007));
    }
}
