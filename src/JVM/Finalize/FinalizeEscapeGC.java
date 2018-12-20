package JVM.Finalize;

/**
 * 下面的代码演示了两点：
 * 1. 对象可以在GC时自我拯救
 * 2. 这种自救的机会只有一次，因为一个对象的finalize()方法最多只能被系统自动调用一次
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes, i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        //自救，把自己(this关键字)赋值给一个类变量
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次进行自救
        SAVE_HOOK = null;
        System.gc();
        //因为finalize()方法优先级很低，暂停0.5s等待
        Thread.sleep(500);
        if(SAVE_HOOK != null)
            SAVE_HOOK.isAlive();
        else
            System.out.println("no, i am dead :(");

        //与上面的代码相同，但是自救失败，因为finalize()方法只能被系统自动调用一次
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK != null)
            SAVE_HOOK.isAlive();
        else
            System.out.println("no, i am dead :(");
    }
}

