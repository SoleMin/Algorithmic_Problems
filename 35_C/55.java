
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		String dimensions = br.readLine();
		String extractDim = "";
		int n = 0, m;
		for (int i = 0 ; i < dimensions.length() ; i++)
		{
			if(dimensions.charAt(i) == ' ')
			{
				n = Integer.parseInt(extractDim);
				extractDim = "";
				continue;
			}
			extractDim += dimensions.charAt(i);
		}
		m = Integer.parseInt(extractDim); 
		
		String burningTrees = br.readLine();
		
		int k = Integer.parseInt(burningTrees);		
		
		Point[] coord = new Point[k];
		
		String coordSet = br.readLine();
		int spaceCount = 0;
		String newCoord = "";
		int s = 0;
		for(int i = 0 ; i < coordSet.length() ; i++)
		{
			if(coordSet.charAt(i) == ' ')
				spaceCount++;
			
			if(spaceCount == 2)
			{
				String extractCoord = "";
				int x = 0, y;
				for (int j = 0 ; j < newCoord.length() ; j++)
				{
					if(newCoord.charAt(j) == ' ')
					{
						x = Integer.parseInt(extractCoord);
						extractCoord = "";
						continue;
					}
					extractCoord += newCoord.charAt(j);
				}
				y = Integer.parseInt(extractCoord);
				
				coord[s] = new Point(x,y);
				s++;
				newCoord = "";
				spaceCount = 0;
				continue;
			}
			
			newCoord += coordSet.charAt(i);
		}
		
		String extractCoord = "";
		int x = 0, y;
		for (int j = 0 ; j < newCoord.length() ; j++)
		{
			if(newCoord.charAt(j) == ' ')
			{
				x = Integer.parseInt(extractCoord);
				extractCoord = "";
				continue;
			}
			extractCoord += newCoord.charAt(j);
		}
		y = Integer.parseInt(extractCoord);
		
		coord[s] = new Point(x,y);
		s++;
		
		br.close();
		
		int[][] forest = new int[n+2][m+2];
		
		for(int i = 0 ; i < forest.length ; i++)
		{
			for(int j = 0 ; j < forest[i].length ; j++)
			{
				if(i == 0 || i == n+1 || j == 0 || j == m+1 )
					forest[i][j] = 0;
				else
					forest[i][j] = 1;
			}
		}
		
		
		Queue<Point> q = new LinkedList<>();
		
		for(int i = 0 ; i < coord.length ; i++)
		{
			forest[coord[i].x][coord[i].y] = 0;
			q.add(coord[i]);
		}
		
		Point tree = new Point();
		while(!q.isEmpty())
		{
			Point temp = q.remove();
			forest[temp.x][temp.y] = 0;
			
			if(q.isEmpty())
				tree = new Point(temp.x ,temp.y);
			for(int i = -1 ; i <= 1 ; i++)
			{
				for(int j = -1; j <= 1; j++)
				{
					if(i != 0 && j != 0 || i == 0 && j == 0)
						continue;
					if(forest[temp.x+i][temp.y+j] == 0)
						continue;
					else
					{
						forest[temp.x+i][temp.y+j] = 0;
						q.add(new Point(temp.x+i , temp.y+j));
					}
				}
			}
			
		}
		
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
		bw.write(tree.x + " " + tree.y);
		bw.close();
		
	
	}

}
