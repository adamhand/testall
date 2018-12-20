package Collection.LinkedList.LinkedListQueue;

import java.util.LinkedList;

/**
 * 用LinkedList模拟一个队列
 */
class QueueSim
{
    private LinkedList linkedList = new LinkedList();

    public void myAdd(Object obj)
    {
        linkedList.addLast(obj);
    }

    public Object myGet()
    {
        return linkedList.removeFirst();
    }

    public boolean isEmpty()
    {
        return linkedList.isEmpty();
    }
}
public class LinkedListQueue {
    public static void main(String[] args) {
        QueueSim queueSim = new QueueSim();

        for(int i = 0; i < 4; i++)
        {
            queueSim.myAdd("hahaha"+ i);
        }

        while(! queueSim.isEmpty())
        {
            System.out.println(queueSim.myGet());
        }
    }
}
