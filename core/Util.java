package core;

public class Util {
    public static void sleepFor(long nanoseconds) {
        long timeElapsed;
        final long startTime = System.nanoTime();

        do {
            timeElapsed = System.nanoTime() - startTime;
        } while (timeElapsed < nanoseconds);
    }

    public static int milliToNano(int milliseconds) { return milliseconds * 1000000; }
}
