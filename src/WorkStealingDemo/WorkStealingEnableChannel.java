package WorkStealingDemo;

import java.nio.channels.Channel;
import java.util.concurrent.BlockingDeque;

public interface WorkStealingEnableChannel<P> extends Channel {
    P take(BlockingDeque<P> preferredQueue) throws InterruptedException;
}