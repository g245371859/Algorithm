package easy;

import java.util.HashMap;
import java.util.NoSuchElementException;

import static util.Utils.*;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author ghf on 2019-07-08 10:13
 */
public class T1_TwoSum {

    public static void main(String[] args) {
        int[] arr = getAndPrintArr(1000000, 100000, 200000);
        int target = 300000;
        startCount();
        int[] resultArr = twoSum(arr, target);
        printCount();
        System.out.println(resultArr[0] + "：" + arr[resultArr[0]]);
        System.out.println(resultArr[1] + "：" + arr[resultArr[1]]);
        resetCount();
        resultArr = twoSum2(arr, target);
        printCount();
        System.out.println(resultArr[0] + "：" + arr[resultArr[0]]);
        System.out.println(resultArr[1] + "：" + arr[resultArr[1]]);
    }

    private static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int value = target - arr[i];
            if (map.containsKey(value) && map.get(value) != i) {
                return new int[]{i, map.get(value)};
            }
        }
        throw new NoSuchElementException();
    }

    private static int[] twoSum2(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int value = target - arr[i];
            if (map.containsKey(value) && map.get(value) != i) {
                return new int[]{i, map.get(value)};
            } else {
                map.put(arr[i], i);
            }
        }
        throw new NoSuchElementException();
    }

}
