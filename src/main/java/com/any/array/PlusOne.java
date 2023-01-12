package com.any.array;

import java.util.Arrays;

/**
 * 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2cv1c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 示例1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 *
 */
public class PlusOne {

    public static void main(String[] args) {

        int [] arr = new int[]{1, 2, 3};
        int [] arr1 = new int[]{9, 1};
        int[] nums = plusOne(arr1);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 如果数组中的所有元素都是9，类似9999，加1之后肯定会变为10000，也就是数组长度会增加1位。
     * 如果数组的元素只要有一个不是9，加1之后直接返回即可。
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits){

        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9){
                // 如果数组当前元素不等于9，直接加1，然后直接返回
                digits[i]++;
                return digits;
            }else{
                // 如果数组当前元素等于9，加1之后肯定会变为0，我们先让他变为0
                digits[i] = 0;
            }
        }

        // 除非数组中的元素都为9，否则不会走到这一步，如果数组中的元素都为9，我们只需要把数组的长度增加1
        // 并且把数组的第一个元素置为1既可。
        int temp[] = new int[len + 1];
        temp[0] = 1;
        return temp;

    }


//    public static int[] plusOne(int[] digits){
//
//        if (digits.length == 1 && digits[0] != 9){
//            digits[0] = digits[0] + 1;
//            return digits;
//        }
//
//        int num = 0;
//        int len = digits.length;
//        for (int i = 0; i < len; i++){
//            num += digits[i] * Math.pow(10, len-i-1);
//            //System.out.println(num);
//        }
//
//
//        num = num + 1;
//        System.out.println("---------------" + num);
//        String str = Integer.toString(num);
//        System.out.println(str);
//
//
//
//        int [] arr = new int[str.length()];
//        for (int j = 0; j < str.length(); j++){
//            arr[j] = Integer.parseInt(Character.toString(str.charAt(j)));
//            System.out.println(arr[j] + "");
//        }
//
//        return arr;
//
//    }
}
