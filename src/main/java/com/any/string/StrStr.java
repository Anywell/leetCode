package com.any.string;

/**
 *  实现 strStr()
 *  给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnr003/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 *
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 */
public class StrStr {

    public static void main(String[] args) {


        String s1 = "leetcode";
        String s2 = "code";

        int i = strStr(s1, s2);
        System.out.println(i);

    }


    /**
     * 一般字符串匹配的时候，最简单的一种方式，就是子串从头开始和主串匹配。
     * 如果匹配失败，子串再次从头开始，而主串从上次匹配的下一个字符开始，
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle){

        if (haystack == null || needle == null || haystack.length() < needle.length()){
            return -1;
        }

        if (needle.length() == 0){
            return 0;
        }

        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()){
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                // 如果不匹配，就回退，从第一次匹配的下一个开始
                i = i - j + 1;
                j = 0;
            }
            // j的值等于needle.length，说明needle全部匹配完成。
            if (j == needle.length()){
                return i - j;
            }
        }
        return -1;
    }

    /**
     * 上面的方式效率比较差
     * 可以使用不断截取主串然后和子串进行比较
     * @return
     */
    public static int strStr1(String haystack, String needle){

        if (needle.length() == 0){
            return 0;
        }

        if (needle.length() > haystack.length()){
            return -1;
        }

        int length = needle.length();
        // 此处的加1,是为了防止当两个字符串长度相同时，total=0，for循环不会执行，会直接返回-1，
        // 加上1，当量字符串长度相同时，会执行一次for循环，会直接比较两个字符串是否相等。
        int total = haystack.length() - length + 1;

        // 如果total不加1，此处应该为 start <= total亦可以。
        for (int start = 0; start < total; start++) {
            if (haystack.substring(start, start + length).equals(needle)){
                return start;
            }
        }
        return -1;

    }
}


