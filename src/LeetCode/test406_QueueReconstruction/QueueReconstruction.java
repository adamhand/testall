package LeetCode.test406_QueueReconstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            //compare如果返回一个大于零的数，说明第一个数比第二个数大，sort就会把两个数交换；如果小于零或者等于零，sort不做处理。
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        for(int[] p : people)
            list.add(p[1], p);   //list.add(index, e)，如果index相同，会将之前的元素后移

        return list.toArray(new int[list.size()][]);
    }
}
