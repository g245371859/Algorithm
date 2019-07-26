package gr.guan.util;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ghf on 2019-07-26 16:59
 */
public class Utils {
    static Random random = new Random();
    static ThreadLocal<Timer> threadLocal = new ThreadLocal();

    public static int[] createIntArr(int length, int min, int max, boolean sort) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(max - min) + min;

        }
        if (sort) {
            Arrays.sort(arr);
        }
        return arr;
    }

    public static void start() {
        threadLocal.set(new Timer());
    }

    public static void reset() {
        threadLocal.get().time = System.currentTimeMillis();
    }

    public static void count() {
        System.out.println(System.currentTimeMillis() - threadLocal.get().time);
    }

    static class Timer {
        long time = System.currentTimeMillis();
    }
}
