package LeetCode.test452_MinimumNumber;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumber {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0)
            return 0;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //count记录的是不重叠的区间的个数
        int count = 1;
        int end = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(end >= points[i][0])
                continue;
            count++;
            end = points[i][1];
        }
        return count;
    }
}
