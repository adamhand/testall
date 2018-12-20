package Collection.LinkedHashSet;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 输出顺序和输入顺序一致
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
//        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>(16, 0.75f);

        linkedHashSet.add("hahahah");
        linkedHashSet.add("hehaee");
        linkedHashSet.add("haeieieieieie");
        linkedHashSet.add("aafdfd");
        linkedHashSet.add("bfdhfjd");

        Iterator<String> iterator = linkedHashSet.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}
