package util;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ghf on 2019-07-08 10:18
 */
public class Utils {

    private static ThreadLocal<Count> threadLocal = new ThreadLocal<>();
    private static Random random = new Random();

    public static void startCount() {
        threadLocal.set(new Count());
    }

    public static void printCount() {
        long time = threadLocal.get().count();
        System.out.println("花费时间：" + time + " ms");
    }

    public static void resetCount() {
        threadLocal.get().reset();
    }

    private static class Count {
        private long startTime = System.currentTimeMillis();

        private long count() {
            return System.currentTimeMillis() - startTime;
        }

        private void reset() {
            this.startTime = System.currentTimeMillis();
        }
    }

    public static int[] getAndPrintArr(int length, int min, int max) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(max - min) + min;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
