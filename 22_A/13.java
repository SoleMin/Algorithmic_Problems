import java.util.*;
import java.lang.*;
import java.io.*;

public class Blah
{
    public static void main(String args[])
    {
	Scanner c = new Scanner(System.in);
	String number = c.nextLine();
	int i = Integer.parseInt(number);
	if (i == 1)
	    {
		System.out.println("NO");
		return;
	    }
	String line = c.nextLine();
	String[] arr = line.split(" ");
	int[] array = new int[i];
	for (int j = 0; j < i; j++)
	    {
		array[j] = Integer.parseInt(arr[j]);
	    }
        int min = array[0];
	int second = 0;
	boolean thing = false;
	for (int j = 0; j < i; j++)
	    {
		if (!thing && array[j] > min)
		    {
			second = array[j];
			thing = true;
		    }
		if (array[j] < min)
		    {
			second = min;
			min = array[j];
			thing = true;
		    }
		else if (thing && array[j] > min && array[j] < second)
		    second = array[j];
	    }
	if (!thing)
	    System.out.println("NO");
	else
	    System.out.println(second);
	return;	     
    }
}