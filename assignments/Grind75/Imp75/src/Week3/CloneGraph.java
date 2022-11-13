package Week3;

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public class CloneGraph {

    private void dfsAddition(Node org, Node cpy, Node[] isVisited) {
        isVisited[cpy.val] = cpy;

        // access the children
        for (Node child : org.neighbors) {
            if (isVisited[child.val] == null) {
                Node temp = new Node(child.val);
                cpy.neighbors.add(temp);
                dfsAddition(child, temp, isVisited);
            } else {
                cpy.neighbors.add(isVisited[child.val]);
            }
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Node ret = new Node(node.val);
        Node[] isVisited = new Node[101]; // for keeping the record as same node can be connected to multiple vertices
        // have a hard coded length as its mentioned as constrain in the problem
        dfsAddition(node, ret, isVisited);

        return ret;
    }
}
