package com.any.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * 示例1：
 * 输入：nums = [1,2,3,1]
 * 输出：true
 *
 * 示例2：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 *
 */
public class ContainsDuplicate {

    public static void main(String[] args) {

        int arr[] = new int[]{1,2,3,1};
        boolean result = containsDuplicate(arr);

        System.out.println("result = " + result);

    }

    /**
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {

        if(nums == null || nums.length == 0){
            return false;
        }

        int len = nums.length;
        // 1. 暴力解法
        // for (int i = 0; i < len; i++){
        //     for (int j = i+1; j < len; j++){
        //         if (nums[i] == nums[j]){
        //             return true;
        //         }
        //     }
        // }

        // 2. 先排序，后比较相邻的元素
        // Arrays.sort(nums);
        // for(int i = 0; i < len -1; i++){
        //     if(nums[i] == nums[i+1]){
        //         return true;
        //     }
        // }

        // return false;

        // 2.添加到set中。
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if(!set.add(num)){
                return true;
            }
        }
        return false;

    }
}
