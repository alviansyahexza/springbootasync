package springbootasync.springbootasync;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class AsyncService {

    @Async
    public void printNumber(int number) throws InterruptedException {
        System.out.println(number);
        System.out.println(Instant.now());
        Thread.sleep(3000L);
    }

    @Async
    public CompletableFuture<Integer> printNumberCompletable(int number) throws InterruptedException {
        System.out.println(number);
        System.out.println(Instant.now());
        Thread.sleep(3000L);
        return CompletableFuture.completedFuture(number);
    }

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(1);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }
}
