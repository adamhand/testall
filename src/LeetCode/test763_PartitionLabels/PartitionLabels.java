package LeetCode.test763_PartitionLabels;

import java.util.ArrayList;
import java.util.List;
//最主要的是找到字符串中的字符最后一次出现的位置。
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0)
            return null;

        //存放字符串中的字符最后一次出现的位置。
        int[] lastIndexOfChar = new int[26];
        char[] chars = S.toCharArray();
        for(int i = 0; i < chars.length; i++)
            lastIndexOfChar[charToIndex(chars[i])] = i;

        List<Integer> list = new ArrayList<>();
        int leftInx = 0;
        while(leftInx < chars.length){
            int rightInx = leftInx;
            for(int i = leftInx; i < chars.length && i <= rightInx; i++){
                int curInx = lastIndexOfChar[charToIndex(chars[i])];
                if(curInx > rightInx)
                    rightInx = curInx;
            }
            list.add(rightInx - leftInx + 1);
            leftInx = rightInx + 1;
        }
        return list;
    }

    private int charToIndex(char ch){
        return ch - 'a';
    }
}
