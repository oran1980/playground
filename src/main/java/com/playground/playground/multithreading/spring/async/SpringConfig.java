package com.playground.playground.multithreading.spring.async;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync(mode = AdviceMode.PROXY,proxyTargetClass = true)
public class SpringConfig {

//    @Bean(name = "asyncExecutor")
//    public Executor asyncExecutor () {
//        return getExecutor();
//    }
//
//    private AsyncTaskExecutor getExecutor () {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(10);
//        executor.setKeepAliveSeconds(10);
//        executor.initialize();
//        return executor;
//    }
}
