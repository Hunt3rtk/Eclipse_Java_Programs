// Imported for algorithm
import java.util.Scanner;
import java.util.Random;
import java.util.LinkedList;
import java.util.Queue;


// Imported for GUI
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Map class hold all information regarding the search map
class Map {
	
	Node[][] grid;
	int numberOfColumns;
	int numberOfRows;
	Cell startCell = new Cell();
	Cell goalCell = new Cell();
}

// Node class holds information regarding each node in the grid
class Node {
	
	int path;
	boolean visited = false;
	boolean obstacle = false;
	boolean solution;
	Node previous = null;
	Cell previousCell;
	
}

// Cell class holds information regarding the row and column of specific nodes of value, such as solution nodes.
class Cell {
	
	int row;
	int column;

}

public class Grassfire_Algorithm {
	
	// initializing map object
	
	public static Map map = new Map();

	// main method
	
	public static void main(String[] args) {
		
		
		//initializing map generator
		mapGenerator(map);
		
		// Calling gui before solution is found
		gui();
		
		//calling the grassfire algorithm
		grassfire(map);
		
		// Calling gui after solution is found
		gui();
		
		return;
	}
	
	// grassfire algorithm startup and finish
	
	static void grassfire(Map map) {
		
		// Setting up current cell as the goal cell
		Cell current = new Cell();
		current.row = map.goalCell.row;
		current.column = map.goalCell.column;
		
		// Goal cell as a visited cell and as our start path
		map.grid[map.goalCell.row][map.goalCell.column].path = 0;
		map.grid[map.goalCell.row][map.goalCell.column].visited = true;
		map.grid[map.goalCell.row][map.goalCell.column].previousCell = current;
		
		// Initializing queue for BFS spread
		Queue<Cell> queue = new LinkedList<>();
		
		queue.add(current);
		
		//spreading algorithm
		Node solution = new Node();
		solution = spread(map, queue);
		
		
		// Outputting solution
		System.out.println("The solution is as follows with coordinates of the path from the starting cell to the goal cell:");
		System.out.printf("(%d, %d)", map.startCell.row+1,map.startCell.column+1);
		while(solution.previous != null)
		{
			solution.solution = true;
			System.out.printf("(%d, %d)", solution.previousCell.row+1, solution.previousCell.column+1);
			solution = solution.previous;
		}
		return;
	}
	
	// spread method carries out recursive grassfire spread
	
	static Node spread(Map map, Queue queue) {
		
		Cell current = (Cell) queue.peek();
		
	
		// If we reach the start cell
		if(current.row == map.startCell.row && current.column == map.startCell.column)
		{
			return map.grid[current.row][current.column];
		}
			
		// Spreading up
		up(map, current, queue);
			
			
		// Spreading down
		down(map, current, queue);
			
			
		// Spreading left
		left(map, current, queue);
			
			
		// Spreading right
		right(map, current, queue);
			
		map.grid[current.row][current.column].visited = true;
		
		// removing visited cell
		queue.remove();
					
		// checking if all paths have been exhausted
		while(queue.peek() == null)
		{
			Node noSolution = new Node();
			return noSolution;
		}
		
		// recursive call until finished
		return spread(map, queue);
	}

	// spread up method
	
	static void up(Map map, Cell current, Queue queue) {

		// If it is an obstacle or doesn't exist
		if(current.row == 0 || map.grid[current.row - 1][current.column].obstacle == true)
		{
			return;
		}
		
		// If it has been visited and is part of a better path
		if(map.grid[current.row - 1][current.column].visited == true && map.grid[current.row - 1][current.column].path <= map.grid[current.row][current.column].path + 1)
		{
			return;
		}
		
		Cell next = new Cell();
		next.row = current.row - 1;
		next.column = current.column;
		
		// else set path number to +1 of current cell and set the previous cell to current node
		map.grid[next.row][next.column].visited = true;
		map.grid[next.row][next.column].path =  map.grid[current.row][current.column].path + 1;
		map.grid[next.row][next.column].previous =  map.grid[current.row][current.column];
		map.grid[next.row][next.column].previousCell = current;
		
		
		
		queue.add(next);
		
		return;
	}
	
	// spread down method
	
	static void down(Map map, Cell current, Queue queue) {
		
		// If it is an obstacle or doesn't exist
		if(current.row == map.numberOfRows - 1 || map.grid[current.row + 1][current.column].obstacle == true)
		{
			return;
		}
				
		// If it has been visited and is part of a better path
		if(map.grid[current.row + 1][current.column].visited == true && map.grid[current.row + 1][current.column].path <= map.grid[current.row][current.column].path + 1)
		{
			return;
		}
			
		Cell next = new Cell();
		next.row = current.row + 1;
		next.column = current.column;
		
		// else set path number to +1 of current cell and set previous to current node
		map.grid[next.row][next.column].path =  map.grid[current.row][current.column].path + 1;
		map.grid[next.row][next.column].previous =  map.grid[current.row][current.column];
		map.grid[next.row][next.column].previousCell = current;
				
		
				
		queue.add(next);
		
		return;
	}
	
	// spread left method
	
	static void left(Map map, Cell current, Queue queue) {
		
		// If it is an obstacle or doesn't exist
		if( current.column == 0 || map.grid[current.row][current.column-1].obstacle == true)
		{
			return;
		}
				
		// If it has been visited and is part of a better path
		if(map.grid[current.row][current.column-1].visited == true && map.grid[current.row][current.column-1].path <= map.grid[current.row][current.column].path + 1)
		{
			return;
		}
			
		Cell next = new Cell();
		next.row = current.row;
		next.column = current.column-1;
		
		// else set path number to +1 of current cell and set previous to current node
		map.grid[next.row][next.column].path =  map.grid[current.row][current.column].path + 1;
		map.grid[next.row][next.column].previous =  map.grid[current.row][current.column];
		map.grid[next.row][next.column].previousCell = current;
		
	
	
		queue.add(next);
		
		return;
	}
	
	// spread right method
	
	static void right(Map map, Cell current, Queue queue) {
		
		// If it is an obstacle or doesn't exist
		if( current.column == map.numberOfColumns - 1 || map.grid[current.row][current.column+1].obstacle == true)
		{
			return;
		}
		
		// If it has been visited and is part of a better path
		if(map.grid[current.row][current.column+1].visited == true && map.grid[current.row][current.column+1].path <= map.grid[current.row][current.column].path + 1)
		{
			return;
		}
		
		Cell next = new Cell();
		next.row = current.row;
		next.column = current.column+1;
		
		// else set path number to +1 of current cell and set previous to current node
		map.grid[next.row][next.column].path =  map.grid[current.row][current.column].path + 1;
		map.grid[next.row][next.column].previous =  map.grid[current.row][current.column];
		map.grid[next.row][next.column].previousCell = current;
		
		
		
		queue.add(next);
		
		return;
	}
	
	// gets user to generate search map
	
	static void mapGenerator(Map map) {
		
		Random rand = new Random();
		Scanner kb = new Scanner(System.in); // Create Scanner object for input
		
		//initiating variables for the generation of the map
		boolean unique;
		double obstacleCellPercentage;
		double numberOfObstacleCells;
		
		//Getting the number of rows
		System.out.println("Enter number of rows (has to be greater than 7):");
		
		map.numberOfRows = kb.nextInt();
		
		while(map.numberOfRows < 8)
		{
			System.out.println("Enter number of rows (has to be greater than 7):");
			
			map.numberOfRows = kb.nextInt();
		}
		
		
		//Getting the number of columns
		System.out.println("Enter number of columns (has to be greater than 7):");
		
		map.numberOfColumns = kb.nextInt();
		
		while(map.numberOfColumns < 8)
		{
			System.out.println("Enter number of columns (has to be greater than 7):");
			
			map.numberOfColumns = kb.nextInt();
		}
		
		// Setting the size of the grid and the 2D array that is keeping track of the visited cells as well as setting the upper and lower bound of obstacle cells
		map.grid= new Node [map.numberOfRows] [map.numberOfColumns];
		
		
		for(int i = 0; i < map.numberOfRows; i++)
		{
			for(int j = 0; j < map.numberOfColumns; j++)
			{
				
				map.grid[i][j] = new Node(); 
				
			}
		}
		
		// Getting the percentage of obstacle cells
		System.out.println("Enter the percentage of obstacle cells between and including 10 to 20 percent (Will be rounded up):");
		
		obstacleCellPercentage = (int)Math.ceil(kb.nextDouble());
		
		while(obstacleCellPercentage < 10 || obstacleCellPercentage > 20)
		{
			System.out.println("Enter the percentage of obstacle cells between and including 10 to 20 percent (Will be rounded up):");
			
			obstacleCellPercentage = (int)Math.ceil(kb.nextDouble());
		}
		
		if((map.numberOfRows*map.numberOfColumns)%(obstacleCellPercentage) != 0)
		{
			numberOfObstacleCells = ((map.numberOfRows*map.numberOfColumns)*(obstacleCellPercentage/100))+1;
		}
		else {
			numberOfObstacleCells = ((map.numberOfRows*map.numberOfColumns)*(obstacleCellPercentage/100));
		}
		
		// Setting the obstacle cells randomly
		for(int i = 0; i < numberOfObstacleCells; i++)
		{
			unique = false;
			
			while(unique == false)
			{
				int row = rand.nextInt(map.numberOfRows-1);
				int column = rand.nextInt(map.numberOfColumns-1);
				
				if(map.grid[row][column].obstacle != true)
				{
					unique = true;
				}
				map.grid[row] [column].obstacle = true;
			}
		}
		
		// Getting the start cell location
		System.out.println("Enter which column the starting cell will be placed on the first row:");
		
		map.startCell.row = 0;
		map.startCell.column = kb.nextInt();
		--map.startCell.column;
		
		while(map.startCell.column >= map.numberOfColumns - 1 || map.startCell.column < 0 || map.grid[0][map.startCell.column].obstacle == true)
		{
			System.out.println("Enter which column the starting cell will be placed on the first row:");
			
			map.startCell.column = kb.nextInt();
			--map.startCell.column;
		}
		
		//map.grid[map.startCell.row][map.startCell.column].solution = true;
		
		// Getting the goal cell location
		System.out.println("Enter the row for the goal cell example:");
		
		map.goalCell.row = kb.nextInt();
		
		while(map.goalCell.row < Math.ceil(map.numberOfRows/2) || map.goalCell.row > map.numberOfRows)
		{
			System.out.println("Enter the row for the goal cell example:");
			
			map.goalCell.row = kb.nextInt();
		}
		
		map.goalCell.row--;
		
		System.out.println("Enter the column for the goal cell example:");
		
		map.goalCell.column = kb.nextInt();
		
		while(map.goalCell.column < Math.ceil((map.numberOfColumns*2)/3) || map.goalCell.column > map.numberOfColumns || map.grid[map.goalCell.row][map.goalCell.column-1].obstacle == true)
		{
			System.out.println("Enter the column for the goal cell example:");
			
			map.goalCell.column = kb.nextInt();
		}
		
		map.goalCell.column--;
		
		//map.grid[map.goalCell.row][map.goalCell.column].solution = true;
	}	
	
	// creates graphics for search map
	
	static void gui() {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		GridLayout tmp = new GridLayout(Grassfire_Algorithm.map.numberOfRows,Grassfire_Algorithm.map.numberOfColumns);
		
		for(int i = 0; i < Grassfire_Algorithm.map.numberOfRows; i++)
		{
			for(int j = 0; j < Grassfire_Algorithm.map.numberOfColumns; j++)
			{
				JButton temp = new JButton("" + Grassfire_Algorithm.map.grid[i][j].path);
				
				if(Grassfire_Algorithm.map.grid[i][j].obstacle == true)
				{
					temp.setBackground(Color.BLACK);
				}
				else if(Grassfire_Algorithm.map.grid[i][j].solution == true)
				{
					temp.setBackground(Color.BLUE);
				}
				else if(Grassfire_Algorithm.map.grid[i][j] == Grassfire_Algorithm.map.grid[map.startCell.row][map.startCell.column])
				{
					temp.setBackground(Color.GREEN);
				}
				else if(Grassfire_Algorithm.map.grid[i][j] == Grassfire_Algorithm.map.grid[map.goalCell.row][map.goalCell.column])
				{
					temp.setBackground(Color.RED);
				}
				
				frame.add(temp);
			}
		}	
		
		frame.setSize(1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(tmp);
	}
}