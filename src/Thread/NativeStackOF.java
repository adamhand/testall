package Thread;

public class NativeStackOF {
    /**
     * VM Args: - Xss128k
     */
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) throws Throwable {
        NativeStackOF oom = new NativeStackOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
