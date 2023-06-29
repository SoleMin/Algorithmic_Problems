import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class BNew {

    double gAns = 0;

    public static void main(String[] args) throws IOException {
        new BNew().solve();
    }

    private void solve() throws IOException {
        MyScanner in = new MyScanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int k = in.nextInt();
        int A = in.nextInt();
        List<Senator> allSenators = new ArrayList<Senator>();
        for (int i = 0; i < n; i++) {
            int level = in.nextInt();
            int loyalty = in.nextInt();
            allSenators.add(new Senator(level, loyalty));
        }
        allSenators = Collections.unmodifiableList(allSenators);

        int npow2 = 1 << n;

        rec(allSenators, 0, k, A);
        for (int okSenatorMask = 0; okSenatorMask < npow2; okSenatorMask++) {
            List<Senator> okSenators = copy(getSenatorsByMask(okSenatorMask, allSenators));
            liftLeastSenators(okSenators, k);
            List<Senator> updatedSenators = new ArrayList<Senator>(okSenators);
            List<Senator> otherSenators = getSenatorsByMask(npow2 - 1 - okSenatorMask, allSenators);
            updatedSenators.addAll(otherSenators);
            check(updatedSenators, A);
        }

        in.close();

        PrintWriter pw = new PrintWriter(System.out);
        System.out.printf("%.6f\n", gAns);
        pw.close();
    }

    private void rec(List<Senator> senators, int senatorId, int k, int A) {
        if (senatorId == senators.size()) {
            check(senators, A);
            return;
        }
        Senator senator = senators.get(senatorId);
        int up = Math.min(k, (100 - senator.loyalty) / 10);
        final int old = senator.loyalty;
        for (int i = 0; i <= up; i++) {
            senator.loyalty = old + i * 10;
            rec(senators, senatorId + 1, k - i, A);
        }
        senator.loyalty = old;
    }

    private void check(List<Senator> senators, double A) {
        double winProp = 0.0;
        for (int mask = 0; mask < 1 << senators.size(); mask++) {
            double caseP = 1.0;
            int okCnt = 0;
            int notOkLevelSum = 0;
            for (int i = 0; i < senators.size(); i++) {
                Senator senator = senators.get(i);
                double senatorLoyalty = senator.loyalty / 100.0;
                boolean ok = (mask & (1 << i)) != 0;
                if (ok) {
                    caseP *= senatorLoyalty;
                    okCnt++;
                } else {
                    caseP *= (1 - senatorLoyalty);
                    notOkLevelSum += senator.level;
                }
            }
            if (okCnt * 2 > senators.size()) {
                winProp += caseP;
            } else {
                double killProp = A / (A + notOkLevelSum);
                winProp += caseP * killProp;
            }
        }
        gAns = Math.max(gAns, winProp);
    }

    List<Senator> copy(List<Senator> senators) {
        List<Senator> copied = new ArrayList<Senator>();
        for (Senator senator : senators) {
            copied.add(new Senator(senator.level, senator.loyalty));
        }
        return copied;
    }

    void liftLeastSenators(List<Senator> senators, int k) {
        if (senators.isEmpty()) {
            return;
        }
        for (int i = 0; i < k; i++) {
            Senator least = senators.get(0);
            for (Senator senator : senators) {
                if (senator.loyalty < least.loyalty) {
                    least = senator;
                }
            }
            if (least.loyalty < 100) {
                least.loyalty += 10;
            }
        }
    }

    List<Senator> getSenatorsByMask(int mask, List<Senator> allSenators) {
        List<Senator> list = new ArrayList<Senator>();
        for (int i = 0; i < allSenators.size(); i++) {
            if ((mask & (1 << i)) != 0) {
                list.add(allSenators.get(i));
            }
        }
        return list;
    }

    static class Senator {
        final int level;
        int loyalty;

        Senator(int level, int loyalty) {
            this.level = level;
            this.loyalty = loyalty;
        }

        @Override
        public String toString() {
            return "{" +
                    "level=" + level +
                    ", loyalty=" + loyalty +
                    '}';
        }
    }

    static class MyScanner {
        final BufferedReader myBr;
        StringTokenizer st = new StringTokenizer("");

        MyScanner(BufferedReader br) {
            myBr = br;
        }

        String nextToken() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(myBr.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        void close() throws IOException {
            myBr.close();
        }
    }
}
