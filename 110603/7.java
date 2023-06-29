import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		BigInteger[] list = new BigInteger[1001];
		list[0] = new BigInteger("1");
		list[1] = new BigInteger("2");
		list[2] = new BigInteger("5");
		list[3] = new BigInteger("13");
		for (int i = 4; i < list.length; i++)
			list[i] = list[i - 1].multiply(new BigInteger("2")).add(list[i - 2]).add(list[i - 3]);
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			System.out.println(list[n]);
		}
	}
}