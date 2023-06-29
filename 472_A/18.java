import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main
{

	private static BufferedReader in;
	private static BufferedWriter out;

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		// streams
		boolean file = false;
		if (file)
			in = new BufferedReader(new FileReader("input.txt"));
		else
			in = new BufferedReader(new InputStreamReader(System.in));
		// out = new BufferedWriter(new OutputStreamWriter(System.out));
		out = new BufferedWriter(new FileWriter("output.txt"));
		StringTokenizer tok;

		int n = Integer.parseInt(in.readLine());
		if (n % 2 == 0)
			System.out.println(4 + " " + (n-4));
		else
			System.out.println(9 + " " + (n-9));
	}

}