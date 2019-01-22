package Generic.ObjectAndT;

class Meat{
    private float weight; //肉的重量
}

class Soup{
    private String category; //汤的种类
}

//微波炉
public class Stove {
//    public static Object heat(Object food){
//        System.out.println(food +"is done");
//        return food;
//    }
//
//    public static void Main(String[] args) {
//        Meat meat = new Meat();
//        meat = (Meat) Stove.heat(meat);
//
//        Soup soup = new Soup();
//        soup = (Soup) Stove.heat(soup);
//    }

    public static <T> T heat(T food){
        System.out.println(food +"is done");
        return food;
    }

    public static void main(String[] args) {
        Meat meat = new Meat();
        meat = Stove.heat(meat);

        Soup soup = new Soup();
        soup = Stove.heat(soup);
    }
}
