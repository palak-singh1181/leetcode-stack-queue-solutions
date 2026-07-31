import java.util.*;

public class StableMountains {

    public static List<Integer> stableMountains(int[] height, int threshold) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] height = {1, 2, 3, 4, 5};
        int threshold = 2;

        System.out.println(stableMountains(height, threshold)); // [3, 4]
    }
}