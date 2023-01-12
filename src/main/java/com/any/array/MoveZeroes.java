package com.any.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例1：
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例2：
 * 输入: nums = [0]
 * 输出: [0]
 *
 */
public class MoveZeroes {

    public static void main(String[] args) {

        int[] arr = new int[]{0,1,0,3,12};
        int[] arr1 = new int[]{0};
        moveZeroes(arr1);

    }

    /**
     * 自己想的方法，太复杂了
     * @param nums
     */
    public static void moveZeroes(int[] nums){

        if (nums == null || nums.length == 0){
            return;
        }

        List<Integer> list = new ArrayList<>();
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0){
                count++;
            }else{
                list.add(nums[i]);
            }
        }

        for (int i = 0; i < count; i++) {
            list.add(0);
        }

        System.out.println(list);

        for (int i = 0; i < len; i++) {
            nums[i] = list.get(i);
        }
    }

    /**
     * 1，把非0的往前挪
     * 把非0的往前挪，挪完之后，后面的就都是0了，然后在用0覆盖后面的。
     *
     * @param nums
     */
    public static void moveZeroes1(int[] nums){

        if (nums == null || nums.length == 0){
            return;
        }

        int index = 0;
        // 一次遍历，把非零的都往前挪
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }

        while (index < nums.length){
            nums[index++] = 0;
        }
    }

    /**
     * 不为0的往前挪，然后i指向的值和j指向的值交换
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            //只要不为0就往前挪
            if (nums[j] != 0) {
                //i指向的值和j指向的值交换
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }
        }
    }

}
