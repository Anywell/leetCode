package com.any.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn96us/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 */
public class IsAnagram {

    public static void main(String[] args) {

        //String s = "anagram", t = "nagaram";
        String s = "car";
        String t = "cat";

        boolean re = isAnagram(s, t);

        System.out.println("re = " + re);


    }

    /**
     * 此种方法在字符串s和t很长（50000个字符）时，会出错，具体原因还不详。
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        // 将两个字符串分别放在map中，key为出现的字符，value为该字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            map1.put(ch1, map1.getOrDefault(ch1, 0) +1);
            map2.put(ch2, map2.getOrDefault(ch2, 0) +1);
        }

        // 遍历两个map，查看两个map中同一个字符的个数是否相同，如果所有字符个数都相同，则返回true，
        // 只要有其中一个字符的个数不相同，false.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map1.get(ch) != map2.get(ch)){
                return false;
            }
        }

        return true;
    }

    /**
     * 计算两个字符串中字符的差值，先统计字符串s中每个字符的数量，然后减去t中每个字符对应的数量
     * 如果最后的结果都是0，说明t是s的字母异位词
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t){

        if (s.length() != t.length()){
            return false;
        }

        int[] letterCount = new int[26];

        // 统计字符串s中的每个字符的数量
        for (int i = 0; i < s.length(); i++) {
            letterCount[s.charAt(i) - 'a']++;
        }
        // 再键入字符串t中的每个字符的数量
        for (int i = 0; i < t.length(); i++) {
            letterCount[t.charAt(i) - 'a']--;
        }
        // 如果letterCount中的每个值都是0，返回true，否则返回false
        for (int count : letterCount) {
            if (count != 0){
                return false;
            }
        }

        return true;
    }

    /**
     * 先排序，再比较
     * 先把两个字符串转化为字符数组，然后再对这两个字符数组进行排序，因为相同的字符在排序之后肯定是挨着的，
     * 最后调用equals方法进行比较这两个排序后的数组的元素是否相同
     * 然后
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t){
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        // 对两个字符串进行排序
        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);
    }

}
