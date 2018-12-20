package LeetCode.test412_FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class fizzBuzz {
    public List<String> fizzBuzz(int n) {
        if(n <= 0)
            return new ArrayList<>();

        List<String> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0)
                list.add("FizzBuzz");
            else if(i % 3 == 0)
                list.add("Fizz");
            else if(i % 5 == 0)
                list.add("Buzz");
            else
                list.add(String.valueOf(i));
        }

        return list;
    }

    public static void main(String[] args) {
        List list = new fizzBuzz().fizzBuzz(15);

        System.out.println(list.toString());
    }
}
