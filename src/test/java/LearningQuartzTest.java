import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class LearningQuartzTest {

  @Test
  @Timeout(7)
  void testCronScheduler() throws Exception {
    LearningQuartz target = new LearningQuartz();
    target.cronScheduler();
    Thread.sleep(5000);
    target.shutdown();
  }

}