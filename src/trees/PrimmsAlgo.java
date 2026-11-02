package trees;
import java.util.*;

//import Project3.ourEdgeNode;

public class PrimmsAlgo {
	// internal class, which is used to create a node in the grade list representation
    private static class ourEdgeNode {
        int ID;
        int weigh;
        int fromID;

        public ourEdgeNode(int ID, int weigh, int fromID) {
        	this.fromID = fromID;
        	this.ID = ID;
            this.weigh = weigh;
            
        }
        
        public int getID() { return ID; }
        
        public int getWeigh() { return weigh; }
        
        public int getFromID() { return fromID; }
    }
    
    public static void ourPutEdgesToDB(LinkedList<ourEdgeNode> edges,
    									LinkedList<ourEdgeNode> DB, 
    									ArrayList<Integer> set) {
	
    	for (ourEdgeNode edge : edges) {
    		if (!set.contains(edge)) {
                DB.addLast(edge);
    		}
    	} 	
    	// Sort DB by weight
        Collections.sort(DB, new Comparator<ourEdgeNode>() {
            @Override
            public int compare(ourEdgeNode e1, ourEdgeNode e2) {
                return Integer.compare(e1.weigh, e2.weigh);
            }
        });
    }

	private static ourEdgeNode ourExtractMinFromDB(LinkedList<ourEdgeNode> DB,
													ArrayList<Integer> set) {
    	
    	ourEdgeNode edge = null;
    	for (int i = 0; i < DB.size(); i++) {
    		edge = DB.get(i);
    		if (!set.contains(edge.ID)) {
    			DB.remove(i);
    			return edge;
    		}
    	}
    	return edge;
    }

    public static void main(String[] args) {

    	// array list for the graph
    	ArrayList<LinkedList<ourEdgeNode>> ourVertexNode = new ArrayList<>(7);
		for(int i = 0; i < 7; ++i) {
			ourVertexNode.add(new LinkedList<ourEdgeNode>());
		}

		// from the view of vertex A
		LinkedList<ourEdgeNode> tmp = ourVertexNode.get(0);
		tmp.addLast(new ourEdgeNode(1, 3, 0));
		tmp.addLast(new ourEdgeNode(3, 8, 0));
		tmp.addLast(new ourEdgeNode(2, 5, 0));

		// from the view of vertex B
		tmp = ourVertexNode.get(1);
		tmp.addLast(new ourEdgeNode(0, 3, 1));
		tmp.addLast(new ourEdgeNode(4, 9, 1));
		tmp.addLast(new ourEdgeNode(6, 7, 1));

		// from the view of vertex C
		tmp = ourVertexNode.get(2);
		tmp.addLast(new ourEdgeNode(0, 5, 2));
		tmp.addLast(new ourEdgeNode(5, 1, 2));

		// from the view of vertex D
		tmp = ourVertexNode.get(3);
		tmp.addLast(new ourEdgeNode(0, 8, 3));
		tmp.addLast(new ourEdgeNode(5, 4, 3));
		tmp.addLast(new ourEdgeNode(6, 10, 3));

		// from the view of vertex E
		tmp = ourVertexNode.get(4);
		tmp.addLast(new ourEdgeNode(1, 9, 4));
		tmp.addLast(new ourEdgeNode(6, 2, 4));

		// from the view of vertex F
		tmp = ourVertexNode.get(5);
		tmp.addLast(new ourEdgeNode(6, 6, 5));
		tmp.addLast(new ourEdgeNode(3, 4, 5));
		tmp.addLast(new ourEdgeNode(2, 1, 5));

		// from the view of vertex g
		tmp = ourVertexNode.get(6);
		tmp.addLast(new ourEdgeNode(4, 2, 6));
		tmp.addLast(new ourEdgeNode(3, 10, 6));
		tmp.addLast(new ourEdgeNode(5, 6, 6));
		tmp.addLast(new ourEdgeNode(1, 7, 6));
		
		
		//begin algorithm 
		
    	//total number of vertices 
    	int numNodes = 7;;
    	// set list, keep track of visited nodes
    	ArrayList<Integer> set = new ArrayList<>();
    	// the MST solution set
		LinkedList<ourEdgeNode> MST = new LinkedList<>();
		// the database of visited edges
		LinkedList<ourEdgeNode> DB = new LinkedList<>();
		
		//start of prims algorithm
		set.add(0);		
		MST.add(tmp.get(0)); 
		ourPutEdgesToDB(ourVertexNode.get(0), DB, set);

		// prims algorithm while loop
		while (set.size() != numNodes) {
			ourEdgeNode edge = ourExtractMinFromDB(DB, set);
			MST.addLast(edge);
			set.add(edge.ID);
			ourPutEdgesToDB(ourVertexNode.get(edge.ID), DB, set);
		}
		// print the MST
      for (int i = 1; i < 7; i++) {
    	  System.out.printf("From node %c to node %c with weight %d \n", 
    			  (char)('A' + MST.get(i).getFromID()),
    			  (char)('A' + MST.get(i).getID()), 
    			  (MST.get(i).getWeigh())); 
      } 
    }

}
