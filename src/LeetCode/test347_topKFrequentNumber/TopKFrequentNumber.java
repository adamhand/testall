package LeetCode.test347_topKFrequentNumber;

import java.util.*;

public class TopKFrequentNumber {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length <= 0)
            return new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i] ,map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }

        for(Integer key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null)
                bucket[freq] = new ArrayList<>();  //用出现的频率作为数组下标，这样出现次数多的就在后面。
                                                   // 有可能出现次数重复，出现次数重复的书都放在一个list里面

            bucket[freq].add(key);
        }

        //从后向前找即可
        for(int i = bucket.length - 1; i >= 0 && k > list.size(); i--)
            if(bucket[i] != null)
                list.addAll(bucket[i]);

        return list;
    }
}
