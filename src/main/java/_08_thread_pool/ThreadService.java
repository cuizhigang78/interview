package _08_thread_pool;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadService
 * @Author Maxwell
 * @Date 2021/9/8 23:26
 * @Description ThreadService
 * @Version 1.0
 */
@Component
public class ThreadService {

    @Async("taskExecutor")
    public void updateArticleViewCount() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
