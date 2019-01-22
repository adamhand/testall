package LeetCode.test118_PascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triggle = new ArrayList<>();

        if(numRows == 0)
            return triggle;

        triggle.add(new ArrayList<Integer>());
        triggle.get(0).add(1);

        for(int rowNum = 1; rowNum < numRows; rowNum++){
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triggle.get(rowNum - 1);
            row.add(1);

            for(int i = 1; i < rowNum; i++){
                row.add(preRow.get(i - 1) + preRow.get(i));
            }

            row.add(1);

            triggle.add(row);
        }

        return triggle;
    }
}
