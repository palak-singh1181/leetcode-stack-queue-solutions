
import java.util.Stack;

public class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {

        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.pop();
    }

    public int peek() {

        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);

        System.out.println("Peek: " + queue.peek());

        System.out.println("Pop: " + queue.pop());

        System.out.println("Is Empty: " + queue.empty());

        queue.push(3);

        System.out.println("Peek: " + queue.peek());

        System.out.println("Pop: " + queue.pop());

        System.out.println("Pop: " + queue.pop());

        System.out.println("Is Empty: " + queue.empty());
    }
}