package _08_thread_pool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @ClassName ThreadPoolConfig
 * @Author Maxwell
 * @Date 2021/9/8 23:27
 * @Description ThreadPoolConfig
 * @Version 1.0
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Bean("taskExecutor")
    public Executor asyncServiceExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(5);
        // 最大线程数
        executor.setMaxPoolSize(20);
        // 队列大小
        executor.setQueueCapacity(Integer.MAX_VALUE);
        // 线程活跃时间
        executor.setKeepAliveSeconds(60);
        // 默认线程名称
        executor.setThreadNamePrefix("MaxWell's");
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 执行初始化
        executor.initialize();
        return executor;
    }

}
