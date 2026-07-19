import java.util.*;

public class RangeFreqQuery {

    private Map<Integer, List<Integer>> map;

    public RangeFreqQuery(int[] arr) {

        map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int value) {

        if (!map.containsKey(value))
            return 0;

        List<Integer> list = map.get(value);

        int leftIndex = lowerBound(list, left);
        int rightIndex = upperBound(list, right);

        return rightIndex - leftIndex;
    }

    private int lowerBound(List<Integer> list, int target) {

        int low = 0;
        int high = list.size();

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid) < target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    private int upperBound(List<Integer> list, int target) {

        int low = 0;
        int high = list.size();

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid) <= target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    public static void main(String[] args) {

        int[] arr = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};

        RangeFreqQuery obj = new RangeFreqQuery(arr);

        System.out.println("Array: " + Arrays.toString(arr));

        System.out.println("Query(1, 2, 4) = " + obj.query(1, 2, 4));

        System.out.println("Query(0, 11, 33) = " + obj.query(0, 11, 33));

        System.out.println("Query(4, 10, 22) = " + obj.query(4, 10, 22));
    }
}