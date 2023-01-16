package com.any.string;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 * 输入: s = "leetcode"
 * 输出: 0
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 *
 * 输入: s = "aabb"
 * 输出: -1
 *
 * 提示: *
 * 1 <= s.length <= 105
 * s 只包含小写字母
 */
public class FindFirstUniqueChar {

    public static void main(String[] args) {

        String s = "aabbb";
        int i = firstUniqueChar2(s);
        System.out.println("i = " + i);

    }

    /**
     * 使用了两个map，有些繁琐
     * @param s
     * @return
     */
    public static int firstUniqueChar(String s){

        if (s == null || s.length() == 0){
            return -1;
        }

        int length = s.length();
        // key：出现的字符，value：该字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        // keu: 出现的字符，value：该字符第一次出现的下标
        Map<Character, Integer> map1 = new HashMap<>();

        int index = 1;
        for (int i = 0; i < length; i++) {

            char c = s.charAt(i);
            // 重复出现时，次数增加
            if (map.containsKey(c)){
                map.put(c, ++index);
            }else{
                // 只出现一次，设置value为1
                map.put(c, 1);
                map1.put(c, i);
            }
        }

        System.out.println(map.toString());
        System.out.println(map.getOrDefault('a', 0));
        System.out.println(map1.toString());

        // 从前往后遍历字符串，第一个出现的次数为1的字符直接返回即可。
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1){
                return map1.get(c);
            }
        }

        return -1;
    }


    /**
     * getOrDefault(Object key, V defaultValue方法：查找map中key的值，如果map中有该key，返回具体的value，
     * 如果没有该key，返回指定的默认值
     * @param s
     * @return
     */
    public static int firstUniqueChar1(String s){
        if (s == null || s.length() == 0){
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            // 统计每个字符出现的次数
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        // 按顺序遍历字符数组，如果哪个字符出现的次数为1，直接返回下标
        for (int i = 0; i < s.length(); i++) {
            if (map.get(chars[i]) == 1){
                return i;
            }
        }

        return -1;
    }

    /**
     * 使用java自带的api，一个从前查找，一个从后查找，如果下标相等，说明只出现了一次
     * @param s
     * @return
     */
    public static int firstUniqueChar2(String s){
        if (s == null || s.length() == 0){
            return -1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                return i;
            }
        }

        return -1;
    }
}
