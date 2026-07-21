
import java.util.Arrays;

public class FindSmallestStableIndex {

    public static int smallestStableIndex(int[] nums, int k) {

        int n = nums.length;

        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int prefixMax = nums[0];

        for (int i = 0; i < n; i++) {

            prefixMax = Math.max(prefixMax, nums[i]);

            if (prefixMax - suffixMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {5, 0, 1, 4};
        int k = 3;

        System.out.println("Array : " + Arrays.toString(nums));
        System.out.println("k = " + k);

        int ans = smallestStableIndex(nums, k);

        System.out.println("Smallest Stable Index = " + ans);
    }
}