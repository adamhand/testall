package DataStructureAndAlgorithm.HashTableManual;

public class Main {
    public static void main(String[] args) {
        HashTableM<String, Integer> hashTableM = new HashTableM<>(3);
        hashTableM.put("1", 1);
        hashTableM.put("2", 2);
        hashTableM.put("3", 3);
        hashTableM.put(null, 4);

        System.out.println(hashTableM.get("1")+" "+hashTableM.get("2")+" "+hashTableM.get("3")+" "+hashTableM.get(null));
    }
}
