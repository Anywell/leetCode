package com.any.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 示例1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例2：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] arr = new int[]{2,7,11,15};
        int[] sum = twoSum1(arr, 17);
        System.out.println(Arrays.toString(sum));

    }

    /**
     * 暴力破解，使用两个for循环，效率差
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target){

        if (nums == null || nums.length == 0){
            return null;
        }

        int[] arr = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]  + nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }

    /**
     * 使用HashMap
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target){

        // 创建一个HashMap
        Map<Integer, Integer> map = new HashMap<>();
        int[] sum = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null){
                sum[0] = map.get(target - nums[i]);
                sum[1] = i;
            }
            // 将（数组元素值,下标）放入到map中
            map.put(nums[i], i);
        }
        return sum;
    }

}


