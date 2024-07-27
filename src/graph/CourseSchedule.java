package graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][] {{1, 0}, {0, 1}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] prer : prerequisites) {
            adjList.get(prer[1]).add(prer[0]);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (isCyclic(adjList, visited, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isCyclic(List<List<Integer>> courses, int[] visited, int curr) {
        if (visited[curr] == 2)
            return true;
        if (visited[curr] == 1)
            return false;

        visited[curr] = 2;

        for (Integer course : courses.get(curr)) {
            if (isCyclic(courses, visited, course)) {
                return true;
            }
        }
        visited[curr] = 1;

        return false;
    }
}
