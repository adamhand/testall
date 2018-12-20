package Collection.LinkedList.LinkedListStack;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;
import java.util.WeakHashMap;

/**
 * 用LinkedList模拟一个堆栈
 */
class StackSim
{
    private LinkedList linkedList = new LinkedList();

    public void myAdd(Object obj)
    {
        linkedList.addLast(obj);
    }

    public Object myGet()
    {
        return linkedList.removeLast();
    }

    public boolean isEmpty()
    {
        return linkedList.isEmpty();
    }
}

public class LinkedListStack {
    public static void main(String[] args) {
        StackSim stackSim = new StackSim();

        for(int i = 0; i < 4; i++)
        {
            stackSim.myAdd("hahaha"+i);
        }

        while(! stackSim.isEmpty())
        {
            System.out.println(stackSim.myGet());
        }
    }
}