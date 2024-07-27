package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class CourseScheduleII {
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(findOrder(4, prerequisites)));
    }


    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // Topological Sort
        List<List<Integer>> adj = new ArrayList<>();
        int[] visited = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prer : prerequisites) {
            adj.get(prer[1]).add(prer[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && isCyclic(adj, visited, stack, i)) {
                return new int[0];
            }
        }

        int i = 0;
        while (!stack.empty()) {
            topologicalOrder[i++] = stack.pop();
        }
        return topologicalOrder;
    }

    private static boolean isCyclic(List<List<Integer>> adj, int[] visited, Stack<Integer> stack,
            int curr) {
        if (visited[curr] == 2)
            return false;
        if (visited[curr] == 1)
            return true;
        visited[curr] = 1;
        for (Integer neighbor : adj.get(curr)) {
            if (isCyclic(adj, visited, stack, neighbor))
                return true;
        }
        visited[curr] = 2;
        stack.add(curr);
        return false;
    }

    public static int[] findOrderLowRank(int numCourses, int[][] prerequisites) {
        // topological sort + DFS
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        // 0 represents the first prerequisite
        int[] indegree = new int[numCourses];
        int[] toplogicalOrder = new int[numCourses];

        for (int[] prep : prerequisites) {
            int post = prep[0];
            int pre = prep[1];
            List<Integer> list = adjList.getOrDefault(pre, new ArrayList<>());
            list.add(post);
            adjList.put(pre, list);
            // count how many prereprisies need before start post course
            indegree[post] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            toplogicalOrder[i++] = node;

            if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0)
                        queue.add(neighbor);
                }
            }
        }

        if (i == numCourses)
            return toplogicalOrder;

        return new int[0];
    }
}
