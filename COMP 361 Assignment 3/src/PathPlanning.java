import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
//importing library
public class PathPlanning extends Graph{
	
	//Node object linking the city halls with the path that has been taken
	static class Node {
		int current;
		int cost;
		Node previous;
	}
	
	//key for integers to city names
	static String key [] = {"WV","NV","V","R","D","B","NW","S","L","A","M","C","H"};
	
	public static void main(String[] args) {
		
		//setting up graph
		GVA();
		
		//getting user input
		Scanner kb = new Scanner(System.in);
		System.out.println("(1)WV\n(2)NV\n(3)V\n(4)R\n(5)D\n(6)B\n(7)NW\n(8)S\n(9)L\n(10)A\n(11)M\n(12)C\n(13)H\n\nSelect one of your two city hall locations (select the above from left to right with regard to your second city hall):");
		int c1 = kb.nextInt()-1;
		System.out.println("(1)WV\n(2)NV\n(3)V\n(4)R\n(5)D\n(6)B\n(7)NW\n(8)S\n(9)L\n(10)A\n(11)M\n(12)C\n(13)H\n\nSelect one of your two city hall locations (select the above from left to right with regard to your first city hall):");
		int c2 = kb.nextInt()-1;
		System.out.println("(1)A_Star\n(2)Grassfire\n(3)Dijsktra\n\nType which of the three algorithms you would like to be used to solve the problem");
		int alg = kb.nextInt();
		
		//calling for solution
		pathFinder(c1,c2,alg);
	}
	
	//path finder method
	static void pathFinder(int c1, int c2, int alg) {
		
		//calling the correct algorithm
		switch(alg) {
			case 1:
				LinkedList<Integer> solution = aStar(c1,c2);
				System.out.println("The solution is:");
				while(solution.size() > 0)
				{
					System.out.print("->" + key[solution.pollLast()]);
				}
			case 2:
				solution = grassfire(c1,c2);
			case 3:
				solution = dijsktra(c1,c2);
		}
	}
	
	//A* algorithm
	static LinkedList<Integer> aStar(int c1, int c2) {
		
		//initializing frontier and start node
		LinkedList<Node> frontier = new LinkedList<Node>();
		Node start = new Node();
		start.current = c1;
		start.previous = null;
		start.cost = 0;
		frontier.add(start);
		
		//while the frontier is not empty
		while(frontier.isEmpty() == false)
		{
			//creating an original node of the city hall that is being expanded
			Node original = frontier.poll();
			frontier.add(original);
			int city = original.current;
			
			//checking for edges with the current node
			for(int i = 0; i < 13; i++)
			{
				//if an edge with the current node exists
				if(edge(city,i) == true)
				{
					//create a node with the new city
					Node node = new Node();
					node.current = i;
					node.previous = original;
					node.cost = original.cost + gva[city][i];
					
					//find where in the frontier (priority queue) it belongs
					for(int y = 0; y < frontier.size(); y++)
					{
						if(H(node.current,c2) + node.cost < H(frontier.get(y).current,c2) + frontier.get(y).cost)
						{
							frontier.add(y, node);
							if(node.current == c2)
							{
								return path(node);
							}
							break;
						}
					}
					if(frontier.contains(node) == false)
					{
						frontier.add(node);
					}
				}
			}
			//remove original node
			frontier.remove(original);
		}
		//if no solution is possible
		System.out.println("no solution is possible.");
		return null;
	}
	
	//unimplemented Grassfire algorithm
	static LinkedList<Integer> grassfire(int c1, int c2) {
		return null;
			
	}
	
	//unimplemented Dijsktra
	static LinkedList<Integer> dijsktra(int c1, int c2) {
		return null;
		
	}
	
	//method creating the solution path
	static LinkedList<Integer> path(Node node) {
		
		LinkedList<Integer> solution = new LinkedList<Integer>();
		while(node.previous != null)
		{
			solution.add(node.current);
			node = node.previous;
		}
		solution.add(node.current);
		return solution;
	}
	
	//heuristic function X-Y
	static int H(int c1,int c2) {
		
		int x = X(c1,c2);
		int y = Y();
		return x-y;
	}
	
	//X function grabbing the minimal distance between city halls from gva
	static int X(int c1, int c2) {
		return gva[c1][c2];
	}
	
	//Y function returns a value from 5 to 10
	static int Y() {
		
		Random rand = new Random();
		int random = rand.nextInt(5,11);
		return random;
	}
}
