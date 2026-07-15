
import java.util.*;

public class BuildArrayWithStackOperations {

    public static List<String> buildArray(int[] target, int n) {

        List<String> ans = new ArrayList<>();

        int index = 0;

        for (int num = 1; num <= n && index < target.length; num++) {

            ans.add("Push");

            if (num == target[index]) {
                index++;
            } else {
                ans.add("Pop");
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] target = {1, 3};
        int n = 3;

        System.out.println(buildArray(target, n));
    }
}