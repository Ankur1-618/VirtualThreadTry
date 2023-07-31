package virtual;

import util.Util;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThreadAction {

    public Long runVirtualThreadAction(int iterations, long sleepTime, boolean readFile, boolean sqaureSum) {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        Future<?>[] virtualThreads = new Future[iterations];

        Instant actionStart = Instant.now();

        // Create and start multiple threads in a loop
        for (int i = 0; i < iterations; i++) {
            final int index = i;
            virtualThreads[i] = executor.submit(() -> {
                // Perform the task within the thread

                if(readFile){
                    Util.readFileOp();
                }

                if(sqaureSum){
                    Util.squaresum(12);
                }

                // Simulate some work
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (Future thread : virtualThreads) {
            try {
                thread.get(); // Wait for thread to complete
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return Duration.between(actionStart, Instant.now()).toMillis();
    }
}