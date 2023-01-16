package com.any.string;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.logging.Level;

public class MyAtoi {

    public static void main(String[] args) {

        //System.out.println("   ".length());
    }

    /**
     * 不会，直接抄了
     * 定义一个指针index 指向正在判断的字符
     * 先把空格去掉index++
     * 再判断是否有符号 index++ 并保留
     * 遇到非数字直接return
     * 先允许越界，越界后数据肯定和期望值不同，整除10后和原来的数比较即可，根据符号返回对应的最值
     * 返回结果时，带上符号
     *
     * @param s
     * @return
     */
    public static int myAtoi(String s){
        
        char[] chars = s.toCharArray();
        int length = chars.length;
        int index = 0;

        // 先去除前置空格
        while (index < length && chars[index] == ' '){
            index++;
        }
        // 极端情况 " " 和""
        if (index >= length){
            return 0;
        }

        // 再判断符号
        int sign = 1;
        if (chars[index] == '-' || chars[index] == '+'){
            if (chars[index] == '-'){
                sign = -1;
            }
            index++;
        }
        int result = 0;
        int temp = 0;
        // 此时下标index在第一位数字位
        while (index < length){
            int num = chars[index] - '0';
            if (num > 9 || num < 0){
                break;
            }
            temp = result;
            result = result * 10 + num;
            // 越界后，数值和期望值发生变化，取余再除以10获取原始值，比对判断
            if (result / 10 != temp){
                if (sign > 0){
                    return Integer.MAX_VALUE;
                }else{
                    return Integer.MIN_VALUE;
                }
            }
            index++;
        }
        return result * sign;
    }


    /**
     * 越界这一块处理没咋看懂，后续在看吧
     * @param s
     * @return
     */
    public static int myAtoi2(String s){
        // 去掉前后两端的空格
        s = s.trim();

        if (s.length() == 0){
            return 0;
        }

        int index = 0; // 遍历字符串中字符的位置
        int res = 0; // 最终结果
        int sign = 1; // 符号，1为正数，-1为负数，默认为正数
        int length = s.length();

        // 判断符号
        if (s.charAt(index) == '-' || s.charAt(index) == '+'){
            if (s.charAt(index) == '-'){
                sign = -1;
            }
            index ++;
        }

        for (; index < length; index++) {
            // 取出字符串中的字符，然后转化为数字
            int digit = s.charAt(index) - '0';
            // 按照题中的要求，读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
            // 字符串中的其余部分将被忽略。如果读取到了非数字，后面都要忽略
            if (digit < 0 || digit > 9){
                break;
            }

            // 越界处理
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10){
                if (sign == 1){
                    return Integer.MAX_VALUE;
                }else{
                    return Integer.MIN_VALUE;
                }
            }else{
                res = res * 10 + digit;
            }
        }

        return res * sign;
    }
}
