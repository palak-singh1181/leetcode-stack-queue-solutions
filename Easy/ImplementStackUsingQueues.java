/*
LeetCode 225
Implement Stack using Queues

Time Complexity:
Push : O(n)
Pop  : O(1)
Top  : O(1)
Empty: O(1)

Space Complexity: O(n)
*/

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    private Queue<Integer> queue;

    public ImplementStackUsingQueues() {
        queue = new LinkedList<>();
    }

    public void push(int x) {

        queue.offer(x);

        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {

        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();

        stack.push(1);
        stack.push(2);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}