package Week4;

import java.util.ArrayList;

public class CourseSchedule {
  
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    ArrayList<Integer>[] Graph = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; i++) {
      Graph[i] = new ArrayList<>();
    }
    int[] inDegree = new int[numCourses];
    ArrayList<Integer> bfs = new ArrayList<>();

    for (int[] e : prerequisites) {
      Graph[e[1]].add(e[0]);
      inDegree[e[0]]++;
    }

    for (int vertex = 0; vertex < numCourses; vertex++)
      if (inDegree[vertex] == 0)
        bfs.add(vertex);
    
    for (int vertex=0; vertex<bfs.size(); vertex++) {
      for (int children : Graph[bfs.get(vertex)]) {
        if (--inDegree[children] == 0)
          // then child has only vertex as its parent and no other dependencies
          bfs.add(children);
      }
    }

    return bfs.size() == numCourses;
  }

  public static void main(String[] args) {
    CourseSchedule obj = new CourseSchedule();
    System.out.println(obj.canFinish(2, new int[][]{{1,0}}));
  }
}
