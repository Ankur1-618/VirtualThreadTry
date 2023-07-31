package traditional;
import util.Util;

import java.io.*;
import java.time.Duration;
import java.time.Instant;

public class TraditionalThreadAction {

    public Long runThreadAction(int iterations, long sleepTime,boolean readFile, boolean sqaureSum){
        Thread threads[] = new Thread[iterations];

        Instant actionStart = Instant.now();

        // Create and start multiple threads in a loop
        for (int i = 0; i < iterations; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                // Perform the task within the thread
                // Simulate some
                if(readFile){
                    Util.readFileOp();
                }
                if(sqaureSum){
                    Util.squaresum(10);
                }
                try {
                    Thread.sleep(sleepTime);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start(); // Start the thread
        }

        for (Thread thread : threads) {
            try {
                thread.join(); // Wait for thread to complete
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return Duration.between(actionStart, Instant.now()).toMillis();
    }
}
