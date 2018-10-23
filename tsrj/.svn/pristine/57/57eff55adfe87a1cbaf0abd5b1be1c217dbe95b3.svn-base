package org.tsrj.common.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by WangSheng on 2017/8/5.
 *
 * @author WangSheng
 * @date 2017/08/05
 */
@Configuration
public class RRajExecutorConfig {
    /** 核心线程数 **/
    private int corePoolSize = 10;
    /** 最大线程数 **/
    private int maxPoolSize = 200;
    /** 阻塞队列的容量 **/
    private int queueCapacity = 10;

    @Bean
    public Executor rRajAsync() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix("RRajExecutor-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
