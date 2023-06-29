import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        arr[0] = sc.nextInt();

        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + sc.nextInt();
        }

        HashMap<Integer, List<Pair>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            if (map.containsKey(arr[i])) map.get(arr[i]).add(new Pair(0, i));
            else {
                List<Pair> l = new ArrayList<>();
                l.add(new Pair(0, i));
                map.put(arr[i], l);
            }

            for (int j = 1; j <= i; j++) {
                int ss = arr[i] - arr[j - 1];
                if (map.containsKey(ss)) map.get(ss).add(new Pair(j, i));
                else {
                    List<Pair> l = new ArrayList<>();
                    l.add(new Pair(j, i));
                    map.put(ss, l);
                }
            }
        }

        List<Pair> el = null;

        for (List<Pair> value : map.values()) {
            value.sort(Comparator.comparingInt(Pair::getStart));
            ArrayList<Pair> ps = new ArrayList<>();
            Pair last = value.get(0);

            for (int i = 1; i < value.size(); i++) {
                if (last.getEnd() < value.get(i).getStart()) {
                    ps.add(last);
                    last = value.get(i);
                }
                else if (last.getEnd() > value.get(i).getEnd()) last = value.get(i);
            }

            ps.add(last);

            if (el == null) el = ps;
            else if (ps.size() > el.size()) el = ps;
        }

        System.out.println(el.size());

        for (Pair pair : el) {
            System.out.println((pair.getStart() + 1) + " " + (pair.getEnd() + 1));
        }

    }
}

class Pair {
    private final int start;
    private final int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}