public class DecodeWays {

    public static int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;

        for (int i = 2; i <= n; i++) {

            int oneDigit = s.charAt(i - 1) - '0';

            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }

            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        System.out.println(numDecodings("12"));    // 2
        System.out.println(numDecodings("226"));   // 3
        System.out.println(numDecodings("06"));    // 0
    }
}