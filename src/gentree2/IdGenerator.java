import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static final AtomicLong idCounter = new AtomicLong(1);

    public static long generateId() {
        return idCounter.getAndIncrement();
    }
}