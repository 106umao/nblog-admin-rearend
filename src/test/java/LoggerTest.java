import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
    @Test
    public void loggerTest() {
        Logger logger = LoggerFactory.getLogger(LoggerTest.class);
        logger.error("test");
    }
}
