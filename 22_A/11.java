import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iTotTerm, i, j, iSml = 0, iPos = 0;
        iTotTerm = Integer.parseInt(br.readLine());
        String seq[];
        seq = br.readLine().split(" ");
        int iSeq[] = new int[iTotTerm];
        for (i = 0; i < iTotTerm; i++) {
            iSeq[i] = Integer.parseInt(seq[i]);
        }
        for (i = 0; i < iTotTerm; i++) {
            iSml = iSeq[i];
            iPos = i;
            for (j = i; j < iTotTerm; j++) {
                if (iSeq[j] < iSml) {
                    iSml = iSeq[j];
                    iPos = j;
                }
            }
            iSeq[iPos] = iSeq[i];
            iSeq[i] = iSml;
            if (i != 0 && iSeq[i - 1] != iSeq[i]) {
                break;
            }
        }
        if (iSml != iSeq[0]) {
            System.out.print(iSml);
        } else {
            System.out.print("NO");
        }
    }
}
