package JVM.GetAllStackTracesTest;

import java.util.Map;

public class Test {
    public static void main(String[] args) {
        outTraces();
    }

    public static void outTraces(){
        for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()){
            Thread thread = (Thread) stackTrace.getKey();
            StackTraceElement[] stack = (StackTraceElement[]) stackTrace.getValue();
            if(thread.equals(Thread.currentThread())){
                continue;
            }
            System.out.println("线程： "+ thread.getName());
            System.out.println();
            for (StackTraceElement element : stack){
                System.out.println(element);
            }
        }
    }
}
