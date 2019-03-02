package DHTDemo;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 一致性哈希，不带虚拟节点
 */
public class DHTDemo1 {
    /**
     * 待添加入Hash环的服务器列表
     */
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};

    /**
     * 默认升序
     */
    private static SortedMap<Integer, String> treeMap = new TreeMap<>();

    static {
        for (int i = 0; i < servers.length; i++){
            int hash = getHash(servers[i]);
            treeMap.put(hash, servers[i]);
            System.out.println("server "+i+" add to server collections, its hash is "+hash);
        }
    }

    private static String getServer(String node){
        int hash = getHash(node);
        SortedMap<Integer, String> subMap = treeMap.tailMap(hash);

        if (subMap.isEmpty()){
            return treeMap.get(treeMap.firstKey());  //如果没有比该key的hash值大的，则从第一个node开始返回
        }else {
            return subMap.get(subMap.firstKey());  //否则返回子map中的第一个服务器
        }
    }


    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
     */
    private static int getHash(String str)
    {
        final int p = 16777619;
        int hash = (int)2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    public static void main(String[] args) {
        String[] keys = {"太阳", "月亮", "星星"};
        for(int i=0; i<keys.length; i++)
            System.out.println("[" + keys[i] + "]的hash值为" + getHash(keys[i])
                    + ", 被路由到结点[" + getServer(keys[i]) + "]");
    }
}
