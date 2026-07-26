import java.util.*;

public class MinCostClimbingStairs {


    public static int minCost(int n, int[] costs) {


        int[] dp = new int[n + 1];


        Arrays.fill(dp, Integer.MAX_VALUE);


        dp[0] = 0;



        for (int i = 1; i <= n; i++) {


            int cost = costs[i - 1];



            // Jump from i-1
            if (i - 1 >= 0) {

                dp[i] = Math.min(
                    dp[i],
                    dp[i - 1] + cost + 1
                );
            }



            // Jump from i-2
            if (i - 2 >= 0) {

                dp[i] = Math.min(
                    dp[i],
                    dp[i - 2] + cost + 4
                );
            }



            // Jump from i-3
            if (i - 3 >= 0) {

                dp[i] = Math.min(
                    dp[i],
                    dp[i - 3] + cost + 9
                );
            }
        }



        return dp[n];
    }



    public static void main(String[] args) {


        // Test Case 1

        int n1 = 4;

        int[] costs1 = {1,2,3,4};


        System.out.println(minCost(n1, costs1));
        // Output: 13




        // Test Case 2

        int n2 = 4;

        int[] costs2 = {5,1,6,2};


        System.out.println(minCost(n2, costs2));
        // Output: 11




        // Test Case 3

        int n3 = 3;

        int[] costs3 = {9,8,3};


        System.out.println(minCost(n3, costs3));
        // Output: 12
    }
}