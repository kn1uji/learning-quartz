import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class LearningQuartz {

  private final Scheduler scheduler;

  public LearningQuartz() throws SchedulerException {
    scheduler = StdSchedulerFactory.getDefaultScheduler();
  }

  public void shutdown() throws SchedulerException {
    scheduler.shutdown();
  }

  public void cronScheduler() throws SchedulerException {

    scheduler.start();

    JobDetail job = JobBuilder
        .newJob(HelloJob.class)
        .withIdentity("HelloJob")
        .usingJobData("YouName", "Tarou")
        .build();

    Trigger trigger = TriggerBuilder
        .newTrigger()
        .withSchedule(
            CronScheduleBuilder.cronSchedule("*/1 * * * * ?")
        )
        .build();

    scheduler.scheduleJob(job, trigger);
  }

}
