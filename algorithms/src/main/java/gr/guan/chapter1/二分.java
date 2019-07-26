package gr.guan.chapter1;

import static gr.guan.util.Utils.*;

/**
 * @author ghf on 2019-07-26 16:57
 */
public class 二分 {

    public static void main(String[] args) {
        start();
        int[] arr = createIntArr(100, 1, 100, true);
        count();
        reset();
        int index = binarySearch(arr, 10);
        count();
        if (index == -1) {
            System.out.println("no element");
        } else {
            System.out.println("index = " + index + " value = " + arr[index]);
        }
    }

    private static int binarySearch(int[] arr, int value) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int i = (max + min) / 2;
            if (arr[i] < value) {
                min = i + 1;
            } else if (arr[i] > value) {
                max = i - 1;
            } else {
                return i;
            }
        }
        return -1;
    }
}
