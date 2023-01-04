package com.any.array;

/**
 *  删除排序数组中的重复项
 *
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 *
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2gy9m/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

       int [] arr =  new int[]{0,0,1,1,1,2,2,3,3,4};

        int num = removeDuplicates(arr);

        System.out.println("num = " + num);


    }

    /**
     * 1，双指针解决
     * 使用两个指针，右指针始终往右移动，
     *
     * 如果右指针指向的值等于左指针指向的值，左指针不动。
     * 如果右指针指向的值不等于左指针指向的值，那么左指针往右移一步，然后再把右指针指向的值赋给左指针。
     *
     * 作者：数据结构和算法
     * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2gy9m/?discussion=4Zkrel
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int left = 0;
        /**
         *  如果左指针和右指针指向的值一样，说明有重复的，
         *  这个时候，左指针不动，右指针继续往右移。如果他俩
         *  指向的值不一样就把右指针指向的值往前挪
         */
        for (int right = 1; right < nums.length; right++){
            if (nums[left] != nums[right]){
                left++;
                nums[left] = nums[right];
            }
        }
        return left +1;

    }

}
