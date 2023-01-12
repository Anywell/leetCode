package com.any.string;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnx13t/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 输入：x = 123
 * 输出：321
 *
 * 输入：x = -123
 * 输出：-321
 *
 * 输入：x = 120
 * 输出：21
 *
 */
public class ReverseInt {

    public static void main(String[] args) {

        int x = 1234567891;
        int result = reverse1(x);
        System.out.println("result = " + result);

    }


    /**
     * 自己写出来的，但是中间除了好几个问题，改正后跑通了，但还是很复杂。
     * @param x
     * @return
     */
    public static int reverse(int x){

        if (x == 0){
            return 0;
        }

        String str = ((Integer)x).toString();
        int length = str.length();
        char[] s = new char[length];

        for (int i = 0; i < length; i++) {
            //直接反转放到char数组中
            if (x >= 0){
                s[i] = str.charAt(length - 1 - i);
            }else {
                s[i+1] = str.charAt(length - 1 - i);
                if (i == length-2){
                    break;
                }
            }
        }
        // 如果是负数，去掉最后一位
        if (x < 0){
            s[0] = '-';
        }

        String newStr = "";
        // 将字符数组转为字符串
        for (int i = 0; i < length; i++) {
            newStr += s[i];
        }

        System.out.println(newStr);
        while (newStr.startsWith("0")){
            newStr = newStr.substring(1);
        }

        long num = Long.parseLong(newStr);

        System.out.println(" num = " + num);

        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE){
            num = 0;
        }

        return (int) num;
    }

    /**
     * 翻转每一个数字。
     * 输入x = 1234
     * int res = 0;
     * 第一步：res = 0 * 10 + 4 = 4;
     * 第二步：res = 4 * 10 + 3 = 43;
     * 第三步：res = 43 * 10 + 2; 432;
     * 第四步：res = 432 * 10 + 1 = 4321;
     * 规律是，将输入对10取余，然后 x = x / 10, 继续对10 取余，继续 x = x / 10，循环，知道x = 0时停止循环     *
     */
    public static int reverse1(int x){

        int res = 0;
        while (x != 0){
            int t = x % 10;
            int newRes = res * 10 + t;
            // 如果数字溢出，直接返回0
            if ((newRes - t) / 10  != res){
                return 0;
            }
            res = newRes;
            x = x /10;

        }

        return  res;
    }

    /**
     * 在上面的方法基础上继续精简优化
     * @param x
     * @return
     */
    public static int reverse3(int x){

        // 将反转后的数字类型设置为long类型，防止翻转后数字移除int范围
        long res = 0;
        while (x != 0){
            res = res % 10 + x % 10;
            x /= 10;
        }
        // 超出范围返回0.
        return (int) res == res ? (int) res : 0;

    }
}
