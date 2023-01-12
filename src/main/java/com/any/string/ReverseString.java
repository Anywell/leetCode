package com.any.string;

import java.util.Arrays;

/**
 *  反转字符串
 *  编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnhbqj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReverseString {


    public static void main(String[] args) {

        char [] s= {'h', 'e', 'l', 'l', 'o'};

        reverseString2(s);

        System.out.println(Arrays.toString(s));

    }


    /**
     * 这种方法开辟了新空间，与题设不符
     * @param s
     */
    public static void reverseString(char[] s){

        int length = s.length;

        char[] temp = Arrays.copyOf(s, length);

        for (int i = 0; i < length; i++) {
            s[i] = temp[length-1-i];
        }
    }

    /**
     * 对称交换
     * @param s
     */
    public static void reverseString1(char[] s){

        int length = s.length;

        for (int i = 0; i < length / 2; i++) {
            char temp = s[i];
            s[i] = s[length -1- i];
            s[length - 1 -i] = temp;
        }
    }

    /**
     * 双指针法，使用两个指针，一个从第一个开始，一个从数组的最后一个开始，两两交换
     * @param s
     */
    public static void reverseString2(char[] s){

        int left = 0;
        int right = s.length -1;
        char temp;
        while (left < right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}
