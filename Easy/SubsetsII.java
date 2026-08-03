
import java.util.*;

public class SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    private static void backtrack(int index, int[] nums, List<Integer> curr, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(curr));

        for (int i = index; i < nums.length; i++) {

            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            curr.add(nums[i]);
            backtrack(i + 1, nums, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2};

        List<List<Integer>> result = subsetsWithDup(nums);

        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}