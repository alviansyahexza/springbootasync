package springbootasync.springbootasync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    AsyncService asyncService2 = new AsyncService();

    @GetMapping(path = "api/async")
    public void async() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            asyncService.printNumber(i);
        }
    }

    @GetMapping(path = "api/async-and-wait")
    public void asyncAndWait() throws InterruptedException {
        CompletableFuture<Integer> o = asyncService.printNumberCompletable(0);
        CompletableFuture<Integer> one = asyncService.printNumberCompletable(1);
        CompletableFuture<Integer> two = asyncService.printNumberCompletable(2);
        CompletableFuture<Integer> three = asyncService.printNumberCompletable(3);
        CompletableFuture<Integer> four = asyncService.printNumberCompletable(4);
        CompletableFuture<Integer> five = asyncService.printNumberCompletable(5);
        CompletableFuture<Integer> six = asyncService.printNumberCompletable(6);
        CompletableFuture<Integer> seven = asyncService.printNumberCompletable(7);
        CompletableFuture<Integer> eight = asyncService.printNumberCompletable(8);
        CompletableFuture<Integer> nine = asyncService.printNumberCompletable(9);
        CompletableFuture<Integer> ten = asyncService.printNumberCompletable(10);
        CompletableFuture<Integer> eleven = asyncService.printNumberCompletable(11);
        CompletableFuture.allOf(o, one, two, three, four, five, six, seven, eight, nine, ten, eleven).join();
    }

    @GetMapping(path = "api/async-failed")
    public void asyncFailed() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            asyncService2.printNumberCompletable(i);
        }
    }
}
