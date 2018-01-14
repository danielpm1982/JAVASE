/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads5;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 *
 * @author Daniel
 */
public class CalculateTimeAsync {
    Future future1, future2, future3;
    public CalculateTimeAsync(Future future1, Future future2, Future future3) {
        this.future1=future1;
        this.future2=future2;
        this.future3=future3;
    }
    public long calculateTimeAsync() throws ExecutionException,InterruptedException{
        Instant instant1 = Instant.now();
        future1.get();
        future2.get();
        future3.get();
        Instant instant2 = Instant.now();
        long duration = Duration.between(instant1, instant2).toMillis();
        return duration;
    }
}
