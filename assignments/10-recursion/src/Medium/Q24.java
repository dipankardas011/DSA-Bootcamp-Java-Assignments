package Medium;

import java.util.ArrayList;
import java.util.List;

public class Q24 {

    private void DFStraversal(int[][] graph, int vertice,
                              List<Integer> currStack, List<List<Integer>> out) {
        if (vertice == graph.length-1) {
            out.add(new ArrayList<>(currStack));
            return;
        }

        for (int edgesOfVertice : graph[vertice]) {
            currStack.add(edgesOfVertice);
            DFStraversal(graph, edgesOfVertice, currStack, out);
            currStack.remove(currStack.size()-1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        DFStraversal(graph, 0, temp, res);
        return res;
    }
}