package com.any.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两个数组的交集
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2y0c2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 示例1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 */
public class Intersect {

    public static void main(String[] args) {

        int [] nums1 = new int[]{4,9,5};
        int [] nums2 = new int[]{9,4,9,8,4};

        int[] arr = intersect(nums1, nums2);

        System.out.println(Arrays.toString(arr));


    }


    /**
     * 先对数组进行排序
     * 先对两个数组进行排序，然后使用两个指针，分别指向两个数组开始的位置。
     *
     * 如果两个指针指向的值相同，说明这个值是他们的交集，就把这个值加入到集合list中，然后两个指针在分别往后移一步。
     * 如果两个指针指向的值不同，那么指向的值相对小的往后移一步，相对大的先不动，然后再比较
     *
     * 作者：数据结构和算法
     * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2y0c2/?discussion=miIug2
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return null;
        }
        // 1.先对数据排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length){
            // 如果i指向的值小于j指向的值，i向后移动一位
            if (nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                // 如果i指向的值大于j指向的值，j向后移动一位
                j++;
            }else{
                // 如果i和j指向的值相同，将值加入到list中，i和j都向后移动一位
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        // 将list转换为数组
        int arr[] = new int[list.size()];
        for(int n = 0; n < list.size(); n++){
            arr[n] = list.get(n);
        }

        return arr;


    }

}
