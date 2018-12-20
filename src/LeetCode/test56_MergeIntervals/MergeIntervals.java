package LeetCode.test56_MergeIntervals;

import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

//有点像贪心算法
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                //return o1.start <= o2.start ? 0 : 1;    //这样写哪里不对？？？
                return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
            }
        });

        LinkedList<Interval> linkedList = new LinkedList<>();
        for(Interval interval : intervals){
            if(linkedList.isEmpty() || linkedList.getLast().end < interval.start)
                linkedList.add(interval);
            else
                linkedList.getLast().end = Math.max(linkedList.getLast().end, interval.end);
        }
        return linkedList;
    }
}
