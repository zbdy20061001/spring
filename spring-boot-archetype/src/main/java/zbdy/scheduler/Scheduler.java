package zbdy.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

//@Component
public class Scheduler {
	@Scheduled(cron = "0 * 20 * * ?")
	public void cronJobSch() {
		System.out.println(
				"Java cron job expression:: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
	}

	//固定速率调度程序用于在特定时间执行任务。它不等待前一个任务的完成
	@Scheduled(fixedRate = 1000)
	public void fixedRateSch() {
		System.out.println(
				"Fixed Rate scheduler:: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
	}
	//固定延迟调度程序用于在特定时间执行任务。 它应该等待上一个任务完成。
	//这里，initialDelay是在初始延迟值之后第一次执行任务的时间。
	//从应用程序启动完成3秒后每秒执行一次任务的示例如下所示
	@Scheduled(fixedDelay = 1000, initialDelay = 3000)
	public void fixedDelaySch() {
		System.out.println(
				"Fixed Delay scheduler:: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
	}
}
