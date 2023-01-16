package com.any.string;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

    }

    /**
     * 先取第一个字符串当做他们的公共前缀
     * 然后找出他和第2个字符串的公共前缀，然后再用这个找出的公共前缀分别和第3个，第4个……判断
     * @param strs
     * @return
     */
    public static String logestCommonPrefs(String[] strs){

        // 边界条件判断
        if (strs == null ||strs.length == 0){
            return null;
        }

        // 默认第一个字符串是他们的公共前缀
        String pre = strs[0];
        int i = 1;
        while (i < strs.length){
            // 不断截取
            while (strs[i].indexOf(pre) != 0){
                // 当没找到，不断缩短pre，直到找到为止结束内部循环
                pre = pre.substring(0, pre.length() -1);
            }
            i++;
        }
        return pre;
    }
}
