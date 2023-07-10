package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.InstantSource;

public class Timer {
    private final InstantSource instantSource;

    public Timer(InstantSource instantSource) {
        this.instantSource = instantSource;
    }

    public Duration measure(Runnable runnable) {
        Instant start = instantSource.instant();
        runnable.run();
        Instant end = instantSource.instant();
        return Duration.between(start, end);
    }

}
