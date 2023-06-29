import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author BSRK Aditya
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long numQuestions = in.nextInt();
        long numCorrectlyAnsweredQuestions = in.nextInt();
        long sizeForDoublingScore = in.nextInt();

        long score = 0;

        long numIncorrectlyAnsweredQuestions = numQuestions - numCorrectlyAnsweredQuestions;

        long numDoublings = Math.max(numQuestions / sizeForDoublingScore - numIncorrectlyAnsweredQuestions, 0);
        score += 2*sizeForDoublingScore*Long.parseLong(new BigInteger("2").modPow(new BigInteger(String.valueOf(numDoublings)), new BigInteger("1000000009")).subtract(BigInteger.ONE).toString());
        score += numCorrectlyAnsweredQuestions - sizeForDoublingScore*numDoublings;
        score %= 1000000009;

        out.println(score);
    }
}

