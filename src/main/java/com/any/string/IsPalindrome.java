package com.any.string;

import java.util.Locale;

/**
 * 验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xne8id/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 *
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 *
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 */
public class IsPalindrome {

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        boolean re = isPalindrome("0P");

        System.out.println(re);

    }


    /**
     * 虽然做出来了，但是效率超级低。
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s){

        if (s == null){
            return false;
        }

        char[] sChar = s.toCharArray();
        String t = "";

        for (int i = 0; i < sChar.length; i++) {
            char c = sChar[i];
            if ((c < 'a' || c >'z') && (c < 'A' || c > 'Z') &&(c < '0' || c > '9')){
                sChar[i] =' ';
            }
            t += sChar[i];
        }

        t = t.replace(" ", "");
        t = t.toLowerCase();
        System.out.println(t);

        int length = t.length();
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != t.charAt(length -i -1)){
                return false;
            }
        }

        return true;
    }

    /**
     * 优化，使用双指针，一个指向前，一个指向后，遇到空格以及特殊字符要跳过，然后判断
     * @param s
     * @return
     */
    public static boolean isPalindrome1(String s){

        if (s.length() == 0){
            return true;
        }

        int left = 0, right = s.length() -1;
        while (left < right){
            // 排除掉非数字和字母字符
            // 此处判断时需要使用while循环，如果使用if判断，会出错
            while (left < right && Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left < right && Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            // 然后把两个字符都变成小写，再判断是否一样，如果不一样，直接返回false
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

    /**
     * 使用正则表达式，把特殊字符过滤掉，只留下字母和数字，然后转化为小写，再反转，判断与原字符串是否相等
     * @param s
     * @return
     */
    public static boolean isPalindrome2(String s){

        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}
