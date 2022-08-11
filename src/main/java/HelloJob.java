import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class HelloJob implements Job {

  @Override
  public void execute(JobExecutionContext context) {
    String name = context.getJobDetail().getJobDataMap().getString("YouName");
    System.out.println("hello " + name);
  }

}
