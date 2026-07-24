
import java.util.*;

public class FindEventualSafeStates {

    public static List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        List<List<Integer>> reverse = new ArrayList<>();
        for (int i = 0; i < n; i++)
            reverse.add(new ArrayList<>());

        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {

            indegree[i] = graph[i].length;

            for (int next : graph[i]) {
                reverse.get(next).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {

            int node = queue.poll();
            ans.add(node);

            for (int prev : reverse.get(node)) {

                indegree[prev]--;

                if (indegree[prev] == 0) {
                    queue.offer(prev);
                }
            }
        }

        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {

        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        System.out.println("Safe Nodes: " + eventualSafeNodes(graph));
    }
}