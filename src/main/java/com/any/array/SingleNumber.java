package com.any.array;

import java.util.HashSet;
import java.util.Set;

/**
 *  只出现一次的数字
 *  给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *  你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间
 *  示例1：
 *  输入：nums = [2,2,1]
 *  输出：1
 *
 * 示例2：
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 */
public class SingleNumber {

    public static void main(String[] args) {

        int arr[] = new int[]{4,1,2,1,2};

        int result = singleNumber(arr);

        System.out.println("result = " + result);
    }

    /**
     * 使用异或运算，将所有值进行异或
     * 异或运算，相异为真，相同为假，所以 a^a = 0 ;0^a = a
     * 因为异或运算 满足交换律 a^b^a = a^a^b = b 所以数组经过异或运算，单独的值就剩下了
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {

        // 1.使用异或的特性 a^a = 0; a^0 = a; a^b^a= a^a^b = b
        // int result = 0;
        // for (int i = 0; i < nums.length; i++){
        //     result ^= nums[i];
        // }

        // return result;

        // 2.使用Set
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            // 如果添加重复的元素，删除掉原先添加减去的该元素
            if (!set.add(num)){
                set.remove(num);
            }
        }

        return (int)set.toArray()[0];

    }
}
