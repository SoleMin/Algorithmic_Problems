import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class D_Rnd718_Explorer
{
	static int row, col;
	static int INF = 1_000_000_000;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		String[] in = scan.readLine().split(" ");
		row = parse(in[0]);
		col = parse(in[1]);
		int k = parse(in[2]);
		
		int[][] xMove = new int[row][col-1];
		for(int i = 0; i < row; i++)
		{
			in = scan.readLine().split(" ");
			for(int j = 0; j < col - 1; j++)
				xMove[i][j] = parse(in[j]);
		}
		
		int[][] yMove = new int[row - 1][col];
		for(int i = 0; i < row - 1; i++)
		{
			in = scan.readLine().split(" ");
			for(int j = 0; j < col; j++)
				yMove[i][j] = parse(in[j]);
		}
		
		
		int[][] output = new int[row][col];
		
		if(k % 2 != 0)
			fill(-1, output);
		
		else
		{
			Point[][] grid = new Point[row][col];
			for(int i = 0; i < row; i++)
				for(int j = 0; j < col; j++)
					grid[i][j] = new Point(i, j);
			
			parseMoves(grid, xMove, yMove);
			
			solve(grid, k, output);
		}
		
		print(output, out);
		
		out.flush();
	}

	private static void solve(Point[][] grid, int k, int[][] output) 
	{
		// try bfs (hoping it passes the time constraint)
		/*int target = k / 2;
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
				output[i][j] = bfs(j, i, target, grid) << 1;*/
		int target = k / 2;
		int[][][] dist = new int[row][col][k/2];
		fill(dist, grid);
		
		for(int steps = 1; steps < target; steps++ )
		{
			for(int i = 0; i < row; i++)
			{
				for(int j = 0; j < col;j ++)
				{
					dist[i][j][steps] = getDist(i, j, steps, dist, grid);
				}
			}
		}
		
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col;j ++)
				output[i][j] = (dist[i][j][target - 1] << 1);
		
	}



	private static int getDist(int y, int x, int steps, int[][][] dist, Point[][] grid) 
	{
		for(int d = 0; d < 4; d++)
		{
			int i = y + dy[d];
			int j = x + dx[d];
			
			if(valid(i, j))
			{
				dist[y][x][steps] = Math.min(dist[y][x][steps], dist[i][j][steps - 1] + grid[y][x].weight[d]);
			}
		}
		
		return dist[y][x][steps];
	}	
	
	private static void fill(int[][][] dist, Point[][] grid) 
	{
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col;j ++)
				for(int s = 0; s < dist[0][0].length; s++)
					dist[i][j][s] = INF;
		
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
				for(int d = 0; d < 4; d++)
					dist[i][j][0] = Math.min(dist[i][j][0], grid[i][j].weight[d]);
		
	}

	private static boolean valid(int y, int x) 
	{
		return y >= 0 && x >= 0 && y < row && x < col;
	}

	/*private static int bfs(int xStart, int yStart, int target, Point[][] grid) 
	{
		PriorityQueue<Step> q = new PriorityQueue<Step>();
		q.add(new Step(grid[yStart][xStart], 0, 0));
		
		Step s;
		int w;
		while(!q.isEmpty())
		{
			s = q.poll();
			
			if(s.numSteps == target)
				return s.length;
			
			// try to go in each of the four directions
			for(int d = 0; d < 4; d++)
			{
				w = s.current.weight[d];
				if(w != -1)
					q.add(new Step(grid[s.current.y + s.current.dy[d]][s.current.x + s.current.dx[d]], s.length + w, s.numSteps + 1));
			}
		}
		
		return -1;
	}*/

	private static void parseMoves(Point[][] grid, int[][] xMove, int[][] yMove) 
	{
		for(int i = 0; i < xMove.length; i++)
		{
			for(int j = 0; j < xMove[i].length; j++)
			{
				grid[i][j].weight[2] = xMove[i][j];	// right
				grid[i][j + 1].weight[3] = xMove[i][j]; // left
			}
		}
		
		for(int i = 0; i < yMove.length; i++)
		{
			for(int j = 0; j < yMove[i].length; j++)
			{
				grid[i][j].weight[0] = yMove[i][j];	// down
				grid[i + 1][j].weight[1] = yMove[i][j]; // up
			}
		}
	}

	private static void fill(int val, int[][] output) 
	{
		for(int i = 0; i < output.length; i++)
			Arrays.fill(output[i], val);
	}
	
	private static void print(int[][] ray, PrintWriter out) 
	{
		for(int i = 0; i < ray.length; i++)
		{
			out.print(ray[i][0]);
			for(int j = 1; j < ray[i].length; j++)
				out.print(" " + ray[i][j]);
			out.println();
		}
		
	}

	public static int parse(String num)
	{
		return Integer.parseInt(num);
	}
	
	static class Point
	{

		int[] weight = new int[4];		// down, up, right, left
		int x, y;
		
		public Point(int i, int j)
		{
			y = i;
			x = j;
			Arrays.fill(weight, INF);
		}
	}
	
	static class Step implements Comparable<Step>
	{
		int length, numSteps;
		Point current;
		
		public Step(Point p, int weight, int s)
		{
			current = p;
			length = weight;
			numSteps = s;
		}

		@Override
		public int compareTo(Step s) 
		{
			if(length == s.length)  return numSteps - s.numSteps;
			return length - s.length;
		}
	}
}
