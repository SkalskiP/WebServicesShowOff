package schedul;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;

@Startup
@Singleton
public class ProgrammaticAtFixedRateTimerBean {

    @Resource
    TimerService timerService;

    @PostConstruct
    public void initialize() {
        timerService.createTimer(0,1000, "Every second timer with no delay");
    }

    @Timeout
    public void programmaticTimout(Timer timer) {
        //TODO
        System.out.println("LOL");
    }
}
