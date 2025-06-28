import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.atomic.AtomicBoolean;

public class NotificationCenterTest {

    @Test
    public void testObserverReceivesNotification() {
        NotificationCenter center = new NotificationCenter();
        AtomicBoolean notified = new AtomicBoolean(false);

        Observer testObserver = message -> notified.set(true);
        center.registerObserver(testObserver);
        center.notifyObservers("Hello");

        assertTrue(notified.get(), "Observer should be notified");
    }
}
