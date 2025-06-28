import org.junit.jupiter.api.Test;

public class StrategyTest {

    @Test
    public void testSimplePrintStrategyDoesNotThrow() {
        PrintStrategy strategy = new SimplePrintStrategy();
        Category testCategory = new Category("Test");
        strategy.print(testCategory); // should not throw
    }
}
