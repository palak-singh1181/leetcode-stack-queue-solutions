import java.util.*;

public class Shift2DGrid {

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k %= total;

        int[][] shifted = new int[m][n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int newIndex = (i * n + j + k) % total;

                int newRow = newIndex / n;
                int newCol = newIndex % n;

                shifted[newRow][newCol] = grid[i][j];
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(shifted[i][j]);
            }

            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int k = 1;

        System.out.println("Original Grid:");

        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("\nShifted Grid:");

        List<List<Integer>> ans = shiftGrid(grid, k);

        for (List<Integer> row : ans) {
            System.out.println(row);
        }
    }
}