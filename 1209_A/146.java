
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A {

  static int countColors(List<Integer> colors) {
    Collections.sort(colors);
    int k = 0;
    while (!colors.isEmpty()) {
      Integer c = colors.get(0);
      colors.remove(0);
      k++;

      List<Integer> toRemove = new ArrayList<>();
      for (int i = 0; i < colors.size(); i++) {
        if (colors.get(i) % c == 0) toRemove.add(i);
      }

      Collections.reverse(toRemove);
      for (Integer integer : toRemove) {
        colors.remove(integer.intValue());
      }
    }
    return k;
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int n = scanner.nextInt();
      scanner.nextLine();
      List<Integer> integers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
      System.out.println(countColors(integers));
    }
  }
}
