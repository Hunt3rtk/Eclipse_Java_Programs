import java.util.ArrayList;

/*
 * A class representing a Graph as an adjacency matrix,
 * and providing search functions for the Graph.
 */

/*
 * Student 1 Name: Hunter Klassen
 * Student 1 Number: 300174049
 * 
 * Student 2 Name:
 * Student 2 Number:
 * 
 */

public class Graph
{

	
    boolean[][] adjMat;  

    // In the adjacency matrix representation of a Graph,
    // if adjMat[i][j] == true, then you can move from 
    // node i to node j.
    // i.e. j is a neighbour of i.
    
    // The constructor builds the adjacency matrix,
    // with initially all values false.
    public Graph(int size)
    {
        adjMat = new boolean[size][size];
        for (int i=0; i < adjMat.length; i++)
        {
            for (int j=0; j < adjMat.length; j++)
            {
                adjMat[i][j] = false;
            }
        }     
    }

    // Add a transition to the adjacency matrix,
    // i.e. a neighbour relation between two nodes.
    public void add(int from, int to)
    {
        adjMat[from][to] = true;
    }

    // Carry out uninformed search of the Graph,
    // from the start node to goal node.
    public boolean search(int start, int goal, int size, boolean dp)
    {
    	// The frontier is an ArrayList of Paths.
        ArrayList<Path> frontier = new ArrayList<Path>();
        
        // Initially the frontier contains just the Path
        // containing only the start node.
        Path firstPath = new Path(start);        
        frontier.add(firstPath);
        
        
        
        
         // CARRY OUT DEPTH-FIRST OR BREADTH-FIRST SEARCH
        
        if(dp == true)
        {
        	for(int j = 0; j < size; j++)
        	{
        		// Search until the goal is found,
                // or the frontier is empty.
        		 while (! frontier.isEmpty())
        	     {
        			 depthfirstSearch( goal, frontier);
        	     }
        	}
        }
        
        for(int j = 0; j < size; j++)
    	{
        	// Search until the goal is found,
            // or the frontier is empty.
        	while (! frontier.isEmpty())
   	     	{
        		breadthfirstSearch( goal, frontier);
   	     	}
    	}
  	
        return false;
    }

    private boolean breadthfirstSearch( int goal, ArrayList<Path> frontier) {
    	
    	// set current node to be explored
    	// remove it from frontier
    	Path current = frontier.get(0);
    	frontier.remove(0);
    	System.out.println("Inspect node " + current.getLastNode());
    	
    	// check if current node is linked to any of the other nodes
		for(int i = 0; i < adjMat.length; i++ )
		{
				// linked to goal node
				if(adjMat[current.getLastNode()][i] == true && i == goal)
				{
					System.out.println("Inspect node " + i);
					System.out.println("Goal node Found!");
					Path edge = new Path(current, i);
					frontier.add(edge);
					System.out.println(frontier.get(frontier.size()-1).toString());
					frontier.clear();
					return true;
				}
				
				// linked but not goal node
				if(adjMat[current.getLastNode()][i] == true)
				{
					Path edge = new Path(current, i);
					frontier.add(edge);
				}
		}
    	
    	return true;
    	
	}

	private boolean depthfirstSearch( int goal, ArrayList<Path> frontier) {
		
		// set current node to be explored
    	// remove it from frontier
		Path current = frontier.get(frontier.size()-1);
    	frontier.remove(frontier.size()-1);
    	System.out.println("Inspect node " + current.getLastNode());
    	
    	// check if current node is linked to any of the other nodes
		for(int i = 0; i < adjMat.length; i++ )
		{
				// linked to goal node
				if(adjMat[current.getLastNode()][i] == true && i == goal)
				{
					System.out.println("Inspect node " + i);
					System.out.println("Goal node Found!");
					Path edge = new Path(current, i);
					frontier.add(edge);
					System.out.println(frontier.get(frontier.size()-1).toString());
					frontier.clear();
					return true;
				}
				
				// linked but not goal node
				if(adjMat[current.getLastNode()][i] == true)
				{
					Path edge = new Path(current, i);
					frontier.add(edge);
				}
		}
		
		return true;
		
	}

	public static void main(String[] args)
    {
    	// Create a Graph containing 7 nodes
        Graph g = new Graph(7);
        
        // Add edges to the Graph
        g.add(0, 1);
        g.add(0, 2);
        g.add(1,5);
        g.add(1,6);
        g.add(2, 3);
        g.add(3, 4);
        
        // select a search type
        boolean depthFirst = true;
        
        // start searching
        g.search(0,4,7,depthFirst);
    }
}