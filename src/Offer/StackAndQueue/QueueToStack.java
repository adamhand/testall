package Offer.StackAndQueue;

import java.util.LinkedList;

public class QueueToStack {
    private LinkedList<Integer> queue1 = new LinkedList<>();
    private LinkedList<Integer> queue2 = new LinkedList<>();

    public void add(int elem) {
        if (!queue1.isEmpty()) {
            queue1.add(elem);
        } else {
            queue2.add(elem);
        }
    }

    public int poll() {
        if (!queue1.isEmpty()) {
            int size = queue1.size();
            while (size > 1) {
                queue2.addFirst(queue1.pollFirst());
                size--;
            }
            return queue1.pollFirst();
        } else if (!queue2.isEmpty()) {
            int size = queue2.size();
            while (size > 1) {
                queue1.addFirst(queue2.pollFirst());
                size--;
            }
            return queue2.pollFirst();
        } else {
            return -1;
        }
    }

    public int size() {
        return queue1.isEmpty() ? queue2.size() : queue1.size();
    }

    public static void main(String[] args) {
        QueueToStack qts = new QueueToStack();

        qts.add(1);
        qts.add(2);
        qts.add(3);

        System.out.println(qts.poll());

        qts.add(4);
        qts.add(5);

        System.out.println(qts.poll());
    }
}
