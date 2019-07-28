package Offer.StackAndQueue;

import java.util.Stack;

// 使用两个栈实现队列
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int elem) {
        stack1.push(elem);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StackToQueue stq = new StackToQueue();

        stq.push(1);
        stq.push(2);
        stq.push(3);
        stq.push(4);

        System.out.println(stq.pop());
        System.out.println(stq.pop());
    }
}
