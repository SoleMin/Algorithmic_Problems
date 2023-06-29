import java.awt.Point;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sdffsdf {

	public static void main(String[] args) {
		try{
			File file = new File("input.txt");
			Scanner sc = new Scanner(file);
			String s = sc.nextLine();
			String[] seperatedd = s.split(" ");
			int x = Integer.parseInt(seperatedd[0]);
			int y = Integer.parseInt(seperatedd[1]);
			int[][] grid = new int[x][y];
			for(int i = 0; i < x; i++)
			{
				for(int j = 0; j < y; j++)
				{
					grid[i][j] = 0;
				}
			}
			s = sc.nextLine();
			int z = Integer.parseInt(s);
			LinkedList<Point> BFS = new LinkedList<Point>();
			s = sc.nextLine();
			String[] seperated = s.split(" ");
			for(int i = 0; i < seperated.length; i = i + 2)
			{
				Point temp = new Point();
				temp.x = Integer.parseInt(seperated[i])-1;
				temp.y = Integer.parseInt(seperated[i+1])-1;
				grid[temp.x][temp.y] = 1;
				BFS.addLast(temp);
			}
			while(!BFS.isEmpty())
			{
				Point temp = new Point();
				temp = BFS.removeFirst();
			 	int	k = temp.x;
			 	int l = temp.y;
				
				if(!(l+1 >= y || grid[k][l+1] == 1))
				{
					Point temp1 = new Point();
					temp1.x = k;
					temp1.y = l+1;
					grid[temp1.x][temp1.y] = 1;
					BFS.addLast(temp1);
				}
				if(!(k+1 >= x || grid[k+1][l] == 1))
				{
					Point temp1 = new Point();
					temp1.x = k+1;
					temp1.y = l;
					grid[temp1.x][temp1.y] = 1;
					BFS.addLast(temp1);
				}
				
								
				if(!(l-1 < 0 || grid[k][l-1] == 1))
				{
					Point temp1 = new Point();
					temp1.x = k;
					temp1.y = l-1;
					grid[temp1.x][temp1.y] = 1;
					BFS.addLast(temp1);
				}
				if(!(k-1 < 0 || grid[k-1][l] == 1))
				{
					Point temp1 = new Point();
					temp1.x = k-1;
					temp1.y = l;
					grid[temp1.x][temp1.y] = 1;
					BFS.addLast(temp1);
				}
				if(BFS.isEmpty())
				{
			try {
						File fil = new File("output.txt");
						PrintWriter out = new PrintWriter(fil);
						int v1 = (int)temp.getX() + 1;
						int v2 = (int)temp.getY() + 1;
						out.println(v1 + " " + v2); 
				        out.close();	
					}
					catch (Exception e) {}
				}
			}
		}
		catch (Exception e) {
			System.out.println("nbvnb");
		}

	}

}
