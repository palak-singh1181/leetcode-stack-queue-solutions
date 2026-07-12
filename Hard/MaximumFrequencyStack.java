
/*
LeetCode 895
Maximum Frequency Stack

Time Complexity:
Push : O(1)
Pop  : O(1)

Space Complexity: O(n)
*/

import java.util.*;

public class MaximumFrequencyStack {

    private Map<Integer, Integer> frequency;
    private Map<Integer, Stack<Integer>> group;
    private int maxFreq;

    public MaximumFrequencyStack() {
        frequency = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {

        int freq = frequency.getOrDefault(val, 0) + 1;
        frequency.put(val, freq);

        if (freq > maxFreq) {
            maxFreq = freq;
        }

        group.computeIfAbsent(freq, k -> new Stack<>()).push(val);
    }

    public int pop() {

        int val = group.get(maxFreq).pop();

        frequency.put(val, frequency.get(val) - 1);

        if (group.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return val;
    }

    public static void main(String[] args) {

        MaximumFrequencyStack stack = new MaximumFrequencyStack();

        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}